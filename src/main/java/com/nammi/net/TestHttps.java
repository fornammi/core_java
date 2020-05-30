package com.nammi.net;

import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

public class TestHttps {
	
	private static final String authUrl = "https://mas.99bill.com/cnp/ind_auth";
	
	public static void main(String[] args) throws Exception{
		CloseableHttpClient client = createHttpsClient();
		//建立HttpPost对象
		HttpPost httpPost = new HttpPost(authUrl);
		//配置要Post的数据
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		//设置为浏览器兼容模式
		multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		//设置请求的编码格式
		multipartEntityBuilder.setCharset(Charset.forName(HTTP.UTF_8));
	}
	
	
	public static CloseableHttpClient createHttpsClient() throws Exception{
		
		X509TrustManager x509mgr = new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}
		};
		
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[]{x509mgr}, new java.security.SecureRandom());
		SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslcsf).build();
		
	}
}
