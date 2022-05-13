package com.arunabimanyu7.pdf.lib.service

import android.content.Context
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.File
import java.io.FileNotFoundException


class PdfService(context: Context) {


    fun renderPdf(filePath: String): ArrayList<PdfRenderer.Page> {

        val pages = ArrayList<PdfRenderer.Page>()

        val renderer = getSeekableFileDescriptor(filePath)?.let { PdfRenderer(it) }


        val pageCount = renderer?.pageCount ?: 0
        for (i in 0 until pageCount) {
            val page: PdfRenderer.Page? = renderer?.openPage(i)
            page?.let { pages.add(it) }
            // close the page
            page?.close()
        }

        renderer?.close()
        return pages
    }

    private fun getSeekableFileDescriptor(filePath: String): ParcelFileDescriptor? {
        val file = File(filePath)
        val pfd: ParcelFileDescriptor = try {
            ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }
        return pfd


    }


    fun terminate() {

    }


}