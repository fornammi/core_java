package daniel.java.util.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import redis.clients.jedis.Jedis;

public class RedisHelper {
	/**
	 * 缓存key前缀
	 */
	public final static String CACHE_KEY_USERINFO = "USERINFO.";  //用户信息
	public final static String CACHE_KEY_TXNINFO = "TXNINFO.";    //交易信息
	public final static String CACHE_KEY_RATEDATA_CUSTOMER_SET = "RATEDATA.C.SET"; 	// 会员集合Set<MemberCode>
	public final static String CACHE_KEY_RATEDATA_CUSTOMER_TXN = "RATEDATA.C.TXN."; // 会员下的交易TimeDescSortList<TxnCache4Customer>
	public final static String CACHE_KEY_RATEDATA_MERCHANT_TXN = "RATEDATA.M.TXN."; // 商户下的交易
	public final static String CACHE_KEY_RATEDATA_MERCHANT_AMOUNT = "RATEDATA.M.AMT."; // 商户下的交易额
	public final static String CACHE_KEY_OPENED_MERCHANT = "OPENED.MERCHANT"; // 已开通快易花的商户
	
	
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.15.82", 6379);
		//10012195250
		//10012077336
		String cacheKey = CACHE_KEY_RATEDATA_MERCHANT_TXN + "10012077336";
		boolean isExists = jedis.exists(cacheKey);
		System.out.println(isExists);
		//key-String
		String val = jedis.get(cacheKey);
		
		//key-list
		byte[] bytes = jedis.get(cacheKey.getBytes());
		Object obj = SerializationHelper.deserialize(bytes);
		if(obj!=null && (obj instanceof List<?>)){
			List<CacheTxn> mtxnList = (List<CacheTxn>)obj;
			for(CacheTxn data : mtxnList){
				System.out.println(data);
			}
		}
		
		
		
		/*Set keys = jedis.keys(cacheKey);
		Iterator it = keys.iterator();
		while(it.hasNext()){
			//CacheTxn txn = (CacheTxn)it.next();
			System.out.println(it.next());
		}*/
	}
	
	public static void delKey(Jedis jedis, String key){
		jedis.del(key);
	}
	
	public static List<CacheTxn> getList(Jedis jedis, String key){
		/*byte[] in = jedis.get(key.getBytes());
		List<CacheTxn> list = ObjectsTranscoder.de*/
		return null;
	}
	
}
