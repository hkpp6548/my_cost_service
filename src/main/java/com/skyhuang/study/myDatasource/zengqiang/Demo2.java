package com.skyhuang.study.myDatasource.zengqiang;

/**使用装饰进行增强
 * Created by hk on 2017/9/20.
 */
public class Demo2 {
    public static void main(String[] args) {
        Car car = new Bmw();
        CarDerector cars = new CarDerector(car);
        cars.run();
    }
}

interface Car{
    public void run();
}

class Bmw implements Car{
    public void run(){
        System.out.println("Bmw running");
    }
}

class Fengtian implements Car{
    public void run(){
        System.out.println("Fengtian runing");
    }
}

class CarDerector implements Car{
    private Car car;
    public CarDerector(Car car){
        this.car = car;
    }
    public void run(){
        System.out.println("添加导航的功能");
        car.run();
    }

}


