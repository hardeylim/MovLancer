package com.hardeylim.movlancer.framework

import com.hardeylim.movlancer.feature.FeatureModule
import com.hardeylim.movlancer.usecase.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidInjectionModule::class,
        FeatureModule::class,
        UseCaseModule::class
    ]
)
@Singleton
interface MovLancerComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MovLancerApplication): Builder

        fun build(): MovLancerComponent
    }

    fun inject(app: MovLancerApplication)
}