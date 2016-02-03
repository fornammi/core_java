package daniel.java.lang.reflect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

class TestA extends Object implements ActionListener {
	private int a = 3;
	public Integer b = new Integer(4);
	public TestA() {}
	public TestA(int id, String name) {}
	public int methodA(int a, String name){return 0;}
	public void actionPerformed(ActionEvent e){}
}
