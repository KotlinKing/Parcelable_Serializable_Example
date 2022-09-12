package com.example.passing_data_examples

import android.os.Parcel
import android.os.Parcelable

data class Feedback(val feedback: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString().toString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(feedback)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Feedback> {
        override fun createFromParcel(parcel: Parcel): Feedback {
            return Feedback(parcel)
        }

        override fun newArray(size: Int): Array<Feedback?> {
            return arrayOfNulls(size)
        }
    }
}