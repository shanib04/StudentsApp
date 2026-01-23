package com.colman.studentsapp.model

import androidx.annotation.DrawableRes

data class Student(
    val uuid: String,
    var id: String,
    var name: String,
    var address: String,
    var phoneNumber: String,
    var isChecked: Boolean,
    @DrawableRes val imageResId: Int,
)
