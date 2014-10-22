package daniel.java.util;

public class Student {
	private int index;
	private String value;
	
	public Student(){}
	
	public Student(int index, String value){
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
