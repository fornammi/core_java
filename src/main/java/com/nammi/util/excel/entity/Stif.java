package com.nammi.util.excel.entity;
/**
 * 
 * Title: 可疑交易<br>
 * @author yanshaodong <br>
 * @date 2012-11-5 下午04:16:24 <br>
 * @email yanshaodong@agilecentury.com <br>
 * @copyright copyright agilecentury 2012 <br>
 */
public class Stif {
	private String id;
	private String ctifId; // CTIF_ID 主体ID
	private String ctnm; // CTNM 主体姓名/名称
	private String citp; // CITP 主体身份证件/证明文件类型
	private String ctid; // CTID 主体身份证件/证明文件号码
	private String cbat; // CBAT 交易主体的银行账号种类
	private String cbac; // CBAC 交易主体的银行账号
	private String cabm; // CABM 交易主体银行账号的开户行名称
	private String ctat; // CTAT 主体的交易账号种类
	private String ctac; // CTAC 主体的交易账号
	private String cpin; // CPIN 主体所在支付机构的名称
	private String cpba; // CPBA 主体所在支付机构的银行账号
	private String cpbn; // CPBN 主体所在支付机构的银行账号的开户行名称
	private String ctip; // CTIP 主体的交易IP地址
	private String tstm; // TSTM 交易时间
	private String cttp; // CTTP 货币资金转移方式
	private String tsdr; // TSDR 资金收付标志
	private String crpp; // CRPP 资金用途
	private String crtp; // CRTP 交易币种
	private String crat; // CRAT 交易金额
	private String tcnm; // TCNM 交易对手姓名/名称
	private String tsmi; // TSMI 交易对手特约商户编码
	private String tcit; // TCIT 交易对手证件/证明文件类型
	private String tcid; // TCID 交易对手证件/证明文件号码
	private String tcat; // TCAT 交易对手的银行账号种类
	private String tcba; // TCBA 交易对手的银行账号
	private String tcbn; // TCBN 交易对手银行账号的开户行名称
	private String tctt; // TCTT 交易对手的交易账号种类
	private String tcta; // TCTA 交易对手的交易账号
	private String tcpn; // TCPN 交易对手所在支付机构的名称
	private String tcpa; // TCPA 交易对手所在支付机构的银行账号
	private String tpbn; // TPBN 交易对手所在支付机构银行账号的开户行名称
	private String tcip; // TCIP 交易对手的交易IP地址
	private String tmnm; // TMNM 交易商品名称
	private String bptc; // BPTC 银行与支付机构之间的业务交易编码
	private String pmtc; // PMTC 支付机构与商户之间的业务交易编码
	private String ticd; // TICD 业务标识号

	private String redt; // REDT 落地时间
	private String isSucc; // IS_SUCC 是否筛出
	private String isRept; // IS_REPT 是否报送
	private String ctifTp; // CTIF_TP 主体类别（1代表个人、2代表机构）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCtifId() {
		return ctifId;
	}

	public void setCtifId(String ctifId) {
		this.ctifId = ctifId;
	}

	public String getCtnm() {
		return ctnm;
	}

	public void setCtnm(String ctnm) {
		this.ctnm = ctnm;
	}

	public String getCitp() {
		return citp;
	}

	public void setCitp(String citp) {
		this.citp = citp;
	}

	public String getCtid() {
		return ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	public String getCbat() {
		return cbat;
	}

	public void setCbat(String cbat) {
		this.cbat = cbat;
	}

	public String getCbac() {
		return cbac;
	}

	public void setCbac(String cbac) {
		this.cbac = cbac;
	}

	public String getCabm() {
		return cabm;
	}

	public void setCabm(String cabm) {
		this.cabm = cabm;
	}

	public String getCtat() {
		return ctat;
	}

	public void setCtat(String ctat) {
		this.ctat = ctat;
	}

	public String getCtac() {
		return ctac;
	}

	public void setCtac(String ctac) {
		this.ctac = ctac;
	}

	public String getCpin() {
		return cpin;
	}

	public void setCpin(String cpin) {
		this.cpin = cpin;
	}

	public String getCpba() {
		return cpba;
	}

	public void setCpba(String cpba) {
		this.cpba = cpba;
	}

	public String getCpbn() {
		return cpbn;
	}

	public void setCpbn(String cpbn) {
		this.cpbn = cpbn;
	}

	public String getCtip() {
		return ctip;
	}

	public void setCtip(String ctip) {
		this.ctip = ctip;
	}

	public String getTstm() {
		return tstm;
	}

	public void setTstm(String tstm) {
		this.tstm = tstm;
	}

	public String getCttp() {
		return cttp;
	}

	public void setCttp(String cttp) {
		this.cttp = cttp;
	}

	public String getTsdr() {
		return tsdr;
	}

	public void setTsdr(String tsdr) {
		this.tsdr = tsdr;
	}

	public String getCrpp() {
		return crpp;
	}

	public void setCrpp(String crpp) {
		this.crpp = crpp;
	}

	public String getCrtp() {
		return crtp;
	}

	public void setCrtp(String crtp) {
		this.crtp = crtp;
	}

	public String getTcnm() {
		return tcnm;
	}

	public void setTcnm(String tcnm) {
		this.tcnm = tcnm;
	}

	public String getTsmi() {
		return tsmi;
	}

	public void setTsmi(String tsmi) {
		this.tsmi = tsmi;
	}

	public String getTcit() {
		return tcit;
	}

	public void setTcit(String tcit) {
		this.tcit = tcit;
	}

	public String getTcid() {
		return tcid;
	}

	public void setTcid(String tcid) {
		this.tcid = tcid;
	}

	public String getTcat() {
		return tcat;
	}

	public void setTcat(String tcat) {
		this.tcat = tcat;
	}

	public String getTcba() {
		return tcba;
	}

	public void setTcba(String tcba) {
		this.tcba = tcba;
	}

	public String getTcbn() {
		return tcbn;
	}

	public void setTcbn(String tcbn) {
		this.tcbn = tcbn;
	}

	public String getTctt() {
		return tctt;
	}

	public void setTctt(String tctt) {
		this.tctt = tctt;
	}

	public String getTcta() {
		return tcta;
	}

	public void setTcta(String tcta) {
		this.tcta = tcta;
	}

	public String getTcpn() {
		return tcpn;
	}

	public void setTcpn(String tcpn) {
		this.tcpn = tcpn;
	}

	public String getTcpa() {
		return tcpa;
	}

	public void setTcpa(String tcpa) {
		this.tcpa = tcpa;
	}

	public String getTpbn() {
		return tpbn;
	}

	public void setTpbn(String tpbn) {
		this.tpbn = tpbn;
	}

	public String getTcip() {
		return tcip;
	}

	public void setTcip(String tcip) {
		this.tcip = tcip;
	}

	public String getTmnm() {
		return tmnm;
	}

	public void setTmnm(String tmnm) {
		this.tmnm = tmnm;
	}

	public String getBptc() {
		return bptc;
	}

	public void setBptc(String bptc) {
		this.bptc = bptc;
	}

	public String getPmtc() {
		return pmtc;
	}

	public void setPmtc(String pmtc) {
		this.pmtc = pmtc;
	}

	public String getTicd() {
		return ticd;
	}

	public void setTicd(String ticd) {
		this.ticd = ticd;
	}

	public String getRedt() {
		return redt;
	}

	public void setRedt(String redt) {
		this.redt = redt;
	}

	public String getIsSucc() {
		return isSucc;
	}

	public void setIsSucc(String isSucc) {
		this.isSucc = isSucc;
	}

	public String getIsRept() {
		return isRept;
	}

	public void setIsRept(String isRept) {
		this.isRept = isRept;
	}

	public String getCrat() {
		return crat;
	}

	public void setCrat(String crat) {
		this.crat = crat;
	}

	public String getCtifTp() {
		return ctifTp;
	}

	public void setCtifTp(String ctifTp) {
		this.ctifTp = ctifTp;
	}

}
