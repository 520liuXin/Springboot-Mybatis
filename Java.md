# 一. Java 基础模块

## 1.JDK 和 JRE 有什么区别？

JDK：Java 开发工具包，提供了 Java 的开发环境和运行环境。

JRE：Java 运行环境，为 Java 的运行提供了所需环境。

具体来说 JDK 其实包含了 JRE，同时还包含了编译 Java 源码的编译器 Javac，还包含了很多 Java 程序调试和分析的工具。如果需要运行 Java 程序，只需安装 JRE 就可以了，如果你需要编写 Java 程序，需要安装 JDK。

## 2.== 和 equals 的区别是什么？

== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；

equals 默认情况下是引用比较，只是很多类重新了 equals 方法，比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等。

## 3.两个对象的 hashCode() 相同，则 equals() 也一定为 true，对吗？

不对，两个对象的 hashCode() 相同，equals() 不一定 true。

因为在散列表中，hashCode() 相等即两个键值对的哈希值相等，hashCode() 在散列表中才有用，在其它情况下没用。

## 4.final 在 Java 中有什么作用？

final 修饰的类叫最终类，该类不能被继承。

final 修饰的方法不能被重写。

final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。

## 5.Java 中的 Math. round(-1. 5) 等于多少？

等于 -1。round()是四舍五入，注意负数5是舍的，例如：Math.round(1.5)值是2，Math.round(-1.5)值是-1。

## 6.String 属于基础的数据类型吗？

String 不属于基础类型，String 属于对象。

基础类型有 8 种：

byte（1字节8bit）

short（2字节16bit）

int（4字节32bit）

long（8字节64bit）

float（4字节32bit）

double（8字节64bit）

char（2字节16bit）

boolean（JVM中没有专用的字节码指令，编译后使用Int值来表示）

## 7.Java 中操作字符串都有哪些类？String、StringBuffer、StringBuilder，它们之间有什么区别？

操作字符串的类有：String、StringBuffer、StringBuilder。

三者区别：

StringBuffer和StringBuilder都继承自抽象类AbstractStringBuilder。

String 声明的是不可变的对象，每次操作都会生成新的 String 对象，然后将指针指向新的 String 对象，而 StringBuffer、StringBuilder 存储数据的字符数组没有被final修饰，说明值可以改变，抽象类AbstractStringBuilder内部都提供了一个自动扩容机制，当发现长度不够的时候(初始默认长度是16)，会自动进行扩容工作，扩展为原数组长度的2倍加2，创建一个新的数组，并将数组的数据复制到新数组，所以对于拼接字符串效率要比String要高。

StringBuffer由于很多方法都被 synchronized 修饰了所以线程安全，所以效率低。StringBuilder相反执行效率高，但是线程不安全。

执行速度:StringBuilder > StringBuffer > String。

## 8.String str="i"与 String str=new String(“i”)一样吗？

不一样，因为内存的分配方式不一样。

String str=“i"的方式，Java 虚拟机会将其分配到常量池（1.8在堆中）中，如果常量池中有"i”，就返回"i"的地址，如果没有就创建"i"，然后返回"i"的地址；

String str=new String(“i”) 则会被分到堆内存中新开辟一块空间。

## 9. short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗?？

1有错，因为s1+1，1是int类型，会强制转换为int，在给short赋值时会报错；

2不会错，s1+=1其中是java底层指令封装的，其中隐含了强制转换为short。

 

## 10.是否可以从静态方法内部发出非静态方法的调用？

不能，静态方法只能访问静态成员，非静态方法都要先创建对象。牵涉到类加载机制，准备和初始化的流程是在实例化对象就进行加载的，所以可能获取不到被实例化的对象；

## 11.抽象类必须要有抽象方法吗？

不需要，抽象类不一定非要有抽象方法；但是包含一个抽象方法的类一定是抽象类。

## 12.普通类和抽象类有哪些区别？

普通类不能包含抽象方法，抽象类可以包含抽象方法。

抽象类是不能被实例化的，就是不能用new调出构造方法创建对象，普通类可以直接实例化。

如果一个类继承于抽象类，则该子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为abstract类。

## 13.抽象类能使用 final 修饰吗？

不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承：

## 14.接口和抽象类有什么区别？

实现：抽象类的子类使用 extends 来继承；接口必须使用 implements 来实现接口。

构造函数：抽象类可以有构造函数；接口不能有。

实现数量：类可以实现很多个接口；但只能继承一个抽象类。

访问修饰符：接口中的方法默认使用 public 修饰；抽象类中的抽象方法可以使用Public和Protected修饰，不能用Private修饰。

## 15.Java 中 IO 流分为几种？

按功能来分：输入流（input）、输出流（output）。

按类型来分：字节流和字符流。

字节流和字符流的区别是：字节流按 8 位传输以字节为单位输入输出数据，字符流按 16 位传输以字符为单位输入输出数据。

## 16.BIO、NIO、AIO 有什么区别？

BIO：Block IO 同步阻塞式 IO，就是我们平常使用的传统 IO，它的特点是模式简单使用方便，并发处理能力低。

NIO：New IO 同步非阻塞 IO，是传统 IO 的升级，客户端和服务器端通过 Channel（通道）通讯，实现了多路复用。

AIO：Asynchronous IO 是 NIO 的升级，也叫 NIO2，实现了异步非堵塞 IO ，异步 IO 的操作基于事件和回调机制。

## 17.有哪些IO模型？

**阻塞****IO****模型**

最传统的IO模型，即在读写过程中会发生阻塞的现象。

**非阻塞****IO****模型**

不会一直阻塞，进行IO请求时，如果没有准备好就会返回一个error的结果。

有一个严重的缺点，不需要停的循环去询问是否就绪，会让CPU占用率很高。

**多路复用****IO****模型**

比较常用的模型（Redis），Java的NIO实际上是就使用了多路复用。

会有一个线程不断轮询多个socket状态，只有一个线程就可以管理多个socket，并且只有socket有真正多些事件进行时，才会使用IO资源，减少资源占用。

多路复用IO比非阻塞IO模型效率高的原因是，非阻塞IO是用户线程轮询，而多路复用是内核进行轮询的。

但是当一个事件响应体很大，就会导致后续事件得不到处理，影响新的事件轮询，Redis不会受到这种影响的原因是Redis的数据模型和数据操作都非常简单

**信号驱动****IO****模型**

在用户线程发起IO请求时，会给对应的socket注册一个信号函数，然后用户线程会继续进行，当内核数据就绪时会发送一个信号给用户线程，接收到后便在信号函数中进行实际的IO操作；

**异步****IO****模型**

最理想的IO模型，用户线程发起read操作后，就可以立刻去做其他事；

内核接到请求会立即返回，等待内核数据准备完成后，将数据copy到用户线程并通知用户线程，用户线程不需要关心IO操作如何进行，只要先发起一个请求，当收到成功信号时IO已经完成，可以直接使用IO中数据。

需要系统底层支持，Java7中提供了Asynchronous IO

**NIO**

IO是面向流的，NIO是面向缓冲区的，由channel、buffer和selectror组成

Channel，通道，和流差不多，但是流是单向的(输入流、输出流)，而channel是双向的，可读可写；

Buffer，缓冲区，实际上是一个容器，一个连续数组。channel从文件、网络中读取到的数据都必须经由buffer；

Selector，是NIO的核心类，selector可以检测多个channel上是否有事件发生，如果有事件就获取事件然后针对事件进行响应处理。一个线程可以管理多个通道，不用维护多个线程，避免多线程之间上下文切换导致的开销（这里和多路复用很像）；

## 18.Java泛型的作用以及使用场景？

参数化类型，所操作的数据类型被指定为一个参数

作用：

适用于多种数据类型执行相同的代码（代码复用）

泛型中的类型在使用时指定，不需要强制类型转换（类型安全，编译器会检查类型，以防ClassCastException）

场景：

比如写一个方法需要对数组进行排序，但是数组内容可能是Int,double,String

这时候就需要泛型，不指定输入数组和返回数组的类型，可以代码复用；

比如指定方法只允许传入内容为Number类型的list，那么使用泛型指定传入

public static void getUperNumber(List<? extends Number> data)

这样当传入的List为非Number类型时就会编译报错，以防强转异常

## 19.怎么判断数组里是否有重复数据，并且剔除重复数据？

1.开双重循环去逐个判断，复杂度高；

2.利用HashSet不允许重复特性，插入进HashSet中，长度小于原来的话就有重复的，并完成了剔除重复数据操作；

3.使用JAVA8中的流的特性，将数组转为List再转换为流，查询去重总数list.stream().distinct().count()，和原数据比较大小，同样剔除也可以使用流的.filter

## 20.Java8的新特性，简要谈谈新特性？

### Java8 Steam:

Java 8添加了新的抽象称为流Stream，可以以声明的方式处理数据。使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。

创建流：需要一个数据源，比如list或者set，.stream() 串行流/.parallelStream()并行流

Filter：过滤，中间操作，只保留符合条件的元素

Distinct：去重，中间操作

Sort：排序，中间操作，返回的是一个排序好的的Stream，注意不影响原本数据源

Map：映射，中间操作，依次将元素转换为另外的对象，比如讲字符串转为大写

Match：匹配，最终操作，返回Boolean，有anyMatch、allMatch、noneMatch表达式

Count：计数，最终操作，可以用于过滤后或者匹配后的计数

forEach：迭代流中的每个数据

并行流，获取到并行流进行排序，效率会很多

例：

查找一个集合中所有长度大于60的曲目的名称根据排序放在另一个列表中

public Set<String> findLongTracks(List<Album> albums) {

  return albums.stream()                    //获取到流

   .filter(track -> track.getLength()>60)    //过滤只留下长度大于60的

.sorted(Comparator.comparing(length::getLength)) //根据长度排序

   .map(track -> track.getName())      //获取到曲目名称重新放在数组里

   .forEach(name -> trackNames.add(name))  //遍历数据将对象放入到新列表中

   .collect(toSet());            //转为一个Set返回

 }

### Optional

Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型

例：

public String getGender(Student student){

​    if(null == student)

​    {

​      return "Unkown";

​    }

​    return student.getGender();   

}

直接转换为：

public String getGender(Student student){

​    return Optional.ofNullable(student).map(u -> u.getGender()).orElse("Unkown");

}

##  21.Java11的新特性，简要谈谈新特性？

Java11是Java8之后的下一个稳定版本，内存结构中开始弱化"代"的概念，包含9.10.11的新特性如下

1.本地变量类型推断
    使用var关键字，可以自动识别属于哪种类型，但是强行赋值还是会报错，比如将string赋值给int。

2.字符串加强
    增加了一系列的字符串功能，比如判断是否为空白isBlank(),字符串复制repeat(3),行数统计.lines().count()

3.集合加强
    从jdk9开始为List/Set/Map都添加了 of 和 copyOf 方法，用于创建不可变集合
    不可变集合用于枚举常量集合，添加、删除、替换、排序等操作都会报错

4.Stram增强
    新增takeWhile 和 dropWhile 方法
    Stream.of(1,2,3,2,1).takeWhile(n->n<3)结果(1,2) 从流中获取元素，直到不满足条件为止结束获取
    Stream.of(1,2,3,2,1).dropWhile(n->n<3)结果(3,2,1) 从流中删除元素，直到不满足条件结束删除

5.Optional 加强
    可以将 Optional 转换成一个 Stream, 或者当一个空 Optional 时给它一个替代的。
    Optional.ofNullable(null).or(() -> Optional.of("javastack")).get(); // javastack

6.InputStream 加强
    新增了非常有用的方法transferTo，数据流可直接传输到 OutputStream
    inputStream.transferTo(outputStream);

7.HTTP Client API
    JDK9就已经存在，在JDK11时正式可用，在java.net包中
    支持同步send()和异步sendAsync()，.GET().POST()指定请求类型

8.命令行优化，之前必须要先编译再执行，现在可以直接执行 java test1.java，不用先操作javac编译了

9.从JDK9开始默认的G1垃圾回收器，横跨新老年代，基于标记-整理算法不产生内存碎片，精确控制停顿时间(可配置)，将内存分为几个独立区域跟踪这些区域的回收进度，维护优先级列表，优先回收垃圾最多的区域，这样确保回收效率，G1回收器逻辑上不需要新老年代了，由G1回收器自动调优新老年代比例；

10.从11新的垃圾回收器ZGC，据说效率很高，物理和逻辑上都不再有新老分区，整个内存做分页处理，对page做压缩，没有碎片化的问题，回收时间和G1一样变的可控，只能在64位的linux上使用，暂时不太流行

 

# 二. Java 容器模块

## 1.Java 容器都有哪些？

![image-20210314222438523](C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210314222438523.png)

Java 容器分为 Collection 和 Map 两大类，其下又有很多子类，比如：

ArrayList

LinkedList

Vector

HashMap

LinkedHashMap

ConcurrentHashMap

Hashtable

## 2.Collection 和 Collections 有什么区别？

Collection 是一个集合接口，它提供了对集合对象进行基本操作的通用接口方法，所有集合都是它的子类，比如 List、Set 等。

Collections 是一个包装类，包含了很多静态方法，不能被实例化，就像一个工具类，比如提供的排序方法： Collections. sort(list)。

## 3.List、Set、Map 之间的区别是什么？

  ![https://img-blog.csdnimg.cn/2019050112132492.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21laXNtNQ==,size_16,color_FFFFFF,t_70](https://img-blog.csdnimg.cn/2019050112132492.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21laXNtNQ==,size_16,color_FFFFFF,t_70) 

**List接口和Set接口属于Collection接口，Map接口和Collection接口并列存在（同级）。** 

List：有序集合（有序，可以存在重复元素）

Set：不重复集合（无序，不允许存在重复的元素），LinkedHashSet按照插入排序，SortedSet可排序，HashSet无序

Map：键值对集合

List、Set、Map 的区别主要体现在两个方面：元素是否有序、是否允许元素重复。

## 4. HashMap 和 Hashtable 有什么区别？

HashMap是继承自AbstractMap类，而HashTable是继承自Dictionary类。不过它们都实现了同时实现了map、Cloneable（可复制）、Serializable（可序列化）这三个接口。

HashMap 最多只允许一条记录的键为 null，允许多条记录的值为 null。

 HashTable中不允许有null键和null值 

线程安全性不同：HashMap是非线程安全的，而Hashtable的方法几乎都是被synchronized关键字修饰的。但是可以使用线程安全的ConcurrentHashMap。**ConcurrentHashMap**虽然也是线程安全的，但是它的效率比Hashtable要高好多倍。因为ConcurrentHashMap使用了分段锁，并不对整个数据进行锁定。

Java8 对 HashMap 进行了一些修改，最大的不同就是利用了红黑树，所以其由 数组+链表+红黑树 组成。超过8位就使用红黑树，默认大小是16位，默认因子是0.75

 

## 5.如何决定使用 HashMap 还是 TreeMap？

对于在 Map 中插入、删除、定位一个元素这类操作，HashMap 是最好的选择，因为相对而言 HashMap 的插入会更快，但如果你要对一个 key 集合进行有序的遍历，那 TreeMap 是更好的选择。

## 6.说一下 HashMap 的实现原理？

在1.8之前是使用数组+链表实现的，数组是主体，链表为了解决hash冲突存在的；

在1.8之后在链表的长度大于阈值(默认8)之后，链表转为红黑树，减少搜索时间；

基于Hash算法实现，根据算法计算出传入key的hash值，使用hash值来确认下标，将value保存进去，查找时通过计算key的hash值通过下标1次就查找到value，效率很高；

计算hashcode相同时，称为哈希冲突，hashmap通过链表和红黑树解决；

一般默认长度是16，默认扩容的比例是1倍，在内部元素到达长度的0.75时进行扩容；

## 7.说一下 HashSet 的实现原理？

HashSet 是基于 HashMap 实现的，HashSet 底层使用 HashMap 来保存所有元素，因此 HashSet 的实现比较简单，相关 HashSet 的操作，基本上都是直接调用底层 HashMap 的相关方法来完成，HashSet 不允许重复的值。

## 8.ArrayList 和 LinkedList 的区别是什么？

数据结构实现：ArrayList 是动态数组的数据结构实现，而 LinkedList 是双向链表的数据结构实现。

随机访问效率：ArrayList 比 LinkedList 在随机访问的时候效率要高，因为 LinkedList 是线性的数据存储方式，所以需要移动指针从前往后依次查找。

增加和删除效率：在非首尾的增加和删除操作，LinkedList 要比 ArrayList 效率要高，因为 ArrayList 增删操作要影响数组内的其他数据的下标。

综合来说，在需要频繁读取集合中的元素时，更推荐使用 ArrayList，而在插入和删除操作较多时，更推荐使用 LinkedList，一般在数据量较小的集合中，如果没有特别内存需求和特别业务需求，都是使用的ArrayList。

## 9.如何实现数组和 List 之间的转换？

数组转 List：使用 Arrays. asList(array) 进行转换。

List 转数组：使用 List 自带的 toArray() 方法。

 

## 10.ArrayList 和 Vector 的区别是什么？

线程安全：Vector 使用了 Synchronized 来实现线程同步，是线程安全的，而 ArrayList 是非线程安全的。

性能：ArrayList 在性能方面要优于 Vector。

扩容：ArrayList 和 Vector 都会根据实际的需要动态的调整容量，只不过在 Vector 扩容每次会增加 1 倍，而 ArrayList 只会增加 50%。

线程安全得list集合推荐使用CopyOnWriteArrayList；使用lock进行线程安全

## 11.Array 和 ArrayList 有何区别？

Array 可以存储基本数据类型和对象，ArrayList 只能存储对象。

Array 是指定固定大小的，而 ArrayList 大小是自动扩展的。

Array 内置方法没有 ArrayList 多，比如 addAll、removeAll、iteration 等方法只有 ArrayList 有。

## 12.在 Queue 中 poll()和 remove()有什么区别？

相同点：都是返回第一个元素，并在队列中删除返回的对象。

不同点：如果没有元素 remove()会直接抛出NoSuchElementException 异常，而 poll()会返回 null。

 ![image-20210322110131475](C:\Users\刘先生\AppData\Roaming\Typora\typora-user-images\image-20210322110131475.png)

## 13.哪些集合类是线程安全的？

Vector、Hashtable、Stack 都是线程安全的，而像 HashMap 则是非线程安全的，不过在1.5 也有了对应的线程安全类，比如 HashMap 对应的线程安全类就是 ConcurrentHashMap。

## 14.迭代器 Iterator 是什么？

Iterator 接口提供遍历任何 Collection 的接口。我们可以从一个 Collection 中使用迭代器方法来获取迭代器实例。迭代器取代了 Java 集合框架中的 Enumeration，迭代器允许调用者在迭代过程中移除元素。

## 15.Iterator 怎么使用？有什么特点？

Iterator 的特点是更加安全，因为它可以确保，在当前遍历的集合元素被更改的时候，就会抛出 ConcurrentModificationException 异常。

## 16.Iterator 和 ListIterator 有什么区别？

Iterator 可以遍历 Set 和 List 集合，而 ListIterator 只能遍历 List。

Iterator 只能单向遍历，而 ListIterator 可以双向遍历（向前/后遍历）。

ListIterator 从 Iterator 接口继承，然后添加了一些额外的功能，比如添加一个元素、替换一个元素、获取前面或后面元素的索引位置。

## 17.怎么确保一个集合不能被修改？

可以使用 Collections. unmodifiableCollection(Collection c) 方法来创建一个只读集合，这样改变集合的任何操作都会抛出 Java. lang. UnsupportedOperationException 异常。

## 18.为什么HashMap的长度要是2的次幂？

Hashmap的下标计算，先计算hashcode值，再将h右移16位，再与原来的h进行异或处理，得到一个散列值x，这个值不能直接使用，还需要对数组的长度-1取模运算，即x&(n-1)，

如果长度n是2的次幂，则(n-1)的二进制就会是3=11,7=111,15=1111，与运算&时，全都是一个字符就极大减少了哈希碰撞的概率；

 

====================================================================

# 三. Java 多线程模块

## 1.并行和并发有什么区别？

并行：多个处理器或多核处理器同时处理多个任务。

并发：多个任务在同一个 CPU 核上，按细分的时间片轮流(交替)执行，从逻辑上来看那些任务是同时执行。

【并发 = 两个队列和一台咖啡机】 【并行 = 两个队列和两台咖啡机】

 

## 2.线程和进程的区别？

一个程序下至少有一个进程，一个进程下至少有一个线程，一个进程下也可以有多个线程来增加程序的执行速度。

## 3.守护线程是什么？

守护线程是运行在后台的一种特殊进程。它独立于控制终端并且周期性地执行某种任务或等待处理某些发生的事件。在 Java 中垃圾回收线程就是特殊的守护线程。

## 4.多线程有几种实现方式？

有4种，分别是：

继承Thread类

实现Runnable接口

实现Callable接口通过FutureTask包装器来创建Thread线程

通过线程池创建线程，使用线程池接口ExecutorService结合Callable、Future实现有返回结果的多线程。

前面两种【无返回值】原因：通过重写run方法，run方法的返回值是void，所以没有办法返回结果。

后面两种【有返回值】原因：通过Callable接口，就要实现call方法，这个方法的返回值是Object，所以返回的结果可以放在Object对象中。

## 5.说一下 Runnable和 Callable有什么区别？

Runnable没有返回值，Callable可以拿到有返回值，Callable可以看作是 Runnable的补充。

## 6.线程有哪些状态？

线程的6种状态：

初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。

运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。

阻塞(BLOCKED)：表示线程阻塞于锁。

等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。

超时等待(TIMED_WAITING)：该状态不同于WAITING，它可以在指定的时间后自行返回。

终止(TERMINATED)：表示该线程已经执行完毕。

## 7.sleep() 和 wait() 有什么区别？

类的不同：sleep() 来自 Thread，wait() 来自 Object。

释放锁：sleep() 不释放锁；wait() 释放锁。

用法不同：sleep() 时间到会自动恢复；wait() 可以使用 notify()/notifyAll()直接唤醒。

## 8.notify()和 notifyAll()有什么区别？

notifyAll()会唤醒所有的线程，notify()之后唤醒一个线程。notifyAll() 调用后，会将全部线程由等待池移到锁池，然后参与锁的竞争，竞争成功则继续执行，如果不成功则留在锁池等待锁被释放后再次参与竞争。而 notify()只会唤醒一个线程，具体唤醒哪一个线程由虚拟机控制。

## 9.线程的 run() 和 start() 有什么区别？

start() 方法用于启动线程，run() 方法用于执行线程的运行时代码。run() 可以重复调用，而 start() 只能调用一次。

 

## 10.创建线程池有哪几种方式？

线程池创建有七种方式，最核心的是最后一种：

newSingleThreadExecutor()：它的特点在于工作线程数目被限制为 1，操作一个无界的工作队列，所以它保证了所有任务的都是被顺序执行，最多会有一个任务处于活动状态，并且不允许使用者改动线程池实例，因此可以避免其改变线程数目；

newCachedThreadPool()：它是一种用来处理大量短时间工作任务的线程池，具有几个鲜明特点：它会试图缓存线程并重用，当无缓存线程可用时，就会创建新的工作线程；如果线程闲置的时间超过 60 秒，则被终止并移出缓存；长时间闲置时，这种线程池，不会消耗什么资源。其内部使用 SynchronousQueue 作为工作队列；

newFixedThreadPool(int nThreads)：重用指定数目（nThreads）的线程，其背后使用的是无界的工作队列，任何时候最多有 nThreads 个工作线程是活动的。这意味着，如果任务数量超过了活动队列数目，将在工作队列中等待空闲线程出现；如果有工作线程退出，将会有新的工作线程被创建，以补足指定的数目 nThreads；

newSingleThreadScheduledExecutor()：创建单线程池，返回 ScheduledExecutorService，可以进行定时或周期性的工作调度；

newScheduledThreadPool(int corePoolSize)：和newSingleThreadScheduledExecutor()类似，创建的是个 ScheduledExecutorService，可以进行定时或周期性的工作调度，区别在于单一工作线程还是多个工作线程；

newWorkStealingPool(int parallelism)：这是一个经常被人忽略的线程池，Java 8 才加入这个创建方法，其内部会构建ForkJoinPool，利用Work-Stealing算法，并行地处理任务，不保证处理顺序；

ThreadPoolExecutor()：是最原始的线程池创建，上面1-3创建方式都是对ThreadPoolExecutor的封装。

## 11.线程池都有哪些状态？

111）RUNNING：这是最正常的状态，接受新的任务，处理等待队列中的任务。

000）SHUTDOWN：不接受新的任务提交，但是会继续处理等待队列中的任务。

001）STOP：不接受新的任务提交，不再处理等待队列中的任务，中断正在执行任务的线程。

010）TIDYING：所有的任务都销毁了，workCount 为 0，线程池的状态在转换为 TIDYING 状态时，会执行钩子方法 terminated()。

100）TERMINATED：terminated()方法结束后，线程池的状态就会变成这个。

 

## 12.线程池中 submit() 和 execute() 方法有什么区别？

execute()：只能执行 Runnable 类型的任务。

submit()：可以执行 Runnable 和 Callable 类型的任务。

Callable 类型的任务可以获取执行的返回值，而 Runnable 执行无返回值。

## 13.在 Java 程序中怎么保证多线程的运行安全？

方法一：使用安全类，比如 Java. util. concurrent 下的类。

方法二：使用自动锁 synchronized。

 

## 13.多线程中 synchronized 锁升级的原理是什么？

1.对象刚被创建时，处于无锁态，markword中存的东西是：hashcode|0|0|01

2.当一个线程进入到这个对象进行锁时，就会加上偏向锁，markword中存的东西就变成了threadId|Epoch|1|1|01，这个步骤头部上的东西发生了改变成了线程ID

3.偏向锁被争用，就变升级为轻量级锁（自旋锁），markword中存的东西就变成了LockRecord Pointer|00，之前存的东西都被复制进lockRecordPointer锁记录指针中

4.当轻量级锁自旋次数大于10，升级为重量级锁，这里就进入到了操作系统中，是一个操作系统中的队列，阻塞住了。

锁的升级的目的：锁升级是为了减低了锁带来的性能消耗。在 Java 6 之后优化 synchronized 的实现方式，使用了偏向锁升级为轻量级锁再升级到重量级锁的方式，从而减低了锁带来的性能消耗。

## 14.什么是死锁？

当线程 A 持有独占锁a，并尝试去获取独占锁 b 的同时，线程 B 持有独占锁 b，并尝试获取独占锁 a 的情况下，就会发生 AB 两个线程由于互相持有对方需要的锁，而发生的阻塞现象，我们称为死锁。

## 15.怎么防止死锁？

尽量使用 tryLock(long timeout, TimeUnit unit)的方法(ReentrantLock、ReentrantReadWriteLock)，设置超时时间，超时可以退出防止死锁。

尽量使用 Java. util. concurrent 并发类代替自己手写锁。

尽量降低锁的使用粒度，尽量不要几个功能用同一把锁。

尽量减少同步的代码块。

## 16.ThreadLocal 是什么？有哪些使用场景？

ThreadLocal 为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。

ThreadLocal 的经典使用场景是数据库连接和 session 管理等。 

## 18.synchronized 和 volatile 的区别是什么？

volatile 是变量修饰符；synchronized 是修饰类、方法、代码段。

volatile 仅能实现变量的修改可见性，不能保证原子性；而 synchronized 则可以保证变量的修改可见性和原子性。

volatile 不会造成线程的阻塞；synchronized 可能会造成线程的阻塞。

## 19.synchronized 和 Lock 有什么区别？

synchronized是一个关键字，Lock是一个接口；

synchronized可以给类、方法、代码块加锁；而 lock 只能给代码块加锁。

synchronized 不需要手动获取锁和释放锁，使用简单，发生异常会自动释放锁，不会造成死锁；而 lock 需要自己加锁和释放锁，如果使用不当没有 unLock()去释放锁就会造成死锁。

通过 Lock 可以知道有没有成功获取锁，而 synchronized 却无法办到。

## 21.说一下 atomic 的原理？

atomic 主要利用 CAS (Compare And Swap) 和 volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。

 

## 22.多线层访问一个非线程安全的HashMap有什么影响？

​     1.造成cpu占用率100%，原因是，在向hashmap插入数据时，如果长度不够，就会自动扩容，新建一个更大的hashmap，再将老的迁移到新的中去，这是一个rehash的过程，多线程操作就会形成循环链表，再使用get时就会无限循环；

​     2.导致put的元素丢失，多线程操作时，如果发生哈希碰撞，可能导致两个线程同时获取到同一个位置，就会发生元素覆盖丢失的情况。

在jdk1.7中，在多线程环境下，扩容时会造成环形链或数据丢失。

在jdk1.8中，在多线程环境下，会发生数据覆盖的情况。

## 22.为什么要使用线程池，而不是自己创建线程？

可以重用已存在的线程，减少线程创建和销毁的开销，提高性能；

提高线程的可管理性，可以统一分配、调优和监控。

线程池的最大线程数配置：

IO密集型 = 2Ncpu（数据库交互、文件处理、网络数据传输等等）

计算密集型 = Ncpu（复杂算法）或者Ncpu+1（发生错误时正好有一个额外线程）

## 23. volatile关键字的作⽤？ 

保证被其修饰的变量在内存中的可见性，即每次读取到这个变量，那么肯定就是最新的数据；

JVM会优化指令以求更好的性能，这个关键字相当于内存屏障，不允许进行指令重排；

只保证可见性，不保证原子性；

场景：比如需要生成获取的流水号的工厂对象；

​    单例模式中的双检查锁的机制，获取的工厂单例对象用volatile修饰；

## 24. 什么是阻塞队列？ 

阻塞队列就是一种多了两个附加操作的队列；

1：队列满时，队列阻塞插入元素的线程，直到队列不满

2：队列为空时，获取元素的线程会阻塞等待，直到队列不为空

插入时使用put[阻塞],add[抛异常]，移除时使用take[阻塞],remove[抛异常]

JDK7中提供了7个阻塞队列，一般就使用ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。

## 25.synchronized锁住方法时，静态方法和普通方法分别锁住的是什么？

静态方法时是使用的类锁；

普通方法是使用的对象锁； 

## 26.在主方法中调用多个耗时长的子方法并需要获取返回值应该怎么优化？

在条件允许的情况下，若多个子方法时间都很长，使用多线程Callable接口使用线程；

将子方法写在新建的线程类中，并使用线程池进行submit，即可多线程同时运行；

返回的是一个Future对象，可以使用get方法拿去到返回对象，主方法会在需要用到子方法返回值的地方，等待子线程完成后再继续进行往后逻辑，但是注意需要捕捉子方法的异常；

## 27.线程池的种类和区别？一般使用的线程池是什么？

JDK中封装的有5种线程池，分别是:

1、CachedThreadPool

​		线程池中数量没有固定，可达到最大值(创建时指定)，线程池中的线程可以进行重复利用和回收，没有可用线程会创建一个线程；

2、FixedThreadPool

​		创建固定线程数的线程池，线程数固定可以很好地控制线程并发，超出的线程数会在队列中等待

3、SingleThreadExecutor

​		线程池最多执行一个线程，超出的在队列中等待

4、ScheduleThreadPool

​		线程池中有指定数量的线程，空线程也将会保留，可定时或延时执行线程活动

5、SingleThreadScheduledExecutor

​		单例和延迟的合并，线程池只执行一个线程，可定时或延时执行线程活动

创建线程池的时候有7个参数：

| 参数                     | 参数解释                                                     |
| ------------------------ | ------------------------------------------------------------ |
| corePoolSize             | 核心线程,会一直保留                                          |
| maximumPoolSize          | 最大线程数                                                   |
| keepAliveTime            | 存活时间,新开启的线程如果执行完毕后可以存活多长时间          |
| timeUnit                 | 时间单位                                                     |
| workQueue                | 任务队列,如果正在执行的任务超过了核心线程数，可以存放在队列中，当线程池中有空闲资源就可以从队列中取出任务继续执行 |
| threadFactor             | 线程工厂,产生线程的，可以自定义线程的类型，比如我们可以定义线程组名称 |
| rejectedExecutionHandler | 拒绝策略，所有线程都在忙，并且任务队列处于满任务的状态，则会执行拒绝策略(直接抛出异常/扔掉最新任务/扔掉最旧任务/调用者处理任务) |

一般要使用自定义的线程池，阿里巴巴开发规范中指明的；

**线程池工作流程原理是，先使用核心线程进行工作，如果核心线程都在忙，就会放入到任务队列中，如果是cacheed线程池，就开启最大线程数执行，如果任务队列中满了，就会执行拒绝策略；**

使用自定义线程池的原因：

1.任务队列默认长度是Integer.MAX_VALUE，最大线程数的默认值也是Integer.MAX_VALUE，使用自定义线程池的时候，这个值太大了，创建太多线程会导致内存溢出，所以需要使用自定义的线程池控制最大数量与队列长度（线程数的值需要根据CPU核心数和压测结果来确定）；

2.自定义的线程工厂，可以指定线程组的名称，方便在生产上查问题；

3.默认的拒绝策略在生产中都不合适，在超出最大长度时，多余的线程队列最好是放进消息中间件kafka执行，或者储存进数据库做持久化再做捡起；

这个是阿里的规范确定的，但是一般公司没阿里的巨大并发，所以不一定会造成内存溢出，还是需要看业务实际情况来确定

## 28.Thread.sleep(0)有什么作用？yeild有什么作用？两者有什么区别？

Thread.sleep(0)和Thread.yeild()都是让包括自己的线程让出时间片,立刻重新竞争抢占CPU的控制权；

区别是Thread.sleep(0)并不会让出锁，但是Thread.yeild()会释放锁；

## 29.什么场景使用多线程和消息队列？

​	多线程和消息队列两者是不冲突的，使用消息队列时，可以提高稳定性，应用机器宕机之后，消息队列中的数据不会丢失，应用程序更加可靠；使用多线程时，会占用应用服务器资源；个人认为时效性不是特别强的、不需要关心执行结果的都可以使用消息队列慢慢消化。

​	批量发送短信、邮件、通知时，数据量庞大，如果使用多线程对系统不安全，所以使用消息队列。

​	程序执行多个耗时方法，使用多线程并行查询，可以使用多线程。

## 30.线程池的任务队列BlockingQueue？

有7种任务队列的实现类，**所有的实现类都是线程并发安全的**

**ArrayBlockingQueue:**有界队列实现类，并发控制使用可重入锁，读取都需要获取到锁；

**SynchronousQueue:**特殊的同步队列，指读写的线程需要同步，即写入一个元素时，不会立即返回，需要等待另一个线程将元素取走；

**LinkedBlockingQueue:**单向队列，一端出入的，具有FIFO特性， 是通过两个ReentrantLock和两个Condition来实现的，可以当做有界队列也可以当做无界队列。

**LinkedBlockingDeque:**双向队列，基于单向链表实现阻塞队列，可以当做有界队列也可以当做无界队列

**PriorityBlockingQueue:** PriorityBlockingQueue是带排序的任务队列，使用 ReentrantLock控制并发，是无界队列（只能指定初始的队列大小，构造函数不能指定大小，之后插入元素的时，空间不够的话会自动扩容）。 

**DelayQueue: **是一个支持延时获取元素的无界阻塞队列。内部用 PriorityQueue 实现

**LinkedTransferQueue:**



## 31.ReentrantLock

====================================================================

# 四. Java 反射模块

## 1.什么是反射？

反射是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 Java 语言的反射机制。

## 2.什么是 Java 序列化？什么情况下需要序列化？

Java 序列化是为了保存各种对象在内存中的状态，并且可以把保存的对象状态再读出来。

以下情况需要使用 Java 序列化：

想把的内存中的对象状态保存到一个文件中或者数据库中时候；

想用套接字在网络上传送对象的时候；

想通过RMI（远程方法调用）传输对象的时候。

## 3.动态代理是什么？有哪些应用？

动态代理是运行时动态生成代理类。

动态代理的应用有 spring aop、hibernate 数据查询、测试框架的后端 mock、rpc，Java注解对象获取等。

## 4.怎么实现动态代理？什么情况下使用相应的动态代理？

JDK 原生动态代理和 cglib 动态代理。

JDK 原生动态代理是基于接口实现的。

CGLIB 是基于字节码底层继承当前类的子类实现的。

Spring默认是使用jdk动态代理的，当bean实现接口时，Spring就会使用JDK动态代理，当Ban没有实现接口时，Spring就会使用CGLIB动态代理； 

效率对比，JAVA8后JDK代理的速度快很多

====================================================================

# 五. Java 对象拷贝模块

## 1.为什么要使用克隆？

克隆的对象可能包含一些已经修改过的属性，而 new 出来的对象的属性都还是初始化时候的值，所以当需要一个新的对象来保存当前对象的“状态”就靠克隆方法了。

## 2.如何实现对象克隆？

实现 Cloneable 接口并重写 Object 类中的 clone() 方法。

实现 Serializable 接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆。

## 3.深拷贝和浅拷贝区别是什么？

浅拷贝：当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制。

深拷贝：除了对象本身被复制外，对象所包含的所有成员变量也将复制。

 

====================================================================

# 六. Java Web模块

### 1.JSP 和 servlet 有什么区别？

JSP 是 servlet 技术的扩展，本质上就是 servlet 的简易方式。servlet 和 JSP 最主要的不同点在于，servlet 的应用逻辑是在 Java 文件中，并且完全从表示层中的 html 里分离开来，而 JSP 的情况是 Java 和 html 可以组合成一个扩展名为 JSP 的文件。JSP 侧重于视图，servlet 主要用于控制逻辑。

### 2.JSP 有哪些内置对象？作用分别是什么？

JSP 有 9 大内置对象：

request：封装客户端的请求，其中包含来自 get 或 post 请求的参数；

response：封装服务器对客户端的响应；

pageContext：通过该对象可以获取其他对象；

session：封装用户会话的对象；

application：封装服务器运行环境的对象；

out：输出服务器响应的输出流对象；

config：Web 应用的配置对象；

page：JSP 页面本身（相当于 Java 程序中的 this）；

exception：封装页面抛出异常的对象。

### 3.说一下 JSP 的 4 种作用域？

page：代表与一个页面相关的对象和属性。

request：代表与客户端发出的一个请求相关的对象和属性。一个请求可能跨越多个页面，涉及多个 Web 组件；需要在页面显示的临时数据可以置于此作用域。

session：代表与某个用户与服务器建立的一次会话相关的对象和属性。跟某个用户相关的数据应该放在用户自己的 session 中。

application：代表与整个 Web 应用程序相关的对象和属性，它实质上是跨越整个 Web 应用程序，包括多个页面、请求和会话的一个全局作用域。

### 4.session 和 cookie 有什么区别？

session：是一种将会话状态保存在服务器端的技术。

Cookie ：是在 HTTP 协议下， Web 服务器保存在用户浏览器（客户端）上的小文本文件，它可以包含有关用户的信息。无论何时用户链接到服务器，Web 站点都可以访问 Cookie 信息 。

存储位置不同：session 存储在服务器端；cookie 存储在浏览器端。

安全性不同：cookie 安全性一般，在浏览器存储，可以被伪造和修改。

容量和个数限制：cookie 有容量限制，每个站点下的 cookie 也有个数限制。

存储的多样性：session 可以存储在 Redis 中、数据库中、应用程序中；而 cookie 只能存储在浏览器中。

### 5.说一下 session 的工作原理？

session 的工作原理是客户端登录完成之后，服务器会创建对应的 session，session 创建完之后，会把 session 的 id 发送给客户端，客户端再存储到浏览器中。这样客户端每次访问服务器时，都会带着 sessionid，服务器拿到 sessionid 之后，在内存找到与之对应的 session 这样就可以正常工作了。

69.如果客户端禁止 cookie 能实现 session 还能用吗？

可以用，session 只是依赖 cookie 存储 sessionid，如果 cookie 被禁用了，可以使用 url 中添加 sessionid 的方式保证 session 能正常使用。

70.spring mvc 和 struts 的区别是什么？

拦截级别：struts2 是类级别的拦截；spring mvc 是方法级别的拦截。

数据独立性：spring mvc 的方法之间基本上独立的，独享 request 和 response 数据，请求数据通过参数获取，处理结果通过 ModelMap 交回给框架，方法之间不共享变量；而 struts2 虽然方法之间也是独立的，但其所有 action 变量是共享的，这不会影响程序运行，却给我们编码和读程序时带来了一定的麻烦。

拦截机制：struts2 有以自己的 interceptor 机制，spring mvc 用的是独立的 aop 方式，这样导致struts2 的配置文件量比 spring mvc 大。

对 ajax 的支持：spring mvc 集成了ajax，所有 ajax 使用很方便，只需要一个注解 @ResponseBody 就可以实现了；而 struts2 一般需要安装插件或者自己写代码才行。

71.如何避免 SQL 注入？

使用预处理 PreparedStatement。

使用正则表达式过滤掉字符中的特殊字符。

72.什么是 XSS 攻击，如何避免？

XSS 攻击：即跨站脚本攻击，它是 Web 程序中常见的漏洞。原理是攻击者往 Web 页面里插入恶意的脚本代码（css 代码、Javascript 代码等），当用户浏览该页面时，嵌入其中的脚本代码会被执行，从而达到恶意攻击用户的目的，如盗取用户 cookie、破坏页面结构、重定向到其他网站等。

预防 XSS 的核心是必须对输入的数据做过滤处理。

73.什么是 CSRF 攻击，如何避免？

CSRF：Cross-Site Request Forgery（中文：跨站请求伪造），可以理解为攻击者盗用了你的身份，以你的名义发送恶意请求，比如：以你名义发送邮件、发消息、购买商品，虚拟货币转账等。

防御手段：

验证请求来源地址；

关键操作添加验证码；

在请求地址添加 token 并验证。

 74.重定向和转发

项目经理交给你个任务，但是这个项目你处理不了，张三能处理它，那么有两种解决办法

           重定向：第一种办法，你跟项目经理说，你说你不会，张三会，你去找张三吧，然后项目经理走了，去找张三了！
           转发：第二种办法：    你不好意思跟项目经理说这个问题你不会，你说好，交给我，硬着头皮答应了，然后你知道张三可以解决这个问题，你就自己去找张三帮你完成了。


====================================================================

# 七. Java 异常模块

## 1.throw 和 throws 的区别？

throw：是真实抛出一个异常。

throws：是声明可能会抛出一个异常。

## 2.final、finally、finalize 有什么区别？

final：是修饰符，如果修饰类，此类不能被继承；如果修饰方法和变量，则表示此方法和此变量不能在被改变，只能使用。

finally：是 try{} catch{} finally{} 最后一部分，表示不论发生任何情况都会执行，finally 部分可以省略，但如果 finally 部分存在，则一定会执行 finally 里面的代码。

finalize： 是Object的protected方法，子类可以覆盖该方法以实现资源清理工作，GC在回收对象之前调用该方法。

## 3.try-catch-finally 中哪个部分可以省略？

try-catch-finally 其中 catch 和 finally 都可以被省略，但是不能同时省略，也就是说有 try 的时候，必须后面跟一个 catch 或者 finally。

## 4.try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？

finally 一定会执行，即使是 catch 中 return 了，catch 中的 return 会等 finally 中的代码执行完之后，才会执行。

## 5.常见的异常类有哪些？

NullPointerException 空指针异常

ClassNotFoundException 指定类不存在

NumberFormatException 字符串转换为数字异常

IndexOutOfBoundsException 数组下标越界异常

ClassCastException 数据类型转换异常

FileNotFoundException 文件未找到异常

IOException IO 异常

 

====================================================================

# 八. 网络模块

## 1.http 响应码 301 和 302 代表的是什么？有什么区别？

301：永久重定向；302：暂时重定向。

它们的区别是，301 对搜索引擎优化（SEO）更加有利；302 有被提示为网络拦截的风险。

## 2.forward 和 redirect 的区别？

forward 是转发 和 redirect 是重定向：

地址栏 url 显示：foward（转发） url 不会发生改变，redirect（重定向） url 会发生改变；

数据共享：forward（转发） 可以共享 request 里的数据，redirect（重定向） 不能共享；

效率：forward（转发） 比 redirect 效率高。

       重定向：第一种办法，你跟项目经理说，你说你不会，张三会，你去找张三吧，然后项目经理走了，去找张三了！
       转发：第二种办法：    你不好意思跟项目经理说这个问题你不会，你说好，交给我，硬着头皮答应了，然后你知道张三可以解决这个问题，你就自己去找张三帮你完成了。
## 3.简述 tcp 和 udp的区别？

tcp 和 udp 是 OSI 模型中的运输层中的协议。tcp 提供可靠的通信传输，而 udp 则常被用于让广播和细节控制交给应用的通信传输。

两者的区别大致如下：

tcp 面向连接，udp 面向非连接即发送数据前不需要建立链接；

tcp 提供可靠的服务（数据传输），udp 无法保证；

tcp 面向字节流，udp 面向报文；

tcp 数据传输慢，udp 数据传输快；

/*UDP头定义，共8个字节*/
 /*TCP头定义，共20个字节*/

## 4.tcp 为什么要三次握手，两次不行吗？为什么？

如果采用两次握手，那么只要服务器发出确认数据包就会建立连接，但由于客户端此时并未响应服务器端的请求，那此时服务器端就会一直在等待客户端，这样服务器端就白白浪费了一定的资源。若采用三次握手，服务器端没有收到来自客户端的再此确认，则就会知道客户端并没有要求建立请求，就不会浪费服务器的资源。

## 5.说一下 tcp 粘包是怎么产生的？

tcp 粘包可能发生在发送端或者接收端，分别来看两端各种产生粘包的原因：

发送端粘包：发送端需要等缓冲区满才发送出去，造成粘包；

接收方粘包：接收方不及时接收缓冲区的包，造成多个包接收。

## 6.OSI 的七层模型都有哪些？

物理层：利用传输介质为数据链路层提供物理连接，实现比特流的透明传输。

数据链路层：负责建立和管理节点间的链路。

网络层：通过路由选择算法，为报文或分组通过通信子网选择最适当的路径。

传输层：向用户提供可靠的端到端的差错和流量控制，保证报文的正确传输。

会话层：向两个实体的表示层提供建立和使用连接的方法。

表示层：处理用户信息的表示问题，如编码、数据格式转换和加密解密等。

应用层：直接向用户提供服务，完成用户希望在网络上完成的各种工作。

## 7.get 和 post 请求有哪些区别？

get 请求会被浏览器主动缓存，而 post 不会。

get 传递参数有大小限制，而 post 没有。

post 参数传输更安全，get 的参数会明文限制在 url 上，post 不会。

##  8.http常见请求码

200 - 服务器成功返回网页
404 - 请求的网页不存在
503 - 服务不可用
详细分解：

### 1xx（临时响应）

表示临时响应并需要请求者继续执行操作的状态代码。

代码 说明
100 （继续） 请求者应当继续提出请求。服务器返回此代码表示已收到请求的第一部分，正在等待其余部分。
101 （切换协议） 请求者已要求服务器切换协议，服务器已确认并准备切换。

### 2xx （成功）

表示成功处理了请求的状态代码。

代码 说明
200 （成功） 服务器已成功处理了请求。通常，这表示服务器提供了请求的网页。
201 （已创建） 请求成功并且服务器创建了新的资源。
202 （已接受） 服务器已接受请求，但尚未处理。
203 （非授权信息） 服务器已成功处理了请求，但返回的信息可能来自另一来源。
204 （无内容） 服务器成功处理了请求，但没有返回任何内容。
205 （重置内容） 服务器成功处理了请求，但没有返回任何内容。
206 （部分内容） 服务器成功处理了部分 GET 请求。

### 3xx （重定向）

表示要完成请求，需要进一步操作。 通常，这些状态代码用来重定向。

代码 说明
300 （多种选择） 针对请求，服务器可执行多种操作。服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择。
301 （永久移动） 请求的网页已永久移动到新位置。服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。
302 （临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
303 （查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。
304 （未修改） 自从上次请求后，请求的网页未修改过。服务器返回此响应时，不会返回网页内容。
305 （使用代理） 请求者只能使用代理访问请求的网页。如果服务器返回此响应，还表示请求者应使用代理。
307 （临时重定向） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。

### 4xx（请求错误）

这些状态代码表示请求可能出错，妨碍了服务器的处理。

代码 说明
400 （错误请求） 服务器不理解请求的语法。
401 （未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。
403 （禁止） 服务器拒绝请求。
404 （未找到） 服务器找不到请求的网页。
405 （方法禁用） 禁用请求中指定的方法。
406 （不接受） 无法使用请求的内容特性响应请求的网页。
407 （需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。
408 （请求超时） 服务器等候请求时发生超时。
409 （冲突） 服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息。
410 （已删除） 如果请求的资源已永久删除，服务器就会返回此响应。
411 （需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。
412 （未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。
413 （请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。
414 （请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。
415 （不支持的媒体类型） 请求的格式不受请求页面的支持。
416 （请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。
417 （未满足期望值） 服务器未满足"期望"请求标头字段的要求。

### 5xx（服务器错误）

这些状态代码表示服务器在尝试处理请求时发生内部错误。 这些错误可能是服务器本身的错误，而不是请求出错。

代码 说明
500 （服务器内部错误） 服务器遇到错误，无法完成请求。
501 （尚未实施） 服务器不具备完成请求的功能。例如，服务器无法识别请求方法时可能会返回此代码。
502 （错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。
503 （服务不可用） 服务器目前无法使用（由于超载或停机维护）。通常，这只是暂时状态。
504 （网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。
505 （HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。

HttpWatch状态码Result is
200 - 服务器成功返回网页，客户端请求已成功。
302 - 对象临时移动。服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
304 - 属于重定向。自上次请求后，请求的网页未修改过。服务器返回此响应时，不会返回网页内容。
401 - 未授权。请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。
404 - 未找到。服务器找不到请求的网页。
2xx - 成功。表示服务器成功地接受了客户端请求。
3xx - 重定向。表示要完成请求，需要进一步操作。客户端浏览器必须采取更多操作来实现请求。例如，浏览器可能不得不请求服务器上的不同的页面，或通过代理服务器重复该请求。
4xx - 请求错误。这些状态代码表示请求可能出错，妨碍了服务器的处理。
5xx - 服务器错误。表示服务器在尝试处理请求时发生内部错误。 这些错误可能是服务器本身的错误，而不是请求出错。

====================================================================

# 九. 设计模式模块

## 1.说一下你熟悉的设计模式？

**单例模式：**保证被创建一次，节省系统开销。

**工厂模式**（简单工厂、抽象工厂）：解耦代码。

**观察者模式：**定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新。

**代理模式：**一个代理类提供另一个类的功能，以便向外围提供接口，或者做原本类的功能的缩减与扩展。（线程的底层就是静态代理）

**模板模式：**定义方法中的骨架(方法以及执行顺序)，而其他步骤延迟在子类中去实现，使子类可以不改变可以不改变算法结构，即可定义该算法的某些步骤；

 

具体举例说明：

**工厂和单例模式：**生成业务订单号的公共方法，产生编辑PDF文件对象，检查黑白名单的公共对象，框架中很多都使用了比如mybatis中sqlSessionFactory/LogFactory；

**代理模式：**比如贷后中，提供了发起扣款、结果查询、结果通知的三个功能，对于某种类型的机构，只允许使用结果查询的功能，对于这种特殊业务类型的对象，产生一个代理对象Wrapper，而这个对象中，实现原本接口功能功能时，其他的类型就会做对应业务报错处理；

**模版模式：**比如下单流程控制中，需要绑卡->活体->授信->借款（只是举例，操作远不止这些），在父类中定义好这些方法，并且定义好流程，设置一个钩子函数，子类继承父类时，根据储蓄卡/支付宝预授权的模式，来定义钩子函数，而当钩子函数满足某个条件时，可以省略一些步骤，比如预授权模式直接变成 活体->借款；

 

## 2.简单工厂和抽象工厂有什么区别？

简单工厂：用来生产同一等级结构中的任意产品，对于增加新的产品，无能为力。

工厂方法：用来生产同一等级结构中的固定产品，支持增加任意产品。

抽象工厂：用来生产不同产品族的全部产品，对于增加新的产品，无能为力；支持增加产品族。

 

====================================================================

# 十. Spring/Spring MVC模块

## 1.为什么要使用 spring？

spring 提供 ioc 技术，容器会管理依赖的对象，从而不需要自己创建和管理依赖对象了，更轻松的实现了程序的解耦。

spring 提供了事务支持，使得事务操作变的更加方便。

spring 提供了面向切片编程，这样可以更方便的处理某一类的问题。

更方便的框架集成，spring 可以很方便的集成其他框架。

## 2.解释一下什么是 aop？

aop 是面向切面编程，通过动态代理实现程序功能的统一维护的一种技术。

简单来说就是统一处理某一“切面”（类）的问题的编程思想，比如统一处理日志、异常等。

## 2.简述AOP有几种通知方式？

**1.前置通知[Before advice]**：在连接点前面执行，前置通知不会影响连接点的执行，除非此处抛出异常。 
**2.正常返回通知[After returning advice]**：在连接点正常执行完成后执行，如果连接点抛出异常，则不会执行。 
**3.异常返回通知[After throwing advice]**：在连接点抛出异常后执行。 
**4.后置通知[After (finally) advice]**：在连接点执行完成后执行，不管是否抛出异常，都执行返回通知中的内容。 
**5.环绕通知[Around advice]**：环绕通知围绕在连接点前后，比如一个方法调用的前后。

## 3.解释一下什么是 ioc？

ioc：控制反转，是 spring 的核心，对于 spring 框架来说，就是由 spring 来负责控制对象的生命周期和对象间的关系。

简单来说，控制指的是当前对象对内部成员的控制权；控制反转指的是，这种控制权不由当前对象管理了，由其他（类,第三方容器）来管理。

## 4.spring 有哪些主要模块？

spring core：框架的最基础部分，提供 ioc 和依赖注入特性。

spring context：构建于 core 封装包基础上的 context 封装包，提供了一种框架式的对象访问方法。

spring dao：Data Access Object 提供了JDBC的抽象层。

spring aop：提供了面向切面的编程实现，让你可以自定义拦截器、切点等。

spring Web：提供了针对 Web 开发的集成特性，例如文件上传，利用 servlet listeners 进行 ioc 容器初始化和针对 Web 的 ApplicationContext。

spring Web mvc：spring 中的 mvc 封装包提供了 Web 应用的 Model-View-Controller（MVC）的实现。

## 5.spring 常用的注入方式有哪些？

setter 属性注入

构造方法注入

注解方式注入

## 6.spring 中的 bean 是线程安全的吗？

spring 中的 bean 默认是单例模式，spring 框架并没有对单例 bean 进行多线程的封装处理。

实际上大部分时候 spring bean 无状态的（比如 dao 类，仅有方法没有数据），所以某种程度上来说 bean 也是安全的，但如果 bean 有状态的话，那就要开发者自己去保证线程安全了。

有状态就是有数据存储功能。

无状态就是不会保存数据。

有状态的bean，也就是有储存数据的bean（比如数据库连接bean）保证线程安全是使用 threadLocal 进行处理，ThreadLocal 是线程本地变量，每个线程拥有变量的一个独立副本，所以各个线程之间互不影响，保证了线程安全 

## 7.spring 支持几种 bean 的作用域？

spring 支持 5 种作用域，如下：

singleton：spring ioc 容器中只存在一个 bean 实例，bean 以单例模式存在，是系统默认值；

prototype：每次从容器调用 bean 时都会创建一个新的示例，既每次 getBean()相当于执行 new Bean()操作；

request：每次 http 请求都会创建一个 bean；

session：同一个 http session 共享一个 bean 实例；

global-session：用于 portlet 容器，因为每个 portlet 有单独的 session，globalsession 提供一个全局性的 http session。

注意： 使用 prototype 作用域需要慎重的思考，因为频繁创建和销毁 bean 会带来很大的性能开销。

## 8.spring 自动装配 bean 有哪些方式？

no：默认值，表示没有自动装配，应使用显式 bean 引用进行装配。

byName：它根据 bean 的名称注入对象依赖项。

byType：它根据类型注入对象依赖项。

构造函数：通过构造函数来注入依赖项，需要设置大量的参数。

autodetect：容器首先通过构造函数使用 autowire 装配，如果不能，则通过 byType 自动装配。

## 11.说一下 spring mvc 运行流程？

spring mvc 先将请求发送给 DispatcherServlet（前端控制器）。

DispatcherServlet 查询一个或多个 HandlerMapping（处理器映射器），找到处理请求的 Controller。

DispatcherServlet 再把请求提交到对应的 Controller。

Controller 进行业务逻辑处理后，会返回一个ModelAndView。

Dispathcher 查询一个或多个 ViewResolver 视图解析器，找到 ModelAndView 对象指定的视图对象。

视图对象负责渲染返回给客户端。

## 12.spring mvc 有哪些组件？

前置控制器 DispatcherServlet。

映射控制器 HandlerMapping。

处理器 Controller。

模型和视图 ModelAndView。

视图解析器 ViewResolver。

## 13.@RequestMapping 的作用是什么？

将 http 请求映射到相应的类/方法上。

## 14.@Autowired 的作用是什么？

@Autowired 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作，通过@Autowired 的使用来消除 set/get 方法。通过byname的方式注入

## 15.在 Spring 框架中如何更有效地使用 JDBC？

使用 SpringJDBC 框架，资源管理和错误处理的代价都会被减轻。所以开发者只需 写 statements 和 queries 从数据存取数据，JDBC 也可以在 Spring 框架提供的 模板类的帮助下更有效地被使用，这个模板叫 JdbcTemplate 。

JdbcTemplate 类提供了很多便利的方法解决诸如把数据库数据转变成基本数据类 型或对象，执行写好的或可调用的数据库操作语句，提供自定义的数据错误处理。 

 

## 16. Spring 对 DAO 的支持 

Spring 对数据访问对象（DAO）的支持旨在简化它和数据访问技术如 JDBC， Hibernate or JDO 结合使用。这使我们可以方便切换持久层。编码时也不用担心会 捕获每种技术特有的异常。 

 

## 17.Spring 支持的事务管理类型

编程式事务管理：这意味你通过编程的方式管理事务，给你带来极大的灵活性，但是 难维护。 

声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和 XML 配置来管理事务。 

大多数 Spring 框架的用户选择声明式事务管理，因为它对应用代码的影响最小，因 此更符合一个无侵入的轻量级容器的思想。声明式事务管理要优于编程式事务管理，虽然比编程式事务管理（这种方式允许你通过代码控制事务）少了一点灵活性。

 

## 18.说一下 spring 的事务隔离？

spring 有五大隔离级别，默认值为 ISOLATION_DEFAULT（使用数据库的设置），其他四个隔离级别和数据库的隔离级别一致：

​     DEFAULT: 默认值,由底层数据库自动判断应该使用什么隔离界别

​     UNCOMMITTED: 可以读取未提交数据,可能出现脏读,不重复读,幻读.

​          效率最高.

​     COMMITTED:只能读取其他事务已提交数据.可以防止脏读,可能出现不可重复读和幻读.

​     REPEATABLE_READ: 读取的数据被添加锁,防止其他事务修改此数据,可以防止不可重复读.脏读,可能出现幻读.

​          锁单条记录

​     SERIALIZABLE: 排队操作,对整个表添加锁.一个事务在操作数据时,另一个事务等待事务操作完成后才能操作这个表.

​          最安全的

​          效率最低的.

​          锁表

## 19.说一下 spring 的事务传播级别？

**@Transactional(propagation=Propagation.REQUIRED)**（睿块奥第）

如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)

**@Transactional(propagation=Propagation.SUPPORTS)**（死破而次）

如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.

**@Transactional(propagation=Propagation.NOT_SUPPORTED)**

容器不为这个方法开启事务

**@Transactional(propagation=Propagation.REQUIRES_NEW)**

不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务

**@Transactional(propagation=Propagation.MANDATORY)**

必须在一个已有的事务中执行,否则抛出异常

**@Transactional(propagation=Propagation.NEVER)**

必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)

NESTED 如果当前存在事务,则在嵌套事务内执行,嵌套事务的提交与回滚与父事务没有任务关系,反之,当父事务提交嵌套事务也一起提交,父事务回滚会也回滚嵌套事务的,如果当前没有事务,则新建一个事务运行.

## 20.spring怎么保证分布式事务的统一？

**1.消息式事务：**

​	基于消息中间件实现，本地事务和消息放在一个分布式事务里，本地事务和消息同时成功或者失败，这样的性能很高，但是有风险；

**2.LCN分布式框架：**

​	独立部署应用，引入依赖，使用唯一标识groupId贯穿全局，各方都加上注解，@TxTransaction，在发起方加上(isStart=true)参数，就能实现发起和参与方事务一致。

**3.seata分布式框架：**

 	独立部署应用，引入依赖，使用XID贯穿全局，使用注解@Transactional和@GlobalTrasactional来标识本地事务和全局事务，拦截业务sql，执行前后分别声称before/after镜像（类似AOP的前置后置通知的思想），根据镜像逆向生成sql进行提交/回滚。

**4.LCN和seata的区别：**

seata和lcn大致实现思路一致，但回滚的机制不一样。

lcn采取代理数据源的模式，seata采取根据undo_log日志表逆向生成sql语句来解决。

lcn能够保证强一致性，性能较差，但可能发生死锁。

seata能保证最终一致性，性能好，但可能造成脏读。



## 21.spring怎么实现延时通知？

1.使用消息队列RabbitMQ可以实现；

2.scheduled声明时使用delay参数，单位是毫秒；

3.quartz声明时使用startDelay参数，单位是毫秒；

 

## 22.spring中的BeanFactory和FactoryBean有什么区别？

都是个工厂，但FactoryBean本质上还是一个Bean，也归BeanFactory管理

BeanFactory是Spring容器的顶层接口，是Spring容器中创建对象的顶层规范；FactoryBean更类似于用户自定义的工厂接口，FactoryBean为实例化bean提供了更灵活的方式，类似于工厂的工厂。

 

## 23.spring中Bean的生命周期？

​     **实例化：**容器启动后就实例化所有的bean，仅仅是简单的实例化，未进行依赖注入，实例化的对象会放在BeanWrapper对象中，仍然是一个原生的状态；

​     **属性赋值：**根据BeanDefinition中的信息通过BeanWrapper提供的设置属性的接口进行依赖注入；

​     **注入Aware接口：**检测是否实现了xxAware接口，并将相关的实例注入给bean；

​     **BeanPostProcessor：**bean对象已经被成功构造，如果需要对bean对象做一些特殊的处理，就可以实现这个接口，提供了两个方法进行处理：

postProcessBeforeInitialzation( Object bean, String beanName ) 

postProcessAfterInitialzation( Object bean, String beanName )

​     **初始化InitializingBean与init-method**：在执行完processorBefore方法就会进入此阶段，完成自定义逻辑，但是不能处理bean本身，只能增加额外的接口的逻辑；

​     **销毁**

## 24.IOC和AOP的实现原理？

1.IOC的实现原理：实现IOC主要就是工厂模式，在启动时，SpringIOC容器将配置与注解的的类，完成对象的创建，再将对象注入到容器中，容器顶层接口是BeanFactory。

2.AOP的实现原理：实现AOP主要就是动态代理，动态代理分为JDK动态代理(基于接口实现)和CGLIB动态代理(基于底层继承该类实现)，使用代理对象调用真实对象方法时，执行AOP的通知操作。

====================================================================

# 十一. Spring Boot模块

## 1.什么是 spring boot？

spring boot 是为 spring 服务的，是用来简化新 spring 应用的初始搭建以及开发过程的。

## 2.为什么要用 spring boot？

配置简单

独立运行

自动装配

无代码生成和 xml 配置

提供应用监控

易上手

提升开发效率

## 3.spring boot 核心配置文件是什么？

spring boot 核心的两个配置文件：

bootstrap (. yml 或者 . properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，且 boostrap 里面的属性不能被覆盖；

application (. yml 或者 . properties)：用于 spring boot 项目的自动化配置。

## 4.spring boot 配置文件有哪几种类型？它们有什么区别？

配置文件有 . properties 格式和 . yml 格式，它们主要的区别是书法风格不同。

properties 配置如下：

spring. RabbitMQ. port=5672

yml 配置如下：

spring:

RabbitMQ:

port: 5672

yml 格式不支持 @PropertySource 注解导入。

## 5.spring boot 有哪些方式可以实现热部署？

使用 devtools 启动热部署，添加 devtools 库，在配置文件中把 spring. devtools. restart. enabled 设置为 true；

使用 Intellij Idea 编辑器，勾上自动编译，当文件修改时同步修改resource和class。

## 6.jpa 和 hibernate 有什么区别？

jpa 全称 Java Persistence API，是 Java 持久化接口规范，hibernate 属于 jpa 的具体实现。

 

## 7.Spring Boot 中的监视器是什么？

Spring boot actuator 是 spring 启动框架中的重要功能之一。

Spring boot 监视器可访问生产环境中正在运行的应用程序的当前状态。

 

## 8.如何实现Spring Boot 应用程序的安全性？

为了实现 Spring Boot 的安全性，要使用 spring-boot-starter-security 依赖项，并且必须添加安全配置。配置类将必须扩展 WebSecurityConfigurerAdapter 并覆盖其方法。

 

## 9.什么是 Swagger？你用 Spring Boot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。

Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。

它使文档能够以与服务器相同的速度更新。

使用注解

@ApiOperation(接口名)、@ApiResponse(接口返回)、

@ApiModel(实体类名与描述)、@ApiModelProperty(实体类属性名与描述)

 

## 10.如何使用 Spring Boot 实现异常处理？

@ControllerAdvice注解，新建一个全局异常类，使用这个注解；

类中使用@ExceptionHandler注解，其中包含异常类，捕捉这个异常信息而抛出友好的信息；

 

## 11.说一下SpringBoot的运行过程？

一、实例化SpringApplication对象，构造方法

 加载classpath下所有可用的 ApplicationContextInitializer(初始器) 和 ApplicationListener(监听器)

启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下3 个注解：

 @EnableAutoConfiguration：进行自动装配【自动装配内容单独再说】 Auto（阿漏）  Configuration（音译：康飞哥瑞讯）

 @SpringBootConfiguration：对所有配置文件类进行装配

 @ComponentScan：组件扫描，装配Bean

 

二、调用run方法

 1.遍历初始化中加载的SpringApplicationRunListeners，然后调用starting(),开始监听springApplication的启动。

 2.加载SpringBoot配置环境(ConfigurableEnvironment)，如果是通过web容器发布，会加载StandardEnvironment。将配置环境对象加入到上面的监听器对象中。

 3.banner属性的设置。

 4.ConfigurableApplicationContext(应用配置上下文)创建，根据webEnvironment是否是web环境创建默认的contextClass,AnnotationConfigEmbeddedWebApplicationContext(通过扫描所有注解类来加载bean)和ConfigurableWebApplicationContext),最后通过BeanUtils实例化上下文对象，并返回。

 5.prepareContext()方法将listeners、environment、applicationArguments、banner等重要组件与上下文对象关联。

 6.refreshContext(context),bean的实例化完成IoC容器可用的最后一道工序。

 

## 12.谈一下SpringBoot的自动装配？

以往在spring中@Autowired声明对象时，必须在ioc容器中存在这个对象，但是springBoot中不需要手动声明，就可以直接使用对象，就是自动装配；

其中原理主要是用到了：javaConfig去配置化，使用@Configuration注解等价于XML配置文件，同时使用@Bean就等同于注入，使用了@Import注解导入其他配置类

SpringBoot其实是：约定优于配置，使用了@Enable注解

每个引入的starter的jar包，其中都会有一个META-INF/spring.facories，这是个配置文件，里面从储存的都是key-value形式的数据，就比如：

org.springframework.boot.autoconfigure.EnableAutoConfiguration=org.springFframework.boot.antoconfig.data.redis

在每个jar包里都有配置类，比如RedisAutoConfiguration和MybatisAutoConfiguration，以供应用加载的时候的被扫描到。

SpringBoot中使用@EnableAutoConfiguration注解，启动自动装配将第三方jar包中的配置信息(spring.facories)导入，主要原理是：

读取所有导入的jar包中spring.facories文件中，

key为”org.springframework.boot.autoconfigure.EnableAutoConfiguration”的值，返回一个String数组，得到所有的在spring.facories中指定的bean路径，最终以@Configuration一样的处理方式注册到容器中。

这种注解方式简化了导入JAR的处理，只需要第三方JAR对外暴露的bean定义在spring.facories即可，按照约定的方式指定好文件中的key；

**结论：**

 

## 13.SpringBoot怎么校验请求参数？

在controller中的请求对象中，需要加上@Valid注解；

在请求对象的属性中加入注解@NotNull(message = " ID为空")；

## 14.SpringBoot的核心注解

@SpringBootApplication 

内部实现是三大注解

@SpringBootConfiguration：内部实现 @Configuration 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，

实现了AutoConfigurationPackage注解和Import注解，springboot所用的自动配置都是在启动的时候扫描并加载spring-boot-autoconfigure下面的/META-INF/spring.factories里面的url进行自动配置，但是不一定生效，需要判断条件是否成立，只有导入对应的start，就会有对应的启动器，有了启动器自动配置才会生效

@ComponentScan：Spring组件扫描

###  15.SpringBoot获取yml文件中参数

yml文件：

```
image:
  upload:
    key: #####
    url: ###
    type: jpg;jpeg;png;
    bucket: hmj
```

实现类：

```
@Value("${image.upload.key}")
private String keyValue;

@Value("${image.upload.url}")
private String urlValue;

@Value("${image.upload.type}")
private String typeValue;

@Value("${image.upload.bucket}")
private String bucketValue;
```

====================================================================

# 十二. Spring Cloud模块

## 1.什么是 spring cloud？

spring cloud 是一系列框架的有序集合。它利用 spring boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 spring boot 的开发风格做到一键启动和部署。

## 2.spring cloud 断路器的作用是什么？

在分布式架构中，断路器模式的作用也是类似的，当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个错误响应，而不是长时间的等待。这样就不会使得线程因调用故障服务被长时间占用不释放，避免了故障在分布式系统中的蔓延。

在这种情况下使用 Hystrix 我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值。

## 3.spring cloud 的核心组件有哪些？

服务注册于发现——Eureka

客服端负载均衡——Ribbon：@LoanBlance注解进行负载均衡，默认轮询算法

断路器——Hystrix

服务网关——Zuul：可以通过配置路由将微服务修改为匹配的网关名称，再请求给对应服务

分布式配置——Spring Cloud Config

声明式客户端——Spring Cloud Feign：基于动态代理机制，封装了Http调用流程，请求模板化，以Java接口注解方式调用Http请求，默认轮询策略，如果需要切换策略就在application.yml里修改配置和Ribbon结合

 

 

## 4.使用spring cloud 的优势和劣势？

优势：

\1.     服务拆分粒度更细，有利于资源重复利用，有利于提高开发效率;

\2.     可以更精准的制定优化服务方案，提高系统的可维护性;

\3.     适于互联网时代，产品迭代周期更短;

劣势：

\1.     分布式系统的相关复杂性，网络、带宽、安全；

\2.     部署复杂性；

 

## 5.服务注册和发现是什么意思？Spring Cloud 如何实现？

Eureka 服务注册和发现可以在这种情况下提供帮助。由于所有服务都在 Eureka 服务器上注

册并通过调用 Eureka 服务器完成查找，因此无需处理服务地点的任何更改和处理。

Eureka相当于一个服务目录；

 

## 6.简单谈一下微服务架构如何设计？

微服务设计有4大原则：

AKF拆分原则：通过加机器可以解决容量和可用性问题

前后端分离

无状态服务

Restful通信风格

 

## 7.使用Hystrix断路器的参数配置？

**熔断器相关：**

1.熔断器在整个统计时间内是否开启的阀值，默认20。也就是在该参数（默认10s）内至少请求20次，熔断器才发挥起作用  

​     circuitBreakerRequestVolumeThreshold;  

2.默认:50%。当出错率超过50%后熔断器启动

​     circuitBreakerErrorThresholdPercentage; 

3.熔断时间窗口，默认:5秒.熔断器中断请求5秒后会进入半打开状态,放下一个请求进来重试，如果该请求成功就关闭熔断器，否则继续等待一个熔断时间窗口

​     circuitBreakerSleepWindowInMilliseconds; 

4.是否启用熔断器,默认true. 启动  

​     circuitBreakerEnabled; 

 

5.是否强制开启熔断器阻断所有请求,默认:false,不开启。置为true时，所有请求都将被拒绝 

​     circuitBreakerForceOpen;

6.是否允许熔断器忽略错误,默认false, 不开启  

​     circuitBreakerForceClosed; 

 

**线程池相关：**

1.该参数用来设置执行命令线程池的核心线程数，该值也是命令执行的最大并发量。10

​     coreSize

2.该参数用来设置线程池的最大队列大小。30

​     maximumSize

3.配置线程值等待队列长度,默认值:-1 建议值:-1表示不等待直接拒绝,测试表明线程池使用直接决绝策略+ 合适大小的非回缩线程池效率最高.所以不建议修改此值。

​     maxQueueSize

4.用来为队列设置拒绝阈值。通过该参数，即使队列没有达到最大值也能拒绝请求。 -1

​     queueSizeRejectionThreshold

## 8.说一下SpringCloud使用分布式配置中心？

1.使用zookeeper分布式配置中心

引入zk和使用zk框架curator的依赖；

定义配置类，其中配置zk的地址和初始化的方法；

从zk中读取数据进入map中，再封装返回出去给应用调用；

自动刷新：在配置类中，使用一个监听器watcher来监听各种事件来做相应的变化，比如子节点变更、新增、删除等

 

2.使用springcloud的配置中心-SpringCloudConfig

构建一个配置服务器的SpringBoot工程使用GitHub作为配置；

导入spring-cloud-starter-config的依赖，再配置git的地址（使用profiles可以指定环境），启动类要加@EnableConfigServer注解

使用配置的客户端也要spring-cloud-starter-config依赖

在客户端的bootstrap.yml 文件指定配置服务器的地址、分支、资源、profiles

自动刷新：客户端需要将@RefreshScope添加在需要刷新的配置文件上

​     配置git的webhook，提交是会自动调用/bus/refresh就可以自动刷新（也可以手动POST请求）



3.使用springcloud的配置中心-NacosConfig

现在在使用的配置中心，需要引入nacos-config的依赖；

在Nacos的后台页面上可以进行编辑配置文件(可以选择文件类型，一般都选用yml和properties)，根据dataId和groupId来确定一个配置文件，我们项目里GroupId使用应用名，dataId的命名规范是【应用名-环境.文件类型】（即loan-channel-dev.yml），这里的应用名和环境都需要与application里的名字和环境对应；

springboot启动类上需要加上注解@NacosPropertySource，参数1就是DataId，参数2标识是否自动刷新

然后就可以直接在代码中引用了，和直接配置在application的参数引用一样使用@Value

使用@RefreshScope注解可以进行参数的自动刷新，修饰在类上，一般不允许我们使用；



## 9.Hystrix断路器的状态？

关闭状态（Closed）：断路器关闭，流量可以正常进入

打开/熔断状态（Open）：断路器打开，即`circuit-breaker`熔断状态，拒绝所有流量，走降级逻辑

半开状态（Half-Open）：断路器半开状态，Open状态过一段时间（默认5s）转为此状态来尝试恢复。此状态时：允许**有且仅一个请求**进入，一旦请求成功就关闭断路器。请求失败就到Open状态（这样再过5秒才能转到半开状态）

====================================================================

# 十三. MyBatis模块

## 1.MyBatis 中 #{}和 ${}的区别是什么？

\#{}是预编译处理，${}是字符替换。 

在使用 #{}时，MyBatis 会将 SQL 中的 #{}替换成“?”，配合 PreparedStatement 的 set 方法赋值，这样可以有效的防止 SQL 注入，保证程序的运行安全。

## 2.MyBatis 有几种分页方式？

分页方式：逻辑分页和物理分页。

逻辑分页： 使用 MyBatis 自带的 RowBounds 进行分页，它是一次性查询很多数据，然后在数据中再进行检索。

物理分页： 自己手写 SQL 分页或使用分页插件 PageHelper，去数据库查询指定条数的分页数据的形式。

## 3.RowBounds 是一次性查询全部结果吗？为什么？

RowBounds 表面是在“所有”数据中检索数据，其实并非是一次性查询出所有数据，因为 MyBatis 是对 jdbc 的封装，在 jdbc 驱动中有一个 Fetch Size 的配置，它规定了每次最多从数据库查询多少条数据，假如你要查询更多数据，它会在你执行 next()的时候，去查询更多的数据。就好比你去自动取款机取 10000 元，但取款机每次最多能取 2500 元，所以你要取 4 次才能把钱取完。只是对于 jdbc 来说，当你调用 next()的时候会自动帮你完成查询工作。这样做的好处可以有效的防止内存溢出。

## 4.MyBatis 逻辑分页和物理分页的区别是什么？

逻辑分页是一次性查询很多数据，然后再在结果中检索分页的数据。这样做弊端是需要消耗大量的内存、有内存溢出的风险、对数据库压力较大。

物理分页是从数据库查询指定条数的数据，弥补了一次性全部查出的所有数据的种种缺点，比如需要大量的内存，对数据库查询压力较大等问题。

## 5.MyBatis 是否支持延迟加载？延迟加载的原理是什么？

MyBatis 支持延迟加载，设置 lazyLoadingEnabled=true 即可。

延迟加载的原理的是调用的时候触发加载，而不是在初始化的时候就加载信息。比如调用 a. getB(). getName()，这个时候发现 a. getB() 的值为 null，此时会单独触发事先保存好的关联 B 对象的 SQL，先查询出来 B，然后再调用 a. setB(b)，而这时候再调用 a. getB(). getName() 就有值了，这就是延迟加载的基本原理。

## 6.说一下 MyBatis 的一级缓存和二级缓存？

一级和二级缓存都使基于PerpetualCache 的 HashMap 本地缓存；

一级缓存：放在sqlSession里，默认就有

二级缓存：放在nameSpace里，默认不打开，要开启二级缓存，使用二级缓存属性类需要实现 Serializable 序列化接口(可用来保存对象的状态)。

缓存更新机制：当某一个作用域(一级缓存 Session/二级缓存 Mapper)进行了C/U/D 操作后，默认该作用域下所有 select 中的缓存将被 clear。

## 7.MyBatis 和 hibernate 的区别有哪些？

灵活性：MyBatis 更加灵活，自己可以写 SQL 语句，使用起来比较方便。

可移植性：MyBatis 有很多自己写的 SQL，因为每个数据库的 SQL 可以不相同，所以可移植性比较差。

学习和使用门槛：MyBatis 入门比较简单，使用门槛也更低。

二级缓存：hibernate 拥有更好的二级缓存，它的二级缓存可以自行更换为第三方的二级缓存。

## 8.MyBatis 有哪些执行器（Executor）？

MyBatis 有三种基本的Executor执行器：

SimpleExecutor：每执行一次 update 或 select 就开启一个 Statement 对象，用完立刻关闭 Statement 对象；

ReuseExecutor：执行 update 或 select，以 SQL 作为 key 查找 Statement 对象，存在就使用，不存在就创建，用完后不关闭 Statement 对象，而是放置于 Map 内供下一次使用。简言之，就是重复使用 Statement 对象；

BatchExecutor：执行 update（没有 select，jdbc 批处理不支持 select），将所有 SQL 都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个 Statement 对象，每个 Statement 对象都是 addBatch()完毕后，等待逐一执行 executeBatch()批处理，与 jdbc 批处理相同。

在Mybatis配置文件中，可以指定默认的 ExecutorType 执行器类型，也可以手动给DefaultSqlSessionFactory 的创建 SqlSession 的方法传递 ExecutorType 类型参数。

## 9.MyBatis 分页插件的实现原理是什么？

分页插件的基本原理是使用 MyBatis 提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的 SQL，然后重写 SQL，根据 dialect 方言，添加对应的物理分页语句和物理分页参数。（oracle使用的是ROWNUM 进行分页）

## 10.Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用<resultMap>标签，逐一定义列名和对象属性名之间的映射关系。

第二种是使用sql列的别名功能，将列别名书写为对象属性名，有了列名与属性名的映射关系后，Mybatis通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。

SpringBoot中可以使用map-underscore-to-camel-case: true # 驼峰命名规范属性进行制定包内的实体类的映射。 

 

## 11.Mybatis的Xml 映射文件中，除了常见的 select|insert|update|delete 标 签之外，还有哪些标签？

还有很多其他的标签，加上动态sql的9个标签，

trim|where|set|foreach|if|choose|when|otherwise|bind等

 

## 12.什么是 MyBatis 的接口绑定,有什么好处？

接口映射就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑定,我们直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可以有更加灵活的选

择和设置.

## 13.接口绑定有几种实现方式,分别是怎么实现的?

接口绑定有两种实现方式,一种是通过注解绑定,就是在接口的方法上面加上

@Select@Update 等注解里面包含 Sql 语句来绑定,另外一种就是通过 xml 里面写 SQL 来绑定,在这种情况下,要指定 xml 映射文件里面的 namespace 必须为接口的全路径名.

## 14.什么情况下用注解绑定,什么情况下用 xml 绑定？

当 Sql 语句比较简单时候,用注解绑定；

当 SQL 语句比较复杂时候,用 xml 绑定；

公司规范我们必须使用xml绑定。

 

## 15.MyBatis 实现一对一有几种方式?具体怎么操作的？

有联合查询和嵌套查询

联合查询：几个表联合查询,只查询一次,通过在 resultMap 里面配置association节点配置一对一的类就可以完成;

嵌套查询：先查一个表,根据这个表里面的结果的外键 id,去再另外一个表里面查询数据,也是通过 association 配置,但另外一个表的查询通过 select 属性配置。

在项目中很复杂的SQL时，在SQL允许的情况加，直接在select标签中直接进行多表关联，查询结果作为一个单独的对象建立一个新的实体类来使用。

 

 

## 17.通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应, Dao 的工作原理，是否可以重载？

不能重载，因为通过 Dao 寻找 Xml 对应的 sql 的时候全限名+方法名的保存和寻找策略。接口工作原理为 jdk 动态代理原理，运行时会为 dao 生成 proxy，代理对象会拦截接口方法，去执行对应的 sql 返回数据。

 

## 18.Mybatis 中如何执行批处理？

使用 BatchExecutor 完成批处理。

 

 

## 19.resultType和resultMap 的区别？

1）类的名字和数据库相同时，可以直接设置 resultType 参数为 Pojo 类 

2）若不同，需要设置 resultMap 将结果名字和 Pojo 名字进行转换

## 20.Mybatis的运行原理

1.实例化 SqlSessionFactoryBuilder 构建器；

2.读取解析配置文件mybatis-config.xml，解析结果存放在Configuration对象中；

3.调用构建器的build方法，将Configuration对象传入，创建SqlSessionFactory 工厂（默认使用DefaultSqlSessionFactory）；

4.由SqlSessionFactory 创建SqlSession，由 TransactionFactory 创建 Transaction对象，创建 SqlSession 的执行器 Excutor，将事务和执行器传给DefaultSqlSession进行实例化产生SqlSession；

5.根据SqlSession接口中的 API 完成具体的事务操作，执行SQL语句，根据情况做commit/rollback；

6.关闭SqlSession;

 

## 21.Mybatis的where、set标签应该注意什么？

在使用逻辑语句中使用，因为set多个字段是需要用逗号隔开，且最后一个字段不需要逗号结尾，所以就要使用<set>来写，可以去除最后1个逗号；

同样的，在使用where时，可能有多个条件使用and，这时使用<where>可以去掉第一个条件最前面的and语句；

====================================================================

# 十四. RabbitMQ模块

## 1.RabbitMQ 的使用场景有哪些？

削峰，比如抢购。

延迟信息处理，比如过10分钟后的提醒。

解耦系统，比如发短信提醒。

## 2.RabbitMQ 有哪些重要的角色？

RabbitMQ 中重要的角色有：生产者、消费者和代理：

生产者：消息的创建者，负责创建和推送数据到消息服务器；

消费者：消息的接收方，用于处理数据和确认消息；

代理：就是 RabbitMQ 本身，用于扮演“快递”的角色，本身不生产消息，只是扮演“快递”的角色。

## 3.RabbitMQ 有哪些重要的组件？

Connection（连接管理器）：应用程序与Rabbit之间建立连接的管理器，程序代码中使用。

Channel（信道）：消息推送使用的通道。

Exchange（交换器）：用于接受、分配消息。

Queue（队列）：用于存储生产者的消息。

Binding（绑定）：用于把交换器的消息绑定到队列上。

## 4.RabbitMQ 中 vhost 的作用是什么？

vhost：每个 RabbitMQ 都能创建很多 vhost，我们称之为虚拟主机，每个虚拟主机其实都是 mini 版的RabbitMQ，它拥有自己的队列，交换器和绑定，拥有自己的权限机制。

## 5.RabbitMQ 的消息是怎么发送的？

首先客户端必须连接到 RabbitMQ 服务器才能发布和消费消息，客户端和 rabbit server 之间会创建一个 tcp 连接，一旦 tcp 打开并通过了认证（认证就是你发送给 rabbit 服务器的用户名和密码），你的客户端和 RabbitMQ 就创建了一条 amqp 信道（channel），信道是创建在“真实” tcp 上的虚拟连接，amqp 命令都是通过信道发送出去的，每个信道都会有一个唯一的 id，不论是发布消息，订阅队列都是通过这个信道完成的。

## 6.RabbitMQ 怎么保证消息的稳定性？

提供了事务的功能。

通过将 channel 设置为 confirm（确认）模式。

## 7.RabbitMQ 怎么避免消息丢失？

把消息持久化磁盘，保证服务器重启消息不丢失。

每个集群中至少有一个物理磁盘，保证消息落入磁盘。

## 8.要保证消息持久化成功的条件有哪些？

声明队列必须设置持久化 durable 设置为 true.

消息推送投递模式必须设置持久化，deliveryMode 设置为 2（持久）。

消息已经到达持久化交换器。

消息已经到达持久化队列。

以上四个条件都满足才能保证消息持久化成功。

## 9.RabbitMQ 持久化有什么缺点？

持久化的缺地就是降低了服务器的吞吐量，因为使用的是磁盘而非内存存储，从而降低了吞吐量。

## 10.RabbitMQ 有几种广播类型？

direct（默认方式）：最基础最简单的模式，发送方把消息发送给订阅方，如果有多个订阅者，默认采取轮询的方式进行消息发送。

headers：与 direct 类似，只是性能很差，此类型几乎用不到。

fanout：分发模式，把消费分发给所有订阅者。

topic：匹配订阅模式，使用正则匹配到消息队列，能匹配到的都能接收到。

## 11.RabbitMQ 怎么实现延迟消息队列？

延迟队列的实现有两种方式：

通过消息过期后进入死信交换器，再由交换器转发到延迟消费队列，实现延迟功能；

使用 RabbitMQ-delayed-message-exchange 插件实现延迟功能。

## 12.RabbitMQ 集群有什么用？

集群主要有以下两个用途：

高可用：某个服务器出现问题，整个 RabbitMQ 还可以继续使用；

高容量：集群可以承载更多的消息量。

## 13.RabbitMQ 节点的类型有哪些？

磁盘节点：消息会存储到磁盘。

内存节点：消息都存储在内存中，重启服务器消息丢失，性能高于磁盘类型。

## 15.RabbitMQ 每个节点是其他节点的完整拷贝吗？为什么？

不是，原因有以下两个：

存储空间的考虑：如果每个节点都拥有所有队列的完全拷贝，这样新增节点不但没有新增存储空间，反而增加了更多的冗余数据；

性能的考虑：如果每条消息都需要完整拷贝到每一个集群节点，那新增节点并没有提升处理消息的能力，最多是保持和单节点相同的性能甚至是更糟。

## 16.RabbitMQ 集群中唯一一个磁盘节点崩溃了会发生什么情况？

如果唯一磁盘的磁盘节点崩溃了，不能进行以下操作：

不能创建队列

不能创建交换器

不能创建绑定

不能添加用户

不能更改权限

不能添加和删除集群节点

唯一磁盘节点崩溃了，集群是可以保持运行的，但你不能更改任何东西。

## 17.RabbitMQ 对集群节点停止顺序有要求吗？

RabbitMQ 对集群的停止的顺序是有要求的，应该先关闭内存节点，最后再关闭磁盘节点。如果顺序恰好相反的话，可能会造成消息的丢失。

 

## 18.RabbitMQ怎么保证消息只被集群消费一次？

从业务角度：业务系统使用锁和幂等的来访来做业务的容错，可以使用数据库和redis；

从消息角度：RabbitMQ的ACK消息确认机制，在消费者执行完成之后，会反馈给MQ，MQ就会将该条消息从队列中剔除，这是默认打开的，但是不保险，也要得在业务上做幂等；

## 19.RabbitMQ的topic模式路由键怎么写？有哪些通配符？

将路由键和某个模式进行匹配，队列需要绑定在一个模式上，使用点.将字符串分隔成单词；

有两种通配符#和\*，#用于匹配1个单词，*用于匹配多个单词

 

## 19.如何保证消息被消费的顺序性？

1.只有一个消费者在监听和消费队列；

2.设置全局顺序标识；

====================================================================

# 十五. Kafka

## 1.kafka 可以脱离 zookeeper 单独使用吗？为什么？

kafka 不能脱离 zookeeper 单独使用，因为 kafka 使用 zookeeper 管理和协调 kafka 的节点服务器。

## 2.kafka 有几种数据保留的策略？

kafka 有两种数据保存策略：按照过期时间保留和按照存储的消息大小保留。

## 3.kafka 同时设置了 7 天和 10G 清除数据，到第五天的时候消息达到了 10G，这个时候 kafka 将如何处理？

这个时候 kafka 会执行数据清除工作，时间和大小不论那个满足条件，都会清空数据。

## 4.什么情况会导致 kafka 运行变慢？

cpu 性能瓶颈

磁盘读写瓶颈

网络瓶颈

## 5.使用 kafka 集群需要注意什么？

集群的数量不是越多越好，最好不要超过 7 个，因为节点越多，消息复制需要的时间就越长，整个群组的吞吐量就越低。

集群数量最好是单数，因为超过一半故障集群就不能用了，设置为单数容错率更高。

 

====================================================================

# 十六. Zookeeper模块

## 1.zookeeper 是什么？

zookeeper 是一个分布式的，开放源码的分布式应用程序协调服务。它是一个为分布式应用提供一致性服务的软件，简单来说就是提供监听通知机制的文件系统。

## 2.zookeeper 都有哪些功能？

集群管理：监控节点存活状态、运行请求等。

分布式锁：zookeeper 提供两种锁：独占锁、共享锁。独占锁即一次只能有一个线程使用资源，共享锁是读锁共享，读写互斥，即可以有多线线程同时读同一个资源，如果要使用写锁也只能有一个线程使用。zookeeper可以对分布式锁进行控制。

命名服务：在分布式系统中，通过使用命名服务，客户端应用能够根据指定名字来获取资源或服务的地址，提供者等信息。

分布式配置中心。

## 3.zookeeper 有几种部署模式？

zookeeper 有三种部署模式：

单机部署：一台集群上运行；

集群部署：多台集群运行；

伪集群部署：一台集群启动多个 zookeeper 实例运行。

## 4.zookeeper 怎么保证主从节点的状态同步？

zookeeper 的核心是原子广播，这个机制保证了各个 server 之间的同步。实现这个机制的协议叫做 zab 协议。 zab 协议有两种模式，分别是恢复模式（选主）和广播模式（同步）。当服务启动或者在领导者崩溃后，zab 就进入了恢复模式，当领导者被选举出来，且大多数 server 完成了和 leader 的状态同步以后，恢复模式就结束了。状态同步保证了 leader 和 server 具有相同的系统状态。

## 5.集群中为什么要有主节点？

在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，所以就需要主节点。

## 6.集群中有 3 台服务器，其中一个节点宕机，这个时候 zookeeper 还可以使用吗？

可以继续使用，单数服务器只要没超过一半的服务器宕机就可以继续使用。

## 7.说一下 zookeeper 的通知机制？

客户端端会对某个 znode 建立一个 watcher 事件，当该 znode 发生变化时，这些客户端会收到 zookeeper 的通知，然后客户端可以根据 znode 变化来做出业务上的改变。

 

====================================================================

# 十七. 数据库模块

## 1.oracle数据库绑定变量？

Oracle执行存在硬解析和软解析；

硬解析：需要经过解析、制定执行路径、优化计划等步骤，耗费CPU，占据重要的闩(latch)资源；

软解析：查询共享缓冲池（shared pool）里有没有完全相同的语句，如果有的话只须执行软分析即可，否则就得进行硬分析；

SQL> variable x number;

SQL> exec :x :=8

SQL> select * from t where id=:x; 

SQL> exec :x :=9

SQL> select * from t where id=:x; 

定义变量，将传入的变量绑定，就可以避免硬解析；

 

## 2.oracle数据库常用的函数？

TO_CHAR：变为字符串类型

TO_NUMBER：变为数字类型

TRIM：去空格

DECODE：判断枚举值，根据值转义另一个值

REPLACE：字符串替换

NVL：判断若为空，则使用其他默认值

 ROUND  函数可将某个数字四舍五入为指定的位数

TRUNC   将数字的小数部分截去，返回整数

## 3.数据库建立主键的方式？

Mysql:可以使用自增主键，AUTO_INCREMENT属性，但是存在最大值限制；

Oracle:使用序列，在业务中一般使用：集群号-机器ID-年月日-序列编号组成32位流水号

在应用中，使用序列产生的唯一流水号，可以在日志、切面中体现，可以在另外地方记录使用。

 

## 4.Mysql数据库怎么搭建主从集群？

整个过程和Redis类似，相当于是Redis的AOF同步模式；

Mysql中有一个bin日志文件(ROW/STATEMENT/MIXED模式)，会记录所有修改的SQL语句，主从复制实质上就是将主节点语句放在从节点上执行一次；

配置过程：

主节点启用bin日志文件；

主节点设置全局唯一的server_id；

主节点上创建有复制权限的用户给从节点使用；

重启主节点；

从节点设置全局唯一的server_id；

从节点执行命令将从节点绑定主主节点（change master to指令要指定bin文件名）；

重启从节点；

这样就搭建好主从集群可以进行主从复制了

Msql的主从复制是异步复制，即主节点写入成功立即响应，再异步发起同步，所以从节点数据会落后于主节点；

 

 

 

 

## 5.Mysql怎么实现读写分离和分库分表？

### 使用mycat中间件

作为中间件独立部署，应用连接的是mycat而不是真实的数据库；核心的配置文件有:

server.xml：记录参数，设置提供给外部的虚拟数据库账号；

schema.xml：物理数据里配置信息；

​     读写分离：配置dataNode，一个dataNode对应一个dataHost，一个dataHost中就可以配置读写分离节点，写节点配置在writeHost读节点是属于写节点的子标签readHost；dataHost配置中核心参数是balance负载均衡策略(0不读写分离1读写分离)，writeType写入方式(0默认不建议改)，就设置好读写分离了；

​     分库分表：在读写分离基础上，配置多个dataNode，还需要配置table标签，可以设置dataNode，主键和分库策略，指定分库策略后再在rule.xml配置；

rule.xml：分片规则的配置文件。

​     分库策略在这里指定，取余算法mod-long，日期范围算法rang-long；     

### 使用sharding-jdbc

使用mycat中间件在分布式中，也需要高可用，就需要搭建集群，消耗很大。

sharding-jdbc以jar包的形式提供轻量级服务，个人认为是如今最好的方式；

只需要引入sharding的jar包进行配置即可；

就是在yml文件中，配置多个分库的数据源(用户名密码地址和驱动)，再配置

分库策略

default-database-strategy.inline.sharding-column

default-database-strategy.inline.algorithm-expression=db$->{id % 3}

分表策略

table-strategy.inline.sharding-column=count

table-strategy.inline.algorithm-expression=book_$->{count % 3}

具体的策略还是需要查看帮助文档；

而实现读写分离只需要在上述的yml文件中，指定数据源时，配置一个master一个slave，和mysql集群内部的主从一致就行，再配置读写分离的均衡算法就可以了，数据源完全由sharding-jbdc托管，写走主，读走从。

 

## 6.说一下 ACID 是什么？

Atomicity（原子性）：事务不可分割、不可约简。

Consistency（一致性）：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。

Isolation（隔离性）

Durability（持久性） 

 

## 7.MySQL 索引是怎么实现的？

帮助数据库高效获取数据的一种已排序好的数据结构。

目前主流引擎的索引都是 B+树实现的，搜索效率可以到达二分法的性能，查找数据区域后再往下查找子节点的数据区域，直到最后的叶节点上会储存数据；

InnoDB引擎储存的是完整的数据；

MyIASM引擎储存的数据的地址，再去数据文件中查找；

 

## 8.说一下 MySQL 常用的引擎？

**InnoDB** **引擎：**聚集引擎，提供了对数据库 acid 事务的支持，它的设计的目标就是处理大数据容量的数据库系统。不会保存表的行数，count(*)时会扫描全表。由于锁的粒度小，写操作是不会锁定全表的,所以在并发度较高的场景下使用会提升效率的。可以快速通过bin-log进行恢复；

**MyIASM** **引擎**：非聚集引擎，MySQL 的默认引擎，但不提供事务的支持。执行写操作的时候需要锁定表，所以效率会低。MyIASM 引擎是保存了表的行数，count(*)可以直接的读取。所以读操作远多于写操作时可以将 MyIASM 作为数据库引擎的首选。不能主动恢复数据。

所以InnoDB支持表锁和行锁，而MyIASM只支持表锁；

 

## 9.一张自增表里面总共有 7 条数据，删除了最后 2 条数据，重启 MySQL 数据库，又插入了一条数据，此时 id 是几？

表类型如果是 MyISAM ，那 id 就是 8。

表类型如果是 InnoDB，那 id 就是 6。

InnoDB 表只会把自增主键的最大 id 记录在内存中，所以重启之后会导致最大 id 丢失。

## 10.char 和 varchar 的区别是什么？

char(n) ：固定长度类型，空间永远是n，不足的补齐空字符串； 

varchar(n) ：可变长度，储存的值就是真实的长度。

所以，从空间上考虑 varchar 比较合适；从效率上考虑 char 比较合适，一般使用varchar，储存固定长度比如身份证密文、手机号、密钥时可以用char，效率高； 

## 11.如何做 MySQL 的性能优化？

从SQL语句层面： 

\1.    根据查询字段建立合适的索引，null不能做索引，离散度不高的不能做索引；

\2.    不能查找*，计算使用count(主键)或者count(*)，是否存在使用exists/limit=1；

\3.    选择正确的引擎；

\4.    索引字段不能做计算，计算后不能走索引；

\5.    前导模糊查询走索引，后导模糊查询不走，模糊查询使用_比%好；

\6.    联合索引需要走最左边的才走索引；

从数据库层面：

\1.    做分区键；

\2.    搭建主从集群；

\3.    实现读写分离；

\4.    实现分库分表；

 

## 12.Mysql的int和bigint字段有多少位长度？

Int支持的长度是10位，bigint长度是19位；

同时插入一个大于这个长度的数字不会报错，只是入表中只有19位支持的最大数字；

 

## 13.简述Mysql中的乐观锁和悲观锁？

​     Mysql中乐观锁和悲观锁是人为定义的，和行锁和表锁不是一个概念，其实和多线程并发中的锁概念一样。

​     乐观锁就是每次修改时，都认为别人不会改这个数据，每次修改都会带原状态去更新，如果更新不到则就报错；

​     悲观锁就是每次修改时，都认为别人一定会改这个数据，每次都会先带for update去进行查询，再去进行修改；

​     在和包贷中，一般一起用，比如一笔订单防止重复处理，查询时先for update锁住（悲观锁），再带着原状态修改为新的中间状态（乐观锁），再手工做一次事务的提交，并发的后一个事务修改时，就会报错因为原状态已改变而报错；

 

## 14.为什么Mysql推荐用自增列主键？

1.数据本身是放在B+Tree的叶节点上，B+Tree的小部分也看起来是二叉树，每个节点中的数据也需要递增排列，用数字排序的效率肯定要比用字符串高；

2.使用自增主键，每次插记录都会在当前索引点往后加一笔记录，如果使用随机主键，这样会随机分配空间，这样也会导致其他数据的移动造成的损耗，特别是存在分页时，可能要面临将前一页数据清除再写在后一页中；

 

## 15.为什么索引能提高效率？

索引的储存是有序的；

使用B+TREE储存，极端情况下的查询效率也会趋近于二分法效率；

 

## 16.数据库怎么进行分区键？

表分区 partition，在和包中一般使用日期范围进行分区键处理

create table order ( order_id int, order_date char(8) )engine innodb

 partition by range(order_date) (

  partition p1 values less than ('20200801'), 

  partition p2 values less than ('20200901'), 

  partition p3 values less than ('20201001'), 

  partition p4 values less than MAXVALUE    //其他在p4

 );

这个就需要DBA到某个日期后做往后的分区处理

## 17.什么是覆盖索引？

是指一个查询语句，只从执行的索引中就能获得查询的字段，不必从表中读取；

 

====================================================================

# 十八. Redis模块

## 1.Redis 是什么？都有哪些使用场景？

Redis 是一个高速缓存数据库，redis是一个key-value存储系统。

Redis 是一个高性能的key-value数据库。 redis的出现，在部分场合可以对关系数据库起到很好的补充作用。

 

## 2.Redis 有哪些功能？

数据缓存功能

分布式锁的功能

支持数据持久化

支持事务

支持消息队列

## 3.Redis 和 memcache 有什么区别？

存储方式不同：memcache 把数据全部存在内存之中，断电后会挂掉，数据不能超过内存大小；Redis 有部份存在硬盘上，这样能保证数据的持久性。

数据支持类型：memcache 对数据类型支持相对简单；Redis 有复杂的数据类型。

value 值大小不同：Redis 最大可以达到 1gb；memcache 只有 1mb。

## 4.Redis 为什么是单线程的？

因为 cpu 不是 Redis 的瓶颈，Redis 的瓶颈最有可能是机器内存或者网络带宽。既然单线程容易实现，而且 cpu 又不会成为瓶颈，那就顺理成章地采用单线程的方案了。

## 5.什么是缓存穿透？怎么解决？

缓存穿透：指查询一个一定不存在的数据，由于缓存是不命中时需要从数据库查询，查不到数据则不写入缓存，这将导致这个不存在的数据每次请求都要到数据库去查询，造成缓存穿透。

解决方案：最简单粗暴的方法如果一个查询返回的数据为空（不管是数据不存在，还是系统故障），我们就把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。

## 6.Redis 支持的数据类型有哪些？

Redis 支持的数据类型：string（字符串）、list（列表）、hash（字典）、set（集合）、zset（有序集合）。

## 185.Redis 支持的 Java 客户端都有哪些？

支持的 Java 客户端有 Redisson、jedis、lettuce 等。

## 7.jedis 和 Redisson 有哪些区别？

jedis：提供了比较全面的 Redis 命令的支持。

Redisson：实现了分布式和可扩展的 Java 数据结构，与 jedis 相比 Redisson 的功能相对简单，不支持排序、事务、管道、分区等 Redis 特性。

## 8.怎么保证缓存和数据库数据的一致性？

合理设置缓存的过期时间。

新增、更改、删除数据库操作时同步更新 Redis，可以使用事物机制来保证数据的一致性。

## 9.Redis 持久化有几种方式？

Redis 的持久化有两种方式，或者说有两种策略：

RDB（Redis Database）：指定的时间间隔能对你的数据进行快照存储。

AOF（Append Only File）：每一个收到的写命令都通过write函数追加到文件中。

## 10.Redis 怎么实现分布式锁？

原始方式：使用 setnx指令，只允许被一个程序占有，使用完调用 del 释放锁。

正确姿势：使用redisson客户端工具非常好，redisson中封装了加锁lock、解锁unlock、尝试获取锁tryLock的方法；

redisson内部提供一个监控锁的看门狗机制后台线程， 每10s检查一次锁状态，通过Config.lockWatchdogTimeout 修改，加锁默认时间是30s，如果加锁的业务没有执行完，那么到了20s的时候就会续期，将锁重置为30s；

异常情况处理，在异常的fannly中也调用解锁；

## 13.Redis 的哨兵机制和选举机制？

哨兵机制Sentinel是一个单独的线程，检测Master状态，并且当主异常时，能调换主和从，修改配置文件，哨兵集群至少3节点；选举步骤有：

**故障节点主观下线**

哨兵节点定时对主发送心跳包，规定时间未返回则认为节点主观下线（主观下线!=异常）

**故障节点客观下线**

该哨兵节点询问其他哨兵节点，如果哨兵集群中超过规定数量的哨兵认为主观下线，则该节点客观下线

**Sentinel****集群选举Leader**

当确认主节点客观下线后，请求其他哨兵将自己选举为Leader，当选举的票数大于（集群/2+1）后，该哨兵被选举为Leader

**Sentinel Leader****决定新主节点**

Leader选择一个redis节点成为主

过滤故障节点--->>优先级(slave-priority)最高节点--->>复制数据量(数据偏移量)最大的节点--->>每次启动唯一标识(runid)最小的节点

 

## 14.Redis中hash、list和set数据类型的用途？

Hah用在：储存省市区信息的，比如全国包含很多省份，每个省份又包含市，名称和编码都会存在hsh中；

List用在：和包贷项目里是用在一些配置上，某些展示是有生效失效时间的，将配置信息存在list中，然后拿当前时间查找范围内的配置就可以查出这个时间段的信息；当然一般其他的场景是排行榜，定时触发去更新排行榜放入redis的list中；

Set用在：和包贷中用的较少，一般在可能认识的人、共同好友的场景下，黑名单白名单也可以用set的sismember指令；

====================================================================

# 十九. JVM模块

## 1.说一下 JVM 的主要组成部分？及其作用？

类加载器（ClassLoader）

运行时数据区（Runtime Data Area）

执行引擎（Execution Engine）

本地库接口（Native Interface）

组件的作用： 首先通过类加载器会把 Java 代码转换成字节码，运行时数据区再把字节码加载到内存中，而字节码文件只是 JVM 的一套指令集规范，并不能直接交个底层操作系统去执行，因此需要执行引擎，将字节码翻译成底层系统指令，再交由 CPU 去执行，而这个过程中需要调用本地库接口实现整个程序的功能。

## 2.说一下 JVM 运行时数据区？

程序计数器（Program Counter Register）

Java 虚拟机栈（Java Virtual Machine Stacks）

本地方法栈（Native Method Stack）

Java 堆（Java Heap）

方法区（Methed Area）

## 3.说一下堆栈的区别？

功能方面：堆是用来存放对象的，栈是用来执行程序的。

共享性：堆是线程共享的，栈是线程私有的。

空间大小：堆大小远远大于栈。

## 4.队列和栈是什么？有什么区别？

队列和栈都是被用来预存储数据的。

队列允许先进先出检索元素，但也有例外的情况，Deque 接口允许从两端检索元素。

栈和队列很相似，但它运行对元素进行后进先出进行检索。

## 5.什么是双亲委派模型？

双亲委派模型：如果一个类加载器收到了类加载的请求，它首先不会自己去加载这个类，而是把这个请求委派给父类加载器去完成，每一层的类加载器都是如此，这样所有的加载请求都会被传送到顶层的启动类加载器中，只有当父加载无法完成加载请求（它的搜索范围中没找到所需的类）时，子加载器才会尝试去加载类。

## 6.说一下类装载的执行过程？

类装载分为以下 5 个步骤：

加载：根据查找路径找到相应的 class 文件然后导入；

检查：检查加载的 class 文件的正确性；

准备：给类中的静态变量分配内存空间；

解析：虚拟机将常量池中的符号引用替换成直接引用的过程。符号引用就理解为一个标示，而在直接引用直接指向内存中的地址；

初始化：对静态变量和静态代码块执行初始化工作。

## 7.怎么判断对象是否可以被回收？

引用计数器：为每个对象创建一个引用计数，有对象引用时计数器 +1，引用被释放时计数 -1，当计数器为 0 时就可以被回收。它有一个缺点不能解决循环引用的问题；

可达性分析：从 GC Roots 开始向下搜索，搜索所走过的路径称为引用链。当一个对象到 GC Roots 没有任何引用链相连时，则证明此对象是不可达的。作为GCRoots的对象一般是，方法区、虚拟栈中引用的对象。

## 8.Java 中都有哪些引用类型？

强引用：发生 gc 的时候不会被回收。

软引用：有用但不是必须的对象，在发生内存溢出之前会被回收。

弱引用：有用但不是必须的对象，在下一次GC时会被回收。

虚引用：无法通过虚引用获得对象，用 PhantomReference 现虚引用，虚引用的用途是在 gc 时返回一个通知。

## 9.说一下 JVM 有哪些垃圾回收算法？

标记-清除算法：标记无用对象，然后进行清除回收。缺点：效率不高，无法清除垃圾碎片。

标记-整理算法：标记无用对象，让所有存活的对象都向一端移动，然后直接清除掉端边界以外的内存。

复制算法：按照容量划分二个大小相等的内存区域，当一块用完的时候将活着的对象复制到另一块上，然后再把已使用的内存空间一次清理掉。缺点：内存使用率不高，只有原来的一半。

分代算法：根据对象存活周期的不同将内存划分为几块，一般是新生代和老年代，新生代基本采用复制算法，老年代采用标记整理算法。

## 10.说一下 JVM 有哪些垃圾回收器？

CMS：一种以获得最短停顿时间为目标的收集器，非常适用 B/S 系统。

G1：一种兼顾吞吐量和停顿时间的 GC 实现，是 JDK 9 以后的默认 GC 选项。

## 11.说一下 JVM 调优的工具？

JDK 自带了很多监控工具，都位于 JDK 的 bin 目录下，其中最常用的是 jconsole 和 jvisualvm 这两款视图监控工具。

jconsole：用于对 JVM 中的内存、线程和类等进行监控；

jvisualvm：JDK 自带的全能分析工具，可以分析：内存快照、线程快照、程序死锁、监控内存的变化、gc 变化等。

## 12.常用的 JVM 调优的参数都有哪些？

-Xms2g：初始化推大小为 2g；

-Xmx2g：堆最大内存为 2g；

-XX:NewRatio=3：设置年轻的和老年代的内存比例为 1:3（接入网关机器设置2:1）；

-XX:SurvivorRatio=8：设置新生代 Eden 和 Survivor 比例为 8:2；

-XX:+UseConcMarkSweepGC：指定使用 CMS + Serial Old 垃圾回收器组合；

-XX:+PreBlockSpin：用来指定自旋锁的自旋次数

-XX:-UseBiasedLocking：关闭偏向锁，大并发的情况下，关闭偏向锁会效率更高

-XX:+PretenureSizeThreshold：设置多大内存的对象直接进入老年代

 

在项目中设置堆内存大小是物理内存的1/4，批量机器32G内存就设置8G的对内存，

平常普通的机器中一般物理内存是4G，堆内存设置是1G，初始化和最大内存应该设置成一样的，不一样会造成内存收缩，物理机内存不是瓶颈，向底层系统申请内存的过程需要时间与IO；

## 13.有哪些类加载器？

启动类加载器：负责加载JAVAHOME/lib目录中

扩展类加载器：负责加载JAVAHOME/lib/ext目录中

应用程序类加载器：负责加载用户路径classpath的类

 

# 二十.hibernate模块

113.为什么要使用 hibernate？

hibernate 是对 jdbc 的封装，大大简化了数据访问层的繁琐的重复性代码。

hibernate 是一个优秀的 ORM 实现，很多程度上简化了 DAO 层的编码功能。

可以很方便的进行数据库的移植工作。

提供了缓存机制，是程序执行更改的高效。

114.什么是 ORM 框架？

ORM（Object Relation Mapping）对象关系映射，是把数据库中的关系数据映射成为程序中的对象。

使用 ORM 的优点：提高了开发效率降低了开发成本、开发更简单更对象化、可移植更强。

115.hibernate 中如何在控制台查看打印的 SQL 语句？

在 Config 里面把 hibernate. show_SQL 设置为 true 就可以。但不建议开启，开启之后会降低程序的运行效率。

116.hibernate 有几种查询方式？

三种：hql、原生 SQL、条件查询 Criteria。

117.hibernate 实体类可以被定义为 final 吗？

实体类可以定义为 final 类，但这样的话就不能使用 hibernate 代理模式下的延迟关联提供性能了，所以不建议定义实体类为 final。

118.在 hibernate 中使用 Integer 和 int 做映射有什么区别？

Integer 类型为对象，它的值允许为 null，而 int 属于基础数据类型，值不能为 null。

119.hibernate 是如何工作的？

读取并解析配置文件。

读取并解析映射文件，创建 SessionFactory。

打开 Session。

创建事务。

进行持久化操作。

提交事务。

关闭 Session。

关闭 SessionFactory。

120.get()和 load()的区别？

数据查询时，没有 OID 指定的对象，get() 返回 null；load() 返回一个代理对象。

load()支持延迟加载；get() 不支持延迟加载。

121.说一下 hibernate 的缓存机制？

hibernate 常用的缓存有一级缓存和二级缓存：

一级缓存：也叫 Session 缓存，只在 Session 作用范围内有效，不需要用户干涉，由 hibernate 自身维护，可以通过：evict(object)清除 object 的缓存；clear()清除一级缓存中的所有缓存；flush()刷出缓存；

二级缓存：应用级别的缓存，在所有 Session 中都有效，支持配置第三方的缓存，如：EhCache。

122.hibernate 对象有哪些状态？

临时/瞬时状态：直接 new 出来的对象，该对象还没被持久化（没保存在数据库中），不受 Session 管理。

持久化状态：当调用 Session 的 save/saveOrupdate/get/load/list 等方法的时候，对象就是持久化状态。

游离状态：Session 关闭之后对象就是游离状态。

123.在 hibernate 中 getCurrentSession 和 openSession 的区别是什么？

getCurrentSession 会绑定当前线程，而 openSession 则不会。

getCurrentSession 事务是 Spring 控制的，并且不需要手动关闭，而 openSession 需要我们自己手动开启和提交事务。

124.hibernate 实体类必须要有无参构造函数吗？为什么？

hibernate 中每个实体类必须提供一个无参构造函数，因为 hibernate 框架要使用 reflection api，通过调用 ClassnewInstance() 来创建实体类的实例，如果没有无参的构造函数就会抛出异常。

 

# 二十一.运维支撑Linux模块

## 1. CPU飙升时，使用的命令？

**top** : 定位CPU最高的进程

**top -Hp pid** : 定位使用CPU最高的线程

**printf '0x%x' tid** ： 线程 id 转化 16 进制

**jstack pid | grep tid** ： 找到线程堆栈

拿到线程时就可以从业务层面分析CPU飙升的原因

 

## 2. CPU的占用率很高一般是什么原因造成？

死循环

死锁

计算密集

IO读写太高

## 3. 常用的运维查询命令

**grep/zgrep****命令**

grep -l  搜索包含关键字的文件名

grep -r  搜索包含关键字的文件明细行，并且显示文件名

grep -w 搜索包含关键字的文件内容，将改行全部显示出来

grep -v  搜索所有的内容中，不包含内容关键字的内容

grep -i  查找时，不区分大小写

多个关键字时使用管道符 |，表示上一个命令的输出作为下一个命令的参数

 

**more/less/vi**

打开某个文件时，使用more/less/vi，一般使用Less，因为可以前后移动(more只能向前)

用Less打开的文件可以进行向上向下搜索

使用管道符 |less 可以在查询结果中用Less打开，方便搜索关键信息

 

**find/xagrs**

find命令把匹配到的文件传递给xargs命令，而xargs命令每次只获取一部分文件而不是全部

查询所有的文件中，再查询包含xargs内容的文件

 

**wc**

可以统计文件的字节数、字数、行数

-c 统计字节数

-l 统计行数

-w 统计字数

 

**tail**

使用tail -f 可以一直监控文件内容的变化，将最新的信息打印出来，前台启动Tomcat时

 

**ps -ef|grep xxx**

查询关键字所属的进程，以及进程信息

 

**df -h**

查看磁盘各分区的内存情况

 

## 4. 后台启动的命令

后台启动tomcat为例：

​     nohup ./startup.sh &

​     (1) nohup 加在一个命令的最前面，表示不挂断的运行命令

​     (2) &加载一个命令的最后面，表示这个命令放在后台执行

# 二十二.业务模块

## 1.前端和后台是如何调用的？

前后端分离的架构，前后端通讯是使用Restful风格的API接口，使用https进行访问的；

在进行访问时，报文做了MDV5加密、RSA的签名验签。

 

## 2.介绍一下自己最熟悉的业务模块？

用户授信下单模块：

用户进入到信用购机页面时，前端调用后台提供的地址，使用ngnix做了负载均衡，再调用页面查询服务，内部服务是使用SpringCloud的Eureka注册中心，使用了Feign+Ribon做了内部的负载均衡和服务调用，根据用户进入渠道（比如和包客户端、京东商城）和归属省份展示不同的信息，这里调用了用户中心服务，从Redis中获取用户号段的归属省份，然后再根据信息，从Redis中查询到配置的展示信息；

再进行下单确认的时候，会调用确认订单服务，通过统一接入网关调用支付的冻结接口，调用gateway统一接出网关，并且做了熔断机制；为了防止操作异常的情况，使用了Redis应用锁防止并发，保证订单只能操作一次，调用后需要更新数据库的信息，使用的mybatis框架进行的数据库访问，在冻结成功后，需要下发短信和推送微信，使用了消息队列rabbitMq进行处理；

在服务切面里使用slf4j进行日志打印，也使用了@ControllerAdvice 注解来封装的全局异常和一些自定义的异常；



## 3.你在项目中使用的消息中间件是什么？为什么使用？

**和包项目中使用的中间件是RabbitMQ和Kafka**
RabbitMQ是多个团队公共使用的，用来发账单提醒短信、邮件和推送的。
Kafka是用来做日志收集和某些特定的大量的外部请求的（比如扣款）。
后期允许可能会使用RocketMQ来替换外部请求的Kafka，Java语言写的更加可靠，稳定性也更好。

**军融公共平台项目中使用中间件RabbitMQ**
项目中发现新闻、技术产品等上报服务在某个时间点（外部调用）特别频繁，所以使用消息中间件来解决。
技术选型还是使用了熟悉的rabbitMQ，天然的集群化和管理页面、社区活跃度也高，但是不利于二次开发。
当时考虑要不要使用RocketMQ，但是数据量并没有那么大所以还是选用了功能完备的rabbitMQ



## 二十三.面试常问问题 

 面试业务

#### **和包项目中使用的中间件是RabbitMQ和Kafka**

RabbitMQ是多个团队公共使用的，用来发账单提醒短信、邮件和推送的。
Kafka是用来做日志收集和某些特定的大量的外部请求的（比如扣款）。
后期允许可能会使用RocketMQ来替换外部请求的Kafka，Java语言写的更加可靠，稳定性也更好。

#### 介绍一下自己最熟悉的业务模块？

- 用户授信下单模块：


用户进入到信用购机页面时，前端调用后台提供的地址，使用ngnix做了负载均衡，再调用页面查询服务，内部服务是使用SpringCloud的Eureka注册中心，使用了Feign+Ribon做了内部的负载均衡和服务调用，根据用户进入渠道（比如和包客户端、京东商城）和归属省份展示不同的信息，这里调用了用户中心服务，从Redis中获取用户号段的归属省份，然后再根据信息，从Redis中查询到配置的展示信息；

再进行下单确认的时候，会调用确认订单服务，通过统一接入网关调用支付的冻结接口，调用gateway统一接出网关，并且做了熔断机制；为了防止操作异常的情况，使用了Redis应用锁防止并发，保证订单只能操作一次，调用后需要更新数据库的信息，使用的mybatis框架进行的数据库访问，在冻结成功后，需要下发短信和推送微信，使用了消息队列rabbitMq进行处理；

在服务切面里使用slf4j进行日志打印，也使用了@ControllerAdvice 注解来封装的全局异常和一些自定义的异常；

- 门店开商户

  ​		用户进入到门店管理系统界面，前端调用后台提供的地址，使用ngnix做了负载均衡，再调用页面查询服务，内部服务使用的是springColud的Eureka注册中心，这里调用了用户中心服务，从Redis中获取用户号段的归属省份，然后再根据信息，从Redis中查询到配置的展示信息，如果是操作员是门店管理员，可以操作门店信息，完善门店信息的时候，会让用户现在去关联商户还是新开一个商户，如果选择关联商户，可以根据营业执照编号和银行卡号查询对应已开户的商户进行绑定，如果选择新增商户，调用OCR识别营业执照信息和身份证信息，通过调用商户侧预校验接口校验提交信息的准确，并生成一条流水记录，校验失败会直接将流水为失败，并将错误信息返回给前端 ，校验成功后查询审核规则，如果这个省份需要审核则录入审核记录，用户在审核界面查询到自己的审核记录，管理员去进行审核，审核成功会调用商户开户的接口，为防止操作异常的情况，使用了Redis应用锁防止并发，保证只能操作一次，调用后更新流水状态为审核中，如果商户侧实时返回最终结果，调用后处理方法，录入门店信息，如果商户侧未能返回最终结果，则后续通过消息订阅和主动查询获取开户结果，其中使用流水号作为唯一标识去查询结果。

  在服务切面里使用slf4j（色奥佛杰）进行日志打印，也使用了@ControllerAdvice 注解来封装的全局异常和一些自定义的异常；

- 服务费生成

  ​	为应对多个亿级数据表联合查询并计算而做的处理

####   1.排序算法

链接：https://www.cnblogs.com/onepixel/articles/7674659.html 动图演示，方便理解

swap使用

```
swap(arrays,i,min) -->(等同于)   int temp=arrays[i];
                      		    arrays[i]=arrays[min];
                      		    arrays[min]=temp;
```

##### 冒泡排序

```java
  //冒泡排序
    private static  int[]  bubbleSort1(int[] arrays ){
        int temp;
        for (int i=0;i<arrays.length-1;i++){
            boolean flag=false;
            for (int j=0;j<arrays.length-1-i;j++){
                if(arrays[j+1]<arrays[j]){
                  swap(arrays,j,j+1)
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        return arrays;
        
    }
```

##### 选择排序

```java
package com.example.demo.basis.arrays;

/*
 * @Author liuxin
 * @Description //TODO 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
    *              存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     *              然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 **/
public class SelectionSort {


    public static void main(String[] args) {

        int[] arrays=new int[10];
        int[] arrays1={1,6,9,44,5,5};
        for (int i=0;i< arrays.length;i++){
            arrays[i]=i;
        }
        // printArrays(bubbleSort(arrays1));
       ArrayDemo1.printArrays(SelectionSort(arrays1));

    }
    
    public static int[] SelectionSort(int[] arrays) {
        int n = arrays.length;
        int temp;
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }
            temp = arrays[i];
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
        return arrays;
    }
}

```

##### 插入排序

```
package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

/*
 * @Author liuxin
 * @Description //TODO 插入排序 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 **/
/**
 算法描述

 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

 从第一个元素开始，该元素可以认为已经被排序；
 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 将新元素插入到该位置后；
 重复步骤2~5。

 **/
public class InsertionSort {


    public static void main(String[] args) {

        int[] arrays=new int[10];
        int[] arrays1={1,6,9,44,5,5};
        sort(arrays1);
        ArrayDemo1.printArrays(arrays1);

    }
    

//插入排序
    private static void sort(int[] arrays) {
        int n = arrays.length;
        //
        int preIndex, current;

        for (int i = 1; i < n; i++) {
            preIndex = i - 1;
            current = arrays[i];
            while (preIndex >= 0 && arrays[preIndex] > current) {
                arrays[preIndex + 1] = arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex + 1] = current;
        }


    }
}

```

##### 希尔排序

```
package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;
import lombok.experimental.var;

import static org.apache.ibatis.ognl.OgnlOps.less;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/*
 * @Author liuxin
 * @Description //TODO 希尔排序
 **/
/**算法描述

 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 按增量序列个数k，对序列进行k 趟排序；
 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arrays1={1,6,9,44,5,5};
        sort(arrays1,2);
        ArrayDemo1.printArrays(arrays1);
    }
    private static void sort(int[] nums,int n){
        int N = nums.length;
        int gap = 1;

        while (gap < N / n){
            gap = n * gap + 1;
        }
        while (gap >= 1){
            for (int i = gap;i < N ; i ++){
                for (int j = i;j >= gap && less(nums[j],nums[j - gap]);j -= gap){
                    swap(nums,j,j-gap);
                }
            }
            gap = gap/ n;
        }
    }

}

```

##### 快速排序

```
package com.example.demo.basis.sortingalgorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

import static org.apache.ibatis.ognl.OgnlOps.less;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/*
 * @Author liuxin
 * @Description //TODO 快速排序
 **/
/**算法描述

 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

 从数列中挑出一个元素，称为 “基准”（pivot）；
 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序*/
public class QuickSort {


    public static void main(String[] args) {
        int[] arrays1={1,6,9,44,5,5};
        quick_sort(arrays1,0,arrays1.length-1);
        ArrayDemo1.printArrays(arrays1);
    }

    static void quick_sort(int arr[],int left,int right) {
        // 左游标大于等于右游标
        if (left >= right) {
            return;
        }
        // 左游标
        int i = left;
        // 右游标
        int j = right + 1;
        // 将最左边的元素，作为分界值（枢纽）
        int key = arr[left];
        while (true) {
            while (arr[++i] < key) {
                if (i == right) {
                    break;
                }
            }
            while (arr[--j] > key) {
                if (j == left) {
                    break;
                }
            }
            // 退出死循环
            if (i >= j) {
                break;
            }
            // 交换左、右游标指向的数
            swap(arr, i, j);
        }
        // 交换左边界值与左游标指向的值
        swap(arr,left,j);
        // 递归处理分界值左边的部分
        quick_sort(arr, left, j - 1);
        // 递归处理分界值右边的部分
        quick_sort(arr, j + 1, right);
    }

}

```







#### 2.Synchronized原理，锁膨胀过程?



（https://mp.weixin.qq.com/s?__biz=MzI3ODA0ODkwNA==&mid=2247483680&idx=1&sn=18a73ea417d299de1a09640d56bd2489&scene=21#wechat_redirect）

#### 3.线程池原理是怎样的?

​		一个线程集合workerSet和一个阻塞队列workQueue。当用户向线程池提交一个任务(也就是线程)时，线程池会先将任务放入workQueue中。workerSet中的线程会不断的从workQueue中获取线程然后执行。当workQueue中没有任务的时候，worker就会阻塞，直到队列中有任务了就取出来继续执行。

（https://mp.weixin.qq.com/s?__biz=MzI3ODA0ODkwNA==&mid=2247484094&idx=1&sn=1b80441305d3ccf68eb122c13c89a9d9&scene=21#wechat_redirect）

使用线程池的好处： 使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。 

#### 4.分布式事务一致性怎么实现?

#### 5.消息乱序遇到过吗?怎么解决的?（门店开户结果信息同步，利用了消息订阅）

​	· 一般消息乱序都是由下游消费方来处理，处理方法是消息中增加版本号、occurTime(业务时间发生时间)来判断消息的先后顺序，然后做对应的业务逻辑，例如，同一业务流水号，从库里面的数据的版本号或occurTime和新消息的版本号和occurTime 比较，版本号更大，时间更靠后的为最新消息，可以做更新操作。 

一般消息中间件都会遇到以下几个问题：

- 消息重复
- 消息并发
- 消息乱序
- 消息延迟
- 消息积压

#### 6.Threadlocal用过吗?实现机制?

#### 7.wait、sleep区别?

​	

```
1、sleep是线程中的方法，但是wait是Object中的方法。

2、sleep方法不会释放lock，但是wait会释放，而且会加入到等待队列中。

3、sleep方法不依赖于同步器synchronized，但是wait需要依赖synchronized关键字。

4、sleep不需要被唤醒（休眠之后退出阻塞），但是wait需要（不指定时间需要被别人中断）。
```



#### 8.反射用过吗?什么原理?

​	反射是 程序可以访问、检测和修改它本身状态或行为的一种能力.使得我们可以在程序运行时动态加载一个类，动态获取类的所有信息,并且进行调用 

 	Java的反射机制原理:在编译并不确定是哪个类被加载了，而是在程序运行的时候,对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性 

​	 功能以及作用 ：

- 在运行时判断任意一个对象所属的类；
- 在运行时构造任意一个类的对象；
- 在运行时判断任意一个类所具有的成员变量和方法；
- 在运行时调用任意一个对象的方法；
- 生成动态代理。

​    使用：可以使用反射获取到自定义注解的内容， 动态代理， Spring的自定义注解 

（https://mp.weixin.qq.com/s?__biz=MzI3ODA0ODkwNA==&mid=2247483957&idx=1&sn=e4dbff3e4b2edcddc39d19135a0d743f&scene=21#wechat_redirect）

#### 9.动态代理了解吗? cglib什么区别

​	

#### 10.单例模式了解吗?实现一个线程安全的单例模式?

 单例模式可以控制单例数量；可以进行有意义的派生；对实例的创建有更自由的控制; 

https://mp.weixin.qq.com/s/dW0L-PoBeTFHhD29HJO0BQ（单例模式解析）

饿汉式：

```java
public class Singleton {
  // 创建一个实例对象
    private static Singleton instance = new Singleton();
    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton(){}
    /**
     * 静态get方法
     */
    public static Singleton getInstance(){
        return instance;
    }
}

```

懒汉式：通过volatile关键字和synchronized实现线程安全

```java
package com.example.demo.oop.singleton;

/*
 * @Author liuxin
 * @Description //TODO 
 **/
public class Singleton {
    //单例模式使用volatile修饰  1.禁止指令重排，2.保证变量可见性
    private volatile static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(instance == null){
            //同步块，线程安全的创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
三问：1.为什么使用volatile 修饰了singleton 引用还用synchronized 锁？
     答：volatile 只保证了共享变量 singleton 的可见性，但是 singleton = new Singleton(); 这个操作	不是原子的，可以分为三步：
    步骤1：在堆内存申请一块内存空间；
    步骤2：初始化申请好的内存空间；
    步骤3：将内存空间的地址赋值给 singleton；
    所以singleton = new Singleton(); 是一个由三步操作组成的复合操作，多线程环境下A 线程执行了第一步、第二步之后发生线程切换，B 线程开始执行第一步、第二步、第三步（因为A 线程singleton 是还没有赋值的），所以为了保障这三个步骤不可中断，可以使用synchronized 在这段代码块上加锁。

     2.第一次检查singleton 为空后为什么内部还需要进行第二次检查？
    A 线程进行判空检查之后开始执行synchronized代码块时发生线程切换(线程切换可能发生在任何时候)，B 线程也进行判空检查，B线程检查 singleton == null 结果为true，也开始执行synchronized代码块，虽然synchronized 会让二个线程串行执行，如果synchronized代码块内部不进行二次判空检查，singleton 可能会初始化二次。
     3.volatile 除了内存可见性，还有别的作用吗？
     volatile 修饰的变量除了可见性，还能防止指令重排序。

```

通过静态内部类实现单例

```
public class Singleton {  
  
    /* 私有构造方法，防止被实例化 */  
    private Singleton() {  
    }  
  
    /* 此处使用一个内部类来维护单例 */  
    private static class SingletonFactory {  
        private static Singleton instance = new Singleton();  
    }  
  
    /* 获取实例 */  
    public static Singleton getInstance() {  
        return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    }  
}  
使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕， 这样我们就不用担心上面的问题。
同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
```

通过枚举实现单例

```
//通过枚举实现单例模式
enum Singletondemo2 {

    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }
    //调用方式
    public static void main(String[] args) {
        Singletondemo2.INSTANCE.doSomething();
    }


}
```

#### 11.无界队列和有界队列? 

-  有界队列：就是有固定大小的队列。比如设定了固定大小的 LinkedBlockingQueue，又或者大小为 0，只是在生产者和消费者中做中转用的 SynchronousQueue。 
-  无界队列：指的是没有设置固定大小的队列。这些队列的特点是可以直接入列，直到溢出。当然现实使用中，几乎不会有到这么大的容量（超过  Integer.MAX_VALUE），所以从使用者的体验上，就相当于 “无界”。比如没有设定固定大小的 LinkedBlockingQueue ， 无界队列的特性：所以无界队列的特点就是可以一直入列，不存在队列满负荷的现象。 



#### 12.AQS知道吗?

#### 13.volatile了解吗?

```
Volatile 关键字的作用是变量在多个线程之间可见。  

防止指令重排序，因为instance = new Singleton()

不是原子操作保证内存可见
```

- 什么时候使用volatile？

 如果需要保证多线程共享变量的可见性时，可以使用volatile 来修饰变量。 

https://mp.weixin.qq.com/s?__biz=MzI3ODA0ODkwNA==&mid=2247483847&idx=1&sn=31e94c25eee7fdd7df3a1707ab02fa79&chksm=eb5db820dc2a3136fdde85beceacb38bc416f21cfbe1dc388ac24d3f8224f1a63ab35ca41b13&cur_album_id=1337196027396407297&scene=190#rd





#### 14.volatile与synchronized区别

仅靠volatile不能保证线程的安全性。（原子性）
①volatile轻量级，只能修饰变量。synchronized重量级，还可修饰方法
②volatile只能保证数据的可见性，不能用来同步，因为多个线程并发访问volatile修饰的变量不会阻塞。
synchronized不仅保证可见性，而且还保证原子性，因为，只有获得了锁的线程才能进入临界区，从而保证临界区中的所有语句都全部执行。多个线程争抢synchronized锁对象时，会出现阻塞。

#### 15.实现一个生产者消费者例子（线程之间的通信问题）

​	**虚假唤醒： 当一个条件满足时，很多线程都被唤醒了，但是只有其中部分是有用的唤醒，其它的唤醒都是无用功1.比如说买货，如果商品本来没有货物，突然进了一件商品，这是所有的线程都被唤醒了   ，但是只能一个人买，所以其他人都是假唤醒，获取不到对象的锁**，在生产者消费者例子中， if块中使用wait方法，是非常危险的，因为一旦线程被唤醒，并得到锁，就不会再判断if条件，而执行if语句块外的代码，产生了虚假唤醒，所以建议，凡是先要做条件判断，再wait的地方，都使用while循环来做 ，原因：

因为if只会执行一次，执行完会接着向下执行if（）外边的
而while不会，直到条件满足才会向下执行while（）外边的

demo1：产生虚假唤醒的例子：

```java
package com.example.demo.basis.pc;

import javax.xml.crypto.Data;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized实现生产者和消费者demo，使用if判断四个线程会导致虚假唤醒
 **/
public class Pcdemo1 {


    public static void main(String[] args) {
        data data=new data();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.increment();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"D").start();
    }
}

///判断等待，业务，通知
class data{
    private int num=0;

    public synchronized void increment()  {
        if(num!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();

    }

    public  synchronized void  decrement()  {
        if(num==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"--->"+num);

        this.notifyAll();
    }
}

```

demo2，避免虚假唤醒的例子：

```
package com.example.demo.basis.pc;

import javax.xml.crypto.Data;

/*
 * @Author liuxin
 * @Description //TODO 使用synchronized实现生产者和消费者demo，
 **/
public class Pcdemo1 {


    public static void main(String[] args) {
        data data=new data();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.increment();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"D").start();
    }
}

///判断等待，业务，通知
class data{
    private int num=0;

    public synchronized void increment()  {
        while (num!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }

    public  synchronized void  decrement()  {
        while(num==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }
}

```

demo3，使用lock实现：

```java
package com.example.demo.basis.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO 使用Lock实现生产者和消费者demo，
 **/
public class PcLockdemo1 {


    public static void main(String[] args) {
        data1 data=new data1();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.increment();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.decrement();
            }
        },"D").start();


    }

}


///判断等待，业务，通知
class data1{
    private int num=0;
    Lock lock=new ReentrantLock();
    Condition condition= lock.newCondition();

    public  void increment()  {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void  decrement()  {
        lock.lock();
        try {
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

```

demo4，实现指定唤醒消费者，使用private Condition conditionC= lock.newCondition();：

```
package com.example.demo.basis.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author liuxin
 * @Description //TODO 使用Lock实现生产者和消费者demo，实现指定唤醒
 **/
public class PcLockConditiondemo2 {


    public static void main(String[] args) {
        DataLock data=new DataLock();
        new Thread(()->{
            for(int i=0;i<40;i++){
              data.A();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                data.B();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                data.C();
            }
        },"C").start();

    }

}


///判断等待，业务，通知
class DataLock{
    private int num=1; //1A  2B 3C
    private   Lock lock=new ReentrantLock();
    private Condition conditionA= lock.newCondition();
    private Condition conditionB= lock.newCondition();
    private Condition conditionC= lock.newCondition();

    public  void A()  {
        lock.lock();
        try {
            while (num!=1){
                conditionA.await();
            }
            num=2;
            System.out.println(Thread.currentThread().getName()+"--->AAAAAAAAAAAAAAAAAAAAAA");
            conditionB.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void  B()  {
        lock.lock();
        try {
            while(num!=2){
                conditionB.await();
            }
            num=3;
            System.out.println(Thread.currentThread().getName()+"--->BBBBBBBBBBBBBBBBBB");
            conditionC.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public  void  C()  {
        lock.lock();
        try {
            while(num!=3){
                conditionC.await();
            }
            num=1;
            System.out.println(Thread.currentThread().getName()+"--->CCCCCCCCCCCCCCCCCCC");
            conditionA.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

```

#### 16.Java内存模型清楚吗?

#### 17.遇到过线上性能问题吗?怎么排查的?

​		1.通过代码返回的错误码定位到

#### 18.三数之和

代码示例：

```java
package com.example.demo.basis.algorithm;

import com.example.demo.basis.arrays.ArrayDemo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author liuxin
 * @Description //TODO 三数之和
 *  给定一个包含n个整数的数组，在数组中是否存在a、b、c元素使得a + b + c = 0?找出数组中所有唯一的三个数组合，它们的和为零。
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [ [-1, 0, 1], [-1, -1, 2]]
 **/
       /* * 解题思路：
         *      首先我们对数组进行排序，然后定义两个指针，
         *      分别指向 当前遍历索引的 下一个 和 数组 最后一个元素的索引位置
         *      在计算的过程当中，我们需要防止重复数字的重复计算。
         */
public class AlgorithmDome {


    public static List<List<Integer>>  threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //判断是否个数是否小于三
        if (nums.length < 3) {
            return lists;
        }
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        //定义一个和为0
        int sum = 0;
        //循环遍历数组，只需要遍历长度-2（nums.length-2）次
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) {
                //如果当前这个数 num > 0 循环结束
                break;
            }
            //防止相同数字重复计算，造成结果相同,结束当前循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //设置边界值  起始 结束
            int begInt = i + 1;
            int endInt = n - 1;
            //循环
            while (begInt < endInt) {
                sum = nums[i] + nums[begInt] + nums[endInt];
                //如果总和为0，则将其添加至list中
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[begInt], nums[endInt]));
                    //防止相同数字重复计算，造成结果相同
                    while (begInt < endInt && nums[begInt] == nums[begInt + 1]) {
                        begInt++;
                    }
                    //防止相同数字重复计算，造成结果相同
                    while (begInt < endInt && nums[endInt] == nums[endInt - 1]) {
                        endInt--;
                    }
                    begInt++;
                    endInt--;
                } else if (sum < 0) {
                    begInt++;
                } else {
                    endInt--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println("进入程序");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists =threeSum(nums);

        System.out.println("输出的值"+lists);

    }

}

```

#### 19.两数之和

代码示例1：循环遍历

```java
   复杂的分析： 时间复杂度：O(N^2)，其中 NNN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
    空间复杂度：O(1)。
   //l两数之和
    //nums = [2,7,11,15], target = 9
    public static int[] twoSum(int[] nums, int target) {
              int n=nums.length;
              for (int i=0;i<n-1;i++){
                  for (int j=i+1;j<n;j++){
                      if (target==nums[i]+nums[j]) {
                          return new int[]{i,j};
                      }
                  }
              }
        return new int[0];

    }
```

代码示例2：待理解？

```java
  public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
```

#### 20.synchronized锁住的是什么？

​		synchronized本身并不是锁，锁本身是一个对象，synchronized最多相当于“加锁”操作，所以synchronized并不是锁住代码块。Java中的每一个对象都可以作为锁。具体表示有三种形式，

1. 当synchronized作用在实例方法时，监视器锁（monitor）便是对象实例（this）； 
2. 当synchronized作用在静态方法时，监视器锁（monitor）便是对象的Class实例，因为Class数据存在于永久代，因此静态方法锁相当于该类的一个全局锁； 
3. 当synchronized作用在某一个对象实例时，监视器锁（monitor）便是括号括起来的对象实例； 

#### 21.synchronized锁升级的过程？

​		当没有竞争出现时，默认使用偏向锁。JVM会利用CAS操作，在对象头上的Mark  Word部分设置线程ID，以表示这个对象偏向于当前线程，所以并不涉及真正的互斥锁。这样做的假设是基于在很多应用场景中，大部分对象生命周期中最多会被一个线程锁定，使用偏向锁可以降低无竞争开销。

如果有另外的线程试图锁定某个已经被偏向过的对象，JVM就需要撤销（revoke）偏向锁，并切换到轻量级锁实现。轻量级锁依赖 CAS 操作Mark Word来试图获取锁，如果重试成功，就使用轻量级锁；否则在自旋一定次数后进一步升级为重量级锁。

#### 22.为什么说Synchronized是非公平锁，这样的优缺点是什么？

​		**非公平主要表现在获取锁的行为上，并非是按照申请锁的时间前后给等待线程分配锁的，每当锁被释放后，任何一个线程都有机会竞争到锁，这样做的目的是为了提高执行性能，缺点是可能产生线程饥饿现象**（线程饥饿现象：一个线程长时间得不到需要的资源而不能执行的现象，可以 采用队列的方式，保证每个人都有机会获得请求的资源。 当然实现方式可以很多个变化，比如优先级，时间片，等，都是“队列”的特殊形式  ）。

#### 23.为什么说synchronized是一个悲观锁？乐观锁的实现原理又是什么？什么是CAS，它有什么特性？

​		Synchronized显然是一个悲观锁，因为它的并发策略是悲观的：**不管是否会产生竞争，任何的数据都必须加锁、用户态核心态转换、维护锁计数器和检查是否有被阻塞的线程需要被唤醒等操作**。

随着硬件指令集的发展，我们可以使用基于冲突检测的乐观并发策略。先进行操作，如果没有任何其他线程征用数据，那操作就成功了；

如果共享数据有征用，产生了冲突，那就再进行其他的补偿措施。这种乐观的并发策略的许多实现不需要线程挂起，所以被称为非阻塞同步。

乐观锁的核心算法是CAS（Compared And Swap，比较并交换），它涉及到三个操作数：内存值、预期值、新值。当且仅当预期值和内存值相等时才将内存指修改为新值。

这样处理的逻辑是，首先检查某块内存的值是否跟之前读取时的一样，如不一样则表示期间此期望值已经被别的线程更改过，舍弃本次操作，反之则说明期间没有其他线程对此内存进行操作，可以把新值设置给此块内存。

CAS具有原子性，它的原子性由CPU硬件指令实现保证，即使用JNI调用Native方法调用由C++编写的硬件级别指令，JDK中提供了Unsafe类执行这些操作。

#### 24.跟Synchronized相比，可重入锁ReenterLock其实现原理有什么不同？

​		其实，锁的实现原理基本都是为了达到一个目的：让所有线程都能看到某种标记。

Synchronized通过在对象头中设置标志实现这一个目的，是一种JVM原生的锁实现方式；而ReenterLock以及所有基于Lock接口的实现类，都是通过一个volatile修饰的int型变量，并保证每个线程都能拥有对该int值的可见性和原子修改，其本质基于AQS框架实现的。

#### 25.尽可能详细地对比下Synchronized和ReenterLock的异同。

​		ReennterLock是Lock的实现类，是一个互斥的同步锁。从功能角度，ReenterLock比Synchronized的同步操作更精细（因为可以像普通对象一样使用），甚至实现Synchronized没有的高级功能，如：

- 等待可中断：当持有锁的线程长期不释放锁的时候，正在等待的线程可以选择放弃等待，对处理执行时间非常长的同步块很有用。
- 带超时的获取锁尝试：在指定的时间范围内获取锁，如果时间到了仍然无法获取则返回。
- 可以判断是否有线程在排队等待获取锁。
- 可以响应中断请求：与Synchronized不同，当获取到锁的线程被中断时，能够响应中断，中断异常将会被抛出，同时锁会被释放。
- 可以实现公平锁。

从锁释放的角度，Synchronized在JVM层面上实现的，不但可以通过一些监控工具监控Synchronized的锁定，而且在代码执行出现异常时，JVM会自动释放锁定；但是使用Lock则不行，Lock是通过代码实现的，要保证锁一定会被释放，就必须将`unLock()`放到`finall{}`中。

#### 26.二叉树；



#### 27.redis锁；

#### 28.项目中遇到的问题，如何解决的。



#### 29.你对springcloud的理解。

​		

```
SpringCloud是基于SpringBoot的一套实现微服务的框架。它提供了微服务开发所需的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等组件。最重要的是，跟SpringBoot框架一起使用的话，会让你开发微服务架构的云服务非常方便。
SpringCloud五大核心组件

服务注册发现-Netflix Eureka

配置中心 - spring cloud config

负载均衡-Netflix Ribbon

断路器 - Netflix Hystrix

路由(网关) - Netflix Zuul

```

#### 30.LCN框架



#### 31.消息队列



#### 32.设计模式-装饰者模式



#### 33.微服务：

```
	将单一应用程序划分为一组小的服务，每个服务运行在其独立的进程中，
服务直接相互协调，相互配合，为用户提供操作，
服务之间通常采用restful api进行通讯。
微服务优缺点
优点：
1.开发简单，开发效率高，一个服务专心做一件事
2.微服务松耦合
3.每个微服务都有自己的存储能力，可以使用唯一数据库，
也可以使用公共数据库
缺点：
1.运维成本高
2。各服务之间的通讯成本
3.数据的一致性
4.系统集成测试
5.性能监控
```



#### 34.数据库事务  四大特性（ACID）   ：

```
##### ⑴ 原子性（Atomicity）

  	原子性是指事务包含的所有操作要么全部成功，要么全部失败回滚，这和前面两篇博客介绍事务的功能是一样的概念，因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。   

##### ⑵ 一致性（Consistency）

​	一致性是指事务必须使数据库从一个一致性状态变换到另一个一致性状态，也就是说一个事务执行之前和执行之后都必须处于一致性状态。　　拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。

##### ⑶ 隔离性（Isolation）

　隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。　　即要达到这么一种效果：对于任意两个并发的事务T1和T2，在事务T1看来，T2要么在T1开始之前就已经结束，要么在T1结束之后才开始，这样每个事务都感觉不到有其他事务在并发地执行。　　关于事务的隔离性数据库提供了多种隔离级别，稍后会介绍到。

##### ⑷ 持久性（Durability）

​	持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。　　例如我们在使用JDBC操作数据库时，在提交事务方法后，提示用户事务操作完成，当我们程序执行完成直到看到提示后，就可以认定事务以及正确提交，即使这时候数据库出现了问题，也必须要将我们的事务完全执行完成，否则就会造成我们看到提示事务处理完毕，但是数据库因为故障而没有执行事务的重大错误。



##### **1，脏读**　　

​		脏读是指在一个事务处理过程里读取了另一个未提交的事务中的数据。　　当一个事务正在多次修改某个数据，而在这个事务中这多次的修改都还未提交，这时一个并发的事务来访问该数据，就会造成两个事务得到的数据不一致。例如：用户A向用户B转账100元，对应SQL命令如下update account set money=money+**100** where name=’B’; (此时A通知B)
update account set money=money - **100** where name=’A’;　　当只执行第一条SQL时，A通知B查看账户，B发现确实钱已到账（此时即发生了脏读），而之后无论第二条SQL是否执行，只要该事务不提交，则所有操作都将回滚，那么当B以后再次查看账户时就会发现钱其实并没有转。

##### **2，不可重复读**　　

​		不可重复读是指在对于数据库中的某个数据，一个事务范围内多次查询却返回了不同的数据值，这是由于在查询间隔，被另一个事务修改并提交了。　　例如事务T1在读取某一数据，而事务T2立马修改了这个数据并且提交事务给数据库，事务T1再次读取该数据就得到了不同的结果，发送了不可重复读。　　不可重复读和脏读的区别是，脏读是某一事务读取了另一个事务未提交的脏数据，而不可重复读则是读取了前一事务提交的数据。　　在某些情况下，不可重复读并不是问题，比如我们多次查询某个数据当然以最后查询得到的结果为主。但在另一些情况下就有可能发生问题，例如对于同一个数据A和B依次查询就可能不同，A和B就可能打起来了……

##### **3，虚读(幻读)**　　

​		幻读是事务非独立执行时发生的一种现象。例如事务T1对一个表中所有的行的某个数据项做了从“1”修改为“2”的操作，这时事务T2又对这个表中插入了一行数据项，而这个数据项的数值还是为“1”并且提交给数据库。而操作事务T1的用户如果再查看刚刚修改的数据，会发现还有一行没有修改，其实这行是从事务T2中添加的，就好像产生幻觉一样，这就是发生了幻读。　　幻读和不可重复读都是读取了另一条已经提交的事务（这点就脏读不同），所不同的是不可重复读查询的都是同一个数据项，而幻读针对的是一批数据整体（比如数据的个数）。
```



#### 35.数据库隔离

```
① Serializable (串行化)：可避免脏读、不可重复读、幻读的发生。
② Repeatable read (可重复读)：可避免脏读、不可重复读的发生。
③ Read committed (读已提交)：可避免脏读的发生。
④ Read (读未提交)：最低级别，任何情况都无法保证。

  在MySQL数据库中，支持上面四种隔离级别，默认的为Repeatable read (可重复读)；而在Oracle数据库中，只支持Serializable (串行化)级别和Read committed (读已提交)这两种级别，其中默认的为Read committed级别。   
```

#### 36.进程和线程的理解

**（1）进程**

进程是程序的一次执行过程，是一个动态概念，是程序在执行过程中分配和管理资源的基本单位，每一个进程都有一个自己的地址空间，至少有 5 种基本状态，它们是：初始态，执行态，等待状态，就绪状态，终止状态。实际存在6种状态：初始态，执行态，等待状态，超时等待状态，就绪状态，终止状态

**（2）线程**

 线程是CPU调度和分派的基本单位，它可与同属一个进程的其他的线程共享进程所拥有的全部资源。java进程中默认有两个线程 mian线程和GC线程

**（3）联系**

 线程是进程的一部分，一个线程只能属于一个进程，而一个进程可以有多个线程，但至少有一个线程。

**（4）区别：理解它们的差别，我从资源使用的角度出发。（所谓的资源就是计算机里的中央处理器，内存，文件，网络等等）**

根本区别：进程是操作系统资源分配的基本单位，而线程是任务调度和执行的基本单位

在开销方面：每个进程都有独立的代码和数据空间（程序上下文），程序之间的切换会有较大的开销；线程可以看做轻量级的进程，同一类线程共享代码和数据空间，每个线程都有自己独立的运行栈和程序计数器（PC），线程之间切换的开销小。

所处环境：在操作系统中能同时运行多个进程（程序）；而在同一个进程（程序）中有多个线程同时执行（通过CPU调度，在每个时间片中只有一个线程执行）

内存分配方面：系统在运行的时候会为每个进程分配不同的内存空间；而对线程而言，除了CPU外，系统不会为线程分配内存（线程所使用的资源来自其所属进程的资源），线程组之间只能共享资源。

包含关系：没有线程的进程可以看做是单线程的，如果一个进程内有多个线程，则执行过程不是一条线的，而是多条线（线程）共同完成的；线程是进程的一部分，所以线程也被称为轻权进程或者轻量级进程。

（5）java真的可以开启一个线程的，开启不了，调用本地方法，底层的C++，java无法操作硬件

#### 37.并发和并行

- 并发（多个线程操作同一个资源，CPU单核处理器，模拟多个线程，快速交替，感觉是多个线程一起在执行）
- 并行：多个人一起行走，CPU多核，多个线程同时执行；线程池
- **并发编程的本质**：**充分利用CPU的资源**

#### 38.线程有几种状态；6钟状态

```
  public enum State {
        //新生
         NEW,
        //运行
        RUNNABLE,
        //阻塞
        BLOCKED,
        //等待 死死的等
        WAITING,
        //超时等待
        TIMED_WAITING,
         //终止
        TERMINATED;
    }
```

#### 39.wait/sleep的区别

- 来自的类不同 。wait来自object类。sleep来自来自Thread类

- 关于锁的释放,wait会释放锁，sleep不会释放锁

- 使用范围不一样，wait只能在同步代码块中使用，sleep可以在任何情况下使用

- wait是对象线程进行释放，然后使用notify()进行唤醒

  sleep是对线程进行休眠，不需要重新唤醒，休眠结束后自动运行

   sleep不释放lock，wait会释放 

#### 40.ReentrantLock()实现的两种方式

```
    /**
   公平锁：非常公平，先来后到
     */
    public ReentrantLock() {
        sync = new NonfairSync();
    }

    /**
     非公平锁：不公平，可以插队，默认
     */
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }

```

#### 41.synchronized和lock的区别

- synchronized是java内置关键字，lock是java的类

- synchronized无法判断获取锁的状态，lock可以判断是否获取到了锁

- synchronized会自动释放锁，lock必须要手动释放锁，如果不释放锁，则会死锁

- synchronized线程1（获得锁，阻塞），线程2（等待，傻傻的等待），lock锁就不一定会等待，可以使用 tryLock  防止自锁（ tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。 ）

- synchronized可重入锁，不可以中断，非公平，lock 可重入锁，可以中断锁，默认非公平，也可以自己设置

  **其可重入最大的作用是避免死锁** 

- synchronized 适合锁少量的代码同步问题，Lock适合锁大量同步代码

#### 42.锁对象

**synchronized（同步方法） 锁的对象是方法的调用者（对象），如果创建两个对象调用不同的方法，通过延时可以演示**

**static  synchronized （静态同步方法） 锁的是class模板，创建多个对象也只有一个class模板**

#### 43.redisson 中文文档 

 https://github.com/redisson/redisson/wiki/%E7%9B%AE%E5%BD%95

#### 44.redis做缓存时热点问题

##### 一、缓存穿透

###### 1.1什么是缓存穿透

​		比如，我们有一张数据库表，ID都是从1开始的(正数)：

但是可能有黑客想把我的数据库搞垮，每次请求的ID都是**负数**。这会导致我的缓存就没用了，请求全部都找数据库去了，但数据库也没有这个值啊，所以每次都返回空出去。

> 缓存穿透是指查询一个一定不存在的数据。由于缓存不命中，并且出于容错考虑，如果从数据库查不到数据则不写入缓存，这将导致这个不存在的数据每次请求都要到数据库去查询，失去了缓存的意义。

 	 这就是缓存穿透，请求的数据在缓存中存在大量的不命中，而直接访问数据库的现象，且返回的数据也会逃过缓存的存储，导致一直不会命中缓存，因为缓存中本来就没有。

###### 1.2解决缓存穿透的方法

​		**1.设置过滤，对非法请求进行过滤 **由于请求的参数是不合法的(每次都请求不存在的参数)，于是我们可以使用**布隆过滤器(BloomFilter)或者压缩filter提前拦截**，不合法就**不让这个请求到数据库层**！

​		2.即使数据库返回值为空，也将他存到**缓存**，但设置一个较短的过期时间，下次请求还是会走缓存。

##### 二，缓存与数据库双写一致

###### 2.1 缓存和数据库数据不一致问题的原因

 	由于缓存是在查询数据库进行的缓存。那么在执行2次同样查询的中间时段，如果一个更新请求，改变了数据库的数据，那么此时第二次查询时，可能缓存中的数据并没有过期，这使得查询的结果和数据库结果不一致，这就是双学一致性问题。

```bash
1、读：
（1）先读cache，如果数据命中则返回
（2）如果数据未命中则读db
（3）将db中读取出来的数据入缓存
2、写：
（1）先淘汰cache
（2）再写db。
```

##### 2.2 解决双写一致问题方案

方案1：Redis设置key的过期时间。
方案2：采用延时双删策略。
（1）先淘汰缓存
（2）再写数据库（这两步和原来一样）
（3）休眠1秒，再次淘汰缓存
这么做，可以将1秒内所造成的缓存脏数据，再次删除。(为何是1秒？需要评估自己的项目的读数据业务逻辑的耗时。这么做的目的，就是确保读请求结束，写请求可以删除读请求造成的缓存脏数据。当然这种策略还要考虑redis和数据库主从同步的耗时。)

解决思路(1)：写请求**先删除缓存，再去更新数据库，（异步等待段时间)再删除缓存**（成功表示有脏数据出现）。

*这种方案读取快速，但会出现短时间的脏数据。*

解决思路(2)：写请求**先修改缓存为指定值，再去更新数据库，再更新缓存**。读请求过来后，先读缓存，判断是指定值后进入循环状态，等待写请求更新缓存。如果循环超时就去数据库读取数据，更新缓存。

*这种方案保证了读写的一致性，但是读请求会等待写操作的完成，降低了吞吐量*

##### 三，缓存雪崩

##### 问题描述：

缓存在同一时间内大量键过期（失效），接着来的一大波请求瞬间都落在了数据库中导致连接异常。

##### 解决方案：

1、建立备份缓存，缓存A和缓存B，A设置超时时间，B不设值超时时间，先从A读缓存，A没有读B，并且更新A缓存和B缓存.

2， 并发量不是特别多的时候，使用最多的解决方案是加锁排队。

​		加锁排队只是为了减轻数据库的压力，并没有提高系统吞吐量。假设在高并发下，缓存重建期间key是锁着的，这是过来1000个请求999个都在阻塞的。同样会导致用户等待超时，这是个治标不治本的方法！

​		注意：加锁排队的解决方式分布式环境的并发问题，有可能还要解决分布式锁的问题；线程还会被阻塞，用户体验很差！因此，在真正的高并发场景下很少使用！



##### 四，缓存击穿

##### 	现象

​	缓存击穿，是指一个key非常热点，在不停的扛着大并发，大并发集中对这一个点进行访问，当这个key在失效的瞬间，持续的大并发就穿破缓存，直接请求数据库，就像在一个屏障上凿开了一个洞。

#####  解决方案

###### 1，"永远不过期"：

​	这里的“永远不过期”包含两层意思：

  (1) 从redis上看，确实没有设置过期时间，这就保证了，不会出现热点key过期问题，也就是“物理”不过期。

  (2) 从功能上看，如果不过期，那不就成静态的了吗？所以我们把过期时间存在key对应的value里，如果发现要过期了，通过一个后台的异步线程进行缓存的构建，也就是“逻辑”过期。

![image-20201028162156287](C:\Users\91479\AppData\Roaming\Typora\typora-user-images\image-20201028162156287.png)

​	从实战看，这种方法对于性能非常友好，唯一不足的就是构建缓存时候，其余线程(非构建缓存的线程)可能访问的是老数据，但是对于一般的互联网功能来说这个还是可以忍受。

###### 2.使用互斥锁(mutex key)：

​	这种解决方案思路比较简单，就是只让一个线程构建缓存，其他线程等待构建缓存的线程执行完，重新从缓存获取数据就可以了。

###### 3."提前"使用互斥锁(mutex key)

​		在value内部设置1个超时值(timeout1), timeout1比实际的memcache timeout(timeout2)小。当从cache读取到timeout1发现它已经过期时候，马上延长timeout1并重新设置到cache。然后再从数据库加载数据并设置到cache中。

#### 45.Eureka和Zookeeper的区别

- Zookeeper中的节点服务挂了就要重新选举，在选举期间的注册服务瘫痪，Zookeeper·存在主从关系，主节点挂了，会影响到其他的节点，zookeeper基于CP

- Eureka中各个节点平等，一个节点挂了不会影响其他的节点，eureka基于AP，（可以查看48.CAP原则）

- Eureka本质是一个工程，Zookeeper只是一个进程

- Eureka取CAP中的AP，注重可用性，Zookeeper取CAP中的CP，注重一致性

- Eureka采用自我保护机制解决分区问题，Zookeeper采用过半数存活机制

- Eureka的自我保护机制是什么：

  当Eureka Server节点在短时间丢失了过多实例的连接时（比如网络故障或频繁启动关闭客户端） 节点会进入自我保护模式，保护注册信息，不在删除注册数据，故障恢复是，自动退出自我保护模式

#### 46.微服务和分布式系统的区别

 		分布式系统属于微服务， 微服务的意思也就是将模块拆分成一个独立的服务单元通过接口来实现数据的交互。但是微服务不一定是分布式，因为微服务的应用不一定是分散在多个服务器上，他也可以是同一个服务器。这也是分布式和微服务的一个细微差别。 

#### 47.ACID原则

**关系型数据库（mysql/oracle/sqlserver...）遵守ACID原则：**

- A：Atomicity 原子性
- C：Consistency 一致性
- I：Isolation 独立性
- D: Durability 持久性

#### 48.CAP原则

**分布式服务、NoSQL遵循CAP原则，但是最多满足其中两种**

- C：Consistency 强一致性
- A：Availability 可用性
- P：Partition Tolerance 分区性容错

#### 49.springcloud如何实现服务的注册

1. 服务发布时，，指定对应的服务名，将服务注册到服务中心（eureka）

2. 注册中心加@EnableEurekaServer，服务用@EnableDiscoveryClient，然后使用feign进行服务直接的调用和发现

3. @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到该服务。

   不同点：`@`EnableEurekaClient只适用于Eureka作为注册中心，`@EnableDiscoveryClient` 可以是其他注册中心。

#### 50.JAVA内存模型

 		JMM 全称 `Java Memory Model`, 是 Java 中非常重要的一个概念，是Java 并发编程的核心和基础。JMM 是Java 定义的一套协议，用来屏蔽各种硬件和操作系统的内存访问差异，让Java 程序在各种平台都能有一致的运行效果。 

#### 51.switch使用范围

```
  \1. byte、char、short、int四种基本类型以及它们的包装类（需要Java5.0/1.5以上版本支持） 
都可以用于switch语句。 
  \2. long、float、double、boolean四种基本类型以及它们的包装类（在Java所有版本中） 
都不能用于switch语句。 
  \3. enum类型，即枚举类型可以用于switch语句，但是要在Java5.0（1.5）版本以上才支 
持。 
  \4. 所有类型的对象（包括String类，但在Java5.0/1.5以上版本中，该项要排除 
byte、char、short、int四种基本类型对应的包装类）都不能用于switch语句。 
```

#### 52.redis分布式锁实现

我们公司对于分布式锁做了封装，其实底层是通过Redisson来实现的，我也仔细研究过代码，内部是对外提供一个接口去实现分布锁，先是通过RedissonClient获取锁名等到一个对象，然后设置一个布尔值，在try- catch里面tryLock进行加锁，如果加锁成功布尔值为true，后续在使用try-catch执行业务代码，并在finally里面解锁。

trylock里面如果获取锁成功会直接返回true，否则则会回循环，如果设置的等待时间之后还是存在锁就会返回失败

一般Redis就问几个问题：
1.有哪些数据类型？

String，List，set，hash，zset，还有三种特殊数据类型：一个Geospatial 地理位置，Hyperloglog，Bitmap 位存储

2.Redis为什么是单线程？为什么单线程还会快？

- CPU不是redis的瓶颈 

- redis的瓶颈主要在内存大小和网络的快慢  

  为什么单线程还会快？

 Redis总体快的原因： 
 1.完全基于内存的 
 2.采用单线程，避免不必要的上下文切换可竞争条件 
 3.数据简单，数据操作也相对简单 
 4.使用多路I/O复用模型，非阻塞IO 

3.简述Redis的主从复制和哨兵机制



4.你们用Redis做分布式锁是怎么做的？

​		我们公司对于分布式锁做了封装，其实底层是通过Redisson来实现的，我也仔细研究过代码，内部是对外提供一个接口去实现分布锁，先是通过RedissonClient获取锁名等到一个对象，然后设置一个布尔值，在try- catch里面tryLock进行加锁，如果加锁成功布尔值为true，后续在使用try-catch执行业务代码，并在finally里面解锁。

trylock里面如果获取锁成功会直接返回true，否则则会回循环，如果设置的等待时间之后还是存在锁就会返回失败，内部加锁的逻辑是使用lua语言实现的，redis会保证其原子性

​		redisson内部提供一个监控锁的看门狗机制后台线程， 每10s检查一次锁状态，通过Config.lockWatchdogTimeout 修改，加锁默认时间是30s，如果加锁的业务没有执行完，那么到了20s的时候就会续期，将锁重置为30s；

5.说一下你们用list干了什么？

​       list的使用：

​		门店的一些消息，也会存储在list里面，比如说总店修改分店的结算信息需要分店同意，那么我们没错记录一条操作记录，分店登录的同时也会把消息存放在redis中，总店多次修改分店，分店就会收到多次消息

​		Hah用在：储存省市区信息的，比如全国包含很多省份，每个省份又包含市，名称和编码都会存在hsh中；

​		Set用在：和包贷中用的较少，一般在可能认识的人、共同好友的场景下，黑名单白名单也可以用set的sismember指令；

6.Redis怎么实现抢红包，你怎么做？



#### 53.事务的隔离级别，传播机制

   **脏读**:事务1第二次读取时读取到了事务2未提交的数据

   **不可重复读**:事务2在事务1第二次读取时，提交了数据。导致事务1前后两次读取的数据不一致

   **幻读:**事务1在第二次读取数据时读取到了事务2提交的数据

   **不可重复读和幻读的区别:**

​      不可重复读针对的是读取到的值不同,幻读针对的是读取到的数据条数不同



**四种隔离级别**

**1.*SERIALIZABLE  可串行读*（  可避免脏读、不可重复读、幻读的发生。   ）**

​      这是效率最低最耗费资源的一个事务级别,和可重复读类似,但在自动提交模式关闭情况下可串行化读会给每个查询加上共享锁和排他锁,意味着所有的读操作之间不阻塞,但读操作和阻塞別的食物的写操作,写操作也阻塞读操作

​    **2.*REPEATABLE READ  可重读读取数据,这也是Mysql默认的隔离级别*（  可避免脏读、不可重复读的发生。   ）**

​      一个事务内的两次无所查询返回的数据都是一样的,但别的事务的新增数据也能读取到,比如另一个事务插入了一条数据并提交,这个事务第二次去读取的时候发现多了一条之前查询数据列表里面不存在的数据,这个级别避免了不可重复读取,但不能避免幻读的问题

​    **3.*READ COMMITTED 读取已提交的数据*（  可避免脏读的发生。   ）**

​      一个事务只能读取数据库中已经提交过的数据,解决了脏读的问题,但不能重复读,即一个事务内的两次查询返回的数据是不一样的,如第一次查询金额100,第二次去查询可能就是50了,这就是不可重复读取.*
*

​    **4.*READ UNCOMMITTED 读取未提交的数据*（  最低级别，任何情况都无法保证。   ）**

​      这是最不安全的一种级别,查询语句在无锁的情况下运行,并能读取到别的未提交的数据,造成脏读,如果未提交的那个事务数据全部回滚了,而之前读取了这个事务的数据即未脏数据

- MYSQL: 默认为REPEATABLE_READ级别
- SQLSERVER: 默认为READ_COMMITTED
- Oracle 默认隔离级别 READ_COMMITTED

7大传播机制

​      1.REQUIRED 如果当前方法没有事务则加入事务,没有则创建一个事务（Transactional默认事务）

​      2.NOT_SUPPORTED 不支持事务,如果当前有事务则挂起事务运行

​      3.REQUIREDS_NEW 新建一个事务并在这个事务中运行,如果当前存在事务就把当前事务挂起,新建的                      事务的提交与回滚一挂起事务没有联系,不会影响挂起事务的操作（常用，使用场景：类似于手动提交，在服务费生成中，因为数据量大，会使用一个方法每次录入10000笔数据，在这个方法上使用REQUIREDS_NEW 进行事务控制）

​      4.MANDATORY 强制当前方法使用事务运行,如果当前没有事务则抛出异常

​      5.NEVER 当前方法不能存在事务,即非事务运行,如果存在事务则抛出异常

​      6.SUPPORTS 支持当前事务,如果当前没事务也支持非事务状态运行（常用，使用场景：）

​      7.NESTED 如果当前存在事务,则在嵌套事务内执行,嵌套事务的提交与回滚与父事务没有任务关系,反之,当父事务提交嵌套事务也一起提交,父事务回滚会也回滚嵌套事务的,如果当前没有事务,则新建一个事务运行.



#### 54.springboot  springmvc spring区别

#### 55.微服务和SOA的关系

#### 56springmvc 常用的注解

#### 57.redis的最常用的客户端

#### 58.redis的事务相关的命令

#### 59.微服务架构常用的组件

#### 60.springcloud常用组件



#### 61.线程阻塞的处理

#### 62.eureka的自我保护机制

#### 63.用过哪些微服务框架和组件？

用过SpringCloud，用的组件是：
注册中心eureka,远程调用是openFeign,里面封装了Robbin客户端负载均衡组件,断路器是Hystrix,配置中心是springCloudConfig
用过SpringCloudAlibaba:
注册中心和配置中心是Nacos,分布式事务使用Seata,其他的组件还是一样的
网关我们也有用gateway，但是我没怎么太接触过。

二、看过其中组件的源码吗？
对注册中心比较有兴趣，所以我读过Eureka和Nacos的源码
简单说一下Eureka:
    Eureka保证CAP原则的AP，就是说保证了高可用但是没保证数据准确性，所以Eureka集群是对等复制的形式，
节点之间不分主从；Eureka服务中使用了二级缓存，一级缓存是可读可写，二级缓存是只读缓存。客户端拉取服务
是从二级缓存中拉取(没有就从一级中读取再存在二级中)，效率非常高，因为多次缓存，注册表肯定是没法保证一致性的，
所以Eureka保证的是AP。Eureka的监听机制是有个心跳机制，注册成功后每个客户端会每30s向注册中心发送心跳，来保证
客户端还存在，可以正常进行调用（记住一定是客户端向注册中心发送心跳，他强调问过我）。Eureka依赖心跳机制有
一个自我保护机制，如果在每一段时间收到的心跳的值少于期待值时就会做服务剔除，阈值是85%。
再简单说一下Nacos:
    Nacos通过缓存+外部数据库，通过配置文件可以切换AP和CP的模式;
    Nacos作为注册中心服务信息是存在一个hashmap之中，当有新的服务注册成功时，Nacos集群通过raft协议实现数据同步，
服务实例的属性ephemeral(是否是临时的)，若是临时实例，则不会在服务端持久化，需要通过上报心跳的方式保证服务存活，
如果没收到心跳就会剔除服务；若不是临时实例，这个服务实例就会持久化进数据库，就算服务远程真的被删除了，
也不会删除服务实例，只是标记为非健康实例。
	Nacos集群与Eureka集群最大的不同是，Nacos集群使用的是主从模式，也就是说只有主节点能够注册，
而其他节点只提供读取功能，同样主节点如果宕机也有选举机制。

三、你们微服务之间调用有什么规范？
我们微服务之间直接使用openFeign通讯，使用的是http通讯，接口名要求是Restful形式，也就是说都是用资源的形式命名接口；
微服务调用要求我们使用openFeign尽量不能直接写RestTemplate，因为openFeign会封装断路器进行熔断；
查询数据使用get请求方式，提交数据使用post请求方式；

四、微服务中常用的注解？
远程调用时@FeignClient注解；
使用hystrix断路器是使用@HystrixCommand注解；
配置文件对象使用@Configuration注解；
控制器用@RestController注解；
注册中心的客户端使用@EnableDiscoveryClient注解；

五、你介绍Seata组件，使用的什么模型，几段提交？

#### 64.seata相关术语

    分布式事务处理过程的模型：1个id + 3个组件。
    1个id是指全局唯一的事务id -- transaction id
    3个组件是指：
    TC：事务协调器 -- 部署的Seata服务器，维护全局和分支事务状态，驱动全局提交/回滚
    TM：事务管理器 -- 加@GlobalTransactional注解的方法，定义全局事务的范围，负责开启全局事务，最终发起全局事务的提交或回滚的决议。
    RM：资源管理器 -- 管理分支的事务，接收协调器的指令，驱动本地事务的提交和回滚

#### 65.seata分布式事务处理过程

    1.TM向TC申请开启一个全局事务，全局事务创建成功时生成一个全局唯一的XID；
    2.XID在微服务调用链路的上下文中传播，可以通过RootContext.getXID()获取；
    3.RM向TC发起分支注册，将此RM纳入XID的全局事务管辖；
    4.TM向TC发起针对XID的全局提交/回滚决议；
    5.TC调度XID下管辖的全部分支一起完成事务的提交/回滚操作。

#### 66.模型-工作模式

    seata官网上说明支持TCC/XA/SAGA/AT的事务模式，默认使用的是AT模式。
    AT模式的前提：基于支持ACID事务的关系型数据库，通过JDBC访问数据库的java应用；
    整体机制： 两阶段提交协议
    一阶段：
        seata拦截业务sql，找到业务操作的数据，在操作前将其保存为before image，执行业务sql，操作之后将其保存为after image，最后生成行锁。这些操作都在新建的表的数据库事务能完成，类似AOP的前置后置通知。
    二阶段：
        提交：如果顺利，只需要删除before image、after image和行锁，再直接进行提交。
        回滚：如果出现异常，需要回滚，比较当前库中的数据与after image是否一致，如果一致就将数据还原成before image，如果不一致，说明数据出现过脏写，需要人工告警处理。

#### 67.用过哪些中间件？

RabbitMQ做消息中间件,发短信、发微信推送都有用到
Redis做缓存,用户信息储存、首页样式配置、分布式锁都有用到

#### 68.RabbitMQ有哪些广播类型？

direct（默认方式）：最基础最简单的模式，发送方把消息发送给订阅方，如果有多个订阅者，默认采取轮询的方式进行消息发送。
headers：与 direct 类似，只是性能很差，此类型几乎用不到。
fanout：分发模式，把消费分发给所有订阅者。
topic：匹配订阅模式，使用正则匹配到消息队列，能匹配到的都能接收到。

#### 69.Redis为什么单线程能这么快？

Redids的瓶颈不是cpu，是网络带宽和机器内存，所以只需要使用单线程就行了；
（如果CPU成为REDIS处理的瓶颈，那就多启动几个REDIS进程）
快的原因是：
首先，数据都存在内存里，基于内存操作自然很快
其次，数据结构简单，对数据操作也简单
最后，使用多路复用的IO模型，这个模型就没有认真的去研读代码了

#### 70.数据库用的什么？平常怎么优化？

oracle和mysql都有用过；有什么区别？
mysql对比oracle是开源的，并且单体机的性能远不如oracle；
mysql有自增主键，oracle没有；mysql有limit，oracle没有；
oracle有很多复杂计算函数，比如nvl，rownnum；
优化：
从SQL语句层面： 
1.根据查询字段建立合适的索引，null不能做索引，离散度不高的不能做索引；
2.不能查找*，计算使用count(主键)或者count(*)，是否存在使用exists/limit=1；
3.索引字段不能做计算，计算后不能走索引；
4.前导模糊查询走索引，后导模糊查询不走，模糊查询使用_比%好；
5.联合索引需要走最左边的才走索引；
从数据库层面：
1.做分区键；
2.搭建主从集群；
3.实现读写分离；
4.实现分库分表；
从系统架构方面：
1.做分库分表，使用shardingshere做分库分表，一般就是针对某字段取余做水平分隔；

#### 71.代码性能优化有哪些见解？

当代码出现问题，要从各个方面来分析问题，我以我的经验来讲述一下吧。
    首先，从最底层想起，是否是数据库可以优化，这里的优化方案我之前说了，我再说一次吧(...参考8)
    其次，如果数据库压力不大，就需要走读代码看看有什么优化点，比如有些代码使用流在代码里对查询出的list集合做分组，
这样对数据库压力小，但是在消耗内存，如果在数据库能筛选掉大量数据时，可以选择在数据库来做分组，当然也是因为我们和包
的数据库是物理机数据库，性能比云数据库好很多才敢这么做，一般还是不要在数据库做复杂逻辑；
    再次，如果查询数据和逻辑处理缓慢，但是数据实时性不用那么高，可以考虑使用Redis做缓存，可以提高很大的效率，这里
我们的首页加载和用户省份信息都存在redis里；实时性不高的报表程序，可以考虑在日终统一跑，不要当场跑，比如账务和文件；
    最后，业务逻辑复杂、并发量大的时候，可以考虑使用Rabbitmq来做解耦和削峰。
    （千万别说太多JVM调优的事，太假了）

#### 72.项目管理的流程，你一般参与哪些阶段

需求阶段
    需求调研、需求编写和评审
开发阶段
    技术方案编写和评审、代码编写和评审、单元测试与集成测试
测试阶段
    测试用例编写和评审、功能测试
预投产阶段
    预投产代码评审、预投产部署和验证
投产阶段
    投产部署和验证

我作为开发工程师，一般参与的过程是需求评审、开发阶段所有的过程、协助功能测试、预投产和投产验证的工作。
需求评审主要是为了了解需求，保证需求满足甲方的要求，以及是否可行。
技术方案编写和评审，主要是为了保证技术方案覆盖所有需求点没有遗漏。
代码评审是与组长一起评审，一般重大需求会有领导和技术专家参与，我们评审是每个需求必定评审，没有遗漏，这个是必要操作。
单元测试和集成测试都是白盒测试，需要测试每个分支每种情况，需要输出测试报告给组长检查。
（测试、预投产、投产的工作你按照你平常说）

