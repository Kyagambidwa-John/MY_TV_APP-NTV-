package com.example.navigationappp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_screen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000 //time 3seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            //code executed when the timer is finished
            //start the home activity
            startActivity(Intent(this,MainActivityy::class.java))

            //close the activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
