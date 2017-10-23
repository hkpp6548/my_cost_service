package com.skyhuang.study.language;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

	// 1.数值操作
	@Test
	public void fun1() {
		NumberFormat nf = NumberFormat.getIntegerInstance();

		String s = nf.format(19.98765);

		System.out.println(s);

	}

	// 2.查分比
	@Test
	public void fun2() {
		NumberFormat nf = NumberFormat.getPercentInstance(Locale.FRANCE);

		String s = nf.format(0.98);

		System.out.println(s);
	}

	// 3.货币
	@Test
	public void fun3() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf.format(1090));
	}
}
