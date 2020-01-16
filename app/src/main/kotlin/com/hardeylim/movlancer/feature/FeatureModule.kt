package com.hardeylim.movlancer.feature

import com.hardeylim.movlancer.feature.movie.MovieModule
import dagger.Module

@Module(
    includes = [
        MovieModule::class
    ]
)
class FeatureModule