package daniel.java.corejava.util.concurrent.pconsumer;

public interface Basket {
	public void add(Apple apple) throws Exception;
	public Apple obtain() throws Exception;
}
