package com.example.imageproctestandroidkotlin

import android.graphics.Bitmap

/**
 * グレースケール
 */
class GrayScale {
    /**
     * コンストラクタ
     */
    public class GrayScale() {}

    /**
     * グレースケールの実行
     * @args bitmap ビットマップ
     * @return return グレースケール後のビットマップ
     */
    public fun goImgProc(bitmap: Bitmap): Bitmap {

        var pixels = IntArray(bitmap.width * bitmap.height);
        var resultPixels = IntArray(bitmap.width * bitmap.height)

        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        for ((count, argb) in pixels.withIndex()) {
            var red = android.graphics.Color.red(argb)
            var green = android.graphics.Color.green(argb)
            var blue = android.graphics.Color.blue(argb)
            var alpha = android.graphics.Color.alpha(argb)
            var gray = (red + green + blue) / 3
            resultPixels[count] = android.graphics.Color.argb(alpha, gray, gray, gray)
        }

        var mutableBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        mutableBitmap.setPixels(resultPixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        return mutableBitmap;
    }
}