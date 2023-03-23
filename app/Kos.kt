package com.example.carikos2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kos(
    var photo: Int,
    var name: String,
    var location: String,
    var distance: String
): Parcelable
//menit ke 41
