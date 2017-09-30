package com.skyhuang.study.listener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class TimerDemo {
	public static void main(String[] args) {

		Timer t = new Timer();

		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("hello timer");
			}
		}, 1000,2000);
	}
}
