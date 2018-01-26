package com.zydlove.home.util;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
@SuppressWarnings("unchecked")
public class IoCloseUtil {
	public static <T extends Closeable> void  close(T...t){
		for(int i = 0;i<t.length;i++){
			if(t[i]!=null){
					try {
						t[i].close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
	public static void close(Object...objArray){
		for(Object obj :objArray){
			if(obj!=null){
				try {
					Class c = obj.getClass();
					Method m = c.getDeclaredMethod("close");
					m.invoke(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
