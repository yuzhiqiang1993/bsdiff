# XeonDiff
超简单实现Android端 文件差分与文件合并。快速实现增量更新功能

使用方式：

1.添加依赖

```
implementation "io.github.yuzhiqiang1993:xeon_bsdiff:1.0.0"
```

2.生成补丁包


```
/*生成补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
val result = XeonBsDiffUtil.diff(
    newFile.absolutePath,//新文件path
    oldFile.absolutePath,//旧文件path
    patchFile.absolutePath//补丁文件path
)
```

3.合并补丁包

```
/*合并补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
val result = XeonBsDiffUtil.patch(
    oldFile.absolutePath,
    patchFile.absolutePath,
    combineFile.absolutePath
)
```

4.合并补丁包后记得对比下新文件和合并后文件的MD5值， MD5值一致表示成功。


如果需要自己生成so库，请看博客： https://blog.csdn.net/yuzhiqiang_1993/article/details/121317195

source目录中有bzip和bsdiff源码文件。



