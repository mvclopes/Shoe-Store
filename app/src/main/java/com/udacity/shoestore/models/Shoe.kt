package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Shoe(
    var name: String = "",
    var size: Int = 0,
    var company: String = "",
    var description: String = ""
)