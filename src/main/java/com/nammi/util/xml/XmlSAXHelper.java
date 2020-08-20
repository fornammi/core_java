package com.nammi.util.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.nammi.util.xml.model.Book;
import com.nammi.util.xml.model.Phone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 此处可以扩展为泛型接口
 * 解析XML的前提：清楚地知道xml的结构特点
 * @author daniel.fang
 *
 */
public class XmlSAXHelper extends DefaultHandler {
	
	private List<Book> books = null;
	private Book book = null;
	//第二种对象
	private List<Phone> phones = null;
	private Phone phone = null;
	
	//作用是记录解析时的上一个节点名称
	private String preTag = null;
	
	
	/**
	 * 接收文档开始的通知
	 */
    @Override
	public void startDocument() throws SAXException {
    	books = new ArrayList<Book>();
    	//第二种对象
    	phones = new ArrayList<Phone>();
	}
    
    /**
     * 接收元素开始的通知
     */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//通过节点名，判断对象类型
		if("book".equals(qName)){
			book = new Book();
			book.setId(Integer.parseInt(attributes.getValue(0)));
		}else if("phone".equals(qName)){
			phone = new Phone();
			phone.setId(Integer.parseInt(attributes.getValue(0)));
		}
		preTag = qName;//将正在解析的节点名称赋给preTag
	}

	/**
	 * 接收元素结束的通知
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(book!=null && "book".equals(qName)){
			books.add(book);
			book = null;
		}else if(phone!=null && "phone".equals(qName)){
			phones.add(phone);
			phone = null;
		}
		preTag = null;
		/**
		 * 当一个元素解析结束时置为空,这里很重要。
		 * 分析：当<name>结束后，会调用endElement方法并执行preTag = null;语句， 
		 * 如果没有该语句，处理完</name>后，到了<price>前，继续执行characters(char[] ch,
		 * int start, int length)这个方法时，preTag的值还是book，就会执行 if(preTag!=null)
		 * 判断里的语句，这样就会把空值赋值给book，这不是我们想要的。
		 */
		  
	}
	
	/**
     * 接收元素中字符数据的通知
     */
    @Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(preTag != null){
			String content = new String(ch, start, length);
			//设置book对象的各个属性
			/*
			 * TODO：此处无法判断多个标签名，导致无法解析xml里的多个java bean
			 * 建议：根节点ROW里的所有带具体值的节点名，都作为java bean的属性名
			 */
			if("name".equals(preTag)){
				if(book!=null){
					book.setName(content);
				}
				if(phone!=null){
					phone.setName(content);
				}
			}else if("price".equals(preTag)){
				if(book!=null){
					book.setPrice(Float.parseFloat(content));
				}
				if(phone!=null){
					phone.setPrice(Float.parseFloat(content));
				}
			}
		}
	}
	
	
	public List<Book> parseBookXml(InputStream xmlStream) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XmlSAXHelper handler = new XmlSAXHelper();
		parser.parse(xmlStream, handler);
		return handler.getBooks();
	}
	
	public List<Phone> parsePhoneXml(InputStream xmlStream) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XmlSAXHelper handler = new XmlSAXHelper();
		parser.parse(xmlStream, handler);
		return handler.getPhones();
	}
	
	public List<Book> getBooks(){
		return books;
	}
	
	public List<Phone> getPhones(){
		return phones;
	}

	/**
	 * 测试main方法
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		XmlSAXHelper sax = new XmlSAXHelper();
		InputStream input = new FileInputStream(new File("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\book_test.xml"));
		List<Book> books = sax.parseBookXml(input);
		for(Book book : books){
			System.out.println(book.toString());
		}
		
		List<Phone> phones = sax.parsePhoneXml(input);
		for(Phone phone : phones){
			System.out.println(phone.toString());
		}
    }
}
