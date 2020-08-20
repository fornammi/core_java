/*
package com.nammi.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

*/
/**
 * http服务Server端：需要在web.xml里配置该类
 * @author daniel.fang
 *
 *//*

public class HttpServerUtils extends HttpServlet {
	
	private static final long serialVersionUID = -6023268050469506893L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String reqStr = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream)req.getInputStream(), "UTF-8"));
		//更直接的方式：BufferReader br = req.getReader();
		StringBuffer sb = new StringBuffer();
		String temp;
		while((temp=br.readLine()) != null){
			sb.append(temp);
		}
		br.close();
		reqStr = sb.toString();
		Map<String, String> respMap = new HashMap<String, String>();
		if(StringUtils.isNotBlank(reqStr)){
			JSONObject reqJson = JSONObject.fromObject(reqStr);
			System.out.println("[HttpServerUtils@doPost]reqJson:"+reqJson.toString());
			String objName = reqJson.optString("objName");
			System.out.println("[HttpServerUtils@doPost]reqJson[objName]:"+objName);
			respMap.put("result", "success");
		}
		JSONObject respJson = JSONObject.fromObject(respMap);
		resp.getOutputStream().write(respJson.toString().getBytes());
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
}
*/
