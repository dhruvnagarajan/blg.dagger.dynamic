package com.example.dynamicfeature

import com.example.app.AppComponent
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class
    ]
)
interface FeatureComponent {

    @Component.Factory
    interface Factory {

        fun create(appComponent: AppComponent): FeatureComponent
    }

    fun inject(featureActivity: FeatureActivity)
}