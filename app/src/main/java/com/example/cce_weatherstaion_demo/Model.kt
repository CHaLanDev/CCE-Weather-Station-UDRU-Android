package com.example.cce_weatherstaion_demo

import android.text.SpannableStringBuilder
import com.google.gson.annotations.SerializedName

data class Model (
        @SerializedName("PM10") val PM10:Double?,
        @SerializedName("Tempurature") val Temperature:Double?,
        @SerializedName("Humidity") val Humidity:Double?,
        @SerializedName("Wind") val Wind:Double?,
        @SerializedName("Wind_Direction") val Wind_Direction:String?,
        @SerializedName("Rain") val Rain:Double?,
        @SerializedName("Pressure") val Pressure:Double?,
        @SerializedName("Solar") val Solar:Double?,
        @SerializedName("UV") val UV:String?
)




