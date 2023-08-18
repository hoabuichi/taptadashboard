package com.example.taptadashboard.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun formatter(n: Long, locale: Locale): String =
    DecimalFormat("#,###", DecimalFormatSymbols(locale)).format(n)