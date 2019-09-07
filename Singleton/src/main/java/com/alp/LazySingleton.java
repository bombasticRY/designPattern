package com.alp;

/**
 * com.alp.LazySingleton
 * 懒汉模式
 * @author liruoyu
 * @date 2019/9/7
 *
 * 类加载时没有生成单例，只有在第一次调用getInstance()方法时才会创建单例
 * 使用了volatile/synchronized 关键字，多线程调用时每次访问都会进行同步，会影响性能
 * 不是多线程程序，可以删除上述关键字
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null; //保证instance 线程同步
    private LazySingleton(){} // 避免在外部实例化
    public static synchronized LazySingleton getInstance(){
        //getInstance方法前 加 同步关键字
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
