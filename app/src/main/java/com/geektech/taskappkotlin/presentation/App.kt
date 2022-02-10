package com.geektech.taskappkotlin.presentation

import android.app.Application
import androidx.room.Room
import com.geektech.taskappkotlin.data.AppDataBase

class App:Application() {
    companion object {
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(this, AppDataBase::class.java, "database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}