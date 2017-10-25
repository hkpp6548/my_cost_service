package com.skyhuang.study.designMode.proxy;

/** 代理
 * Created by dahoufang the one on 2017/10/25.
 */
public class Xmq {

    public static void main(String[] args) {
        KingWoman woman = new Pjl();
        KingWoman wp = new Wp(woman);
        wp.throwEye();
        wp.doSomething();
    }

}
