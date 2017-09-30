package com.skyhuang.study.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class MyFrame extends JFrame{
	private JButton but = new JButton("按钮"); // 事件源
	// 事件:but被按下就是一个事件。 ActionEvent 对于ActionEvent事件的监听器就是ActionListener.
	public MyFrame() {
		this.getContentPane().add(but);
		but.addActionListener(new ButListener()); // 注册监听
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}

// 监听器
class ButListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// e.getSource() 获取事件源
		System.out.println("hello world");
	}
}
