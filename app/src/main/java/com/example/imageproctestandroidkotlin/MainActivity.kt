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
    private lateinit var mImageView: ImageView
    private lateinit var mBitmap: Bitmap
    private lateinit var mBtnMono: Button
    private lateinit var mBtnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayout()
    }

    /**
     * レイアウトの初期設定
     */
    private fun initLayout() {
        mImageView = findViewById(R.id.image)
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)

        mBtnMono = findViewById(R.id.mono)
        mBtnMono?.setOnClickListener { onClickBtnMono() }

        mBtnReset = findViewById(R.id.reset)
        mBtnReset?.setOnClickListener { onClickBtnReset() }
    }

    /**
     * モノクロボタンのクリックイベント
     */
    private fun onClickBtnMono() {
        var gray = GrayScale()
        var mutableBitmap = gray.goImgProc(mBitmap)
        mImageView.setImageBitmap(mutableBitmap.copy(Bitmap.Config.ARGB_8888, false))
    }

    /**
     * リセットボタンのクリックイベント
     */
    private fun onClickBtnReset() {
        mImageView.setImageBitmap(mBitmap)
    }
}
