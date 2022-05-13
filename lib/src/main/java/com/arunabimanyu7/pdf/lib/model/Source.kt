package com.arunabimanyu7.pdf.lib.model

data class Source(
    val filePath: String?
)

sealed class SourceType {

    class Remote(val source: Source) : SourceType()

    class Local(val source: Source) : SourceType()

}