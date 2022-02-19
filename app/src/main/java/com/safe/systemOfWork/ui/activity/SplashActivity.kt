package com.safe.systemOfWork.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.safe.systemOfWork.R
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_splash)

        Timer().schedule(3000) {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }

    }
}