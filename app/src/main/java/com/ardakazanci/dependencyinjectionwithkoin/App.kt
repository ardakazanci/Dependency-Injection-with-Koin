package com.ardakazanci.dependencyinjectionwithkoin

import android.app.Application
import com.ardakazanci.dependencyinjectionwithkoin.di.apiModule
import com.ardakazanci.dependencyinjectionwithkoin.di.repositoryModule
import com.ardakazanci.dependencyinjectionwithkoin.di.retrofitModule
import com.ardakazanci.dependencyinjectionwithkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }

}