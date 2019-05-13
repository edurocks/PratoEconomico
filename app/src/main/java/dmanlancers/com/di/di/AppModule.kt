package dmanlancers.com.di.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dmanlancers.com.R
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(application : Application) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(application.getString(R.string.server_url))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}