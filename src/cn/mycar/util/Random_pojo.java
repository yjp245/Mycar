package cn.mycar.util;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Random;
public class Random_pojo {

	/**
	 * 产生6位随机数
	 * @return x
	 */
	@Test
	public void test(){
		System.out.println(getRandomString(6));
	}
	public int getrandom_4() {
		int x=0;
		Random random=new Random();
		for(int i=0;i<20;i++) {	
			while(x<1000)
			 x=random.nextInt(10000);
		}
		return x;
	}
	public static String getRandomString(int length) {
		//随机字符串的随机字符库
		//String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String KeyString = "0123456789";
		StringBuffer sb = new StringBuffer();
		int len = KeyString.length();
		for (int i = 0; i < length; i++) {
			sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
		}
		return sb.toString();
	}
}
