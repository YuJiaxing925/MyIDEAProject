package com.yuntu.reflect;

public class Factory {
    public static Car createCar(/*String carName*/ String className) {
        Car car = null;
        try {
            car = (Car) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return car;
    }

    public static Car createByd(String carName) {
        Car car = null;
        switch (carName) {
            case "BydTang":
                car = new com.yuntu.reflect.BydTang();
                break;
            case "BydHan":
                car = new com.yuntu.reflect.BydHan();
                break;
            case "BydQin":
                car = new com.yuntu.reflect.BydQin();
                break;
            case "BydSong":
                car = new com.yuntu.reflect.BydSong();
                break;
            case "BydYuan":
                car = new com.yuntu.reflect.BydYuan();
                break;
        }
        return car;
    }
}
