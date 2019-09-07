package com.alp;

/**
 * PrototypeTest
 *
 * @author liruoyu
 * @date 2019/9/7
 * 克隆测试类
 * 浅克隆
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype)obj1.clone();
        System.out.println("obj1 == obj2 ? " + (obj1 == obj2));
    }
}

class Realizetype implements Cloneable{
    Realizetype(){
        System.out.println("具体原型类创建成功！");
    }
    public Object clone() throws CloneNotSupportedException{
        System.out.println("具体原型类复制成功！");
        return (Realizetype)super.clone();
    }
}