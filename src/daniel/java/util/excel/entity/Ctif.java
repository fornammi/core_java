package daniel.java.util.excel.entity;
/**
 * 
 * Title:可疑主体 <br>
 * @author yanshaodong <br>
 * @date 2012-11-5 下午04:16:08 <br>
 * @email yanshaodong@agilecentury.com <br>
 * @copyright copyright agilecentury 2012 <br>
 */
public class Ctif {
	private String id;
	private String smid; // SMID 主体特约商户编号
	private String citp; // CITP 主体身份证件/证明文件类型
	private String ctid; // CTID 主体身份证件/证明文件号码
	private String ctar; // CTAR 详细地址
	private String cctl; // CCTL 联系电话
	private String ceml; // CEML 电子邮件
	private String ctvc; // CTVC 主体的职业/行业类别
	private String crnm; // CRNM 主体的法定代表人姓名
	private String crit; // CRIT 主体的法定代表人身份证件类型
	private String crid; // CRID 主体的法定代表人身份证件号码
	private String curInnum; // CUR_IN_NUM 当日交易笔数（收）
	private String curInamt; // CUR_IN_AMT 当日交易金额（收）
	private String curOutnum; // CUR_OUT_NUM 当日交易笔数（支）
	private String curOutamt; // CUR_OUT_AMT 当日交易金额（支）
	private String accInnum; // ACC_IN_NUM 累计交易笔数（收）
	private String accInamt; // ACC_IN_AMT 累计交易金额（收）
	private String accOutnum; // ACC_OUT_NUM 累计交易笔数（支）
	private String accOutamt; // ACC_OUT_AMT 累计交易金额（支）
	private String riskLevel; // RISK_LEVEL 风险等级
	private String compScore; // COMP_SCORE 综合评分
	private String succNum; // SUCC_NUM 筛出次数
	private String reptNum; // REPT_NUM 报送次数
	private String busiRegno; // BUSI_REG_NO 业务注册号
	private String busiType; // BUSI_TYPE 业务类型
	private String lstp; // LSTP 名单类别
	private String redt; // REDT 落地时间
	private String ctifTp; // CTIF_TP 主体类别（1代表个人、2代表机构）
	private String ctnm; // CTNM 主体名称
	private String clientTp; // CLIENT_TP 客户类别(1代表客户,2代表商户)
	private String country; // COUNTRY 国籍
	private String nation; // NATION 民族
	private String sex; // SEX 性别
	private String birthday; // BIRTHDAY 出生日期
	private String endtime; // ENDTIME 有效期限
	private String agencyCtnm; // AGENCY_CTNM 代办理人姓名
	private String agencyCitp; // AGENCY_CITP 代办理人证件类型
	private String agencyCtid; // AGENCY_CTID 代办理人证件号码
	private String agencyEndtime; // AGENCY_ENDTIME 代办理人证件有效期限
	private String crpType; // CRP_TYPE 机构类别
	private String regCptl; // REG_CPTL 注册资本
	private String fudDate; // FUD_DATE 成立日期
	private String remarkCitp; // REMARK_CITP 对身份证件类型进行说明
	private String remarkCtvc; // REMARK_CTVC 对商户的经营范围进行备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSmid() {
		return smid;
	}

	public void setSmid(String smid) {
		this.smid = smid;
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

	public String getCtar() {
		return ctar;
	}

	public void setCtar(String ctar) {
		this.ctar = ctar;
	}

	public String getCctl() {
		return cctl;
	}

	public void setCctl(String cctl) {
		this.cctl = cctl;
	}

	public String getCeml() {
		return ceml;
	}

	public void setCeml(String ceml) {
		this.ceml = ceml;
	}

	public String getCtvc() {
		return ctvc;
	}

	public void setCtvc(String ctvc) {
		this.ctvc = ctvc;
	}

	public String getCrnm() {
		return crnm;
	}

	public void setCrnm(String crnm) {
		this.crnm = crnm;
	}

	public String getCrit() {
		return crit;
	}

	public void setCrit(String crit) {
		this.crit = crit;
	}

	public String getCrid() {
		return crid;
	}

	public void setCrid(String crid) {
		this.crid = crid;
	}

	public String getCurInnum() {
		return curInnum;
	}

	public void setCurInnum(String curInnum) {
		this.curInnum = curInnum;
	}

	public String getCurInamt() {
		return curInamt;
	}

	public void setCurInamt(String curInamt) {
		this.curInamt = curInamt;
	}

	public String getCurOutnum() {
		return curOutnum;
	}

	public void setCurOutnum(String curOutnum) {
		this.curOutnum = curOutnum;
	}

	public String getCurOutamt() {
		return curOutamt;
	}

	public void setCurOutamt(String curOutamt) {
		this.curOutamt = curOutamt;
	}

	public String getAccInnum() {
		return accInnum;
	}

	public void setAccInnum(String accInnum) {
		this.accInnum = accInnum;
	}

	public String getAccInamt() {
		return accInamt;
	}

	public void setAccInamt(String accInamt) {
		this.accInamt = accInamt;
	}

	public String getAccOutnum() {
		return accOutnum;
	}

	public void setAccOutnum(String accOutnum) {
		this.accOutnum = accOutnum;
	}

	public String getAccOutamt() {
		return accOutamt;
	}

	public void setAccOutamt(String accOutamt) {
		this.accOutamt = accOutamt;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getCompScore() {
		return compScore;
	}

	public void setCompScore(String compScore) {
		this.compScore = compScore;
	}

	public String getSuccNum() {
		return succNum;
	}

	public void setSuccNum(String succNum) {
		this.succNum = succNum;
	}

	public String getReptNum() {
		return reptNum;
	}

	public void setReptNum(String reptNum) {
		this.reptNum = reptNum;
	}

	public String getBusiRegno() {
		return busiRegno;
	}

	public void setBusiRegno(String busiRegno) {
		this.busiRegno = busiRegno;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getLstp() {
		return lstp;
	}

	public void setLstp(String lstp) {
		this.lstp = lstp;
	}

	public String getRedt() {
		return redt;
	}

	public void setRedt(String redt) {
		this.redt = redt;
	}

	public String getCtifTp() {
		return ctifTp;
	}

	public void setCtifTp(String ctifTp) {
		this.ctifTp = ctifTp;
	}

	public String getCtnm() {
		return ctnm;
	}

	public void setCtnm(String ctnm) {
		this.ctnm = ctnm;
	}

	public String getClientTp() {
		return clientTp;
	}

	public void setClientTp(String clientTp) {
		this.clientTp = clientTp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getAgencyCtnm() {
		return agencyCtnm;
	}

	public void setAgencyCtnm(String agencyCtnm) {
		this.agencyCtnm = agencyCtnm;
	}

	public String getAgencyCitp() {
		return agencyCitp;
	}

	public void setAgencyCitp(String agencyCitp) {
		this.agencyCitp = agencyCitp;
	}

	public String getAgencyCtid() {
		return agencyCtid;
	}

	public void setAgencyCtid(String agencyCtid) {
		this.agencyCtid = agencyCtid;
	}

	public String getAgencyEndtime() {
		return agencyEndtime;
	}

	public void setAgencyEndtime(String agencyEndtime) {
		this.agencyEndtime = agencyEndtime;
	}

	public String getCrpType() {
		return crpType;
	}

	public void setCrpType(String crpType) {
		this.crpType = crpType;
	}

	public String getRegCptl() {
		return regCptl;
	}

	public void setRegCptl(String regCptl) {
		this.regCptl = regCptl;
	}

	public String getFudDate() {
		return fudDate;
	}

	public void setFudDate(String fudDate) {
		this.fudDate = fudDate;
	}

	public String getRemarkCitp() {
		return remarkCitp;
	}

	public void setRemarkCitp(String remarkCitp) {
		this.remarkCitp = remarkCitp;
	}

	public String getRemarkCtvc() {
		return remarkCtvc;
	}

	public void setRemarkCtvc(String remarkCtvc) {
		this.remarkCtvc = remarkCtvc;
	}

}
