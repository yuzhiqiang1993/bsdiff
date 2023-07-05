package com.yzq.bsdiff

/**
 * @description: BsDiff工具类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/11/16
 * @time   : 22:12
 */

object BsDiffTool {

    init {
        kotlin.runCatching {
            System.loadLibrary("xeon_bsdiff")
        }

    }


    /**
     * 生成差分包
     * @param newFilePath String 新文件地址
     * @param oldFilePath String 旧文件地址
     * @param patchFilePath String 生成的差分包地址
     * @return Int 0表示成功
     */
    external fun diff(newFilePath: String, oldFilePath: String, patchFilePath: String): Int

    /**
     * 合并差分包
     * @param oldFilePath String 旧文件地址
     * @param patchFilePath String 补丁文件地址
     * @param combineFilePath String 合并后的新文件地址
     * @return Int 0表示成功
     */
    external fun patch(oldFilePath: String, patchFilePath: String, combineFilePath: String): Int

}