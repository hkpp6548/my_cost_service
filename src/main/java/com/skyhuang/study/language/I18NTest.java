package com.skyhuang.study.language;

import java.util.Locale;
import java.util.ResourceBundle;

//演示 ResourceBundle使用
public class I18NTest {

	public static void main(String[] args) {

		//ResourceBundle bundle = ResourceBundle.getBundle("message");
		
		ResourceBundle bundle = ResourceBundle.getBundle("message",Locale.FRANCE);
		String value = bundle.getString("msg");

		System.out.println(value);
	}
}
