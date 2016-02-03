package daniel.java.util.EnDecrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SkeyeUtil {
	private static final Set<String> cpSet = new HashSet<String>();
	private static final Set<String> cnpSet = new HashSet<String>();
	private static final Map<String, String> m1 = new HashMap<String, String>();
	private static final Map<String, String> m2 = new HashMap<String, String>();

	static {
		cnpSet.add("011");
		cnpSet.add("012");

		cpSet.add("021");
		cpSet.add("022");
		cpSet.add("051");
		cpSet.add("051");
		cpSet.add("071");
		cpSet.add("072");

		m1.put("0", "T");
		m1.put("T", "0");
		m1.put("1", "w");
		m1.put("w", "1");
		m1.put("2", "r");
		m1.put("r", "2");
		m1.put("3", "i");
		m1.put("i", "3");
		m1.put("4", "o");
		m1.put("o", "4");
		m1.put("5", "L");
		m1.put("L", "5");
		m1.put("6", "y");
		m1.put("y", "6");
		m1.put("7", "F");
		m1.put("F", "7");
		m1.put("8", "e");
		m1.put("e", "8");
		m1.put("9", "b");
		m1.put("b", "9");

		m2.put("0", "A");
		m2.put("A", "0");
		m2.put("1", "a");
		m2.put("a", "1");
		m2.put("2", "m");
		m2.put("m", "2");
		m2.put("3", "M");
		m2.put("M", "3");
		m2.put("4", "k");
		m2.put("k", "4");
		m2.put("5", "D");
		m2.put("D", "5");
		m2.put("6", "p");
		m2.put("p", "6");
		m2.put("7", "P");
		m2.put("P", "7");
		m2.put("8", "x");
		m2.put("x", "8");
		m2.put("9", "z");
		m2.put("z", "9");
	}
	
	/**
	 * 加密数字
	 * @param val
	 * @return
	 */
	public static String encryptNum(long val) {
		String str = "" + val;
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int n = Integer.parseInt("" + c);
			if (cnt < 3 || i == 0) {
				if (n % 2 == 0) {
					sb.append(m1.get("" + c));
				} else {
					sb.append(m2.get("" + c));
				}
			} else {
				if (n % 3 == 1) {
					sb.append(m1.get("" + c));
				} else if (n % 4 == 3) {
					sb.append(m2.get("" + c));
				} else {
					sb.append(n);
				}
			}
			cnt++;
		}
		sb.append("v");
		int len = 15 - str.length();
		for (int i = 0; i < len; i++) {
			Random r = new Random();
			int n = Math.abs(r.nextInt());
			n = n % 10;
			if (i % 3 == 1) {
				sb.append(m1.get("" + n));
			} else {
				sb.append(m2.get("" + n));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 解密数字
	 * @param str
	 * @return
	 */
	public static long decryptNum(String str) {
		int index = str.indexOf("v");
		if (index > 0) {
			str = str.substring(0, index);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c);
				continue;
			}
			String s = m1.get("" + c);
			if (s != null) {
				sb.append(s);
				continue;
			} else {
				s = m2.get("" + c);
				if (s != null) {
					sb.append(s);
					continue;
				}
			}
		}
		return Long.parseLong(sb.toString());
	}

	public static String getServiceEntryModeName(String srvEntryMode) {
		if (cpSet.contains(srvEntryMode))
			return "CP";
		if (cnpSet.contains(srvEntryMode))
			return "CNP";
		return "NONE";
	}

	public static void deleteAll(File dir) {
		if (dir == null)
			return;
		if (dir.exists() == false)
			return;
		File[] fs = dir.listFiles();
		if (fs == null || fs.length < 1) {
			dir.delete();
			return;
		}
		for (File file : fs) {
			if (file.isFile()) {
				file.delete();
			} else {
				deleteAll(file);
			}
		}
		dir.delete();
	}

	/**
	 * 将查询Map中的查询条件去掉前后空格
	 * 
	 * @param queryMap
	 *            查询条件Map
	 */
	public static void trimMapValue(Map queryMap) {
		Iterator it = queryMap.keySet().iterator();
		while (it.hasNext()) {
			Object key = (Object) it.next();
			Object val = queryMap.get(key);
			if (val instanceof String) {
				String str = (String) val;
				if (str != null) {
					str = str.trim();
					queryMap.put(key, str);
				}
			}
		}
	}

	/**
	 * 加密函数
	 * 
	 * @param S
	 * @param k
	 * @return
	 */
	public static String encrypt(String S) // 加密函数
	{
		int C1 = getC1();
		int C2 = getC2();
		int key = getKey();
		StringBuffer str = new StringBuffer();
		List<Character> result = new ArrayList<Character>();
		for (int i = 0; i < S.length(); i++) // 依次对字符串中各字符进行操作
		{
			char c = S.charAt(i);
			char rt = (char) getUnsignedByte((short) (c ^ ((key >> 8))));// 将密钥移位后与字符异或
			result.add(rt);
			key = getUnsignedByte((short) ((rt + key) * C1 + C2));// 产生下一个密钥
		}
		for (int i = 0; i < result.size(); i++) // 对加密结果进行转换
		{
			char j = result.get(i); // 提取字符
			// 将字符转换为两个字母保存
			str.append((char) (65 + j / 26));
			str.append((char) (65 + j % 26));
		}
		return str.toString();
	}

	/**
	 * 解密函数
	 * 
	 * @param S
	 * @param Key
	 * @return
	 */
	public static String decrypt(String S) // 解密函数
	{
		int Key = getKey();
		int C1 = getC1();
		int C2 = getC2();
		int i, j;
		StringBuffer str = new StringBuffer();
		List<Character> result = new ArrayList<Character>();
		for (i = 0; i < S.length() / 2; i++) // 将字符串两个字母一组进行处理
		{
			j = getUnsignedByte((byte) (S.charAt(2 * i) - 65)) * 26;
			j += getUnsignedByte((byte) (S.charAt(2 * i + 1))) - 65;// 相应的，解密处要改为相同的数
			result.add((char) j);
		}
		for (Character ch : result) {
			str.append((char) getUnsignedByte((byte) (ch ^ (Key >> 8))));// 将密钥移位后与字符异或
			Key = getUnsignedByte((short) ((ch + Key) * C1 + C2));// 产生下一个密钥
		}
		return str.toString();
	}

	private static int getKey() {
		return getUnsignedByte((byte) (("sdadewfds.sGHJ".charAt(5) ^ (35 >> 8) - 69) * 35)) * 15;
	}

	private static int getC1() {
		return getUnsignedByte((short) (("OHTrftDrkoX".charAt(5) ^ (35 >> 8) - 129) * 79));
	}

	private static int getC2() {
		return getUnsignedByte((short) (("NIOSEWNOFH".charAt(5) ^ (678 >> 8) - 83) * 52));
	}

	private static int getUnsignedByte(byte data) { // 将data字节型数据转换为0~255 (0xFF
		// 即BYTE)。
		return data & 0x0FF;
	}

	private static int getUnsignedByte(short data) { // 将data字节型数据转换为0~65535
		// (0xFFFF 即 WORD)。
		return data & 0x0FFFF;
	}



	/**
	 * 获取随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static final String randomString(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = null;
		randGen = new Random();
		numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
				+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

	
	/**
	 * 字符串转成list
	 */
	public static List<String> strToList(String array) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotBlank(array)) {
			String subArray = "";
			if (array.indexOf('[') != -1 && array.indexOf(']') != -1) {
				subArray = array.substring(1, array.length() - 1);
			} else {
				subArray = array;
			}
			String[] arrays = subArray.split(",");
			for (String s : arrays) {
				list.add(s.trim());
			}
		}
		return list;
	}
	

	/**
	 * 数组转字符串,逗号隔开
	 */

	public static String arrayToStr(String[] array) {
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if (cnt > 0) {
				sb.append("," + array[i]);
			} else {
				sb.append(array[i]);
			}
			cnt++;
		}
		return sb.toString();
	}


	public static String arrayToStr2(String[] array) {
		int cnt = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			if (cnt > 0) {
				sb.append(",a" + array[i] + "b");
			} else {
				sb.append("%a" + array[i] + "b");
			}
			cnt++;
		}
		sb.append("%");
		return sb.toString();
	}

	public static String convertFileSize(Long fileSize) {
		if (fileSize == null || fileSize.intValue() == 0) {
			return "0  字节";
		}
		String strUnit = "字节";
		int unitDivisor = 1;
		String strAfterComma = "";
		if (fileSize >= 1024 * 1024) {
			strUnit = "MB";
			unitDivisor = 1024 * 1024;
		} else if (fileSize >= 1024) {
			strUnit = "KB";
			unitDivisor = 1024;
		}

		strAfterComma = "" + 100 * (fileSize % unitDivisor) / unitDivisor;

		return fileSize / unitDivisor + "." + strAfterComma + " " + strUnit;
	}

	public static String parseTemplate(String template, Map parameters)
			throws Exception {
		if ((template == null) || (template.trim().length() == 0)) {
			return "";
		}
		if ((null == parameters) || (parameters.size() == 0)) {
			return template;
		}
		StringWriter writer = new StringWriter();
		StringReader reader = new StringReader(template);
		Template temp = new Template("", reader);
		temp.process(parameters, writer);
		return writer.toString();
	}

	public static String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String sj_str = dateFormat.format(new Date());
		return sj_str;
	}

	public static String getDate(String formatstr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatstr);
		String sj_str = dateFormat.format(new Date());
		return sj_str;
	}

	public static String appendSymbol4Pan(String sPan) {
		String spanBySymbol = "";
		if (StringUtils.isNotBlank(sPan)) {
			String spanFront = sPan.substring(0, 6);
			String spanEnd = sPan.substring(6, sPan.length());
			StringBuffer new_span = new StringBuffer("");
			new_span.append(spanFront).append("****").append(spanEnd);
			spanBySymbol = new_span.toString();
		}
		return spanBySymbol;
	}

	/**
	 * 拼接邮件内容
	 * 
	 * @param originalContent
	 *            原邮件内容
	 * @param originalAddrInfo
	 *            原邮件地址信息
	 * @param appendContent
	 *            追加内容
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String returnBankEmail(byte[] originalContent,
			String originalAddrInfo, String appendContent)
			throws UnsupportedEncodingException {
		if (originalContent == null || originalContent.length == 0) {
			return appendContent + "<br><HR><br>" + originalAddrInfo;
		}
		String bc = new String(originalContent);
		String temp = bc.toLowerCase();
		int bodyIndex = temp.indexOf("<body>");
		String front = "";
		String back = "";
		if (bodyIndex < 0) {
			bodyIndex = temp.indexOf("<body");
			if (bodyIndex >= 0) {
				String tmp = bc.substring(bodyIndex);
				int endIndex = tmp.indexOf(">");
				int frontEndIndex = bodyIndex + endIndex + 1;
				front = bc.substring(0, frontEndIndex);
				back = bc.substring(frontEndIndex);
			} else {
				front = "";
				if (temp.indexOf("</td>") < 0 && temp.indexOf("</div>") < 0) {
					back = "<pre>" + bc + "</pre>";
				} else {
					back = bc;
				}
			}
		} else {
			front = bc.substring(0, bodyIndex + 6);
			back = bc.substring(bodyIndex + 6);
		}
		return front + appendContent + "<br><br><HR><br><br>"
				+ originalAddrInfo + back;
	}

}
