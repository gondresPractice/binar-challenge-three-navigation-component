package com.projectpertama.navsample.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val umur: Int?,
    val alamat: String?,
    val status: String?
        ):Parcelable