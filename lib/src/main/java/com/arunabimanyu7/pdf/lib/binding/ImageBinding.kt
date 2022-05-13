package com.arunabimanyu7.pdf.lib.binding

import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.pdf.PdfRenderer
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ImageBinding {


    @JvmStatic
    @BindingAdapter(value = ["bind:page"], requireAll = false)
    fun bindImageView(view: ImageView, page: PdfRenderer.Page) {
        val bitmap = createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)

        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        view.setImageBitmap(bitmap)

    }
}


