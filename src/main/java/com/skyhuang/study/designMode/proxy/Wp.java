package com.skyhuang.study.designMode.proxy;

/** 代理类王婆
 * Created by dahoufang the one on 2017/10/25.
 */
public class Wp implements KingWoman{

    private KingWoman woman;

    public Wp(KingWoman woman) {
        this.woman = woman;
    }

    public void throwEye() {
        //在这里做操作，可以控制是否调用真实行为。
        woman.throwEye();
        //在这个位置，可以在真实行为调用完成后，在做操作。
    }

    public void doSomething() {
        woman.doSomething();
    }
}
