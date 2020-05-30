package com.nammi.util.redis;

import java.util.Date;

public class CacheTxn implements TimeDescSortInterface {
	
	private static final long serialVersionUID = 1L;
	
	private Long tradeId; // 交易主键ID
	private String memberCode; // 用户会员号
	private Long payAmount; // 支付金额（分）
	private Date txnTime; // 交易生成时间
	private Long txnStatus; // 状态
	
	private Long expTimeStart; // 缓存生效时间(用于剔除过期数据)

	public Long getTradeId() {
		return tradeId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public Long getPayAmount() {
		return payAmount;
	}

	public Long getTxnStatus() {
		return txnStatus;
	}

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public void setTxnStatus(Long txnStatus) {
		this.txnStatus = txnStatus;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}
	
	public void setExpTimeStart(Long expTimeStart) {
		this.expTimeStart = expTimeStart;
	}

	@Override
	public Long getOrderTime() {
		if (expTimeStart != null) {
			return expTimeStart;
		}
		if (txnTime != null) {
			return txnTime.getTime();
		}

		return System.currentTimeMillis();
	}
	
	@Override
	public String toString() {
		return "[CacheTxn:"
		+ "tradeId=" + tradeId
		+ ", " + "memberCode=" + memberCode
		+ ", " + "payAmount=" + payAmount
		+ ", " + "txnTime=" + txnTime
		+ ", " + "txnStatus=" + txnStatus
		+"]";
	}
}
