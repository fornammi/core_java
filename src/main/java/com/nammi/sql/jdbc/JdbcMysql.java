package com.nammi.sql.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.opencsv.CSVReader;

public class JdbcMysql {
	private static String driverClass = "com.mysql.jdbc.Driver";
	//private static String jdbcUrl = "jdbc:mysql://192.168.64.6:3330/rcs_db";
	//ps.setString()中文乱码解决：jdbc url里指定编码characterEncoding=utf8
	private static String jdbcUrl = "jdbc:mysql://192.168.6.49:3306/rcs_db?characterEncoding=UTF-8";
	private static String userId = "rcs";
	private static String password = "rcs123";
	
	private static String insertSql1 = "insert into t_rm_cellphone_source(id,number,province,city,card,section,zip)" +
			" values(?,?,?,?,?,?,?)";
	
	private static String insertSql2 = "insert into t_rm_country_ip_source(id,start_ip,end_ip,code2,start_ip1,end_ip1)" +
	" values(?,?,?,?,?,?)";
	
	private static String insertSql3 = "insert into t_rm_city_ip_source(id,start_ip,end_ip,province,city,isp,start_ip1,end_ip1)" +
	" values(?,?,?,?,?,?,?,?)";
	
	/**
	 * 前提：利用PL/SQL 导出oracle数据到csv文件
	 * 此处实现功能：将csv文件的数据导入mysql数据库中
	 */
	public void insertDataFromCSV(String fileName, String sql){
		try {
			Class.forName(driverClass);
			Connection con = java.sql.DriverManager.getConnection(jdbcUrl,userId, password);
			PreparedStatement ps = con.prepareStatement(sql);
			File file = new File(fileName);
			//如果tt索引存在，但还是报下标越界异常，则可能是乱码
			BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			//BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			int i = 0;
			while ((tt = reader.readNext()) != null) {
				/*if (tt == null || tt.length < 11) {
					if (tt != null) {
						for (String t : tt) {
							System.out.println("------" + t);
						}
					} else {
						System.out.println("nullllllllllllllllllll");
					}
					continue;
				}*/
				ps.setInt(1, Integer.parseInt(tt[0]));
				ps.setString(2, tt[1]);
				ps.setString(3, tt[2]);
				ps.setString(4, tt[3]);
				ps.setString(5, tt[4]);
				ps.setString(6, tt[5]);
				ps.setString(7, tt[6]);
				ps.addBatch();
				if (i % 1000 == 1) {
					ps.executeBatch();
					System.out.println("commit records[1]:" + i);
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
	
	
	public void insertDataFromCSV2(String fileName, String sql){
		try {
			Class.forName(driverClass);
			Connection con = java.sql.DriverManager.getConnection(jdbcUrl,userId, password);
			PreparedStatement ps = con.prepareStatement(sql);
			File file = new File(fileName);
			//如果tt索引存在，但还是报下标越界异常，则可能是乱码
			BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			//BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			int i = 0;
			while ((tt = reader.readNext()) != null) {
				ps.setInt(1, Integer.parseInt(tt[0]));
				ps.setLong(2, Long.parseLong(tt[1]));
				ps.setLong(3, Long.parseLong(tt[2]));
				ps.setString(4, tt[3]);
				ps.setString(5, tt[4]);
				ps.setString(6, tt[5]);
				ps.addBatch();
				if (i % 1000 == 1) {
					ps.executeBatch();
					System.out.println("commit records[2]:" + i);
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
	
	
	public void insertDataFromCSV3(String fileName, String sql){
		try {
			Class.forName(driverClass);
			Connection con = java.sql.DriverManager.getConnection(jdbcUrl,userId, password);
			PreparedStatement ps = con.prepareStatement(sql);
			File file = new File(fileName);
			//如果tt索引存在，但还是报下标越界异常，则可能是乱码
			BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			//BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			CSVReader reader = new CSVReader(rd);
			//先读出第一行数据（标题）,while从第二行开始处理
			reader.readNext();
			String[] tt;
			int i = 0;
			while ((tt = reader.readNext()) != null) {
				ps.setInt(1, Integer.parseInt(tt[0]));
				ps.setLong(2, Long.parseLong(tt[1]));
				ps.setLong(3, Long.parseLong(tt[2]));
				ps.setString(4, tt[3]);
				ps.setString(5, tt[4]);
				ps.setString(6, tt[5]);
				ps.setString(7, tt[6]);
				ps.setString(8, tt[7]);
				ps.addBatch();
				if (i % 1000 == 1) {
					ps.executeBatch();
					System.out.println("commit records[3]:" + i);
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
	 * ps.set的分类处理
	 * 思路：获取插入表结构的元数据，自动生成set
	 * @param ps
	 * @param tt
	 */
	private void setValue(PreparedStatement ps, String[] tt){
		
	}
	
	
	public static void main(String[] args) {
		String filePath = "d:\\daniel.fang\\桌面\\IP库更新";
		
		//ip手机
		String fileName = "skeye.temp_cellphone.csv";
		//ip国家
		String fileName2 = "skeye.temp_country_ip.csv";
		//ip城市
		String fileName3 = "skeye.temp_city_ip.csv";
		
		//csv数据导入到表中
		new JdbcMysql().insertDataFromCSV(filePath+"\\"+fileName, insertSql1);
		new JdbcMysql().insertDataFromCSV2(filePath+"\\"+fileName2, insertSql2);
		new JdbcMysql().insertDataFromCSV3(filePath+"\\"+fileName3, insertSql3);
		
	}
}
