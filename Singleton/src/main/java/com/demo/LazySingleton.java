package com.demo;

/**
 * LazySingleton
 * 懒汉模式应用
 * @author liruoyu
 * @date 2019/9/7
 *
 * 懒汉模式应用
 * 模拟产生美国当今总统对象
 * 分析： 每届任期只有一个总统。所以使用单例模式
 */
public class LazySingleton {

    public static void main(String[] args) {
        President zt1 = President.getInstance();
        zt1.getName();
        President zt2 = President.getInstance();
        zt2.getName();
        if(zt1 == zt2){
            System.out.println("他们是同一个人！");
        } else {
            System.out.println("他们不是同一个人");
        }
    }


}

class President
{
    private static volatile President instance = null;
    private President(){
        System.out.println("产生一个总统！");
    }
    public static synchronized President getInstance(){
        if(instance == null){
            instance = new President();
        } else {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }

    public void getName(){
        System.out.println("我是美国总统：特朗普。");
    }

}
