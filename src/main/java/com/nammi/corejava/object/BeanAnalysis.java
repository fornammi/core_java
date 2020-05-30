package com.nammi.corejava.object;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 获取对象里值为空（包括null、空白等）的属性集合
 * @author daniel.fang
 * apply：
 * 		BeanUtils.copyProperties(A,B)时A中的空值会覆盖掉B中字段的值，所以采用
 * 		BeanUtils.copyProperties(riskInfoDataJsonDto, rcsReferenceDataJsonDto, ignoreProperties);
 * 其中String[] ignoreProperties = getBlankProperties(riskInfoDataJsonDto);
 */
public class BeanAnalysis {
	
	private static final long serialVersionUID = 1717420842011846358L;
	
	public static String[] getBlankProperties(Object obj){
		List<String> propList = new ArrayList<String>();
		
		try {
			Class<?> cls = obj.getClass();
			System.out.println("className="+cls.getName());
			
			Field[] allField = cls.getDeclaredFields();
			for(Field fld : allField){
				System.out.println("-----field type="+fld.getType());
				if(fld.toString().endsWith("serialVersionUID")){
					//serialVersionUID不作处理
					System.out.println("-----serialVersionUID不作处理----");
				//}else if((fld.getType()).isAssignableFrom(List.class) || (fld.getType()).isAssignableFrom(Collection.class) || (fld.getType()).isAssignableFrom(Set.class)){
				}else if((List.class).isAssignableFrom(fld.getType()) || (Set.class).isAssignableFrom(fld.getType()) || (Collection.class).isAssignableFrom(fld.getType())){
					//集合类型不作处理
					System.out.println("-----集合类型不作处理----");
				}else{
					PropertyDescriptor pd = PropertyUtils.getPropertyDescriptor(obj, fld.getName());
					//PropertyDescriptor pd = new PropertyDescriptor(fld.getName(), cls);
					Method getMethod = pd.getReadMethod();
					System.out.println("getMethod="+getMethod);
					String val = (String)getMethod.invoke(obj);
					if(StringUtils.isBlank(val)){
						propList.add(fld.getName());
					}else{
						System.out.println("----- fieldList print-----");
						System.out.println("val = " + val); 
						System.out.println("----- fieldList print-----");
					}
				}
			}
		} /*catch (IntrospectionException e) {
			e.printStackTrace();
		}*/ catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return propList.toArray(new String[propList.size()]);
	}
	
	public static void main(String[] args) {
		
		RcsReferenceDataDto dto = new RcsReferenceDataDto();
		String[] proArr = getBlankProperties(dto);
		for(String s : proArr){
			System.out.println("s="+s);
		}
	}
	
}
