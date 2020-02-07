package com.example.dynamicfeature

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.SampleApplication
import com.example.app.SampleInterface
import javax.inject.Inject

class FeatureActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleInterface: SampleInterface

    lateinit var component: FeatureComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        component = DaggerFeatureComponent.factory().create(
            (application as SampleApplication).appComponent
        )
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        Toast.makeText(
            this,
            sampleInterface.getText(),
            Toast.LENGTH_SHORT
        ).show()
    }
}