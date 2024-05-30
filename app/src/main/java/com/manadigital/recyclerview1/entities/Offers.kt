package com.manadigital.recyclerview1.entities

import android.os.Parcel
import android.os.Parcelable

data class Offers(
    var titulo: String?,
    var descripcion: String?,
    val imagen: Int,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(descripcion)
        parcel.writeInt(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Offers> {
        override fun createFromParcel(parcel: Parcel): Offers {
            return Offers(parcel)
        }

        override fun newArray(size: Int): Array<Offers?> {
            return arrayOfNulls(size)
        }
    }
}