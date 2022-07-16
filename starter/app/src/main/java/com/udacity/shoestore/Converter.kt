package com.udacity.shoestore

import androidx.databinding.InverseMethod

//TODO: Udacity suggestion -> https://developer.android.com/topic/libraries/data-binding/two-way#converters
object Converter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(
        value: Double
    ): String {
        // Converts long to String.
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(
        value: String
    ): Double {
        // Converts String to long.
        return if (value.isNotEmpty())
            value.toDouble()
        else
            0.0
    }
}