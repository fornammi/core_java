package com.nammi.concurrent.pconsumer;

public interface Basket {
	public void add(Apple apple) throws Exception;
	public Apple obtain() throws Exception;
}
