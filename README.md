# XeonDiff
超简单在Android端通过bsdiff实现件差分与文件合并。快速实现增量更新功能

先上图：

生成补丁包

![生成补丁包](https://github.com/yuzhiqiang1993/XeonBsDiff/blob/main/img/diff.png "生成补丁包")

合并补丁包
![合并补丁包](https://github.com/yuzhiqiang1993/XeonBsDiff/blob/main/img/patch.png "合并补丁包")

产生的文件：
![产生的文件](https://github.com/yuzhiqiang1993/XeonBsDiff/blob/main/img/result.png "产生的文件")


代码示例：

1.添加依赖
```
implementation "com.xeonyu:bsdiff:1.0.4"
```

2.生成补丁包


```
/*生成补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
val result = BsDiffTool.diff(
    newFile.absolutePath,//新文件path
    oldFile.absolutePath,//旧文件path
    patchFile.absolutePath//补丁文件path
    )

```

3.合并补丁包

```
/*合并补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
    val result = BsDiffTool.patch(
        oldFile.absolutePath,
        patchFile.absolutePath,
        combineFile.absolutePath
    )
```

4.合并补丁包后记得对比下新文件和合并后文件的MD5值， MD5值一致表示成功。


如果需要自己生成so库，请看博客： https://blog.csdn.net/yuzhiqiang_1993/article/details/121317195

source目录中有bzip和bsdiff源码文件。
