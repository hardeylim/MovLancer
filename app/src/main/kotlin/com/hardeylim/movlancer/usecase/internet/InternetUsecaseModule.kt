package com.hardeylim.movlancer.usecase.internet

import dagger.Binds
import dagger.Module

@Module
abstract class InternetUsecaseModule {

    @Binds
    internal abstract fun bindInternetChecker(defaultInternetChecker: DefaultInternetChecker) : InternetChecker
}