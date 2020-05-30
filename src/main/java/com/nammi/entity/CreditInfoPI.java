package com.nammi.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class CreditInfoPI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String orderId;
    private String requestNo;
    private String clientName;
    private String legalPersonName;
    private String legalPersonId;
    private String resultGmsfhm;
    private String resultXm;
    private String xb;
    private String csrq;
    private String whcd;
    private String zy;
    private String zz;
    private String xp;
    private String errorCode;
    private String errorMsg;
    private java.util.Date infoDate;
    private java.util.Date createTime;
    //新接口
    private String ssssxq;
    private String rtdn;
    private String rtdes;
    
    private String orderField;

    public Long getId( ){
		    return id;
    }
    public void setId(Long id){
		    this.id=id;
    }

    public String getOrderId( ){
		    return orderId;
    }
    public void setOrderId(String orderId){
		    this.orderId=orderId;
    }

    public String getRequestNo( ){
		    return requestNo;
    }
    public void setRequestNo(String requestNo){
		    this.requestNo=requestNo;
    }

    public String getClientName( ){
		    return clientName;
    }
    public void setClientName(String clientName){
		    this.clientName=clientName;
    }

    public String getLegalPersonName( ){
		    return legalPersonName;
    }
    public void setLegalPersonName(String legalPersonName){
		    this.legalPersonName=legalPersonName;
    }

    public String getLegalPersonId( ){
		    return legalPersonId;
    }
    public void setLegalPersonId(String legalPersonId){
		    this.legalPersonId=legalPersonId;
    }

    public String getResultGmsfhm( ){
		    return resultGmsfhm;
    }
    public void setResultGmsfhm(String resultGmsfhm){
		    this.resultGmsfhm=resultGmsfhm;
    }

    public String getResultXm( ){
		    return resultXm;
    }
    public void setResultXm(String resultXm){
		    this.resultXm=resultXm;
    }

    public String getXb( ){
		    return xb;
    }
    public void setXb(String xb){
		    this.xb=xb;
    }

    public String getCsrq( ){
		    return csrq;
    }
    public void setCsrq(String csrq){
		    this.csrq=csrq;
    }

    public String getWhcd( ){
		    return whcd;
    }
    public void setWhcd(String whcd){
		    this.whcd=whcd;
    }

    public String getZy( ){
		    return zy;
    }
    public void setZy(String zy){
		    this.zy=zy;
    }

    public String getZz( ){
		    return zz;
    }
    public void setZz(String zz){
		    this.zz=zz;
    }

    public String getXp( ){
		    return xp;
    }
    public void setXp(String xp){
		    this.xp=xp;
    }

    public String getErrorCode( ){
		    return errorCode;
    }
    public void setErrorCode(String errorCode){
		    this.errorCode=errorCode;
    }

    public String getErrorMsg( ){
		    return errorMsg;
    }
    public void setErrorMsg(String errorMsg){
		    this.errorMsg=errorMsg;
    }

    public java.util.Date getInfoDate( ){
		    return infoDate;
    }
    public void setInfoDate(java.util.Date infoDate){
		    this.infoDate=infoDate;
    }

    public java.util.Date getCreateTime( ){
		    return createTime;
    }
    public void setCreateTime(java.util.Date createTime){
		    this.createTime=createTime;
    }

    public String getSsssxq() {
		return ssssxq;
	}
	public void setSsssxq(String ssssxq) {
		this.ssssxq = ssssxq;
	}
	public String getRtdn() {
		return rtdn;
	}
	public void setRtdn(String rtdn) {
		this.rtdn = rtdn;
	}
	public String getRtdes() {
		return rtdes;
	}
	public void setRtdes(String rtdes) {
		this.rtdes = rtdes;
	}
	public String getOrderField(){
		    return orderField;
    }
    public void setOrderField(String orderField){
		    this.orderField = orderField;
    }
    
	@Override
	public String toString() {
		Map map = new HashMap();
		map.put("id", this.id);
		map.put("orderId", this.orderId);
		map.put("requestNo", this.requestNo);
		map.put("clientName", this.clientName);
		map.put("legalPersonName", this.legalPersonName);
		map.put("legalPersonId", this.legalPersonId);
		map.put("resultGmsfhm", this.resultGmsfhm);
		map.put("resultXm", this.resultXm);
		map.put("xb", this.xb);
		map.put("csrq", this.csrq);
		map.put("whcd", this.whcd);
		map.put("zy", this.zy);
		map.put("zz", this.zz);
		map.put("xp", this.xp);
		map.put("ssssxq", this.ssssxq);
		map.put("rtdn", this.rtdn);
		map.put("rtdes", this.rtdes);
		map.put("errorCode", this.errorCode);
		map.put("errorMsg", this.errorMsg);
		map.put("infoDate", this.infoDate);
		map.put("createTime", this.createTime);
		JSONObject jsonObj = JSONObject.fromObject(map);
		return jsonObj.toString();
	}
    
}