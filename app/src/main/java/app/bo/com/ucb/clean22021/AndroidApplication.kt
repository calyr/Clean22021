package app.bo.com.ucb.clean22021

import android.app.Application

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}