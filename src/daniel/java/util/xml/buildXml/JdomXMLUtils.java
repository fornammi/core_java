package daniel.java.util.xml.buildXml;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JdomXMLUtils {
	
	public String buildXmlString() throws IOException, JDOMException{
		// 创建根节点 list
		Element root = new Element("list");
		// 根节点添加到文档中
		Document doc = new Document(root);
		// 此处 for 循环可替换成 遍历 数据库表的结果集操作;
		for (int i = 0; i < 2; i++) {
			// 创建节点 user
			Element elements = new Element("user");
			// 给 user 节点添加属性 id
			elements.setAttribute("id", "" + i);
			// 给 user 节点添加子节点并赋值
			/**
			 * new Element("name")中的 "name" 替换成表中相应字段，
			 * setText("xuehui")中 "xuehui"替换成表中记录值
			 * 
			 */
			elements.addContent(new Element("name").setText("xuehui"));
			elements.addContent(new Element("age").setText("28"));
			elements.addContent(new Element("sex").setText("Male"));
			//测试null及""
			elements.addContent(new Element("testNull1").setText(null));
			elements.addContent(new Element("testNull2").setText(""));
			// 给父节点list添加user子节点;
			root.addContent(elements);
		}
		//输出到stream
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		XMLOutputter xmlOut = new XMLOutputter(format);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		xmlOut.output(doc, baos);
		return baos.toString();
	}
	
	public void buildXml() throws IOException, JDOMException {
		// 创建根节点 list
		Element root = new Element("list");
		// 根节点添加到文档中
		Document doc = new Document(root);
		// 此处 for 循环可替换成 遍历 数据库表的结果集操作;
		for (int i = 0; i < 2; i++) {
			// 创建节点 user
			Element elements = new Element("user");
			// 给 user 节点添加属性 id
			elements.setAttribute("id", "" + i);
			// 给 user 节点添加子节点并赋值
			/**
			 * new Element("name")中的 "name" 替换成表中相应字段，
			 * setText("xuehui")中 "xuehui"替换成表中记录值
			 * 
			 */
			elements.addContent(new Element("name").setText("xuehui"));
			elements.addContent(new Element("age").setText("28"));
			elements.addContent(new Element("sex").setText("Male"));
			// 给父节点list添加user子节点;
			root.addContent(elements);
		}
		// 输出 user.xml 文件
		/**
		 * 路径必须已经存在，否则报错:java.io.FileNotFoundException: 
		 * (系统找不到指定的路径。)
		 */
		XMLOutputter xmlOut = new XMLOutputter();
		xmlOut.output(doc, new FileOutputStream("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\buildXml\\user.xml"));
	}
	
	/**
	 * Air
	 * @throws IOException
	 * @throws JDOMException
	 */
	public void buildAirlineXml() throws IOException, JDOMException{
		Element root = new Element("Request");
		Document doc = new Document(root);
		//1.1
		Element transactionEl = new Element("Transaction");
		
		//1.1.1
		Element txnDetailsEl = new Element("TxnDetails");
		//1.1.1.1
		Element the3rdManEl = new Element("The3rdMan");
		the3rdManEl.setAttribute("type", "realtime");
		//1.1.1.1.1
		Element billingAddressEl = new Element("BillingAddress");
		billingAddressEl.addContent(new Element("street_address_1").setText("Mulberry House"));
		billingAddressEl.addContent(new Element("street_address_2").setText("15 Acacia Place"));
		billingAddressEl.addContent(new Element("city").setText("Edinburgh"));
		billingAddressEl.addContent(new Element("county").setText("Lothian"));
		billingAddressEl.addContent(new Element("country").setText("826"));
		billingAddressEl.addContent(new Element("postcode").setText("EH6 7EZ"));
		//1.1.1.1.2
		Element customerInformationEl = new Element("CustomerInformation");
		customerInformationEl.addContent(new Element("email").setText("accept@datacash.com"));
		customerInformationEl.addContent(new Element("title").setText("Ms"));
		customerInformationEl.addContent(new Element("forename").setText("John"));
		customerInformationEl.addContent(new Element("surname").setText("Smith"));
		customerInformationEl.addContent(new Element("telephone").setText("000777777"));
		customerInformationEl.addContent(new Element("alt_telephone").setText("0131123534"));
		customerInformationEl.addContent(new Element("ip_address").setText("119.236.55.177"));
		customerInformationEl.addContent(new Element("sales_channel").setText("1"));
		customerInformationEl.addContent(new Element("customer_reference").setText("Wang0101"));
		customerInformationEl.addContent(new Element("order_number").setText("Ref0105"));
		//1.1.1.1.3
		Element accountInformationEl = new Element("AccountInformation");
		Element userDetailsEl = new Element("UserDetails");
		userDetailsEl.addContent(new Element("id").setText("Matrix"));
		userDetailsEl.addContent(new Element("machine_id").setText("xc334sv"));
		accountInformationEl.addContent(userDetailsEl);
		//1.1.1.1.4
		Element orderInformationEl = new Element("OrderInformation");
		//1.1.1.1.4.1
		orderInformationEl.addContent(new Element("distribution_channel").setText("Y"));
		//1.1.1.1.4.2此处productsEl可能需要循环赋值
		Element productsEl = new Element("Products");
		productsEl.setAttribute("count","1");
		//1.1.1.1.4.2.1
		Element productEl = new Element("Product");
		//1.1.1.1.4.2.1.1
		Element airlineInformationEl = new Element("AirlineInformation");
		airlineInformationEl.addContent(new Element("flight_carrier").setText("BA"));
		airlineInformationEl.addContent(new Element("dob").setText("1970-06-16"));
		airlineInformationEl.addContent(new Element("fare_class").setText("Economy"));
		airlineInformationEl.addContent(new Element("flight_number").setText("059"));
		airlineInformationEl.addContent(new Element("loyalty_indicator").setText("Y"));
		airlineInformationEl.addContent(new Element("loyalty_number").setText("9876"));
		airlineInformationEl.addContent(new Element("nationality").setText("SA"));
		airlineInformationEl.addContent(new Element("passport_or_ssn").setText("456789032"));
		airlineInformationEl.addContent(new Element("route_via").setText("ABC-DEF-GHI"));
		productEl.addContent(airlineInformationEl);
		//1.1.1.1.4.2.1.(2~8)
		productEl.addContent(new Element("code").setText("John Smith"));
		productEl.addContent(new Element("price").setText("100.00"));
		productEl.addContent(new Element("prod_category").setText("LDN"));
		productEl.addContent(new Element("prod_description").setText("17 Aug 2014 17:50"));
		productEl.addContent(new Element("prod_risk").setText("LOW"));
		productEl.addContent(new Element("prod_type").setText("CDG"));
		productEl.addContent(new Element("quantity").setText("1"));
		
		productsEl.addContent(productEl);
		orderInformationEl.addContent(productsEl);
		
		//1.1.1.1层级关系
		the3rdManEl.addContent(billingAddressEl);
		the3rdManEl.addContent(customerInformationEl);
		the3rdManEl.addContent(accountInformationEl);
		the3rdManEl.addContent(orderInformationEl);
		
		//1.1.1层级关系
		txnDetailsEl.addContent(the3rdManEl);
		txnDetailsEl.addContent(new Element("merchantreference").setText("99billtestLL08"));
		
		//1.1.2
		Element fraudOnlyTxnEl = new Element("FraudOnlyTxn");
		//1.1.2.1
		Element cardEl = new Element("Card");
		cardEl.addContent(new Element("bin").setText("444433"));
		cardEl.addContent(new Element("last_4_digits").setText("1111"));
		cardEl.addContent(new Element("expirydate").setText("01/20"));
		cardEl.addContent(new Element("pan").setText("4444333322221111"));
		cardEl.addContent(new Element("issuenumber_or_start_date").setText("01/10"));
		//1.1.2.3
		Element responseEl = new Element("Response");
		responseEl.addContent(new Element("avs_postcode_response").setText("2"));
		responseEl.addContent(new Element("bank_response_message").setText("AUTHORISED"));
		responseEl.addContent(new Element("auth_code").setText("100000"));
		responseEl.addContent(new Element("bank_response_code").setText("00"));
		responseEl.addContent(new Element("avs_address_response").setText("2"));
		responseEl.addContent(new Element("cv2_response").setText("2"));
		//1.1.2.5
		Element secureEl = new Element("Secure");
		secureEl.addContent(new Element("security_code").setText("MDEyMzQ1Njc4OUFCQ0RFRkdISUo="));
		secureEl.addContent(new Element("eci").setText("06"));
		//1.1.2.6
		Element amountEl = new Element("amount");
		amountEl.setAttribute("currency", "EUR");
		amountEl.setText("313.37");
		
		//1.1.2层级关系
		fraudOnlyTxnEl.addContent(cardEl);
		fraudOnlyTxnEl.addContent(new Element("acquirer").setText("MiGs"));
		fraudOnlyTxnEl.addContent(responseEl);
		fraudOnlyTxnEl.addContent(new Element("tran_type").setText("pre"));
		fraudOnlyTxnEl.addContent(secureEl);
		fraudOnlyTxnEl.addContent(amountEl);
		
		//1.1层级关系
		transactionEl.addContent(txnDetailsEl);
		transactionEl.addContent(fraudOnlyTxnEl);
		
		//1.2层级关系
		Element authenticationEl = new Element("Authentication");
		authenticationEl.addContent(new Element("password").setText("????"));
		authenticationEl.addContent(new Element("client").setText("????"));
		
		//1层级关系
		root.addContent(transactionEl);
		root.addContent(authenticationEl);
		
		//输出文件
		XMLOutputter xmlOut = new XMLOutputter();
		String filePath = "D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\buildXml\\TempAir.xml";
		xmlOut.output(doc, new FileOutputStream(filePath));
		
	}
	
	/**
	 * Retail
	 * @throws IOException
	 * @throws JDOMException
	 */
	public void buildRetailXml() throws IOException, JDOMException{
		Element root = new Element("Request");
		Document doc = new Document(root);
		//1.1
		Element transactionEl = new Element("Transaction");
		
		//1.1.1
		Element txnDetailsEl = new Element("TxnDetails");
		//1.1.1.1
		Element the3rdManEl = new Element("The3rdMan");
		the3rdManEl.setAttribute("type", "realtime");
		//1.1.1.1.1
		Element billingAddressEl = new Element("BillingAddress");
		billingAddressEl.addContent(new Element("street_address_1").setText("Mulberry House"));
		billingAddressEl.addContent(new Element("street_address_2").setText("15 Acacia Place"));
		billingAddressEl.addContent(new Element("city").setText("Edinburgh"));
		billingAddressEl.addContent(new Element("county").setText("Lothian"));
		billingAddressEl.addContent(new Element("country").setText("826"));
		billingAddressEl.addContent(new Element("postcode").setText("EH6 7EZ"));
		//1.1.1.1.2
		Element deliveryAddressEl = new Element("DeliveryAddress");
		deliveryAddressEl.addContent(new Element("street_address_1").setText("10 Stratford Road"));
		deliveryAddressEl.addContent(new Element("street_address_2").setText("Windsor"));
		deliveryAddressEl.addContent(new Element("city").setText("London"));
		deliveryAddressEl.addContent(new Element("county").setText("London"));
		deliveryAddressEl.addContent(new Element("country").setText("826"));
		deliveryAddressEl.addContent(new Element("postcode").setText("AB1 2CD"));
		//1.1.1.1.3
		Element customerInformationEl = new Element("CustomerInformation");
		customerInformationEl.addContent(new Element("email").setText("accept@datacash.com"));
		customerInformationEl.addContent(new Element("title").setText("Ms"));
		customerInformationEl.addContent(new Element("forename").setText("John"));
		customerInformationEl.addContent(new Element("surname").setText("Smith"));
		customerInformationEl.addContent(new Element("telephone").setText("000777777"));
		customerInformationEl.addContent(new Element("alt_telephone").setText("0131123534"));
		customerInformationEl.addContent(new Element("ip_address").setText("119.236.55.177"));
		customerInformationEl.addContent(new Element("sales_channel").setText("1"));
		customerInformationEl.addContent(new Element("customer_reference").setText("Wang0101"));
		customerInformationEl.addContent(new Element("order_number").setText("Ref0105"));
		//1.1.1.1.4
		Element accountInformationEl = new Element("AccountInformation");
		Element userDetailsEl = new Element("UserDetails");
		userDetailsEl.addContent(new Element("id").setText("Matrix"));
		userDetailsEl.addContent(new Element("machine_id").setText("xc334sv"));
		accountInformationEl.addContent(userDetailsEl);
		//1.1.1.1.5
		Element orderInformationEl = new Element("OrderInformation");
		//1.1.1.1.5.1：区别
		//orderInformationEl.addContent(new Element("distribution_channel").setText("Y"));
		//1.1.1.1.5.2此处productsEl可能需要循环赋值
		Element productsEl = new Element("Products");
		productsEl.setAttribute("count","1");
		//1.1.1.1.5.2.1
		Element productEl = new Element("Product");
		//1.1.1.1.5.2.1.1：区别
		/*Element airlineInformationEl = new Element("AirlineInformation");
		airlineInformationEl.addContent(new Element("flight_carrier").setText("BA"));
		airlineInformationEl.addContent(new Element("dob").setText("1970-06-16"));
		airlineInformationEl.addContent(new Element("fare_class").setText("Economy"));
		airlineInformationEl.addContent(new Element("flight_number").setText("059"));
		airlineInformationEl.addContent(new Element("loyalty_indicator").setText("Y"));
		airlineInformationEl.addContent(new Element("loyalty_number").setText("9876"));
		airlineInformationEl.addContent(new Element("nationality").setText("SA"));
		airlineInformationEl.addContent(new Element("passport_or_ssn").setText("456789032"));
		airlineInformationEl.addContent(new Element("route_via").setText("ABC-DEF-GHI"));
		productEl.addContent(airlineInformationEl);*/
		//1.1.1.1.5.2.1.(2~8)
		productEl.addContent(new Element("code").setText("B40103"));
		productEl.addContent(new Element("price").setText("100.00"));
		productEl.addContent(new Element("prod_category").setText("Shoe0101"));
		productEl.addContent(new Element("prod_description").setText("Pretty Shoes"));
		productEl.addContent(new Element("prod_risk").setText("Low"));
		productEl.addContent(new Element("prod_type").setText("Clothing"));
		productEl.addContent(new Element("quantity").setText("2"));
		
		productsEl.addContent(productEl);
		orderInformationEl.addContent(productsEl);
		
		//1.1.1.1层级关系
		the3rdManEl.addContent(billingAddressEl);
		//Retail与Air区别：1
		the3rdManEl.addContent(deliveryAddressEl);
		the3rdManEl.addContent(customerInformationEl);
		the3rdManEl.addContent(accountInformationEl);
		the3rdManEl.addContent(orderInformationEl);
		
		//1.1.1层级关系
		txnDetailsEl.addContent(the3rdManEl);
		txnDetailsEl.addContent(new Element("merchantreference").setText("99billtestLL11"));
		
		//1.1.2
		Element fraudOnlyTxnEl = new Element("FraudOnlyTxn");
		//1.1.2.1
		Element cardEl = new Element("Card");
		cardEl.addContent(new Element("bin").setText("444433"));
		cardEl.addContent(new Element("last_4_digits").setText("1111"));
		cardEl.addContent(new Element("expirydate").setText("01/20"));
		cardEl.addContent(new Element("pan").setText("4444333322221111"));
		cardEl.addContent(new Element("issuenumber_or_start_date").setText("01/10"));
		//1.1.2.3
		Element responseEl = new Element("Response");
		responseEl.addContent(new Element("avs_postcode_response").setText("2"));
		responseEl.addContent(new Element("bank_response_message").setText("AUTHORISED"));
		responseEl.addContent(new Element("auth_code").setText("100000"));
		responseEl.addContent(new Element("bank_response_code").setText("00"));
		responseEl.addContent(new Element("avs_address_response").setText("2"));
		responseEl.addContent(new Element("cv2_response").setText("2"));
		//1.1.2.5
		Element secureEl = new Element("Secure");
		secureEl.addContent(new Element("security_code").setText("MDEyMzQ1Njc4OUFCQ0RFRkdISUo="));
		secureEl.addContent(new Element("eci").setText("06"));
		//1.1.2.6
		Element amountEl = new Element("amount");
		amountEl.setAttribute("currency", "EUR");
		amountEl.setText("313.37");
		
		//1.1.2层级关系
		fraudOnlyTxnEl.addContent(cardEl);
		fraudOnlyTxnEl.addContent(new Element("acquirer").setText("MiGs"));
		fraudOnlyTxnEl.addContent(responseEl);
		fraudOnlyTxnEl.addContent(new Element("tran_type").setText("pre"));
		fraudOnlyTxnEl.addContent(secureEl);
		fraudOnlyTxnEl.addContent(new Element("alt_tran_type").setText("unknown"));
		fraudOnlyTxnEl.addContent(amountEl);
		
		//1.1层级关系
		transactionEl.addContent(txnDetailsEl);
		transactionEl.addContent(fraudOnlyTxnEl);
		
		//1.2层级关系
		Element authenticationEl = new Element("Authentication");
		authenticationEl.addContent(new Element("password").setText("????"));
		authenticationEl.addContent(new Element("client").setText("????"));
		
		//1层级关系
		root.addContent(transactionEl);
		root.addContent(authenticationEl);
		
		//输出文件
		XMLOutputter xmlOut = new XMLOutputter();
		String filePath = "D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\buildXml\\TempRetail.xml";
		xmlOut.output(doc, new FileOutputStream(filePath));
		
	}
	
	public static void main(String[] args) {
		try {
			JdomXMLUtils j2x = new JdomXMLUtils();
			System.out.println("生成xml 文件...");
			System.out.println(j2x.buildXmlString());
			//j2x.buildXml();
			//j2x.buildAirlineXml();
			//j2x.buildRetailXml();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
