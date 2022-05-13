package com.arunabimanyu7.pdf.lib


import android.content.Context
import android.graphics.pdf.PdfRenderer
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arunabimanyu7.pdf.lib.adapter.PdfAdapter
import com.arunabimanyu7.pdf.lib.model.Source
import com.arunabimanyu7.pdf.lib.service.PdfService


/*
@Author Arunachalam K
@CreatedOn 1/28/2020
*/
class PdfView : RecyclerView {


    private var source: Source? = null

    private var pdfDataItemList = ArrayList<PdfRenderer.Page>()

    val pdfService by lazy {
        PdfService(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet) {
        val typeAttributeSet = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PdfView,
            0, 0
        )

        try {
            if (typeAttributeSet.hasValue(R.styleable.PdfView_filePath)) {
                source = Source(
                    filePath = typeAttributeSet.getString(R.styleable.PdfView_filePath)
                )


            }

            setUpAdapter()

        } finally {
            typeAttributeSet.recycle()
        }
    }

    private fun setUpAdapter() {
        source?.filePath?.let { pdfService.renderPdf(it) }?.let { pdfDataItemList.addAll(it) }
        adapter = PdfAdapter(pdfDataItemList)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }


}