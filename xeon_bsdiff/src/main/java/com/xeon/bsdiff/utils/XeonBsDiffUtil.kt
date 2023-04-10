package com.xeon.bsdiff.utils

/**
 * @description: BsDiff工具类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/11/16
 * @time   : 22:12
 */

object XeonBsDiffUtil {

    init {
        kotlin.runCatching {
            System.loadLibrary("xeon_bsdiff")
        }

    }

    /**
     * 生成补丁包
     * @param newFilePath String 新文件的地址
     * @param oldFilePath String  旧文件的地址
     * @param patchFilePath String  生成的补丁文件地址
     * @return Int
     */
    external fun bsdiff(newFilePath: String, oldFilePath: String, patchFilePath: String): Int

    /**
     * 合并差分包
     * @param oldFilePath String 旧文件地址
     * @param patchFilePath String 补丁文件地址
     * @param combineFilePath String 合并后的新文件地址
     * @return Int
     */
    external fun bspatch(oldFilePath: String, patchFilePath: String, combineFilePath: String): Int

}