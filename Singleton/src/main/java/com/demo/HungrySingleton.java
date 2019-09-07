package com.demo;

import java.awt.*;
import javax.swing.*;

/**
 * HungrySingleton
 *
 * @author liruoyu
 * @date 2019/9/7
 *
 * 饿汉模式示例
 * 产生猪八戒对象，并用显示图片（使用了JFrame框架窗体组件）
 */
public class HungrySingleton {
    public static void main(String[] args) {
        JFrame jf = new JFrame("饿汉单例模式示例");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        Bajie obj1 = Bajie.getInstance();
        contentPane.add(obj1);
        Bajie obj2 = Bajie.getInstance();
        contentPane.add(obj2);
        if(obj1 == obj2){
            System.out.println("他们是同一个八戒！");
        } else {
            System.out.println("他们不是同一个八戒！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Bajie extends JPanel{
    private static Bajie instance = new Bajie();
    private Bajie(){
        String filepath = System.getProperty("user.dir") + "\\src\\" + "main\\" + "resources\\";
        System.out.println(filepath + "Bajie.jpg");
        JLabel ll = new JLabel(new ImageIcon(filepath + "Bajie.jpg"));
        this.add(ll);
    }
    public static Bajie getInstance(){
        return instance;
    }
}
