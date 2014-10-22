package daniel.java.object;

import java.io.Serializable;
import java.util.List;

public class RcsReferenceDataDto implements Serializable {

	private static final long serialVersionUID = -7499104494657801440L;
	
	//测试集合类型
	protected List<RcsReferenceDataDto> passengerInfo;

	private String cardholderName; // 持卡人姓名
	private String cardholderPhoneCountryCode;//持卡人手机国家码
	private String cardholderPhone;//持卡人手机
	private String cardholderTelCountryCode;//持卡人电话国家码
	private String cardholderTelRegion;//	持卡人电话区号
	private String cardholderTel;//持卡人电话
	private String cardholderIdtype;//持卡人证件类型
	private String cardholderId; // 持卡人身份证号
	private String cardholderZip; // 持卡人账单邮编
	private String cardholderBillCountryIso; // 国家ISO
	private String cardholderBillProvinceState; // 省份/周
	private String cardholderBillCity; // 城市
	private String cardholderBillAddress; // 持卡人账单地址
	private String pName;//购货人姓名
	private String pPhone; // 购货人手机
	private String pTelCountryCode; // 电话国家码
	private String pTelRegion; // 区号
	private String pPhoneCountryCode; // 手机国家码
	private String pTel; // 购货人电话
	private String pIp; // 购货人IP
	private String pIdtype; // 购货人证件
	private String pIdnumber; // 购货人证件号码
	private String pIsMerchantmbr; // 是否商户会员
	private String pRegtime; // 会员注册时间
	private String cName; // 收货人姓名
	private String cPhoneCountryCode;//收货人手机国家码
	private String cTelCountryCode;//收货人电话国家码
	private String cTelRegion;//收货人区号
	private String cIdtype; // 收货人证件类型
	private String cIdnumber; // 收货人证件号码
	private String cPhone; // 收货人手机
	private String cTel; // 收货人电话
	private String cAddress; // 收货人地址
	private String cCountry; // 收货人国家
	private String cProvince; // 收货人省份
	private String cCity; // 收货人城市
	private String pProductname; // 商品名称
	private String pProducttype; // 商品类型
	private String pQuantity; // 商品数量
	private String pTotalprice; // 商品总价
	private String pRegAddress;// 会员注册信息中的地址
	private String pOpentime;// 服务开始时间
	private String pClosetime;// 服务结束时间
	private String pDdetail;// 商品明细
	private String cardholderEmail; // 持卡人账单邮箱
	private String pHostname; // 购货人HOSTNAME
	private String cZip;//收货人邮编
	private String cMethord;//收货方式
	private String deviceId;//策略ID
	private String cardholderFirstName;//持卡人名
	private String cardholderLastName;//持卡人姓
	private String payIp;//支付人IP
	private String tmxSessionId; // ThreatMetrix session_id add by leo.cao 2013.10.30
	
	// ------------------- //
	private String tbPName;//乘机人姓名
	private String tbPTel; // 乘机人电话
	private String tbPPhone; // 乘机人手机
	private String tbPIdtype; // 乘机人证件类型
	private String tbPIdnumber; // 乘机人证件号码
	private String tbIsFrequenter; // 是否常旅客
	private String tbPProductname; // 航班号flight number
	private String tbPQuantity; // 机票数量 Quantity
	private String tbPTotalprice; // 机票总价 Product Total Price （账单金额）
	private String tbPExt1; // 机票细节1（航空公司）Product Detail1 (Airline Name)
	private String tbPExt2; // 机票细节2（机票类座位等级）Product Detail2 (classes for arilines)
	private String isSingleTrip; // 是否单程
	private String tbPDepTime; // 起飞时间
	private String tbPDepAirport; // 起飞机场 Departure Airport
	private String tbPArrAirport; // 降落机场 Arrival Airport
	private String tbPTraAirport; // 中转机场 Transit Airport
	private String tbPIscustomer; // 付款人是否在乘机人范围 Is payer a customer
	private String tbPIsCardholder;//付款人是否是持卡人本人Is payer the card holder
	private String tbPCusNantionality; // 乘机人国籍 Customer Nantionality
	private String tbPLeadtime; // 收发时间差 Lead Time 订票时间和登机时间的时间差，单位是天
	private String tbPLocaltime; // 支付发生的当地时间
	private String tbPTelCountry; // 订票电话所在国家
	private String tbPPhoneCountry; // 订票手机号所在国家
	private String tbJourbillAddress;// 收取行程单地址
	private String tbOffState;//起飞国家
	private String tbTagetState;//目的国家
	// ------------------------- //
	private String hotelPName; // 入住人姓名
	private String hotelPPhone; // 入住人手机或电话
	private String hotelPIdtype; // 入住人证件类型
	private String hotelPIdnumber; // 入住人证件号码
	private String hotelProductDetail1; // 商品细节1（酒店品牌）Product Detail1 (Hotel Brand for Hotel)
	private String hotelProductDetail2; // 商品细节2（房间种类）Product Detail2 (room type for hotel)
	private String hotelPStarttime;// 入住起始时间
	private String hotelPEndtime;// 入住终止时间
	// ------------------------- //
	private String deMPhone; // 会员手机或电话
	private String deMIdtype; // 会员证件类型
	private String deIsRealnameAuth; // 是否实名认证用户
	private String deMIdnumber; // 会员证件号码
	private String riskInfoList;//TB行业XML串

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardholderId() {
		return cardholderId;
	}

	public void setCardholderId(String cardholderId) {
		this.cardholderId = cardholderId;
	}

	public String getCardholderZip() {
		return cardholderZip;
	}

	public void setCardholderZip(String cardholderZip) {
		this.cardholderZip = cardholderZip;
	}

	public String getCardholderBillCountryIso() {
		return cardholderBillCountryIso;
	}

	public void setCardholderBillCountryIso(String cardholderBillCountryIso) {
		this.cardholderBillCountryIso = cardholderBillCountryIso;
	}

	public String getCardholderBillProvinceState() {
		return cardholderBillProvinceState;
	}

	public void setCardholderBillProvinceState(String cardholderBillProvinceState) {
		this.cardholderBillProvinceState = cardholderBillProvinceState;
	}

	public String getCardholderBillCity() {
		return cardholderBillCity;
	}

	public void setCardholderBillCity(String cardholderBillCity) {
		this.cardholderBillCity = cardholderBillCity;
	}

	public String getCardholderBillAddress() {
		return cardholderBillAddress;
	}

	public void setCardholderBillAddress(String cardholderBillAddress) {
		this.cardholderBillAddress = cardholderBillAddress;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getpTelCountryCode() {
		return pTelCountryCode;
	}

	public void setpTelCountryCode(String pTelCountryCode) {
		this.pTelCountryCode = pTelCountryCode;
	}

	public String getpTelRegion() {
		return pTelRegion;
	}

	public void setpTelRegion(String pTelRegion) {
		this.pTelRegion = pTelRegion;
	}

	public String getpPhoneCountryCode() {
		return pPhoneCountryCode;
	}

	public void setpPhoneCountryCode(String pPhoneCountryCode) {
		this.pPhoneCountryCode = pPhoneCountryCode;
	}

	public String getpTel() {
		return pTel;
	}

	public void setpTel(String pTel) {
		this.pTel = pTel;
	}

	public String getpIp() {
		return pIp;
	}

	public void setpIp(String pIp) {
		this.pIp = pIp;
	}

	public String getpIdtype() {
		return pIdtype;
	}

	public void setpIdtype(String pIdtype) {
		this.pIdtype = pIdtype;
	}

	public String getpIdnumber() {
		return pIdnumber;
	}

	public void setpIdnumber(String pIdnumber) {
		this.pIdnumber = pIdnumber;
	}

	public String getpIsMerchantmbr() {
		return pIsMerchantmbr;
	}

	public void setpIsMerchantmbr(String pIsMerchantmbr) {
		this.pIsMerchantmbr = pIsMerchantmbr;
	}

	public String getpRegtime() {
		return pRegtime;
	}

	public void setpRegtime(String pRegtime) {
		this.pRegtime = pRegtime;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcIdtype() {
		return cIdtype;
	}

	public void setcIdtype(String cIdtype) {
		this.cIdtype = cIdtype;
	}

	public String getcIdnumber() {
		return cIdnumber;
	}

	public void setcIdnumber(String cIdnumber) {
		this.cIdnumber = cIdnumber;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcCountry() {
		return cCountry;
	}

	public void setcCountry(String cCountry) {
		this.cCountry = cCountry;
	}

	public String getcProvince() {
		return cProvince;
	}

	public void setcProvince(String cProvince) {
		this.cProvince = cProvince;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public String getpProductname() {
		return pProductname;
	}

	public void setpProductname(String pProductname) {
		this.pProductname = pProductname;
	}

	public String getpProducttype() {
		return pProducttype;
	}

	public void setpProducttype(String pProducttype) {
		this.pProducttype = pProducttype;
	}

	public String getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(String pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpTotalprice() {
		return pTotalprice;
	}

	public void setpTotalprice(String pTotalprice) {
		this.pTotalprice = pTotalprice;
	}

	public String getpRegAddress() {
		return pRegAddress;
	}

	public void setpRegAddress(String pRegAddress) {
		this.pRegAddress = pRegAddress;
	}

	public String getpOpentime() {
		return pOpentime;
	}

	public void setpOpentime(String pOpentime) {
		this.pOpentime = pOpentime;
	}

	public String getpClosetime() {
		return pClosetime;
	}

	public void setpClosetime(String pClosetime) {
		this.pClosetime = pClosetime;
	}

	public String getpDdetail() {
		return pDdetail;
	}

	public void setpDdetail(String pDdetail) {
		this.pDdetail = pDdetail;
	}

	public String getTbPTel() {
		return tbPTel;
	}

	public void setTbPTel(String tbPTel) {
		this.tbPTel = tbPTel;
	}

	public String getTbPPhone() {
		return tbPPhone;
	}

	public void setTbPPhone(String tbPPhone) {
		this.tbPPhone = tbPPhone;
	}

	public String getTbPIdtype() {
		return tbPIdtype;
	}

	public void setTbPIdtype(String tbPIdtype) {
		this.tbPIdtype = tbPIdtype;
	}

	public String getTbPIdnumber() {
		return tbPIdnumber;
	}

	public void setTbPIdnumber(String tbPIdnumber) {
		this.tbPIdnumber = tbPIdnumber;
	}

	public String getTbIsFrequenter() {
		return tbIsFrequenter;
	}

	public void setTbIsFrequenter(String tbIsFrequenter) {
		this.tbIsFrequenter = tbIsFrequenter;
	}

	public String getTbPProductname() {
		return tbPProductname;
	}

	public void setTbPProductname(String tbPProductname) {
		this.tbPProductname = tbPProductname;
	}

	public String getTbPQuantity() {
		return tbPQuantity;
	}

	public void setTbPQuantity(String tbPQuantity) {
		this.tbPQuantity = tbPQuantity;
	}

	public String getTbPTotalprice() {
		return tbPTotalprice;
	}

	public void setTbPTotalprice(String tbPTotalprice) {
		this.tbPTotalprice = tbPTotalprice;
	}

	public String getTbPExt1() {
		return tbPExt1;
	}

	public void setTbPExt1(String tbPExt1) {
		this.tbPExt1 = tbPExt1;
	}

	public String getTbPExt2() {
		return tbPExt2;
	}

	public void setTbPExt2(String tbPExt2) {
		this.tbPExt2 = tbPExt2;
	}

	public String getIsSingleTrip() {
		return isSingleTrip;
	}

	public void setIsSingleTrip(String isSingleTrip) {
		this.isSingleTrip = isSingleTrip;
	}

	public String getTbPDepTime() {
		return tbPDepTime;
	}

	public void setTbPDepTime(String tbPDepTime) {
		this.tbPDepTime = tbPDepTime;
	}

	public String getTbPDepAirport() {
		return tbPDepAirport;
	}

	public void setTbPDepAirport(String tbPDepAirport) {
		this.tbPDepAirport = tbPDepAirport;
	}

	public String getTbPArrAirport() {
		return tbPArrAirport;
	}

	public void setTbPArrAirport(String tbPArrAirport) {
		this.tbPArrAirport = tbPArrAirport;
	}

	public String getTbPTraAirport() {
		return tbPTraAirport;
	}

	public void setTbPTraAirport(String tbPTraAirport) {
		this.tbPTraAirport = tbPTraAirport;
	}

	public String getTbPIscustomer() {
		return tbPIscustomer;
	}

	public void setTbPIscustomer(String tbPIscustomer) {
		this.tbPIscustomer = tbPIscustomer;
	}

	public String getTbPCusNantionality() {
		return tbPCusNantionality;
	}

	public void setTbPCusNantionality(String tbPCusNantionality) {
		this.tbPCusNantionality = tbPCusNantionality;
	}

	public String getTbPLeadtime() {
		return tbPLeadtime;
	}

	public void setTbPLeadtime(String tbPLeadtime) {
		this.tbPLeadtime = tbPLeadtime;
	}

	public String getTbPLocaltime() {
		return tbPLocaltime;
	}

	public void setTbPLocaltime(String tbPLocaltime) {
		this.tbPLocaltime = tbPLocaltime;
	}

	public String getTbPTelCountry() {
		return tbPTelCountry;
	}

	public void setTbPTelCountry(String tbPTelCountry) {
		this.tbPTelCountry = tbPTelCountry;
	}

	public String getTbPPhoneCountry() {
		return tbPPhoneCountry;
	}

	public void setTbPPhoneCountry(String tbPPhoneCountry) {
		this.tbPPhoneCountry = tbPPhoneCountry;
	}

	public String getTbJourbillAddress() {
		return tbJourbillAddress;
	}

	public void setTbJourbillAddress(String tbJourbillAddress) {
		this.tbJourbillAddress = tbJourbillAddress;
	}

	public String getHotelPName() {
		return hotelPName;
	}

	public void setHotelPName(String hotelPName) {
		this.hotelPName = hotelPName;
	}

	public String getHotelPPhone() {
		return hotelPPhone;
	}

	public void setHotelPPhone(String hotelPPhone) {
		this.hotelPPhone = hotelPPhone;
	}

	public String getHotelPIdtype() {
		return hotelPIdtype;
	}

	public void setHotelPIdtype(String hotelPIdtype) {
		this.hotelPIdtype = hotelPIdtype;
	}

	public String getHotelPIdnumber() {
		return hotelPIdnumber;
	}

	public void setHotelPIdnumber(String hotelPIdnumber) {
		this.hotelPIdnumber = hotelPIdnumber;
	}

	public String getHotelProductDetail1() {
		return hotelProductDetail1;
	}

	public void setHotelProductDetail1(String hotelProductDetail1) {
		this.hotelProductDetail1 = hotelProductDetail1;
	}

	public String getHotelProductDetail2() {
		return hotelProductDetail2;
	}

	public void setHotelProductDetail2(String hotelProductDetail2) {
		this.hotelProductDetail2 = hotelProductDetail2;
	}

	public String getHotelPStarttime() {
		return hotelPStarttime;
	}

	public void setHotelPStarttime(String hotelPStarttime) {
		this.hotelPStarttime = hotelPStarttime;
	}

	public String getHotelPEndtime() {
		return hotelPEndtime;
	}

	public void setHotelPEndtime(String hotelPEndtime) {
		this.hotelPEndtime = hotelPEndtime;
	}

	public String getDeMPhone() {
		return deMPhone;
	}

	public void setDeMPhone(String deMPhone) {
		this.deMPhone = deMPhone;
	}

	public String getDeMIdtype() {
		return deMIdtype;
	}

	public void setDeMIdtype(String deMIdtype) {
		this.deMIdtype = deMIdtype;
	}

	public String getDeIsRealnameAuth() {
		return deIsRealnameAuth;
	}

	public void setDeIsRealnameAuth(String deIsRealnameAuth) {
		this.deIsRealnameAuth = deIsRealnameAuth;
	}

	public String getDeMIdnumber() {
		return deMIdnumber;
	}

	public void setDeMIdnumber(String deMIdnumber) {
		this.deMIdnumber = deMIdnumber;
	}

	public String getCardholderPhoneCountryCode() {
		return cardholderPhoneCountryCode;
	}

	public void setCardholderPhoneCountryCode(String cardholderPhoneCountryCode) {
		this.cardholderPhoneCountryCode = cardholderPhoneCountryCode;
	}

	public String getCardholderPhone() {
		return cardholderPhone;
	}

	public void setCardholderPhone(String cardholderPhone) {
		this.cardholderPhone = cardholderPhone;
	}

	public String getCardholderTelCountryCode() {
		return cardholderTelCountryCode;
	}

	public void setCardholderTelCountryCode(String cardholderTelCountryCode) {
		this.cardholderTelCountryCode = cardholderTelCountryCode;
	}

	public String getCardholderTelRegion() {
		return cardholderTelRegion;
	}

	public void setCardholderTelRegion(String cardholderTelRegion) {
		this.cardholderTelRegion = cardholderTelRegion;
	}

	public String getCardholderTel() {
		return cardholderTel;
	}

	public void setCardholderTel(String cardholderTel) {
		this.cardholderTel = cardholderTel;
	}

	public String getCardholderIdtype() {
		return cardholderIdtype;
	}

	public void setCardholderIdtype(String cardholderIdtype) {
		this.cardholderIdtype = cardholderIdtype;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcPhoneCountryCode() {
		return cPhoneCountryCode;
	}

	public void setcPhoneCountryCode(String cPhoneCountryCode) {
		this.cPhoneCountryCode = cPhoneCountryCode;
	}

	public String getcTelCountryCode() {
		return cTelCountryCode;
	}

	public void setcTelCountryCode(String cTelCountryCode) {
		this.cTelCountryCode = cTelCountryCode;
	}

	public String getcTelRegion() {
		return cTelRegion;
	}

	public void setcTelRegion(String cTelRegion) {
		this.cTelRegion = cTelRegion;
	}

	public String getTbPName() {
		return tbPName;
	}

	public void setTbPName(String tbPName) {
		this.tbPName = tbPName;
	}

	public String getTbPIsCardholder() {
		return tbPIsCardholder;
	}

	public void setTbPIsCardholder(String tbPIsCardholder) {
		this.tbPIsCardholder = tbPIsCardholder;
	}

	public String getCardholderEmail() {
		return cardholderEmail;
	}

	public void setCardholderEmail(String cardholderEmail) {
		this.cardholderEmail = cardholderEmail;
	}

	public String getpHostname() {
		return pHostname;
	}

	public void setpHostname(String pHostname) {
		this.pHostname = pHostname;
	}

	public String getcZip() {
		return cZip;
	}

	public void setcZip(String cZip) {
		this.cZip = cZip;
	}

	public String getcMethord() {
		return cMethord;
	}

	public void setcMethord(String cMethord) {
		this.cMethord = cMethord;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCardholderFirstName() {
		return cardholderFirstName;
	}

	public void setCardholderFirstName(String cardholderFirstName) {
		this.cardholderFirstName = cardholderFirstName;
	}

	public String getCardholderLastName() {
		return cardholderLastName;
	}

	public void setCardholderLastName(String cardholderLastName) {
		this.cardholderLastName = cardholderLastName;
	}

	public String getRiskInfoList() {
		return riskInfoList;
	}

	public void setRiskInfoList(String riskInfoList) {
		this.riskInfoList = riskInfoList;
	}

	public String getPayIp() {
		return payIp;
	}

	public void setPayIp(String payIp) {
		this.payIp = payIp;
	}

	public String getTbOffState() {
		return tbOffState;
	}

	public void setTbOffState(String tbOffState) {
		this.tbOffState = tbOffState;
	}

	public String getTbTagetState() {
		return tbTagetState;
	}

	public void setTbTagetState(String tbTagetState) {
		this.tbTagetState = tbTagetState;
	}

	public String getTmxSessionId() {
		return tmxSessionId;
	}

	public void setTmxSessionId(String tmxSessionId) {
		this.tmxSessionId = tmxSessionId;
	}

}
