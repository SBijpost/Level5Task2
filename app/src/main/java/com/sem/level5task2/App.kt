package com.sem.level5task2

import android.app.Application
import android.content.Context


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object {
        private var mContext: Context? = null
        val context: Context?
            get() = mContext
    }
}