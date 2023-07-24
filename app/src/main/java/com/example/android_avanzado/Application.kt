package com.example.android_avanzado

import android.app.Application
import com.example.android_avanzado.di.appModule
import com.example.android_avanzado.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(){
            androidLogger(
                if(BuildConfig.DEBUG){
                    Level.NONE
                }else{
                    Level.INFO
                }
            )
            androidContext(this@Application)
            modules(
                presentationModule,
                appModule
            )
        }
    }
}