package com.yuntu.pojo;

public class HelloSpring {
    private String name;
    private String say;

    public void print(){
        System.out.println(name+"说："+say);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}
