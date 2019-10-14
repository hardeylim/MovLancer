package com.hardeylim.movlancer.framework

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

//Custom Application that allows initial setups for the entire app
//Need to add this to Android Manifest
open class MovLancerApplication: Application(), HasAndroidInjector{

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    private lateinit var component: MovLancerComponent

    override fun androidInjector(): AndroidInjector<Any>  = androidInjector

    override fun onCreate() {
        super.onCreate()
        initializeComponent().inject(this)
    }

    protected open fun initializeComponent(): MovLancerComponent {
        component = DaggerMovLancerComponent
            .builder()
            .application(this)
            .build()
        return component
    }
}