package daniel.java.sql.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.output.FileWriterWithEncoding;

import com.opencsv.CSVReader;

public class JDBCTest {
	private static String driverClass = "oracle.jdbc.driver.OracleDriver";
	private static String jdbcUrl = "jdbc:oracle:thin:@192.168.63.146:1530:billdb";
	private static String userId = "rm";
	private static String password = "rm";
	
	private String queryEmailSql = "select t.id, t.confirm_mail, g.email, g.fc_email, g.sale_email, g.sale_man" +
			" from rm.temp_confirm_merchant t" +
			" inner join rm.temp_agent g" +
			" on t.agent_name = g.agent_name" +
			" where t.agent_name is not null";
	private String updateEmailSql = "update rm.temp_confirm_merchant set confirm_mail = ? where id = ?";
	
	//两张表关联查询：将两张表的值拼接，更新到某个字段
	private String queryMerEmailSql = "select t.id, t.confirm_mail, t.cc_mail, g.email,g.full_name_cn" +
			" from rm.temp_confirm_merchant t" +
			" inner join rm.TEMP_MERCHANT g" +
			" on t.merchant_id = g.merchant_id";
	private String updateMerEmailSql = "update rm.temp_confirm_merchant set confirm_mail=?, cc_mail=? where id=?";
	
	
	private String queryMerchantSql = "select id,confirm_mail,cc_mail,remarks,merchant_id,merchant_name," +
			"idcontent,is_delete,sync_mrs,merchant_urge,is_receive_retrieval from rm.temp_confirm_merchant order by id";
	
	private String insertMerchantSql = "insert into rm.temp_confirm_merchant(confirm_mail,cc_mail,remarks," +
			"merchant_id,merchant_name,idcontent,is_delete,sync_mrs,merchant_urge,is_receive_retrieval," +
			"create_date,last_update_time,id) " +
			" values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/**
	 * 将csv文件的数据导入数据库中
	 */
	public void insertDataFromCSV(){
		try {
			Class.forName(driverClass);
			Connection con = java.sql.DriverManager.getConnection(jdbcUrl,userId, password);
			//保存商户邮箱
			/*String sql = "insert into TEMP_MERCHANT(ID,MERCHANT_ID,FULL_NAME_CN,EMAIL) values(?,?,?,?)";
			String fileName = "d:\\daniel.fang\\桌面\\mer\\TEMP_MERCHANT.csv";*/
			//商户原数据
			String sql = "insert into temp_confirm_merchant(id,confirm_mail,cc_mail,remarks,merchant_id,merchant_name,idcontent,"
						+"is_delete,sync_mrs,merchant_urge,IS_RECEIVE_RETRIEVAL) values(?,?,?,?,?,?,?,?,?,?,?)";
			String fileName = "d:\\daniel.fang\\桌面\\mer\\dd.csv";
			PreparedStatement ps = con.prepareStatement(sql);
			File file = new File(fileName);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "GBK"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			int i = 0;
			while ((tt = reader.readNext()) != null) {
				if (tt == null || tt.length < 11) {
					if (tt != null) {
						for (String t : tt) {
							System.out.println("------" + t);
						}
					} else {
						System.out.println("nullllllllllllllllllll");
					}
					continue;
				}
				ps.setLong(1, Long.parseLong(tt[0]));
				ps.setString(2, tt[1]);
				ps.setString(3, tt[2]);
				ps.setString(4, tt[3]);
				ps.setString(5, tt[4]);
				ps.setString(6, tt[5]);
				ps.setString(7, tt[6]);
				ps.setLong(8, Long.parseLong(tt[7]));
				ps.setString(9, tt[8]);
				ps.setString(10, tt[9]);
				ps.setLong(11, Long.parseLong(tt[10]));
				ps.addBatch();
				if (i % 1000 == 1) {
					ps.executeBatch();
					System.out.println("commit records:" + i);
				}
				i++;
			}
			ps.executeBatch();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 拼接收件人，并将结果更新到收件人字段
	 * @return
	 */
	public void composeEmailReceiver(){
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rs = null;
		PreparedStatement updatePtst = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(jdbcUrl, userId, password);
			//ptst = conn.prepareStatement(queryEmailSql);
			ptst = conn.prepareStatement(queryMerEmailSql);
			ptst.setFetchSize(1000);
			rs = ptst.executeQuery();
			//prepareStatement不能放在while中，否则导致游标错误
			updatePtst = conn.prepareStatement(updateMerEmailSql);
			int count = 0;
			while(rs.next()){
				Set<String> mailSet = new HashSet<String>();
				String confirm_mail = rs.getString("confirm_mail");
				String cc_mail = rs.getString("cc_mail");
				String email = rs.getString("email");
				//String fc_email = rs.getString("fc_email");
				//String sale_email = rs.getString("sale_email");
				if(confirm_mail!=null){
					mailSet.addAll(Arrays.asList((confirm_mail.split(";"))));
				}
				if(email!=null){
					mailSet.addAll(Arrays.asList((email.split(";"))));
				}
				
				Set<String> ccmailSet = new HashSet<String>();
				ccmailSet.add("rm_cb@99bill.com");
				if(cc_mail!=null){
					ccmailSet.addAll(Arrays.asList((cc_mail.split(";"))));
				}
				/*if(fc_email!=null){
					mailSet.addAll(Arrays.asList((fc_email.split(";"))));
				}
				if(sale_email!=null){
					mailSet.addAll(Arrays.asList((sale_email.split(";"))));
				}*/
				
				//更新confirm_mail
				String str = genEmailStr(mailSet);
				int len = str.length();
				if(len>256){
					System.out.println("id:"+rs.getString("id"));
					System.out.println("mail:"+str);
					System.out.println("full_name_cn:"+rs.getString("full_name_cn"));
				}
				updatePtst.setString(1, genEmailStr(mailSet));
				updatePtst.setString(2, genEmailStr(ccmailSet));
				updatePtst.setLong(3, rs.getLong("id"));
				updatePtst.addBatch();
				//每10000个批次执行一次批量更新
				if(count%10000==1){
					updatePtst.executeBatch();
					System.out.println("count : "+count);
				}
				//每增加一个批次，计数器加1
				count++;
			}
			//小于10000的余量，批量更新
			updatePtst.executeBatch();
			System.out.println("count : "+count);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ptst!=null){
				try {
					ptst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void batchInsert(){
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rs = null;
		PreparedStatement insertPtst = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(jdbcUrl, userId, password);
			ptst = conn.prepareStatement(queryMerchantSql);
			ptst.setFetchSize(1000);
			rs = ptst.executeQuery();
			//prepareStatement不能放在while中，否则导致游标错误
			insertPtst = conn.prepareStatement(insertMerchantSql);
			int count = 0;
			while(rs.next()){
				String confirm_mail = rs.getString("confirm_mail");
				String cc_mail = rs.getString("cc_mail");
				String remarks = rs.getString("remarks");
				String merchant_id = rs.getString("merchant_id");
				String merchant_name = rs.getString("merchant_name");
				String idcontent = rs.getString("idcontent");
				Long is_delete = rs.getLong("is_delete");
				String sync_mrs = rs.getString("sync_mrs");
				String merchant_urge = rs.getString("merchant_urge");
				Long is_receive_retrieval = rs.getLong("is_receive_retrieval");
				long id = rs.getLong("id");
				
				//更新confirm_mail
				insertPtst.setString(1, confirm_mail);
				insertPtst.setString(2, cc_mail);
				insertPtst.setString(3, remarks);
				insertPtst.setString(4, merchant_id);
				insertPtst.setString(5, merchant_name);
				insertPtst.setString(6, idcontent);
				insertPtst.setLong(7, is_delete);
				insertPtst.setString(8, sync_mrs);
				insertPtst.setString(9, merchant_urge);
				insertPtst.setLong(10, is_receive_retrieval);
				insertPtst.setString(11, "sysdate");
				insertPtst.setString(12, "sysdate");
				insertPtst.setLong(13, id);
				
				insertPtst.addBatch();
				//每增加一个批次，计数器加1
				count++;
				//每10000个批次执行一次批量更新
				if(count%10000==1){
					insertPtst.executeBatch();
					System.out.println("count : "+count);
				}
			}
			insertPtst.executeBatch();
			System.out.println("count : "+count);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ptst!=null){
				try {
					ptst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * 生成ctl文件
	 */
	public void geneCtlFile(){
		Connection conn = null;
		PreparedStatement ptst = null;
		ResultSet rs = null;
		//每增加一个批次，计数器加1
		int count = 0;
		String filePath = "d:\\daniel.fang\\桌面\\mer\\ctl\\数据修复-商户邮箱_RM_";
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(jdbcUrl, userId, password);
			ptst = conn.prepareStatement(queryMerchantSql);
			ptst.setFetchSize(1000);
			rs = ptst.executeQuery();
			List<String> dataList = new ArrayList<String>();
			while(rs.next()){
				String str = "";
				String confirm_mail = rs.getString("confirm_mail");
				String cc_mail = rs.getString("cc_mail");
				if(cc_mail==null || "null".equalsIgnoreCase(cc_mail)){
					cc_mail = "";
				}
				String remarks = rs.getString("remarks");
				if(remarks==null || "null".equalsIgnoreCase(remarks)){
					remarks = "";
				}
				String merchant_id = rs.getString("merchant_id");
				String merchant_name = rs.getString("merchant_name");
				String idcontent = rs.getString("idcontent");
				if(idcontent==null || "null".equalsIgnoreCase(idcontent)){
					idcontent = "";
				}
				long is_delete = rs.getLong("is_delete");
				String sync_mrs = rs.getString("sync_mrs");
				String merchant_urge = rs.getString("merchant_urge");
				long is_receive_retrieval = rs.getLong("is_receive_retrieval");
				long id = rs.getLong("id");
				
				//如果ctl中id采用sequenct，则str不需要该字段
				str = id+"," 
					+confirm_mail+","
					+ cc_mail+","
					+ remarks+","
					+ merchant_id+","
					+ merchant_name+","
					+ idcontent+","
					+ is_delete+","
					+ sync_mrs+","
					+ merchant_urge+","
					+ is_receive_retrieval
					+ "\r\n";
					
				dataList.add(str);
				int size = dataList.size();
				//每10000个批次执行一次批量更新
				if(size%100000==0){
					//写出到文件
					System.out.println("count : "+count);
					write2File(filePath+count+".ctl", dataList);
					dataList.clear();
					count++;
				}
			}
			System.out.println("count : "+count);
			write2File(filePath+count+".ctl", dataList);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ptst!=null){
				try {
					ptst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void write2File(String fileName, List<String> list) {
		try {
			FileWriterWithEncoding f = new FileWriterWithEncoding(fileName, "GBK");
			BufferedWriter bf = new BufferedWriter(f);
			/*FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bf = new BufferedWriter(fileWriter);*/
			//ctl文件头
			bf.write("-------------"+"\r\n");
			bf.write("--SCHEMA:RM"+"\r\n");
			bf.write("--insert:大约10000 records"+"\r\n");
			bf.write("-------------"+"\r\n");
			bf.write("LOAD DATA"+"\r\n");
			bf.write("INFILE *"+"\r\n");
			bf.write("APPEND INTO TABLE rm.t_rm_bank_confirm_merchant"+"\r\n");
			bf.write("Fields terminated by \',\'"+"\r\n");
			bf.write("trailing nullcols"+"\r\n");
			bf.write("(ID,"+"\r\n");
			bf.write("confirm_mail,"+"\r\n");
			bf.write("cc_mail,"+"\r\n");
			bf.write("remarks,"+"\r\n");
			bf.write("merchant_id,"+"\r\n");
			bf.write("merchant_name,"+"\r\n");
			bf.write("idcontent,"+"\r\n");
			bf.write("is_delete,"+"\r\n");
			bf.write("sync_mrs,"+"\r\n");
			bf.write("merchant_urge,"+"\r\n");
			bf.write("is_receive_retrieval,"+"\r\n");
			bf.write("create_date \"sysdate\","+"\r\n");
			bf.write("last_update_time \"sysdate\""+"\r\n");
			bf.write(")"+"\r\n");
			bf.write("BEGINDATA"+"\r\n");
			for (int i = 0; i < list.size(); i++) {
				bf.write(list.get(i));
			}
			bf.flush();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private String genEmailStr(Set<String> set){
		String res = "";
		if(set!=null && set.size()>0){
			int count = 0;
			for(String str : set){
				if(count>0){
					res += ";";
				}
				res += str;
				count++;
			}
		}
		return res;
	}
	
	
	public void orcl2MySQL(){
		
	}
	
	public static void main(String[] args) {
		/*String str = "123";
		String[] strArr = str.split(";");
		for(int i=0; i<strArr.length; i++){
			System.out.println("str-"+i+":"+strArr[i]);
		}
		String str1 = "123";
		String[] strArr1 = str1.split(";");
		for(int i=0; i<strArr1.length; i++){
			System.out.println("str1-"+i+":"+strArr1[i]);
		}*/
		
		/*Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		System.out.println(new JDBCTest().genEmailStr(set));*/
		
		//1、csv数据导入到表中
		//new JDBCTest().insertDataFromCSV();
		
		//2、更新收件人
		//new JDBCTest().composeEmailReceiver();
		
		//3、导出数据到文件
		new JDBCTest().geneCtlFile();
	}
}
