package daniel.java.util.excel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opencsv.CSVReader;

import daniel.java.util.file.FileUtils;

public class ExcelUtils {
	
	/**
	 * 反洗钱解析excel
	 */
	public static void readExcel(){
		Workbook workBook = null;
		Sheet sheet = null;
		HSSFWorkbook book = null;
        try {  
            //构造Workbook（工作薄）对象  
        	//String fileName = "d:\\daniel.fang\\桌面\\read.xls";
        	String fileName = "d:\\daniel.fang\\桌面\\导入数据.xls";
			File file = new File(fileName);
            workBook=Workbook.getWorkbook(file);
            
            InputStream is = new FileInputStream(file);
            book = new HSSFWorkbook(is);
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        if(workBook==null){
        	return;  
        } 
          
        //获得了Workbook对象之后，就可以通过它得到Sheet（工作表）对象了  
        //Sheet[] sheets = workBook.getSheets(); 
        StringBuffer finalBuf = new StringBuffer();
        //if(sheets!=null&&sheets.length>0){
        	//sheet = sheets[0];
        	HSSFSheet hssfsheet = book.getSheetAt(0);
        	String toFilePath = "d:\\daniel.fang\\桌面\\testInsert\\";
        	int size = 0;
        	int count = 0;
        	int rowCount = hssfsheet.getLastRowNum();
        	//for (int i = 1; i <= sheet.getRows()-1; i++) {
        	for (int i = 1; i < rowCount + 1; i++) {
//        		Ctif ctif = new Ctif();
        		HSSFRow row = hssfsheet.getRow(i);
        		StringBuffer tmpStr = new StringBuffer();
        		String id = UUID.randomUUID().toString().substring(4);
        		tmpStr.append("insert into tppaml.t_pstr_ctif(ID");
        		tmpStr.append(",WARN_DT");
        		tmpStr.append(",WARN_RL");
        		tmpStr.append(",IN_AMT");
        		tmpStr.append(",OUT_AMT");
        		tmpStr.append(",IN_NUM");
        		tmpStr.append(",OUT_NUM");
        		tmpStr.append(",RISK_LEVEL");
        		tmpStr.append(",CTNM");
        		tmpStr.append(",SMID");
        		tmpStr.append(",CITP");
        		tmpStr.append(",CITP_NT");
        		tmpStr.append(",CTID");
        		tmpStr.append(",CTAR");
        		tmpStr.append(",CCTL");
        		tmpStr.append(",CEML");
        		tmpStr.append(",CTVC");
        		tmpStr.append(",CRNM");
        		tmpStr.append(",CRIT");
        		tmpStr.append(",CRIT_NT");
        		tmpStr.append(",CRID");
        		tmpStr.append(",CTIF_TP");
        		tmpStr.append(",CLIENT_TP");
        		tmpStr.append(",SEQ_NO");
        		
        		tmpStr.append(") values('");
        		
        		tmpStr.append(id + "'");
        		/*tmpStr.append(",to_date('"+sheet.getCell(0, i).getContents()+ "','yyyy-MM-dd')");
        		tmpStr.append(",'"+sheet.getCell(1, i).getContents()+ "'");
        		tmpStr.append(","+sheet.getCell(2, i).getContents()+ "");
        		tmpStr.append(","+sheet.getCell(3, i).getContents()+ "");
        		tmpStr.append(","+sheet.getCell(4, i).getContents()+ "");
        		tmpStr.append(","+sheet.getCell(5, i).getContents()+ "");
        		tmpStr.append(","+sheet.getCell(6, i).getContents()+ "");
        		tmpStr.append(",'"+sheet.getCell(7, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(8, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(9, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(10, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(11, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(12, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(13, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(14, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(15, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(16, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(17, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(18, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(19, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(20, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(21, i).getContents()+ "'");
        		tmpStr.append(","+sheet.getCell(22, i).getContents()+ "");*/
        		tmpStr.append(",to_date('"+row.getCell(0)+ "','yyyy-MM-dd')");
        		tmpStr.append(",'"+row.getCell(1)+ "'");
        		tmpStr.append(","+row.getCell(2)+ "");
        		tmpStr.append(","+row.getCell(3)+ "");
        		tmpStr.append(","+row.getCell(4)+ "");
        		tmpStr.append(","+row.getCell(5)+ "");
        		tmpStr.append(","+row.getCell(6)+ "");
        		tmpStr.append(",'"+row.getCell(7)+ "'");
        		tmpStr.append(",'"+row.getCell(8)+ "'");
        		tmpStr.append(",'"+row.getCell(9)+ "'");
        		tmpStr.append(",'"+row.getCell(10)+ "'");
        		tmpStr.append(",'"+row.getCell(11)+ "'");
        		tmpStr.append(",'"+row.getCell(12)+ "'");
        		tmpStr.append(",'"+row.getCell(13)+ "'");
        		tmpStr.append(",'"+row.getCell(14)+ "'");
        		tmpStr.append(",'"+row.getCell(15)+ "'");
        		tmpStr.append(",'"+row.getCell(16)+ "'");
        		tmpStr.append(",'"+row.getCell(17)+ "'");
        		tmpStr.append(",'"+row.getCell(18)+ "'");
        		tmpStr.append(",'"+row.getCell(19)+ "'");
        		tmpStr.append(",'"+row.getCell(20)+ "'");
        		tmpStr.append(",'"+row.getCell(21)+ "'");
        		tmpStr.append(","+row.getCell(22)+ "");
        		tmpStr.append(");");
        		tmpStr.append("\r\n");
        		
        		//可疑记录表
        		tmpStr.append("insert into tppaml.T_DATA_NOTES(ID");
        		tmpStr.append(",RCD_TYPE");
        		tmpStr.append(",DATA_ID");
        		tmpStr.append(",RCD_TIME");
        		tmpStr.append(",RECORDER");
        		tmpStr.append(",RCD_CLASS");
        		tmpStr.append(",RCD_CONT");
        		
        		tmpStr.append(") values(");
        		
        		tmpStr.append("sys_guid()");
        		tmpStr.append(",'STAN_CTIF_02'");
        		tmpStr.append(",'"+id + "'");
        		//随机生成一定范围内的时间
        		/*tmpStr.append(",to_date('"+sheet.getCell(23, i).getContents()+ "','yyyy-MM-dd HH24:mi:ss')");
        		tmpStr.append(",'"+sheet.getCell(24, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(25, i).getContents()+ "'");
        		tmpStr.append(",'"+sheet.getCell(26, i).getContents()+ "'");*/
        		tmpStr.append(",to_date('"+row.getCell(23)+ "','yyyy-MM-dd HH24:mi:ss')");
        		tmpStr.append(",'"+row.getCell(24)+ "'");
        		tmpStr.append(",'"+row.getCell(25)+ "'");
        		tmpStr.append(",'"+row.getCell(26)+ "'");
        		tmpStr.append(");");
        		tmpStr.append("\r\n");
        		
        		//System.out.println(i+":"+tmpStr);
        		finalBuf.append(tmpStr.toString());
        		size ++;
        		if(count%10000==1){
        			File toFile = new File(toFilePath+count+".sql");
        			FileUtils.genFile(toFile, finalBuf.toString());
        			finalBuf = new StringBuffer();
        			count++;
        		}
        		File toFile = new File(toFilePath+count+".sql");
    			FileUtils.genFile(toFile, finalBuf.toString());
        	}
        //}  
        //最后关闭资源，释放内存  
        workBook.close();  
	}
	
	/**
	 * csv处理excel,生成多个sql文件
	 * @param args
	 * @throws IOException 
	 */
	public static void excel2cvs() throws IOException{
		
		//String fileName = "d:\\daniel.fang\\桌面\\read.xls";
    	String fileName = "d:\\daniel.fang\\桌面\\导入数据.csv";
		
		File file = new File(fileName);
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "GBK"));
		CSVReader reader = new CSVReader(rd);
		//先读出第一行数据（标题）,while从第二行开始处理
		reader.readNext();
		String[] tt;
		int i = 0;
		StringBuffer finalBuf = new StringBuffer();
		String toFilePath = "d:\\daniel.fang\\桌面\\testInsert\\";
    	int count = 0;
		while ((tt = reader.readNext()) != null) {
			StringBuffer tmpStr = new StringBuffer();
    		String id = UUID.randomUUID().toString().substring(4);
    		tmpStr.append("insert into tppaml.t_pstr_ctif(ID");
    		tmpStr.append(",SPCS_ST");
    		tmpStr.append(",WARN_DT");
    		tmpStr.append(",WARN_RL");
    		tmpStr.append(",IN_AMT");
    		tmpStr.append(",OUT_AMT");
    		tmpStr.append(",IN_NUM");
    		tmpStr.append(",OUT_NUM");
    		tmpStr.append(",RISK_LEVEL");
    		tmpStr.append(",CTNM");
    		tmpStr.append(",SMID");
    		tmpStr.append(",CITP");
    		tmpStr.append(",CITP_NT");
    		tmpStr.append(",CTID");
    		tmpStr.append(",CTAR");
    		tmpStr.append(",CCTL");
    		tmpStr.append(",CEML");
    		tmpStr.append(",CTVC");
    		tmpStr.append(",CRNM");
    		tmpStr.append(",CRIT");
    		tmpStr.append(",CRIT_NT");
    		tmpStr.append(",CRID");
    		tmpStr.append(",CTIF_TP");
    		tmpStr.append(",CLIENT_TP");
    		tmpStr.append(",SEQ_NO");
    		
    		tmpStr.append(") values('");
    		
    		tmpStr.append(id + "'");
    		tmpStr.append(",to_date('"+tt[0]+ "','yyyy-MM-dd')");
    		tmpStr.append(",'2'");
    		tmpStr.append(",'"+tt[1]+ "'");
    		tmpStr.append(","+tt[2]+ "");
    		tmpStr.append(","+tt[3]+ "");
    		tmpStr.append(","+tt[4]+ "");
    		tmpStr.append(","+tt[5]+ "");
    		tmpStr.append(","+tt[6]+ "");
    		tmpStr.append(",'"+tt[7]+ "'");
    		tmpStr.append(",'"+tt[8]+ "'");
    		tmpStr.append(",'"+tt[9]+ "'");
    		tmpStr.append(",'"+tt[10]+ "'");
    		tmpStr.append(",'"+tt[11]+ "'");
    		tmpStr.append(",'"+tt[12]+ "'");
    		tmpStr.append(",'"+tt[13]+ "'");
    		tmpStr.append(",'"+tt[14]+ "'");
    		tmpStr.append(",'"+tt[15]+ "'");
    		tmpStr.append(",'"+tt[16]+ "'");
    		tmpStr.append(",'"+tt[17]+ "'");
    		tmpStr.append(",'"+tt[18]+ "'");
    		tmpStr.append(",'"+tt[19]+ "'");
    		tmpStr.append(",'"+tt[20]+ "'");
    		tmpStr.append(",'"+tt[21]+ "'");
    		tmpStr.append(","+tt[22]+ "");
    		tmpStr.append(");");
    		tmpStr.append("\r\n");
    		
    		//可疑记录表
    		tmpStr.append("insert into tppaml.T_DATA_NOTES(ID");
    		tmpStr.append(",RCD_TYPE");
    		tmpStr.append(",DATA_ID");
    		tmpStr.append(",RCD_TIME");
    		tmpStr.append(",RECORDER");
    		tmpStr.append(",RCD_CLASS");
    		tmpStr.append(",RCD_CONT");
    		
    		tmpStr.append(") values(");
    		
    		tmpStr.append("sys_guid()");
    		tmpStr.append(",'STAN_CTIF_02'");
    		tmpStr.append(",'"+id + "'");
    		//随机生成一定范围内的时间
    		/*tmpStr.append(",to_date('"+sheet.getCell(23, i).getContents()+ "','yyyy-MM-dd HH24:mi:ss')");
    		tmpStr.append(",'"+sheet.getCell(24, i).getContents()+ "'");
    		tmpStr.append(",'"+sheet.getCell(25, i).getContents()+ "'");
    		tmpStr.append(",'"+sheet.getCell(26, i).getContents()+ "'");*/
    		tmpStr.append(",to_date('"+tt[23]+ "','yyyy-MM-dd HH24:mi:ss')");
    		tmpStr.append(",'"+tt[24]+ "'");
    		tmpStr.append(",'"+tt[25]+ "'");
    		tmpStr.append(",'"+tt[26]+ "'");
    		tmpStr.append(");");
    		tmpStr.append("\r\n");
    		
    		//System.out.println(i+":"+tmpStr);
    		finalBuf.append(tmpStr.toString());
    		if (i % 1000 == 1) {
    			File toFile = new File(toFilePath+count+".sql");
    			FileUtils.genFile(toFile, finalBuf.toString());
    			finalBuf = new StringBuffer();
				System.out.println("commit records:" + i);
				count++;
			}
			i++;
		}
		File toFile = new File(toFilePath+count+".sql");
		FileUtils.genFile(toFile, finalBuf.toString());
	}
	
	
	/**
	 * 反洗钱合规：根据csv生成ctl文件
	 * 注：excel文件的直接读取，数据量太大容易报错（堆内存溢出）
	 * main && note
	 * @param args
	 */
	public void geneMainCtlFile(){
		//每增加一个批次，计数器加1
		int count = 0;
		String filePath = "d:\\daniel.fang\\桌面\\央行合规—数据修复\\央行合规—数据修复_RM_";
		try {
			//String fileName = "d:\\daniel.fang\\桌面\\main.csv";
			//String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2016.1.19\\main-企业-待确认.csv";
			//String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2016.1.19\\main-个人-待确认.csv";
			
			String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2016.3.28\\main-跨境导入版-已排除.csv";
			//String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2016.3.28\\main-企业-已排除.csv";
			//String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2016.3.28\\main-个人-已排除.csv";
			File file = new File(fileName);
			//编码问题原因：1)导入数据报超长错误，但是实际数据长度合理
			BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			//BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			StringBuffer finalBuf = new StringBuffer();
			StringBuffer noteBuf = new StringBuffer();
			
			String type = "main";
			//String type = "txn";
			//String type = "note";
			String head = genCtlHead("main");
			finalBuf.append(head);
			String noteHead = genCtlHead("note");
			noteBuf.append(noteHead);
			String fileType = "企业-已排除_";
			//String fileType = "个人-已排除_";
			while ((tt = reader.readNext()) != null) {
				String body = genCtlBody(tt, "main");
				finalBuf.append(body);
				//note
				String noteBody = genCtlBody(tt, "note");
				noteBuf.append(noteBody);
				count++;
				//每100000个批次执行一次批量更新
				if(!(count==1) && count%30000==1){//设置为30000,100000会导致堆内存溢出
					//写出到文件
					System.out.println("count : "+count);
					write2File(filePath+"main"+fileType+count+".ctl", finalBuf.toString());
					write2File(filePath+"note"+fileType+count+".ctl", noteBuf.toString());
					//重置Buf
					finalBuf = new StringBuffer();
					finalBuf.append(head);
					noteBuf = new StringBuffer();
					noteBuf.append(noteHead);
					count++;
				}
			}
			System.out.println("count : "+count);
			write2File(filePath+"main_"+fileType+count+".ctl", finalBuf.toString());
			write2File(filePath+"note_"+fileType+count+".ctl", noteBuf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 反洗钱合规：生成txn的ctl文件
	 * txn
	 */
	public void geneTxnCtlFile(){
		//每增加一个批次，计数器加1
		int count = 0;
		String filePath = "d:\\daniel.fang\\桌面\\央行合规—数据修复\\央行合规—数据修复_RM_";
		try {
			//TODO 1
			//String fileName = "d:\\daniel.fang\\桌面\\txn.csv";
			String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\央行合规—数据修复_RM_2015.7.12\\txn.csv";
			//main_all_columns
			//String fileName = "D:\\99bill\\RM运维\\反洗钱\\反洗钱数据修复\\数据备份\\main17.csv";
			//txn_all_columns
			//String fileName = "d:\\daniel.fang\\桌面\\2015.3.25反洗钱数据修复\\tppaml.csv";
			File file = new File(fileName);
			//TODO 2
			BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			//TODO DM导出来的csv是utf-8编码,导致GBK读取时候会报错：java.lang.ArrayIndexOutOfBoundsException: 36
			//BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			StringBuffer finalBuf = new StringBuffer();
			
			//TODO 3
			String type = "txn";
			//main_all_columns
			//String type = "main_all_columns";
			//txn_all_columns
			//String type = "txn_all_columns";
			String head = genCtlHead(type);
			finalBuf.append(head);
			while ((tt = reader.readNext()) != null) {
				// System.out.println("1 count:"+count);
				String body = genCtlBody(tt, type);
				finalBuf.append(body);
				count++;
				
				/**
				 * //TODO 每30000个批次执行一次批量更新
				 * 出现以下异常需要减少每批次的数目
				 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
				 */
				if(!(count==1) && count%30000==1){//DM导出来的csv，30000会报错
					//写出到文件
					System.out.println("count : "+count);
					write2File(filePath+type+"_"+count+".ctl", finalBuf.toString());
					//重置Buf
					finalBuf = new StringBuffer();
					finalBuf.append(head);
					count++;
				}
			}
			System.out.println("count : "+count);
			write2File(filePath+type+"_"+count+".ctl", finalBuf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 反洗钱ctl的head
	 * @param type
	 * @return
	 */
	private String genCtlHead(String type){
		StringBuffer headBuf = new StringBuffer();
		headBuf.append("-------------"+"\r\n");
		headBuf.append("--SCHEMA:TPPAML"+"\r\n");
		headBuf.append("--insert:大约100000 records"+"\r\n");
		headBuf.append("-------------"+"\r\n");
		headBuf.append("LOAD DATA"+"\r\n");
		headBuf.append("INFILE *"+"\r\n");
		if("main".equals(type)){
			headBuf.append("APPEND INTO TABLE TPPAML.T_PSTR_CTIF"+"\r\n");
			headBuf.append("Fields terminated by \';\'"+"\r\n");
			headBuf.append("trailing nullcols"+"\r\n");
			headBuf.append("(ID char,"+"\r\n"
					+"SPCS_ST,"+"\r\n"//可疑状态必须赋值
					+"WARN_DT date\"yyyy-MM-dd\","+"\r\n"
					+"CREATE_TIME date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"
					+"RDDT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//生成时间
					+"WARN_RL,"+"\r\n"
					+"IN_AMT,"+"\r\n"
					+"OUT_AMT,"+"\r\n"
					+"IN_NUM,"+"\r\n"
					+"OUT_NUM,"+"\r\n"
					+"RISK_LEVEL,"+"\r\n"
					+"CTNM,"+"\r\n"
					+"SMID,"+"\r\n"
					+"CITP,"+"\r\n"
					+"CITP_NT,"+"\r\n"
					+"CTID,"+"\r\n"
					+"CTAR,"+"\r\n"
					+"CCTL,"+"\r\n"
					+"CEML,"+"\r\n"
					+"CTVC,"+"\r\n"
					+"CRNM,"+"\r\n"
					+"CRIT,"+"\r\n"
					+"CRIT_NT,"+"\r\n"
					+"CRID,"+"\r\n"
					+"CTIF_TP,"+"\r\n"
					+"CLIENT_TP"+"\r\n"
					);
		}else if("main_all_columns".equals(type)){//主体：全字段
			headBuf.append("APPEND INTO TABLE TPPAML.T_PSTR_CTIF"+"\r\n");
			headBuf.append("Fields terminated by \';\'"+"\r\n");
			headBuf.append("trailing nullcols"+"\r\n");
			headBuf.append("(REP_ID,"+"\r\n"//报告ID
					+"SEQ_NO,"+"\r\n"//可疑主体编号
					+"CTNM,"+"\r\n"//可疑主体姓名/名称
					+"SMID,"+"\r\n"//主体特约商户编号
					+"CITP,"+"\r\n"//可疑主体身份证件/证明文件类型
					+"CTID,"+"\r\n"//可疑主体身份证件/证明文件号码
					+"CTAR,"+"\r\n"//详细住址
					+"CCTL,"+"\r\n"//联系电话
					+"CEML,"+"\r\n"//电子邮件
					+"CTVC,"+"\r\n"//可疑主体的职业/行业类别
					+"CRNM,"+"\r\n"//可疑主体的法定代表人姓名
					+"CRIT,"+"\r\n"//可疑主体的法定代表人身份证件类型
					+"CRID,"+"\r\n"//可疑主体的法定代表人身份证件号码
					+"IN_NUM,"+"\r\n"//交易笔数（收）
					+"IN_AMT,"+"\r\n"//交易金额（收）
					+"OUT_NUM,"+"\r\n"//交易笔数（支）
					+"OUT_AMT,"+"\r\n"//交易金额（支）
					+"RISK_LEVEL,"+"\r\n"//风险等级
					+"COMP_SCORE,"+"\r\n"//综合评分
					+"LSTP,"+"\r\n"//名单类别
					+"SPCS_ST,"+"\r\n"//可疑状态
					+"WARN_DT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//预警日期:历史数据，该字段都是时间，不是日期
					+"WARN_KD,"+"\r\n"//预警方式
					+"WARN_RL,"+"\r\n"//预警规则
					+"CTIF_TP,"+"\r\n"//主体类型
					+"MEND_ST,"+"\r\n"//补录状态
					+"RDDT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//生成时间
					+"CHECK_ST,"+"\r\n"//校验状态
					+"SUSP_INDEX,"+"\r\n"//可疑指数
					+"CTIF_ID,"+"\r\n"//标准主体ID
					+"CLIENT_TP,"+"\r\n"//客户类型
					+"CITP_NT,"+"\r\n"//可疑主体身份证件类型说明
					+"CRIT_NT,"+"\r\n"//可疑主体的法人身份证件类型说明
					+"STIF_NUM,"+"\r\n"//交易总数
					+"STIF_NONUM,"+"\r\n"//校验交易未通过数
					+"CTIF_NO,"+"\r\n"//导入交易时，根据此字段匹配主体
					+"DOUBUTCLASS,"+"\r\n"//事由类别
					+"ID,"+"\r\n"//
					+"REMARK,"+"\r\n"//具体事由
					+"CREATE_TIME date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//创建时间
					+"MEND_TM date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//补录时间
					+"MENDER"+"\r\n"//补录人
					);
		}else if("txn_all_columns".equals(type)){//交易：全字段
			headBuf.append("APPEND INTO TABLE TPPAML.T_PSTR_STIF"+"\r\n");
			headBuf.append("Fields terminated by \';\'"+"\r\n");
			headBuf.append("trailing nullcols"+"\r\n");
			headBuf.append("(ID,"+"\r\n"//详细ID
					+"REP_ID,"+"\r\n"//报告ID
					+"SEQ_NO,"+"\r\n"//可疑交易序号
					+"CTNM,"+"\r\n"//可疑主体姓名/名称
					+"CITP,"+"\r\n"//可疑主体身份证件/证明文件类型
					+"CTID,"+"\r\n"//可疑主体身份证件/证明文件号码
					+"CBAT,"+"\r\n"//可疑主体的银行账号种类
					+"CBAC,"+"\r\n"//可疑主体的银行账号
					+"CABM,"+"\r\n"//可疑主体银行账号的开户行名称
					+"CTAT,"+"\r\n"//可疑主体的交易账号种类
					+"CTAC,"+"\r\n"//可疑主体的交易账号
					+"CPIN,"+"\r\n"//可疑主体所在支付机构的名称
					+"CPBA,"+"\r\n"//可疑主体所在支付机构的银行账号
					+"CPBN,"+"\r\n"//可疑主体所在支付机构的银行账号的开户行名称
					+"CTIP,"+"\r\n"//可疑主体的交易IP地址
					+"TSTM,"+"\r\n"//交易时间
					+"CTTP,"+"\r\n"//货币资金转移方式
					+"TSDR,"+"\r\n"//资金收付标志
					+"CRPP,"+"\r\n"//资金用途
					+"CRTP,"+"\r\n"//交易币种
					+"CRAT,"+"\r\n"//交易金额
					+"TCNM,"+"\r\n"//交易对手姓名/名称
					+"TSMI,"+"\r\n"//交易对手特约商户编号
					+"TCIT,"+"\r\n"//交易对手证件/证明文件类型
					+"TCID,"+"\r\n"//交易对手证件/证明文件号码
					+"TCAT,"+"\r\n"//交易对手的银行账号种类
					+"TCBA,"+"\r\n"//交易对手的银行账号
					+"TCBN,"+"\r\n"//交易对手银行账号的开户行名称
					+"TCTT,"+"\r\n"//交易对手的交易账号种类
					+"TCTA,"+"\r\n"//交易对手的交易账号
					+"TCPN,"+"\r\n"//交易对手所在支付机构的名称
					+"TCPA,"+"\r\n"//交易对手所在支付机构的银行账号
					+"TPBN,"+"\r\n"//交易对手所在支付机构银行账号的开户行名称
					+"TCIP,"+"\r\n"//交易对手的交易IP地址
					+"TMNM,"+"\r\n"//交易商品名称
					+"BPTC,"+"\r\n"//银行与支付机构之间的业务交易编码
					+"PMTC,"+"\r\n"//支付机构与商户之间的业务交易编码
					+"TICD,"+"\r\n"//业务标识号
					+"REDT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//生成时间
					+"RPD_ID,"+"\r\n"//主体ID
					+"IS_USE,"+"\r\n"//使用状态
					+"MEND_ST,"+"\r\n"//补录状态
					+"CHECK_ST,"+"\r\n"//校验状态
					+"SPCS_ST,"+"\r\n"//可疑状态
					+"WARN_DT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//预警日期:历史数据，该字段都是时间，不是日期
					+"CITP_NT,"+"\r\n"//可疑主体身份证件/证明文件类型说明
					+"TCIT_NT,"+"\r\n"//交易对手证件/证明文件类型说明
					+"SMID,"+"\r\n"//主体特约商户编号
					+"CTIF_ID,"+"\r\n"//标准主体ID
					+"CREATE_TIME date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//创建时间
					+"REMARK,"+"\r\n"//具体事由
					+"DOUBUTCLASS,"+"\r\n"//事由类别
					+"MEND_TM date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//补录时间
					+"MENDER"+"\r\n"//补录人
					);
		}else if("txn".equals(type)){
			headBuf.append("APPEND INTO TABLE TPPAML.T_PSTR_STIF"+"\r\n");
			headBuf.append("Fields terminated by \';\'"+"\r\n");
			headBuf.append("trailing nullcols"+"\r\n");
			headBuf.append("(ID,"+"\r\n"
					+"SPCS_ST,"+"\r\n"//可疑状态必须赋值2
					+"WARN_DT date\"yyyy-MM-dd\","+"\r\n"
					+"CREATE_TIME date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"
					+"REDT date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"//生成时间
					+"REMARK,"+"\r\n"
					+"CTNM,"+"\r\n"
					+"CITP,"+"\r\n"
					+"CITP_NT,"+"\r\n"
					+"CTID,"+"\r\n"
					+"CBAT,"+"\r\n"
					+"CBAC,"+"\r\n"
					+"CABM,"+"\r\n"
					+"CTAT,"+"\r\n"
					+"CTAC,"+"\r\n"
					+"CPIN,"+"\r\n"
					+"CPBA,"+"\r\n"
					+"CPBN,"+"\r\n"
					+"CTIP,"+"\r\n"
					+"TSTM,"+"\r\n"
					+"CTTP,"+"\r\n"
					+"TSDR,"+"\r\n"
					+"CRPP,"+"\r\n"
					+"CRTP,"+"\r\n"
					+"CRAT,"+"\r\n"
					+"TCNM,"+"\r\n"
					+"TSMI,"+"\r\n"
					+"TCIT,"+"\r\n"
					+"TCIT_NT,"+"\r\n"
					+"TCID,"+"\r\n"
					+"TCAT,"+"\r\n"
					+"TCBA,"+"\r\n"
					+"TCBN,"+"\r\n"
					+"TCTT,"+"\r\n"
					+"TCTA,"+"\r\n"
					+"TCPN,"+"\r\n"
					+"TCPA,"+"\r\n"
					+"TPBN,"+"\r\n"
					+"TCIP,"+"\r\n"
					+"TMNM,"+"\r\n"
					+"BPTC,"+"\r\n"
					+"PMTC,"+"\r\n"
					+"TICD,"+"\r\n"
					+"RPD_ID"+"\r\n"
					);
		}else if("note".equals(type)){
			headBuf.append("APPEND INTO TABLE TPPAML.T_DATA_NOTES"+"\r\n");
			headBuf.append("Fields terminated by \';\'"+"\r\n");
			headBuf.append("trailing nullcols"+"\r\n");
			headBuf.append("(ID,"+"\r\n"
					+"DATA_ID,"+"\r\n"
					+"RCD_TYPE,"+"\r\n"
					+"RCD_TIME date\"yyyy-MM-dd hh24:mi:ss\","+"\r\n"
					+"RECORDER,"+"\r\n"
					+"RCD_CLASS,"+"\r\n"
					+"RCD_CONT"+"\r\n"
					);
			
		}
		headBuf.append(")"+"\r\n");
		headBuf.append("BEGINDATA"+"\r\n");
		return headBuf.toString();
	}
	
	
	/**
	 * 反洗钱ctl的body
	 * @param tt
	 * @param type
	 * @return
	 */
	private String genCtlBody(String[] tt, String type){
		String body = "";
		if("main".equals(type)){
			//excel中的"主体编号"，是随机生成的32位UUID，赋值进去
			//String id = UUID.randomUUID().toString().substring(4);
			String WARN_DT= tt[0];
			String WARN_RL= tt[1];
			String IN_AMT= tt[2];
			String OUT_AMT= tt[3];
			String IN_NUM= tt[4];
			String OUT_NUM= tt[5];
			String RISK_LEVEL= tt[6];
			String CTNM= tt[7];
			String SMID= tt[8];
			String CITP= tt[9];
			String CITP_NT= tt[10];
			String CTID= tt[11];
			String CTAR= tt[12];
			String CCTL= tt[13];
			String CEML= tt[14];
			String CTVC= tt[15];
			String CRNM= tt[16];
			String CRIT= tt[17];
			String CRIT_NT= tt[18];
			String CRID= tt[19];
			String CTIF_TP= tt[20];
			String CLIENT_TP= tt[21];
			String SEQ_NO= tt[22];
			
			body = SEQ_NO
			+";2"//0待确认,1已确认,2已排除
			+";"+WARN_DT
			+";"+WARN_DT
			+";"+WARN_DT
			+";"+WARN_RL
			+";"+IN_AMT
			+";"+OUT_AMT
			+";"+IN_NUM
			+";"+OUT_NUM
			+";"+RISK_LEVEL
			+";"+CTNM
			+";"+SMID
			+";"+CITP
			+";"+CITP_NT
			+";"+CTID
			+";"+CTAR
			+";"+CCTL
			+";"+CEML
			+";"+CTVC
			+";"+CRNM
			+";"+CRIT
			+";"+CRIT_NT
			+";"+CRID
			+";"+CTIF_TP
			+";"+CLIENT_TP
			+ "\r\n";
		}else if("main_all_columns".equals(type)){
			String REP_ID=tt[0];//报告ID
			String SEQ_NO=tt[1];//可疑主体编号
			String CTNM=tt[2];//可疑主体姓名/名称
			String SMID=tt[3];//主体特约商户编号
			String CITP=tt[4];//可疑主体身份证件/证明文件类型
			String CTID=tt[5];//可疑主体身份证件/证明文件号码
			String CTAR=tt[6];//详细住址
			String CCTL=tt[7];//联系电话
			String CEML=tt[8];//电子邮件
			String CTVC=tt[9];//可疑主体的职业/行业类别
			String CRNM=tt[10];//可疑主体的法定代表人姓名
			String CRIT=tt[11];//可疑主体的法定代表人身份证件类型
			String CRID=tt[12];//可疑主体的法定代表人身份证件号码
			String IN_NUM=tt[13];//交易笔数（收）
			String IN_AMT=tt[14];//交易金额（收）
			String OUT_NUM=tt[15];//交易笔数（支）
			String OUT_AMT=tt[16];//交易金额（支）
			String RISK_LEVEL=tt[17];//风险等级
			String COMP_SCORE=tt[18];//综合评分
			String LSTP=tt[19];//名单类别
			String SPCS_ST=tt[20];//可疑状态
			String WARN_DT=tt[21];//预警日期
			String WARN_KD=tt[22];//预警方式
			String WARN_RL=tt[23];//预警规则
			String CTIF_TP=tt[24];//主体类型
			String MEND_ST=tt[25];//补录状态
			String RDDT=tt[26];//生成时间
			String CHECK_ST=tt[27];//校验状态
			String SUSP_INDEX=tt[28];//可疑指数
			String CTIF_ID=tt[29];//标准主体ID
			String CLIENT_TP=tt[30];//客户类型
			String CITP_NT=tt[31];//可疑主体身份证件类型说明
			String CRIT_NT=tt[32];//可疑主体的法人身份证件类型说明
			String STIF_NUM=tt[33];//交易总数
			String STIF_NONUM=tt[34];//校验交易未通过数
			String CTIF_NO=tt[35];//导入交易时，根据此字段匹配主体
			String DOUBUTCLASS=tt[36];//事由类别
			String ID=tt[37];//
			String REMARK=tt[38];//具体事由
			String CREATE_TIME=tt[39];//创建时间
			String MEND_TM=tt[40];//补录时间
			String MENDER=tt[41];//补录人
			
			body = REP_ID//报告ID
			+";"+SEQ_NO//可疑主体编号
			+";"+CTNM//可疑主体姓名/名称
			+";"+SMID//主体特约商户编号
			+";"+CITP//可疑主体身份证件/证明文件类型
			+";"+CTID//可疑主体身份证件/证明文件号码
			+";"+CTAR//详细住址
			+";"+CCTL//联系电话
			+";"+CEML//电子邮件
			+";"+CTVC//可疑主体的职业/行业类别
			+";"+CRNM//可疑主体的法定代表人姓名
			+";"+CRIT//可疑主体的法定代表人身份证件类型
			+";"+CRID//可疑主体的法定代表人身份证件号码
			+";"+IN_NUM//交易笔数（收）
			+";"+IN_AMT//交易金额（收）
			+";"+OUT_NUM//交易笔数（支）
			+";"+OUT_AMT//交易金额（支）
			+";"+RISK_LEVEL//风险等级
			+";"+COMP_SCORE//综合评分
			+";"+LSTP//名单类别
			+";"+SPCS_ST//可疑状态
			+";"+WARN_DT//预警日期
			+";"+WARN_KD//预警方式
			+";"+WARN_RL//预警规则
			+";"+CTIF_TP//主体类型
			+";"+MEND_ST//补录状态
			+";"+RDDT//生成时间
			+";"+CHECK_ST//校验状态
			+";"+SUSP_INDEX//可疑指数
			+";"+CTIF_ID//标准主体ID
			+";"+CLIENT_TP//客户类型
			+";"+CITP_NT//可疑主体身份证件类型说明
			+";"+CRIT_NT//可疑主体的法人身份证件类型说明
			+";"+STIF_NUM//交易总数
			+";"+STIF_NONUM//校验交易未通过数
			+";"+CTIF_NO//导入交易时，根据此字段匹配主体
			+";"+DOUBUTCLASS//事由类别
			+";"+ID//
			+";"+REMARK//具体事由
			+";"+CREATE_TIME//创建时间
			+";"+MEND_TM//补录时间
			+";"+MENDER//补录人
			+ "\r\n";
		}else if("txn_all_columns".equals(type)){
			String ID=tt[0];//详细ID
			//System.out.println("tt[0]:"+ID);
			String REP_ID=tt[1];//报告ID
			String SEQ_NO=tt[2];//可疑交易序号
			String CTNM=tt[3];//可疑主体姓名/名称
			String CITP=tt[4];//可疑主体身份证件/证明文件类型
			String CTID=tt[5];//可疑主体身份证件/证明文件号码
			String CBAT=tt[6];//可疑主体的银行账号种类
			String CBAC=tt[7];//可疑主体的银行账号
			String CABM=tt[8];//可疑主体银行账号的开户行名称
			String CTAT=tt[9];//可疑主体的交易账号种类
			String CTAC=tt[10];//可疑主体的交易账号
			String CPIN=tt[11];//可疑主体所在支付机构的名称
			String CPBA=tt[12];//可疑主体所在支付机构的银行账号
			String CPBN=tt[13];//可疑主体所在支付机构的银行账号的开户行名称
			String CTIP=tt[14];//可疑主体的交易IP地址
			String TSTM=tt[15];//交易时间
			String CTTP=tt[16];//货币资金转移方式
			String TSDR=tt[17];//资金收付标志
			String CRPP=tt[18];//资金用途
			String CRTP=tt[19];//交易币种
			String CRAT=tt[20];//交易金额
			String TCNM=tt[21];//交易对手姓名/名称
			String TSMI=tt[22];//交易对手特约商户编号
			String TCIT=tt[23];//交易对手证件/证明文件类型
			String TCID=tt[24];//交易对手证件/证明文件号码
			//System.out.println("tt[24]:"+TCID);
			String TCAT=tt[25];//交易对手的银行账号种类
			//System.out.println("tt[25]:"+TCAT);
			String TCBA=tt[26];//交易对手的银行账号
			String TCBN=tt[27];//交易对手银行账号的开户行名称
			String TCTT=tt[28];//交易对手的交易账号种类
			String TCTA=tt[29];//交易对手的交易账号
			String TCPN=tt[30];//交易对手所在支付机构的名称
			String TCPA=tt[31];//交易对手所在支付机构的银行账号
			String TPBN=tt[32];//交易对手所在支付机构银行账号的开户行名称
			String TCIP=tt[33];//交易对手的交易IP地址
			//System.out.println("tt[33]:"+TCIP);
			String TMNM=tt[34];//交易商品名称
			//System.out.println("tt[34]:"+TMNM);
			String BPTC=tt[35];//银行与支付机构之间的业务交易编码
			//3339行java.lang.ArrayIndexOutOfBoundsException: 36
			//System.out.println("tt[35]:"+BPTC);
			String PMTC=tt[36];//支付机构与商户之间的业务交易编码
			//System.out.println("tt[36]:"+PMTC);
			String TICD=tt[37];//业务标识号
			String REDT=tt[38];//生成时间
			String RPD_ID=tt[39];//主体ID
			String IS_USE=tt[40];//使用状态
			String MEND_ST=tt[41];//补录状态
			String CHECK_ST=tt[42];//校验状态
			String SPCS_ST=tt[43];//可疑状态
			String WARN_DT=tt[44];//预警日期
			//System.out.println("tt[44]:"+WARN_DT);
			String CITP_NT=tt[45];//可疑主体身份证件/证明文件类型说明
			String TCIT_NT=tt[46];//交易对手证件/证明文件类型说明
			String SMID=tt[47];//主体特约商户编号
			String CTIF_ID=tt[48];//标准主体ID
			String CREATE_TIME=tt[49];//创建时间
			String REMARK=tt[50];//具体事由
			String DOUBUTCLASS=tt[51];//事由类别
			String MEND_TM=tt[52];//补录时间
			String MENDER=tt[53];//补录人
			
			body = ID//详细ID
			+";"+REP_ID//报告ID
			+";"+SEQ_NO//可疑交易序号
			+";"+CTNM//可疑主体姓名/名称
			+";"+CITP//可疑主体身份证件/证明文件类型
			+";"+CTID//可疑主体身份证件/证明文件号码
			+";"+CBAT//可疑主体的银行账号种类
			+";"+CBAC//可疑主体的银行账号
			+";"+CABM//可疑主体银行账号的开户行名称
			+";"+CTAT//可疑主体的交易账号种类
			+";"+CTAC//可疑主体的交易账号
			+";"+CPIN//可疑主体所在支付机构的名称
			+";"+CPBA//可疑主体所在支付机构的银行账号
			+";"+CPBN//可疑主体所在支付机构的银行账号的开户行名称
			+";"+CTIP//可疑主体的交易IP地址
			+";"+TSTM//交易时间
			+";"+CTTP//货币资金转移方式
			+";"+TSDR//资金收付标志
			+";"+CRPP//资金用途
			+";"+CRTP//交易币种
			+";"+CRAT//交易金额
			+";"+TCNM//交易对手姓名/名称
			+";"+TSMI//交易对手特约商户编号
			+";"+TCIT//交易对手证件/证明文件类型
			+";"+TCID//交易对手证件/证明文件号码
			+";"+TCAT//交易对手的银行账号种类
			+";"+TCBA//交易对手的银行账号
			+";"+TCBN//交易对手银行账号的开户行名称
			+";"+TCTT//交易对手的交易账号种类
			+";"+TCTA//交易对手的交易账号
			+";"+TCPN//交易对手所在支付机构的名称
			+";"+TCPA//交易对手所在支付机构的银行账号
			+";"+TPBN//交易对手所在支付机构银行账号的开户行名称
			+";"+TCIP//交易对手的交易IP地址
			+";"+TMNM//交易商品名称
			+";"+BPTC//银行与支付机构之间的业务交易编码
			+";"+PMTC//支付机构与商户之间的业务交易编码
			+";"+TICD//业务标识号
			+";"+REDT//生成时间
			+";"+RPD_ID//主体ID
			+";"+IS_USE//使用状态
			+";"+MEND_ST//补录状态
			+";"+CHECK_ST//校验状态
			+";"+SPCS_ST//可疑状态
			+";"+WARN_DT//预警日期
			+";"+CITP_NT//可疑主体身份证件/证明文件类型说明
			+";"+TCIT_NT//交易对手证件/证明文件类型说明
			+";"+SMID//主体特约商户编号
			+";"+CTIF_ID//标准主体ID
			+";"+CREATE_TIME//创建时间
			+";"+REMARK//具体事由
			+";"+DOUBUTCLASS//事由类别
			+";"+MEND_TM//补录时间
			+";"+MENDER//补录人
			+ "\r\n";
		}else if("txn".equals(type)){
			String id = UUID.randomUUID().toString().substring(4);
			String WARN_DT= tt[0];
			String REMARK = tt[1];
			String CTNM   = tt[2];
			String CITP   = tt[3];
			String CITP_NT= tt[4];
			String CTID   = tt[5];
			String CBAT   = tt[6];
			String CBAC   = tt[7];
			String CABM   = tt[8];
			String CTAT   = tt[9];
			String CTAC   = tt[10];
			String CPIN   = tt[11];
			String CPBA   = tt[12];
			String CPBN   = tt[13];
			String CTIP   = tt[14];
			String TSTM   = tt[15];
			String CTTP   = tt[16];
			String TSDR   = tt[17];
			String CRPP   = tt[18];
			String CRTP   = tt[19];
			String CRAT   = tt[20];
			String TCNM   = tt[21];
			String TSMI   = tt[22];
			String TCIT   = tt[23];
			String TCIT_NT= tt[24];
			String TCID   = tt[25];
			String TCAT   = tt[26];
			String TCBA   = tt[27];
			String TCBN   = tt[28];
			String TCTT   = tt[29];
			String TCTA   = tt[30];
			String TCPN   = tt[31];
			String TCPA   = tt[32];
			String TPBN   = tt[33];
			String TCIP   = tt[34];
			String TMNM   = tt[35];
			String BPTC   = tt[36];
			String PMTC   = tt[37];
			String TICD   = tt[38];
			String RPD_ID = tt[39];
			
			body = id 
			+";2"//0待确认,1已确认,2已排除
			+";"+WARN_DT
			+";"+WARN_DT
			+";"+WARN_DT
			+";"+REMARK
			+";"+CTNM
			+";"+CITP
			+";"+CITP_NT
			+";"+CTID
			+";"+CBAT
			+";"+CBAC
			+";"+CABM
			+";"+CTAT
			+";"+CTAC
			+";"+CPIN
			+";"+CPBA
			+";"+CPBN
			+";"+CTIP
			+";"+TSTM
			+";"+CTTP//货币资金转移方式
			+";"+TSDR//资金收付标志
			+";"+CRPP
			+";"+CRTP
			+";"+CRAT
			+";"+TCNM
			+";"+TSMI
			+";"+TCIT
			+";"+TCIT_NT
			+";"+TCID
			+";"+TCAT//交易对手的银行账号种类
			+";"+TCBA
			+";"+TCBN
			+";"+TCTT
			+";"+TCTA
			+";"+TCPN
			+";"+TCPA
			+";"+TPBN
			+";"+TCIP
			+";"+TMNM
			+";"+BPTC
			+";"+PMTC
			+";"+TICD
			+";"+RPD_ID
			+ "\r\n";
		}else if("note".equals(type)){
			String id = UUID.randomUUID().toString().substring(4);
			String SEQ_NO= tt[22];
			String RCD_TIME= tt[23];
			String RECORDER= tt[24];
			String RCD_CLASS= tt[25];
			String RCD_CONT= tt[26];
			
			body = id
			+";"+SEQ_NO
			+";STAN_CTIF_02"	//必须有该值，“已排除可疑”——“事由类别”才有记录
			+";"+RCD_TIME
			+";"+RECORDER
			+";"+RCD_CLASS
			+";"+RCD_CONT
			+ "\r\n";
		}
		return body;
	}
	
	/**
	 * String写入到文件
	 * @param fileName
	 * @param str
	 */
	private void write2File(String fileName, String str) {
		try {
			FileWriterWithEncoding f = new FileWriterWithEncoding(fileName, "GBK");
			BufferedWriter bf = new BufferedWriter(f);
			/*FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bf = new BufferedWriter(fileWriter);*/
			bf.write(str);
			bf.flush();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		//ExcelUtils.readExcel();
		//main&note
		new ExcelUtils().geneMainCtlFile();
		//txn or txn_all_columns
		//new ExcelUtils().geneTxnCtlFile();
		
		/**
		 * 生成主体编号
		 */
		/*String fileName = "d:\\daniel.fang\\桌面\\main4000.txt";
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<4000;i++){//40万：java.lang.OutOfMemoryError: Java heap space
			String no = UUID.randomUUID().toString().substring(4);
			buf.append(no+"\r\n");
		}
		new ExcelUtils().write2File(fileName, buf.toString());*/
	}
	
}
