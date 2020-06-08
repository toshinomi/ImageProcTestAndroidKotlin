package com.example.imageproctestandroidkotlin

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.imageproctestandroidkotlin.GrayScale
import com.example.imageproctestandroidkotlin.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayout()
    }

    /**
     * レイアウトの初期設定
     */
    private fun initLayout() {
        var btnMono: Button = findViewById(R.id.mono)
        btnMono?.setOnClickListener { onClickBtnMono() }

        var btnReset: Button = findViewById(R.id.reset)
        btnReset?.setOnClickListener { onClickBtnReset() }
    }

    /**
     * モノクロボタンのクリックイベント
     */
    private fun onClickBtnMono() {
        var gray = GrayScale()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        var mutableBitmap = gray.goImgProc(bitmap)
        var imageView: ImageView = findViewById(R.id.image)
        imageView?.setImageBitmap(mutableBitmap.copy(Bitmap.Config.ARGB_8888, false))
    }

    /**
     * リセットボタンのクリックイベント
     */
    private fun onClickBtnReset() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        var imageView: ImageView = findViewById(R.id.image)
        imageView?.setImageBitmap(bitmap)
    }
}
