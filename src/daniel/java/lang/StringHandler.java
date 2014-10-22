package daniel.java.lang;

public class StringHandler {
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "b";
		final String s3 = "b";
		String c1 = "a" + "b";
		String c2 = "a" + s3;
		String c3 = s1 + s2;
		System.out.println("c1==ab:"+(c1=="ab"));//true
		System.out.println("c2==ab:"+(c2=="ab"));//true
		System.out.println("c3==ab:"+(c3=="ab"));//false
		System.out.println("c1==c2:"+(c1==c2));//true
		System.out.println("c1==c3:"+(c1==c3));//false
		System.out.println("c2==c3:"+(c2==c3));//false
		System.out.println("c1.equals(c2):"+c1.equals(c2));//true
		System.out.println("c1.equals(c3):"+c1.equals(c3));//true
		System.out.println("c2.equals(c3):"+c1.equals(c3));//true
		System.out.println("============================");
		String str4 = "a" + "b"; 
		System.out.println(str4 == "ab");
		System.out.println("============================");
		final String s = "a"; // 注意:这里s用final修饰，相当于一个常量
		String str5 = s + "b";
		System.out.println(str5 == "ab");
		System.out.println("============================");
		String s61 = "a";
		String s62 = "b";
		String str6 = s61 + s62;
		System.out.println(str6 == "ab"); 


		
	}
}
