package com.colman.studentsapp.ui

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.applyStatusBarInsetPadding() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        val statusBars = insets.getInsets(WindowInsetsCompat.Type.statusBars())
        // Preserve existing padding and add the inset on top.
        v.setPadding(v.paddingLeft, statusBars.top, v.paddingRight, v.paddingBottom)
        insets
    }
    // Trigger initial insets dispatch.
    requestApplyInsets()
}

