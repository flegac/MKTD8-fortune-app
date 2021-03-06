package io.monkeypatch.fortunes

import android.app.Application

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Application
    }
}

