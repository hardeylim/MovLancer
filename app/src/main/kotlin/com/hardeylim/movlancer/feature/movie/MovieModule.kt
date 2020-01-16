package com.hardeylim.movlancer.feature.movie

import com.hardeylim.movlancer.feature.movie.popular.list.PopularListModule
import dagger.Module

@Module(
    includes = [
        PopularListModule::class
    ]
)
class MovieModule