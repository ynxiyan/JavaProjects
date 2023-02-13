# [socket网络通信](https://www.cnblogs.com/ynxiyan/p/17076745.html)

整理和总结了一下大家常遇到的问题：

 1. 客户端socket发送消息后，为什么服务端socket没有收到？

 2. 使用while 循环实现连续输入，是不是就是多线程模式？

 3. 对多线程处理机制不是很明白，希望详细讲解？

 4. 希望详细讲解ServerSocketChannel和SocketChannel与ServerSoket和Socket的区别？

 5. 希望有详细的例子，可以直接拷贝下来运行？

### **一：socket通信基本原理。**

首先socket 通信是基于TCP/IP 网络层上的一种传送方式，我们通常把TCP和UDP称为传输层。

![0](https://note.youdao.com/yws/public/resource/0eaefabe6c65f4d1f719ec775c4ae1d4/xmlnote/964D3AAB12D544B7AA8553B2D028A79A/7929)

如上图，在七个层级关系中，我们将的socket属于传输层，其中UDP是一种面向无连接的传输层协议。UDP不关心对端是否真正收到了传送过去的数据。如果需要检查对端是否收到分组数据包，或者对端是否连接到网络，则需要在应用程序中实现。UDP常用在分组数据较少或多播、广播通信以及视频通信等多媒体领域。在这里我们不进行详细讨论，这里主要讲解的是基于TCP/IP协议下的socket通信。

socket是基于应用服务与TCP/IP通信之间的一个抽象，他将TCP/IP协议里面复杂的通信逻辑进行分装，对用户来说，只要通过一组简单的API就可以实现网络的连接。借用网络上一组socket通信图给大家进行详细讲解：

![0](https://note.youdao.com/yws/public/resource/0eaefabe6c65f4d1f719ec775c4ae1d4/xmlnote/822263B34A36419F98A57DD5FF3A7D63/7932)

首先，服务端初始化ServerSocket，然后对指定的端口进行绑定，接着对端口及进行监听，通过调用accept方法阻塞，此时，如果客户端有一个socket连接到服务端，那么服务端通过监听和accept方法可以与客户端进行连接。

### **二：socket通信基本示例：**

在对socket通信基本原理明白后，那我们就写一个最简单的示例，展示童鞋们常遇到的第一个问题：客户端发送消息后，服务端无法收到消息。



```java
 import java.io.BufferedWriter; import java.io.OutputStreamWriter; import java.net.Socket; public class ClientSocketTest {    public static void main(String[] args) {        BufferedWriter bw = null;        try {            Socket so = new Socket("127.0.0.1", 8888);            bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));            String str = "你好，这是我的第一个socket";            bw.write(str);        } catch (Exception e) {            e.printStackTrace();        } finally {            try {                if (bw != null)                    bw.close();            } catch (Exception e) {                e.printStackTrace();            }        }    } }              
 
import java.io.BufferedReader; import java.io.InputStreamReader; import java.net.ServerSocket; import java.net.Socket; public class ServerSocketTest {    public static void main(String[] args) {        BufferedReader br = null;        try {            // 初始化服务端socket并且绑定8888端口            ServerSocket ss = new ServerSocket(8888);            // 等待客户端的连接            Socket so = ss.accept();            // 获取输入流            br = new BufferedReader(new InputStreamReader(so.getInputStream()));            // 读取一行数据            String str = br.readLine();            // 输出打印            System.out.println("连接到server\t" + str);        } catch (Exception e) {            e.printStackTrace();        } finally {            try {                if (br != null)                    br.close();            } catch (Exception e) {                e.printStackTrace();            }        }    } }            
```

![0](https://note.youdao.com/yws/public/resource/0eaefabe6c65f4d1f719ec775c4ae1d4/xmlnote/96120E3662AC4CB5ACF6C1774C7BE51D/7939)

![0](https://note.youdao.com/yws/public/resource/0eaefabe6c65f4d1f719ec775c4ae1d4/xmlnote/F36C790A3A1D4088B1F722B76238453F/7937)

然后好多童鞋，就拷贝这个java.net.SocketException: Connection reset上网查异常，查询解决方案，搞了半天都不知道怎么回事。解决这个问题我们首先要明白，socket通信是阻塞的，他会在以下几个地方进行阻塞。第一个是accept方法，调用这个方法后，服务端一直阻塞在哪里，直到有客户端连接进来。第二个是read方法，调用read方法也会进行阻塞。通过上面的示例我们可以发现，该问题发生在read方法中。有朋友说是Client没有发送成功，其实不是的，我们可以通debug跟踪一下，发现客户端发送了，并且没有问题。而是发生在服务端中，当服务端调用read方法后，他一直阻塞在哪里，因为客户端没有给他一个标识，告诉是否消息发送完成，所以服务端还在一直等待接受客户端的数据，结果客户端此时已经关闭了，就是在服务端报错：java.net.SocketException: Connection reset

那么理解上面的原理后，我们就能明白，客户端发送完消息后，需要给服务端一个标识，告诉服务端，我已经发送完成了，服务端就可以将接受的消息打印出来。

 通常大家会用以下方法进行进行结束：

socket.close() 或者调用socket.shutdownOutput();方法。调用这俩个方法，都会结束客户端socket。但是有本质的区别。socket.close() 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。而socket.shutdownOutput()是将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的。现在我们将上面的客户端示例修改一下啊，增加一个标识告诉流已经输出完毕：