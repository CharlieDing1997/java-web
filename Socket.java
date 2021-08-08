Socket 类代表一个客户端套接字，可以使用该类向服务器发送和接受数据。一般需要通过下面几个步骤：

建立与服务器的连接；
使用输出流将数据发送到服务器；
使用输入流读取服务器返回的数据；
关闭连接。
构造方法
Socket 常用构造方法：

Socket(InetAddress address, int port)：创建一个套接字，连接到指定 IP 地址和端口的服务器
Socket(String host, int port)：创建一个套接字，连接到指定的主机名和端口的服务器
Socket(InetAddress address, int port, InetAddress localAddr, int localPort)：创建一个套接字连接到指定的 IP 地址和端口的服务器，并且显示的指定客户端地址和端口。
在创建 Socket 时，需要捕获异常。

getOutputStream()
该方法可以获取输出流，在建立连接后，可以使用该方法获取输出流，发送数据到服务器。发送数据的方式和使用 IO 流是相同的，使用 write 方法发送指定的数据即可。

getInputStream()
用户获取输入流，通过该方法获取输入流之后可以读取服务器发送来的数据。使用方法和 IO 流相同，使用 read 方法即可。

close()
关闭 Socket，可能抛出 IO 异常，所以我们同样需要捕获异常。




ServerSocket类用于实现服务器套接字，服务器套接字会等待客户端网络连接，与客户端连接之后，会进行一系列操作，然后将结果返回给客户端。

创建一个 ServerSocket 一般需要以下几个步骤：

创建服务器套接字并将其绑定到特定的接口
等待客户端连接
通过客户端套接字获取输入流，从客户端读取数据
通过客户端套接字获取输出流，发送数据到客户端
关闭套接字
构造方法
常见构造方法：

ServerSocket()：创建一个未绑定端口的服务器套接字。

ServerSocket(int port)：创建绑定到指定端口号的服务器套接字。

ServerSocket(int port,int backlog)：创建一个绑定到指定端口号的服务器套接字，并且backlog 参数指定了最大排队连接数。

ServerSocket(int port,int backlog,InetAddress bindAddr)：创建服务器套接字并将其绑定到指定的端口号和本地 IP 地址。

示例：

ServerSocket serverSocket = new ServerSocket(8888);
copy
accept()
用于监听客户端连接请求，当调用该方法时，会阻塞当前线程，直到有客户端发起请求与其建立连接，否则将一直等待。当连接成功后，将返回一个 Socket 对象。

close()
用于关闭服务器套接字，服务器停止后，将断开所有连接。
