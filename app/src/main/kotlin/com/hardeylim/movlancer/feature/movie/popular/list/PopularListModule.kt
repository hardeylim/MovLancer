package com.hardeylim.movlancer.feature.movie.popular.list

import com.hardeylim.movlancer.feature.movie.popular.list.view.ViewModule
import dagger.Module

@Module(
    includes = [
        ViewModule::class
    ]
)
class PopularListModule