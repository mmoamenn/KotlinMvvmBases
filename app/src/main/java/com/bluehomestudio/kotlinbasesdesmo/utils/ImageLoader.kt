package com.bluehomestudio.kotlinbasesdesmo.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso
import java.io.File

object ImageLoader {

    const val NO_HOLDER = 0

    fun load(imageURL: String,  holder: ImageView) {
        Picasso.get().load(imageURL).into(holder)
    }

    fun load(imageURL: String, @DrawableRes placeHolder: Int, holder: ImageView) {
        Picasso.get().load(imageURL).placeholder(placeHolder).into(holder)
    }

    fun load(@DrawableRes drawable: Int, @DrawableRes placeHolder: Int, holder: ImageView) {
        Picasso.get().load(drawable).placeholder(placeHolder).into(holder)
    }

    fun load(file: File, @DrawableRes placeHolder: Int, holder: ImageView) {
        Picasso.get().load(file).placeholder(placeHolder).into(holder)
    }

}