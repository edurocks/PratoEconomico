package dmanlancers.com

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dmanlancers.com.di.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}