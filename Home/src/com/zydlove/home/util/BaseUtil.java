package com.zydlove.home.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseUtil {
	public String getParamValue(String param){
		return param!=null&&!param.trim().equals("")?param.trim():null;
	}
	/**
	 * 根据列名获取属性名
	 * @param colName
	 * @return
	 */
	public static  String getFieldNameByColName(String colName){
		StringBuffer fieldName = new StringBuffer();
		for(int i = 0;i<colName.length();i++){
			char c = colName.charAt(i);
			if(c=='_'){
				fieldName.append((colName.charAt(i+1)+"").toUpperCase());
				i++;
			}else{
				fieldName.append(c);
			}
		}
		return  fieldName.toString();
	}
	public static String getTabOrColName(String name){
		StringBuffer result = new StringBuffer(name.charAt(0)+"");
		for(int i = 1;i<name.length();i++){
			char c = name.charAt(i);
			if(c>='A'&&c<='Z'){
				result.append("_"+c);
			}else{
				result.append(c);
			}
		}
		return result.toString();
	}
	public static String getGetter(Field field){
		String fieldName = field.getName();
		return (field.getType()==boolean.class?"is":"get")+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	public static Method getGetterMethod(Class clazz,Field field) throws SecurityException, NoSuchMethodException{
		String getter = getGetter(field);
		return clazz.getDeclaredMethod(getter);
	}
	public static String getSetter(String fieldName){
		return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	public static Method getSetterMethod(Class clazz,Field field) throws SecurityException, NoSuchMethodException{
		String fieldName = field.getName();
		String setter = getSetter(fieldName);
		Method method = clazz.getDeclaredMethod(setter, field.getType());
		return method;
	}
}
