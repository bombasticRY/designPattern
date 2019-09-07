package com.demo;

import sun.security.provider.Sun;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * ProtoTypeWukong
 *
 * @author liruoyu
 * @date 2019/9/7
 * 原型模式示例1 孙悟空复制(生成相同的对象)
 * 通过显示悟空的图像   并复制多个图像  来表示原型模式的应用
 */
public class ProtoTypeWukong {
    public static void main(String[] args) {
        JFrame jf = new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        SunWukong obj1 = new SunWukong();
        contentPane.add(obj1);
        SunWukong obj2 = (SunWukong)obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class SunWukong extends JPanel implements Cloneable{
    public SunWukong(){
        String filepath = System.getProperty("user.dir") + File.separator + "src"+File.separator+"main"+File.separator+"resources" + File.separator;
        System.out.println(filepath + "Wukong.jpg");
        JLabel ll = new JLabel(new ImageIcon(filepath + "Wukong.jpg"));
        this.add(ll);
    }
    public Object clone(){
        SunWukong w = null;
        try{
            w = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败！");
        }
        return w;
    }
}