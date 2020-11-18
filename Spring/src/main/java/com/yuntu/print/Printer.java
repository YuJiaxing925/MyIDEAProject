package com.yuntu.print;

import com.yuntu.ink.Ink;
import com.yuntu.paper.Paper;

public class Printer {
    //面向接口编程，不需要具体实现
    private Ink ink;
    private Paper paper;

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    /**
     *
     */
    public void print(String str){
        //输出的颜色
        System.out.println("使用的颜色是："+ink.getColor(22,255,30));
        //将字一个一个打印在纸张上
        for (int i  = 0;i<str.length();i++){
            paper.putInChar(str.charAt(i));
        }
        //将纸张内容输出
        System.out.println(paper.getContent());
    }
}
