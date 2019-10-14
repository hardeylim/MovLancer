package com.hardeylim.movlancer.usecase.api

import com.hardeylim.movlancer.BuildConfig
import com.hardeylim.movlancer.Constants.NamedInjections.INTERNET_CHECKER
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Provides the bindings/dependencies for all Retrofit Service interfaces.
 */
@Module
class InternetCheckerRetrofitModule {

    @Provides
    @Singleton
    internal fun provideInternetCheckerApi(@Named(INTERNET_CHECKER) retrofit: Retrofit): InternetCheckerApi =
        retrofit.create(InternetCheckerApi::class.java)

    @Provides
    @Singleton
    @Named(INTERNET_CHECKER)
    internal fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(loggingInterceptor)
        builder.readTimeout(60, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(BuildConfig.GOOGLE_URL)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
