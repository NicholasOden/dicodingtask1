package com.example.carikos2

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseFirebase(
	@SerializedName("name")
	val name: String,
	@SerializedName("distance")
	val distance: String? = null,
	@SerializedName("jenis")
	val jenis: String? = null,
	@SerializedName("location")
	val location: String? = null
): Parcelable
