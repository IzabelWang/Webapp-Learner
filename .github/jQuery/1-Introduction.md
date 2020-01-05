# jQuery基础知识总结
## 1、什么是JQuery？

    它是js的一个框架，它是开源的项目。对底层的js进行封装，我们通过js框架就可以快速的完成DOM

    对元素的增删改查操作，并提供了动画功能。jquery对外提供api让开发者去开发jquery

    插件（就是一个功能模块，用户只要做一些简单的配置就完成复杂的功能）。jquery目前

    是比较流行的一个JQuery框架。（宗旨：写得少，做的多）。

 

## 2、JQuery特点:

- 轻量级
- 强大的选择器
- 出色的DOM封装
- 可靠的事件处理机制
- 完善的Ajax
- 出色的浏览器兼容性
- 丰富的插件支持
- 完善的文档
- 支持链式操作


## 3、JQuery的环境配置

- 1)官网：http://www.jquery.com

- 2)去下载jquery库文件:

      通常有两个版本:

       *未压缩版本：--用在开发和调试。（我们下载此版本）

       *压缩版本:--产品发布的时候使用，可以提高性能和减少带宽

 

## 4、在html页面中如何使用jQuery？

    使用<script src="jquery.js" type="text/javascript"></script>引入

 

## 5、在<script></script>内编写jquery脚本   
```
/*当文档解析完毕好以后去执行一个函数*/
// 第一种写法
jQuery(document).ready(function(){
    alert("hello,jQuery");
});
```
 
// 第二种写法
```
$(document).ready(function(){
    alert("hello,jQuery");
})
```
 
// 第三种写法
```
$(function(){
    alert("hello,jQuery");
})
      注意:jQuery可以使用$符号作为别名。

 

      强调:和window.οnlοad=function(){}区别?

      *加载时机不同，$(function(){})优先于window.οnlοad=function(){}先执行

      *执行的次数不同，window.οnlοad=function(){}只会执行最后一个绑定的函数。

        $(function(){})可以绑定多个函数来分别执行。
```