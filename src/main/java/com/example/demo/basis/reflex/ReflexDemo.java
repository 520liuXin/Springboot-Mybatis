package com.example.demo.basis.reflex;

/*
 * @Author liuxin
 * @Description //TODO
 **/

//测试Class的创建方法
public class ReflexDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        People people=new Student();

        //方式1 通过对象获取
        Class c1=people.getClass();
        System.out.println(c1);

        System.out.println(c1.hashCode());

        //方式2 forname获取
        Class c2=Class.forName("com.example.demo.basis.reflex.Student");
        System.out.println(c2.hashCode());

        //方式3 通过类名.class获取
        Class c3=Student.class;
        System.out.println(c3.hashCode());

        //方式四 ：基本类型的包装类都有Type属性
        Class c4=Integer.TYPE;
        System.out.println(c4.hashCode());

        //获取父类类型
        Class c5=c1.getSuperclass();
        System.out.println(c5.hashCode());
        
    }


}


class People {
    public   String name;
}

class Teacher extends People{
    public Teacher(){
        this.name="老师";
    }


}

class Student extends People{
    public Student(){
        this.name="学生";
    }
}