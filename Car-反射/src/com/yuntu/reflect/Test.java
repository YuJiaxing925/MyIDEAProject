package com.yuntu.reflect;

public class Test {
    public static void main(String[] args) {
        Car car = Factory.createCar("com.yuntu.reflect.BydQin");
        car.show();
        car = Factory.createCar("com.yuntu.reflect.BydSong");
        car.show();
        car = Factory.createCar("com.yuntu.reflect.BydHan");
        car.show();
        car = Factory.createCar("com.yuntu.reflect.BydTang");
        car.show();

        car = Factory.createByd("BydYuan");
        car.show();
    }
}
