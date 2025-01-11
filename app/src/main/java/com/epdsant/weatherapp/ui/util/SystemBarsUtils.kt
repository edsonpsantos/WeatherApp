package com.epdsant.weatherapp.ui.util

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController


fun setSystemBarsAppearance(window: Window) {

    val isDarkMode = (window.context.resources.configuration.uiMode and
            android.content.res.Configuration.UI_MODE_NIGHT_MASK) ==
            android.content.res.Configuration.UI_MODE_NIGHT_YES

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        // To Android 11 (API 30) ou latest
        window.insetsController?.apply {
            if (isDarkMode) {
                setSystemBarsAppearance(0,0)
            }else {
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            }
        }
    } else {
        @Suppress("DEPRECATION")
        if (isDarkMode) {
            window.decorView.systemUiVisibility = 0 // No modo escuro, usa o padrão
        } else {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }
}