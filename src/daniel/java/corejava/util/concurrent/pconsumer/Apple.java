package daniel.java.corejava.util.concurrent.pconsumer;

public class Apple {
	private String appleName;
	
	public Apple(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	@Override
	public String toString() {
		return this.appleName;
	}
	
}
