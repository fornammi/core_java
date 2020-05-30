package com.nammi.creditpay.mgw.entity;

public class MerchantAuthInfo {
	//共同字段
	private String merchantId;	//商户号
	private String customerId;	//客户号
	private String externalRefNumber;	//外部跟踪号
	private String pan;	//卡号
	private String phoneNO;	//手机号码
	//鉴权请求报文 
	private String terminalId;	//终端号
	private String cardHolderName;	//持卡人户名
	private String idType;	//证件类型
	private String cardHolderId;	//证件号码
	private String expiredDate;	//有效期
	private String cvv2;	//卡校验码
	//动态码验证请求报文
	private String validCode;	//验证码
	private String token;	//令牌信息
}
