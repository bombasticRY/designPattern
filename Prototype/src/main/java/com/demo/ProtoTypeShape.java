package com.demo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ProtoTypeShape
 *
 * @author liruoyu
 * @date 2019/9/7
 * 原型模式扩展
 * 带有原型管理器的原型模式
 * 示例为：
 * 用带原型管理器的原型模式来生成包含 圆形 和 正方形 等图形的原型，并计算他们的面积
 * 由于图形类不同，生成面积的方法也不同。用原型管理器来管理他们
 */
public class ProtoTypeShape {
    public static void main(String[] args) {
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape obj1 = (Circle)pm.getShape("Circle");
        obj1.countArea();
        Shape obj2 = (Square)pm.getShape("Square");
        obj2.countArea();
    }
}

interface Shape extends Cloneable{
    public Object clone();
    public void countArea();
}

class Circle implements Shape{

    public Object clone() {
        Circle c = null;
        try{
            c = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆形失败！");
        }
        return c;
    }

    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("圆的面积为：" + 3.1415 * r * r + "\n");
    }
}

class Square implements Shape{

    public Object clone() {
        Square s = null;
        try {
            s = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void countArea() {
        int a = 0;
        System.out.println("请输入正方形的边长：");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("正方形的面积为：" + a * a + "\n");
    }
}

class ProtoTypeManager{
    private HashMap<String, Shape> ht = new HashMap<String, Shape>();
    public ProtoTypeManager(){
        ht.put("Circle", new Circle());
        ht.put("Square", new Square());
    }
    public void addshape(String key, Shape obj){
        ht.put(key, obj);
    }
    public Shape getShape(String key){
        Shape temp = ht.get(key);
        return (Shape)temp.clone();
    }

}