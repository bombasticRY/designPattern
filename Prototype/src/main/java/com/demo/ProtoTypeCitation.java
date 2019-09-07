package com.demo;

/**
 * ProtoTypeCitation
 *
 * @author liruoyu
 * @date 2019/9/7
 * 原型模式生成相似的对象
 * 生成三好学生奖状。姓名不同，其他属性相同
 */
public class ProtoTypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException{
        Citation obj1 = new Citation("张三", "同学：在2019年第一学期期末考试表现优异，被评为三好学生。" , "韶关学院");
        obj1.display();
        Citation obj2 = (Citation)obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}
class Citation implements Cloneable{
    String name;
    String info;
    String college;
    Citation(String name, String info, String college){
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void display(){
        System.out.println(name + info + college);
    }

    public Object clone() throws CloneNotSupportedException{
        System.out.println("奖状拷贝成功！");
        return (Citation)super.clone();
    }

}