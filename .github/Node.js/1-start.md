# 一.Node.js 是什么？
1. NodeJs就是运行在服务端的js（可以解析和执行JavaScript代码）。
nodejs下载地址：https://nodejs.org/en/
安装成功后打开window+r---输入cmd----node -v检测是否下载成功 

2. 现在的JavaScript可以完全脱离浏览器来运行，一切都归功于Node.js

3. 浏览器中的JavaScript包括EcmaScript、BOM、DOM

4. Node.js中的JavaScript ：没有BOM、DOM，用EcmaScript进行编码，主要是在Node这个JavaScript执行环境中为JavaScript提供一些服务器级别的API操作（例如文件读写、网络服务的构建、网络通信、http服务器等处理）

5. Node.js特性是 使用事件驱动、非阻塞IO模型(异步)，使得其轻量和高效

6. npm是基于Node.js开发出来的包管理工具，npm是世界上最大的开源库生态系统，绝大多数js相关的包都存放在npm上，方便开发人员下载使用

7. Google Chrome的V8引擎是目前公认的解析执行JavaScript代码最快的，Node.js构建在Google Chrome的V8引擎之上，是一个独立的JavaScript运行时环境

8. Node.js能做的事：Web服务器后台、命令行工具(npm、git、hexo)

# 二. http 创建服务器
创建一个简单的服务器，在nodejs中创建一个server.js文件
    
```
引入http模块
var http=require（'http’）；
//2.使用http模块创建一个服务
var server=http.createServer(function(req,res){//请求，响应
  console.log('开启服务');
  //响应有两个方法
  res.write('succ');//响应的内容
  res.end();//响应结束
});
//3.监听一个端口号（需要打开xampp服务）
server.listen(8080);
//4.打开浏览器输入127.0.0.1:8080，同时在window+r--cmd中执行server.js文件

```
在使用http模块创建一个服务是不仅仅只有响应这个两个方法，还有以下方法：
```
//引入http模块
var http=require（'http’）；
//2.使用http模块创建一个服务
var server=http.createServer(function(req,res){//请求，响应
  console.log('开启服务');
  //响应有两个方法
  res.write('succ');//响应的内容
  res.end();//响应结束
});
//3.监听一个端口号（需要打开xampp服务）
server.listen(8080);
//4.打开浏览器输入127.0.0.1:8080，同时在window+r--cmd中执行server.js文件
```

# 三. fs 文件模块 （读文件）
在nodejs文件夹中创建fs.txt文档与fs.js
```
//1.引入fs模块
var fs=require('fs');
//2.读取文件
fs.readFile(fs.txt,function(err,data){//err:读取失败   data：表示文件中的内容
  console.log(err);//没有错就输出null  有错就报错
  if(err){
    console.log();
  }else{
    //console.log(data);//2进制
    console.log(data.toString);//转化为字符串
  }
})
```

# 四. fs文件模块（写文件）
创建一个writeFile.js
```
//1.引入fs模块
var fs=require('fs');
//2.写文件
//fs.wirteFile('文件名','内容',function(err){})
fs.wirteFile('aaa.txt','Where is my love,See one love one',function(err){
  console.log(err);
})
```
打开window+r输入node writeFile.js
此时文件中多一个aaa.txt文档，打开文档会有上面的Where is my love,See one love one内容

# 五. 响应内容类型Content-type
```
var http = require('http')
var server = http.createServer()
server.on('request',function(req,res){
    //在服务端默认发送的数据其实是utf-8编码的内容
    //但是浏览器不知道你是utf-8编码的内容，在浏览器不知道服务器响应内容的编码的情况下会按照当前操作系统的默认编码去解析
    //中文操作系统默认是gbk 
    //要让浏览器显示的数据不是乱码的，就需要告诉浏览器服务器发给它的内容是什么编码的，下面这行代码就可以解决这个问题
    var url = req.url
    if(url === '/plain'){
        // text/plain 就是普通文本  text/plain的意思是将文件设置为纯文本的形式，浏览器在获取到这种文件时并不会对其进行处理
        res.setHeader('Content-Type','text/plain; charset=utf-8')
        res.end('hello 世界')
    }else if(url === '/html'){
        // text/html的意思是将文件的content-type设置为text/html的形式，浏览器在获取到这种文件时会自动调用html的解析器对文件进行相应的处理
        // 如果你发送的是 html 格式的字符串，则也要告诉浏览器我给你发送的是 text/html 格式的内容
        res.setHeader('Content-Type','text/html; charset=utf-8')
        res.end('<p>hello html <a href="">点我</a></p>')
    }
})
server.listen(3000,function(){
    console.log('Server is running.....，可以通过 http://127.0.0.1:3000/ 来进行访问')
})
```

# 六. 通过hhtp网络发送文件
发送的并不是文件，本质上发送的是文件的内容

当浏览器收到服务器响应内容之后，就会根据你的 Content-Type 进行对应的解析处理

服务器最好把每次响应的数据是什么内容类型都告诉客户端，而且要正确的告诉

不同资源对应的 Content-Type 是不一样的，具体参照：http://tool.oschina.net/commons

对于文本类型的数据，最好都加上编码，目的是为了防止中文解析乱码问题

```
//1.结合fs发送文件中的数据
//2.Content-Type  不同的资源对应的 Content-Type 是不一样的，图片不需要指定编码，一般只为字符数据指定编码
var http = require('http')
var fs = require('fs')

var server = http.createServer()

server.on('request',function(req,res){
    var url = req.url
    if(url === '/'){
        //发送的是在文件中的内容
        fs.readFile('./resource/index.html',function(err,data){
            if(err){
                //告诉客户端，读取失败 
                res.setHeader('Content-Type','text/plain; charset=utf-8')
                res.end('文件读取失败，请稍后重试！')
            }else{
                //data默认是二进制数据，可以通过 .toString 转为咱们能识别的字符串
                //res.end()支持两种数据类型，一种是二进制，一种是字符串
                res.setHeader('Conten-Type','text/html; charset=utf-8')
                res.end(data)
            }
        })    
    }else if(url==='/baby'){
        //url:统一资源定位符
        //一个 url 最终其实是要对应到一个资源的
        fs.readFile('./resource/ab2.jpg',function(err,data){
            if(err){
                //告诉客户端，读取失败 
                res.setHeader('Content-Type','text/plain; charset=utf-8')
                res.end('文件读取失败，请稍后重试！')
            }else{
                //data默认是二进制数据，可以通过 .toString 转为咱们能识别的字符串（因为res.end也支持二进制的数据类型，所以这里也可以不用转）
                //res.end()支持两种数据类型，一种是二进制，一种是字符串
                //图片就不需要指定编码了，因为我们常说的编码指的是字符编码
                res.setHeader('Conten-Type','image/jpeg')
                res.end(data)
            }
        })    
    }
})
server.listen(3000,function(){
    console.log('Server is running......')
})
```

# 七. ip地址和端口号
1. 所有联网的程序都需要进行网络通信。一台计算机只有一个物理网卡，而且同一个局域网中，网卡的ip地址必须是唯一的(网卡是通过唯一的ip地址来进行定位的)。

2. DNS: 域名系统（英文：Domain Name System，缩写：DNS）是互联网的一项服务，是万维网上作为域名和IP地址相互映射的一个分布式数据库，能够使用户更方便的访问互联网，而不用去记住能够被机器直接读取的IP数串。
 
3. ①ip地址用来定位计算机 ②端口号用来定位具体的应用程序（所有需要联网通信的应用程序都必须占用一个端口号）

4. 端口号的范围从0~65536之间

5. 在计算机中有一些默认端口号，最好不要去使用(例如http服务的80)

6. 在开发过程中使用一些简单好记的就可以了，例如3000、5000等没什么含义
 
7. 浏览器默认使用的端口号是80，若要请求其他端口号，则一定要在ip地址后面给出来

8. 可以同时开启多个服务，但一定要确保不同服务占用的端口号不一致才可以。说白了，在一台计算机中，同一个端口号同一时间只能被一个程序占用

# 八.一些知识点补充
1. hhtp服务的响应内容(res.end())只能是二进制数据或者字符串（注意：数字、对象、数组、布尔值都是不可以的）

2. JSON.stringify() 方法将 JavaScript 对象或数组转换为字符串。JSON.parse() 方法将字符串数据转换为 JavaScript 对象或数组。

3. Node为JavaScript提供了很多服务器级别的API，这些API绝大多数都被包装到了一个具名的核心模块中。例如文件操作的fs核心模块，http服务构建的http模块，path路径操作模块、os操作系统信息模块。以后如果说一个模块是核心模块，就要想到如果要使用它，就必须require，例如：

　　var fs = require('fs')
　　var http = require('http')

4. require 是一个方法，它的作用是用来加载模块的。在Node中，模块有两种：一是具名的核心模块，例如 fs、http；二是用户自己编写的文件模块(说白了就是js文件)。require加载用户自定义的模块时，require中的相对路径的 ./ 不能省略，否则会报错。补：后缀名也可以省略，require默认找的就是 .js 结尾的文件

5. 在Node中，没有全局作用域，只有模块作用域(外部访问不到内部，内部也访问不到外部)

6. require 方法有两个作用：①加载文件模块并执行里面的代码②拿到被加载文件模块导出的接口对象（每个文件模块中都提供了一个对象---export，export默认是一个空对象，所有需要被外部访问的成员都需要挂载到exports这个对象中！)

例如：
a.js如下：
```
var ret = require('./b')
console.log(ret.foo)
console.log(ret.add(10,30))
b.js如下：

var foo = 'bbb'
exports.foo = "hello"
exports.add = function(x,y){
    return x+y
}
```


