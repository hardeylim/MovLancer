package com.hardeylim.movlancer.usecase

import com.hardeylim.movlancer.usecase.api.ApiModule
import com.hardeylim.movlancer.usecase.internet.DefaultInternetChecker
import com.hardeylim.movlancer.usecase.internet.InternetChecker
import com.hardeylim.movlancer.usecase.internet.InternetUsecaseModule
import com.hardeylim.movlancer.usecase.movie.MovieUsecaseModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        InternetUsecaseModule::class,
        MovieUsecaseModule::class
    ]
)
abstract class UseCaseModule {
}