package com.example.app

import dagger.Binds
import dagger.Component
import dagger.Module

@Component(
    modules = [
        Module1::class
    ]
)
interface AppComponent {

    fun exposeSampleInterface(): SampleInterface

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}

@Module
interface Module1 {

    @Binds
    fun bindSampleInteractor(sampleInterfaceImpl: SampleInterfaceImpl): SampleInterface
}