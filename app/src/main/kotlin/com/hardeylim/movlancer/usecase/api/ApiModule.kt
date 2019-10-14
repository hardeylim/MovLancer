package com.hardeylim.movlancer.usecase.api

import dagger.Module


@Module(
    includes = [
        InternetCheckerRetrofitModule::class,
        MoviesDbRetrofitModule::class
    ]
)
class ApiModule {
}