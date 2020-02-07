package com.example.app

import javax.inject.Inject

class SampleInterfaceImpl @Inject constructor() : SampleInterface {

    override fun getText(): String = "Hello, from :app !"
}