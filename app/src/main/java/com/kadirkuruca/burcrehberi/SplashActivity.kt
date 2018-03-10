package com.kadirkuruca.burcrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.statusBarColor = resources.getColor(R.color.statusBar)
    }

    override fun onResume() {

        var logoDondur = AnimationUtils.loadAnimation(this,R.anim.rotate)
        imgLogo.animation = logoDondur

        object: CountDownTimer(5000,1000){
            override fun onFinish() {
                var intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(p0: Long) {
            }

        }.start()

        super.onResume()
    }
}
