package com.alp;

/**
 * com.alp.HungrySingleton
 * 饿汉模式
 * @author liruoyu
 * @date 2019/9/7
 *
 * 在类创建的同时就创建好了静态对象供系统使用。线程安全。
 * 可直接用于多线程，不会出问题
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
