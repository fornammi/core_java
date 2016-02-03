package daniel.java.util.EnDecrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class EnDecrypt {
	
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

	public static void main(String[] args) {
		System.out.println(decryptNum("zoo9FvaoPDwDpwPp"));
		//System.out.println(encryptNum(26181));
	}
	
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
}
