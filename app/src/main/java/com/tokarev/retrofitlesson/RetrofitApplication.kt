package com.tokarev.retrofitlesson

import android.app.Application
import org.koin.android.ext.android.startKoin

class RetrofitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(mainModule))
    }
}