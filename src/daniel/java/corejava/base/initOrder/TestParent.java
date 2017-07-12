package daniel.java.corejava.base.initOrder;

public class TestParent {
	// 静态变量
	public static String p_StaticField = "父类--静态变量";
	// 变量
	public String p_Field = "父类--变量";
	protected int i = 9;
	protected int j = 0;
	// 构造器
	public TestParent() {
		System.out.println("父类--构造器");
		System.out.println("i=" + i + ", j=" + j);
		j = 20;
	}
	// 静态初始化块
	static {
		System.out.println(p_StaticField);
		System.out.println("父类--静态初始化块");
	}
	// 初始化块
	{
		System.out.println(p_Field);
		System.out.println("父类--初始化块");
	}
}