package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invoke_feature_button.setOnClickListener {
            openFeatureActivity()
        }
    }

    private fun openFeatureActivity() {
        installFeatureModule {
            val intent = Intent().apply {
                setClassName(
                    BuildConfig.APPLICATION_ID,
                    "com.example.dynamicfeature.FeatureActivity"
                )
            }
            startActivity(intent)
        }
    }

    private fun installFeatureModule(onInstall: () -> Unit) {
        SplitCompat.installActivity(this)
        val splitInstallManager = SplitInstallManagerFactory.create(applicationContext)
        val splitRequest = SplitInstallRequest.newBuilder()
            .addModule("dynamicfeature")
            .build()
        splitInstallManager.startInstall(splitRequest)
            .addOnSuccessListener {
                Log.d("Install", "Success")
                onInstall()
            }
            .addOnCompleteListener {
                Log.d("Install", "Complete")
            }
            .addOnFailureListener {
                Log.d("Install", "Exception")
                it.printStackTrace()
            }
    }
}
