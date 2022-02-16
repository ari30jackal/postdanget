package com.digimaster.daylima.util.digiuikit

import android.text.Html
import android.text.Spanned

fun convertHtmlString(htmlString: String): Spanned {

        val htmlAsString = htmlString
        val htmlAsSpanned: Spanned = Html.fromHtml(htmlAsString)
        return htmlAsSpanned

}