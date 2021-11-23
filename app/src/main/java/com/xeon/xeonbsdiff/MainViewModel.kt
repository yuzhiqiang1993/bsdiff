package com.xeon.xeonbsdiff

import androidx.lifecycle.*
import com.blankj.utilcode.util.*
import com.xeon.bsdiff.utils.XeonBsDiffUtil
import kotlinx.coroutines.*
import java.io.File
import kotlin.system.measureTimeMillis


/**
 * @description: MainViewModel
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/11/16
 * @time   : 22:40
 */

class MainViewModel : ViewModel() {

    /*异常处理*/
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        LogUtils.e("异常了:${throwable.localizedMessage}")
        throwable.printStackTrace()
    }

    /*文件后缀名*/
    private val suffix = "apk"

    /*旧文件*/
    private val oldFile = File(PathUtils.getExternalAppFilesPath(), "old.${suffix}")

    /*新文件*/
    private val newFile = File(PathUtils.getExternalAppFilesPath(), "new.${suffix}")

    /*补丁文件*/
    private val patchFile = File(PathUtils.getExternalAppFilesPath(), "patch.${suffix}")

    /*合并后的文件*/
    private val combineFile = File(PathUtils.getExternalAppFilesPath(), "combine.${suffix}")

    /*生成补丁文件*/
    fun fileDiff() {
        viewModelScope.launch(exceptionHandler) {

            val measureTimeMillis = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    if (!oldFile.exists() || !newFile.exists()) {
                        ToastUtils.showShort("对比包缺失")
                        return@withContext
                    }

                    /*生成补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
                    val result = XeonBsDiffUtil.bsdiff(
                        newFile.absolutePath,//新文件path
                        oldFile.absolutePath,//旧文件path
                        patchFile.absolutePath//补丁文件path
                    )

                }
            }

            LogUtils.i("生成补丁文件耗时:${measureTimeMillis}")
            LogUtils.i("oldFileSize:${FileUtils.getSize(oldFile)}")
            LogUtils.i("newFileSize:${FileUtils.getSize(newFile)}")
            LogUtils.i("patchFileSize:${FileUtils.getSize(patchFile)}")

        }

    }

    /*合并补丁文件*/
    fun filePatch() {
        viewModelScope.launch(exceptionHandler) {
            val measureTimeMillis = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    LogUtils.e(PathUtils.getExternalAppFilesPath())
                    if (!oldFile.exists() || !patchFile.exists()) {
                        ToastUtils.showShort("补丁文件或旧文件缺失")
                        return@withContext
                    }
                    /*合并补丁包，耗时操作，记得放在子线程  返回值 0表示成功*/
                    val result = XeonBsDiffUtil.bspatch(
                        oldFile.absolutePath,
                        patchFile.absolutePath,
                        combineFile.absolutePath
                    )
                }
            }
            LogUtils.i("合并补丁文件耗时:${measureTimeMillis}")
            LogUtils.i("newFile MD5:${FileUtils.getFileMD5ToString(newFile)}")
            LogUtils.i("combineFile MD5:${FileUtils.getFileMD5ToString(combineFile)}")

        }

    }
}

