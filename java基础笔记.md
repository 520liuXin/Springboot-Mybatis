**数组知识点:**

声明的时候是在栈里面   int[] array;

创建数组的时候是在堆里面    array= new int[10];

数组的的四个基本特点：

1.数组的长度是确定的，数组一旦被创建，他的大小是不可以改变的，如果越界，则报：ArrayIndexOutofBounds数组越界错误

2.数组中的元素必须是相同类型的，不允许出现混合类型

3.数组中的元素可以是任何数据类型，包括基本类型和引用类型

4.数组变量属引用类型，数组可以看做成对象，数组中的每个元素相当于该对象的成员变量，

数组本身就是对象，java中的对象就是在堆中的，（new出来的都在堆中），因此数组无论保存原始类型还是其他对象类型，数组的本身是在堆中的

**构造器**

1.和类名相同

2.没有返回值

作用：

1.new的本质是在调用构造方法

2.初始化对象的值

注意点：定义有参构造之后，如果要是用无参构造，显示的定义无参构造

alt+insert 快捷键

**super注意点：**

1.super 调用父类的构造方法，必须在构造方法的第一个

2.super必须只能出现在子类方法或者构造方法中

3.super和this不能同时调用构造方法

**VS**

**this**

代表的对象不同

   	this：本身调用者这个对象

​		super：代表父类对象的应用

前提

​		this：没有继承关系也可以使用

​		super：只能在继承的条件下才能使用

构造方法：

​		this（）：本类的构造

​		super（）：父类的构造

**重写**

需要有继承关系，子类重写父类方法，子类的方法和父类的必须要一致，方法体不同

1.方法名必须相同

2.参数列表必须相同

3.修饰符：范围可以扩大但不能缩小  public>Portected<Default>private

4.抛出的异常:范围，可以被缩小，但是不能扩大

为什么要重写： 父类的功能，子类不一定需要，或者不一定满足

**多态：**

 多态性是对象多种表现形式的体现。 既同一个方法可以根据发送对象的不同而采用多种不同的行为方式

###  多态的优点 

- 1. 消除类型之间的耦合关系
- 2. 可替换性
- 3. 可扩充性
- 4. 接口性
- 5. 灵活性
- 6. 简化性

### 多态存在的三个必要条件

- 继承

- 重写

- 父类引用指向子类对象：Parent p = new Child();

  注意：多态是方法的多态，属性没有多态

**抽象类的思考;**

抽象类存在构造器吗？答案： 虽然抽象类不能被实例化，但可以有构造函数。由于抽象类的构造函数在实例化派生类之前发生，所以，可以在这个阶段初始化抽象类字段或执行其它与子类相关的代码。 

**抽象类存在的意义：**

java中抽象类更利于代码的维护和重用。
抽象类往往用来表征对问题领域进行分析、设计中得出的抽象概念，是对一系列看上去不同，但是本质上相同的具体概念的抽象。具体分析如下：
1.因为抽象类不能实例化对象，所以必须要有子类来实现它之后才能使用。这样就可以把一些具有相同属性和方法的组件进行抽象，这样更有利于代码和程序的维护。
比如本科和研究生可以抽象成学生，他们有相同的属性和方法。这样当你对其中某个类进行修改时会受到父类的限制，这样就会提醒开发人员有些东西不能进行随意修改，这样可以对比较重要的东西进行统一的限制，也算是一种保护，对维护会有很大的帮助。
2.当又有一个具有相似的组件产生时，只需要实现该抽象类就可以获得该抽象类的那些属性和方法。
比如学校又新产生了专科生这类学生，那么专科生直接继承学生，然后对自己特有的属性和方法进行补充即可。这样对于代码的重用也是很好的体现。
所以，Java中抽象类对于代码的维护和重用有很好的帮助，也是Java面向对象的一个重要体现。



# **线程**

线程开启

**1.start（）和run方法的区别**

调用start方法可以启动一个线程，而run方法只是thread类中的一个普通方法调用，还是从主线程里面执行的。

###### **2.线程的实现方式**

**a.继承Thread类** 

- 子类继承Thread类 具备多线程能力，重新run方法

- 启动线程：子类对象.start()

- 不建议使用：避免OOP单继承的局限性
  $$
  package com.example.demo.basis.thread;/* * @Author liuxin * @Description //TODO 线程的创建 继承Thread实现多线程 线程不是立即执行，由CPU调度安排 **///1.start（）和run方法的区别//调用start方法可以启动一个线程，而run方法只是thread类中的一个普通方法调用，还是从主线程里面执行的。public class ThreadDemo1 extends Thread {    @Override    public void run() {        for(int i=0;i<1000;i++){            System.out.println("liuxin在学习敲代码"+i);        }       System.out.println();    }     public static void main(String[] args) throws InterruptedException {        ThreadDemo1 threadDemo1=new ThreadDemo1();       // threadDemo1.run();         //threadDemo1.start();        for(int i=0;i<2000;i++){            System.out.println("wozai敲代码"+i);            sleep(1);        }    }}
  $$

  ```java
  package com.example.demo.basis.thread;
  /* * @Author liuxin * @Description //TODO 线程的创建 继承Thread实现多线程 线程不是立即执行，由CPU调度安排 **
  //1.start（）和run方法的区别//调用start方法可以启动一个线程，而run方法只是thread类中的一个普通方法调用，还是从主线程里面执行的。
  public class ThreadDemo1 extends Thread {  
  @Override    public void run() {       
      for(int i=0;i<1000;i++){          
          System.out.println("liuxin在学习敲代码"+i);        }      
      System.out.println();  
  }    
  
  public static void main(String[] args) throws InterruptedException {        ThreadDemo1 threadDemo1=new ThreadDemo1();     
                                                                      //    		threadDemo1.run();                                                                      //threadDemo1.start();    
   for(int i=0;i<2000;i++){         
       System.out.println("wozai敲代码"+i);         
       sleep(1);       
   }   
       }
  }
  ```

**b.实现Runnable接口具备多线程能力**

推荐使用：避免了单继承局限性，灵活方便，方便同一个对象被多个线程使用

启动线程:传入目标对象+Thread对象.start()

```java
public class ThreadDemo2  implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<200;i++){
            System.out.println("我在敲代码"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2=new ThreadDemo2();
        Thread thread= new Thread(threadDemo2);
        thread.start();
        System.out.println(thread.getName());

    }
}

```

c.实现Callable接口（了解）

1. 实现Callable接口需要返回值类型

2. 重新call方法需要抛出异常

3. 创建目标对象

4. ```
           //执行服务
           ExecutorService ser= Executors.newFixedThreadPool(1);
           //提交执行
           Future<Boolean> res=ser.submit(threadDemo2);
           //获取结果
           boolean res1=res.get();
           //关闭服务
           ser.shutdownNow();
   ```

代码案例：

```java
package com.example.demo.basis.thread;

import org.apache.catalina.Executor;

import java.util.concurrent.*;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo2Callable implements Callable<Boolean> {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo2Callable threadDemo2 = new ThreadDemo2Callable();

        //执行服务
        ExecutorService ser= Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> res=ser.submit(threadDemo2);
        //获取结果
        boolean res1=res.get();
        //关闭服务
        ser.shutdownNow();

    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在敲代码" + i);
        }
        return true;
    }
}

```

###### 静态代理

线程底部的实现原理是静态代理

```java
package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO 静态代理详解
 **/
/**
   静态代理总结：
 真实对象和代理对象都要实现同一个接口
 代理对象需要代理真实角色
 好处：代理对象可以做很多真实对象做不了的事情
 真实对象可以专注于做自己的事情
 案例：
    你：真实角色
   婚庆公司：代理你，帮你处理结婚的事情
    结婚（接口）：实现结婚的接口即可
 **/

public class StaticProxy {

    public static void main(String[] args) {

        new Wedding(new You()).HaapyMarry();
        new Thread(()->System.out.println("我在")).start();
    }

   //接口
    interface Marry{

        void HaapyMarry();
    }
    //真实角色
    static class  You implements Marry{

        @Override
        public void HaapyMarry() {
            System.out.println("我准备结婚了");
        }
    }

    //代理角色
    static class Wedding implements Marry{
        private Marry target;

        public Wedding(Marry target) {
            this.target = target;
        }

        @Override
        public void HaapyMarry() {
            before();
            target.HaapyMarry();
            after();
        }

        private void before() {
            System.out.println("结婚前准备");
        }

        private void after() {
            System.out.println("结婚后付款");
        }
    }

}

```

##### lambad表达式

代码详情：

展示了实现类，静态内部类，局部内部类，匿名内部类，lambda表达式

```java
package com.example.demo.basis.lambad;

/*
 * @Author liuxin
 * @Description //TODO lambad表达式的实现
 **/
public class LambadDome1 {


    //3静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambatTest(String name) {
            System.out.println(name + "喜欢lomba表达式-->3");
        }
    }
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambatTest("刘信");


        ILike like1=new Like1();
        like1.lambatTest("刘信");


        //4局部内部类
        class Like2 implements ILike {
            @Override
            public void lambatTest(String name) {
                System.out.println(name + "喜欢lomba表达式-->4");
            }
        }
        ILike like2=new Like2();
        like2.lambatTest("刘信");


        //5 匿名内部类
        ILike like3=new ILike(){

            @Override
            public void lambatTest(String name) {
                System.out.println(name + "喜欢lomba表达式-->5");
            }
        };
        like3.lambatTest("刘信");

        //lambda表达式
        ILike like4=(String name)->System.out.println(name + "喜欢lomba表达式-->6");
        like4.lambatTest("刘信");
    }


}
//接口
interface ILike{

    void lambatTest(String name);
}

//实现类
 class Like implements ILike{
    @Override
    public void lambatTest(String name) {
        System.out.println(name+"喜欢lomba表达式-->1");
    }


}
```

###### **线程的状态：**

![image-20210228153232935](C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210228153232935.png)



![image-20210228153341698](C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210228153341698.png)

线程的停止;

推荐线程自己停止下来，使用一个标志位进行终止变量，当falg=false时，线程停止

<img src="C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210228154804257.png" alt="image-20210228154804257" style="zoom: 80%;" />

###### 守护（daemon）线程

- 线程分为用户线程和守护线程
- 虚拟机必须要要确保用户线程执行完毕
- 虚拟机不用等待守护线程执行完毕
- 如：后台记录操作日子，监控内存，垃圾回收等待



JVM内存区：

程序计数器，虚拟机栈，本地方法栈，堆，方法区（包括常量池）

不属于JVM内存区：

直接内存（Direct Memory），用户I/O操作



#### 同步方法和同步代码块

区别：
同步方法默认用this或者当前类class对象作为锁；
同步代码块可以选择以什么来加锁，比同步方法要更细颗粒度，我们可以选择只同步会发生同步问题的部分代码而不是整个方法；
同步方法使用关键字 synchronized修饰方法，而同步代码块主要是修饰需要进行同步的代码，用 synchronized（object）{代码内容}进行修饰；

为何使用同步？
java允许多线程并发控制，当多个线程同时操作一个可共享的资源变量时（增删改查），将会导致数据的不准确，相互之间产生冲突。类似于在atm取钱，银行数据确没有变，这是不行的，要存在于一个事务中。因此加入了同步锁，以避免在该线程没有结束前，调用其他线程。从而保证了变量的唯一性，准确性。
1.同步方法：
即有synchronized (同步，美 ['sɪŋkrənaɪzd] ) 修饰符修饰的方法。
由于java的每个对象都有一个内置锁，当用此关键字修饰方法时，内置锁会保护整个方法。在调用给方法前，要获取内置锁，否则处于阻塞状态。
例：public synchronized getMoney(){}
注：synchronized修饰静态方法，如果调用该静态方法，将锁住整个类。

2.同步代码块
即有synchronized修饰符修饰的语句块，被该关键词修饰的语句块，将加上内置锁。实现同步。
例：synchronized(Object o ){}

同步是高开销的操作，因此尽量减少同步的内容。通常没有必要同步整个方法，同步部分代码块即可。
同步方法默认用this或者当前类class对象作为锁。
同步代码块可以选择以什么来加锁，比同步方法要更颗粒化，我们可以选择只同步会发生问题的部分代码而不是整个方法。

同步方法块代码：

```java
package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized实现同步方法，锁的是this
 **/
public class ThreadDemo3 implements Runnable {

    private int ticket =100;
    boolean falg=true;
    @Override
    public void run() {
        while (falg){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //使用synchronized实现同步方法，锁的是this
    private synchronized   void  buy() throws InterruptedException {
        if (ticket<=0){
            falg=false;
            return;
        }
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticket+"张票");
        ticket--;
    }

    public static void main(String[] args) {
        ThreadDemo3 threadDemo3=new ThreadDemo3();
        new Thread(threadDemo3,"刘信1").start();
        new Thread(threadDemo3,"刘信2").start();
        new Thread(threadDemo3,"刘信3").start();
        new Thread(threadDemo3,"刘信5").start();
        new Thread(threadDemo3,"刘信6").start();
        new Thread(threadDemo3,"刘信7").start();
    }
}

```

同步代码块：

demo1：

```java
package com.example.demo.basis.thread;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadDemo3Syn {


    public static void main(String[] args) {
        Acount acount=new Acount("结婚基金",1000);
        Withdrawal withdrawal=new Withdrawal(acount,500,"刘信");
        Withdrawal withdrawal1=new Withdrawal(acount,1000,"思思");
        withdrawal.start();
        withdrawal1.start();

    }





    static class Acount{
        private String name;
        private int money;

        public Acount(String name,  int money) {
            this.name = name;
            this.money = money;
        }
    }

    //模拟银行进行取款
    static class  Withdrawal extends Thread{
        Acount acount;
        //取了多少钱
        int drawingMoney;
        //现在还剩多少钱
        int nowMoney;

        public Withdrawal(Acount acount, int drawingMoney,String name) {
            super(name);
            this.acount = acount;
            this.drawingMoney = drawingMoney;
        }

        @Override
        public void run() {

            synchronized (acount){
            //判断有没有钱<
            if(acount.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，无法取");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            acount.money-=drawingMoney;
            nowMoney+=drawingMoney;
            System.out.println(acount.name+"余额为"+acount.money);
            //Thread.currentThread().getName()=this.getName() 以为继承了Thread
            System.out.println(this.getName()+"手里的钱为："+nowMoney);
            }
        }
    }
}


```



demo2：

ArrayList是不安全的 ，ArrayList 可以通过synchronized同步代码块实现安全

JUC安全类型集合 CopyOnWriteArrayList是安全的

```
package com.example.demo.basis.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class ThreadList {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        CopyOnWriteArrayList<String> list1=new CopyOnWriteArrayList<String>();

        
        for(int i=0;i<10000;i++){

                new Thread(()->{
                    synchronized (list){
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());



        for(int i=0;i<10000;i++){

            new Thread(()->{
                    list1.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list1.size());
    }
}

```

#### 死锁

多线程互相抱着对方所需要的资源，互相僵持

![image-20210228191118160](C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210228191118160.png)



预防死锁：

- 资源一次性分配：一次性分配所有资源，这样就不会再有请求了：（破坏请求条件）
- 只要有一个资源得不到分配，也不给这个进程分配其他的资源：（破坏请保持条件）
- 可剥夺资源：即当某进程获得了部分资源，但得不到其它资源，则释放已占有的资源（破坏不可剥夺条件）
- 资源有序分配法：系统给每类资源赋予一个编号，每一个进程按编号递增的顺序请求资源，释放则相反（破坏环路等待条件）































































