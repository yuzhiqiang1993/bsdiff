package com.yzq.bsdiff.demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yzq.bsdiff.demo.databinding.ActivityMainBinding

/**
 * @description: MainActiviy
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/11/17
 * @time   : 21:46
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*生成补丁包*/
        binding.btnDiff.setOnClickListener {
            vm.fileDiff()
        }

        /*合并补丁包*/
        binding.btnPatch.setOnClickListener {
            vm.filePatch()
        }

    }


}