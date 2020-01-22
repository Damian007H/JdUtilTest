
该项目中集成了，开发使用中常用的工具类，[GitHub地址](https://github.com/Len-jidong/JdUtilTest)，[原文地址](https://blog.csdn.net/qq_36652498/article/details/104069385)
## 一：声明
该项目仅供自己和无项目攻击者使用，因为内容单一且简单

## 二：背景
我是一名Android开发者，在平常的开发过程中，常常会使用到一些工具类，例如：时间转换工具，保存文件工具，图片截取工具.....,如果此时你正在参加一个项目，那还好，如果有新增什么方法，你可以直接修改工具类，那如果你此时正在参加多个项目（同时和非同时都存在这个问题）如果你需要用到工具类，那你将需要在每个项目的工具类中修改对应的方法，岂不是很麻烦，在之前的工作当中也遇到了类似的很多情况，所以一直有个想法，看能否将平常使用到的工具类统一一下放在一起，在项目中直接依赖该lib，这样将会很方便，一个是你的主项目代码少，思路清晰，另一个是你的工具类易维护，在此也是希望谁有好的工具方法可以提上来，供大家学习并使用。


## 三：如何使用，项目介绍
- 项目结构：

        app.......................................（项目目录，主要是用于测试jdutil）.................
            src......................................................................................
            build.gradle...........................（主项目配置文件）................................
        gradle.......................................................................................
        jdutil......................................(工具类Module)...................................
            src......................................................................................
            build.gradle...........................（工具类配置文件，及打包命令）....................
        build.gradle.................................................................................
        config.gradle..............................（使得主项目和moduel版本一致）....................


- 如何使用：

        step1：将jdutil--jdUtilV1.0.0.jar（1.0.0 为版本号，可能会发生改变）  复制到你要使用的项目的module的libs 中
        step2：在该module的build.gradle 中找到 dependencies标签，添加implementation fileTree(include: ['*.jar'], dir: 'libs') 和 添加 implementation files('libs/jdUtilV1.0.0.jar')
              
**注意：**

如果你只想在该module中使用工具类以上配置已经完全可以了，但是如果你是想在你的子module（指的非appmodule，而是其他的moduel）中添加，而希望在主项目中使用，则
               将implementation files('libs/jdUtilV1.0.0.jar') 中的 implementation 修改为api ，否则无法在appModule中使用，具体原因请  [查看](https://www.jianshu.com/p/8962d6ba936e)

## 四：新增工具类方法，如何打包
工具类方法统一放至jdutil--src--main--java--cn.ddh.jdutil 下
以上工作全部就绪之后，进行编译出jar
    

    
- 方式一：
    打开AndroidStudio右上侧Gradle目录，找到jdutil-->Tasks-->other-->makeJar 双击makeJar 等待编译
![在这里描述](https://img-blog.csdnimg.cn/20200122133427836.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NjUyNDk4,size_16,color_FFFFFF,t_70)
- 方式二：
    打开AndroidStudio下方Terminal工具，在确保路径是在JdUtilTest下，输入 gradlew makeJar 回车 等待编译
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012213344867.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NjUyNDk4,size_16,color_FFFFFF,t_70)


**注意：**
不管采用哪种方式其实原理是一样的，打包命令以及配置定义在jdutil目录下的build.gradle中
def _BASENAME = jar的名称 例如 jdUtil
def _VERSION = jarInfo.versionName; jar的版本 例如 V1.0.0
def _DestinationPath = jarInfo.destinationPath;  生成jar包的位置
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020012213402339.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NjUyNDk4,size_16,color_FFFFFF,t_70)
## 五：期望
希望这个工具类能够容纳越来越多的方法，造福于每个项目


内容如有出入，请多多指正，谢谢！


