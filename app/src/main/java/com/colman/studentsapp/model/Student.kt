package com.colman.studentsapp.model

import androidx.annotation.DrawableRes

data class Student(
    var id: String,
    var name: String,
    var isChecked: Boolean,
    @DrawableRes val imageResId: Int,
)
