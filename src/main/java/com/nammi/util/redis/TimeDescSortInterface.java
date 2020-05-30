package com.nammi.util.redis;

import java.io.Serializable;

/**
 * 按时间字段倒序排序接口
 * 
 * @author ruihua.qin
 *
 */
public interface TimeDescSortInterface extends Serializable{
	
	/*
	 * 返回排序、剔除用的交易时间(ms)
	 */
	public Long getOrderTime();
}
