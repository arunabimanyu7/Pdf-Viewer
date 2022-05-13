package com.arunabimanyu7.pdf.lib.adapter

import android.graphics.pdf.PdfRenderer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arunabimanyu7.pdf.lib.R
import com.arunabimanyu7.pdf.lib.databinding.ContainerPdfBinding

class PdfAdapter
constructor(val pdfItemList: ArrayList<PdfRenderer.Page>) :
    RecyclerView.Adapter<PdfAdapter.PdfViewHolder>() {

    inner class PdfViewHolder(val binding: ContainerPdfBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindData(page: PdfRenderer.Page) {
            binding.page = page
            binding.executePendingBindings()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
        val binding: ContainerPdfBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.container_pdf, parent, false
        )
        return PdfViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
        holder.bindData(pdfItemList[position])
    }

    override fun getItemCount(): Int {
        return pdfItemList.size
    }


}