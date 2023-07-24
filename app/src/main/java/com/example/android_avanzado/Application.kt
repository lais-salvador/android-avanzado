package com.example.android_avanzado

import android.app.Application
import com.example.android_avanzado.di.dataModule
import com.example.android_avanzado.di.domainModule
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
                    Level.INFO
                }else{
                    Level.NONE
                }
            )
            androidContext(this@Application)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}