package com.Assignment.activitywithtwotextviews

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var portraitCount=1
    private var landscapeCount = 0
    var handle = Handler()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        var text: TextView = findViewById(R.id.MyFirstTextView);
         handle.postDelayed({
             text.text = "MyFirstTextView is on create state";
         }, 1500)


         var ChangeActivityBtn: Button = findViewById(R.id.button)
         ChangeActivityBtn.setOnClickListener {
             val intent = Intent(this, ActivityWithTwoButtons::class.java)
             startActivity(intent)
         }


    }

    override fun onStart() {
            super.onStart()
            var text: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({text.text = "MyFirstTextView is starting"

        },2000)


        }


    override fun onResume() {
        super.onResume()
        var text: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            text.text = "MyFirstTextView is resuming"
        },2500)

    }

    override fun onPause() {
        super.onPause()
        var text: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            text.text = "MyFirstTextView is  paused"
        },3000)

    }

    override fun onStop() {
        super.onStop()
        var text: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            text.text = "MyFirstTextView has been stopped"
        },3500)

    }

    override fun onRestart() {
        super.onRestart()
        var text: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            text.text = "MyFirstTextView is restarting"
        },4000)

    }

    override fun onDestroy() {
        super.onDestroy()
        var text: TextView = findViewById(R.id.MyFirstTextView)
        text.text = "MyFirstTextView is destroyed"
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val text: TextView = findViewById(R.id.MySecondTextView)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                landscapeCount++
            text.text = "my Secondtextview is landscape: "+ landscapeCount
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitCount++
            text.text = "my Secondtextview is potrait: "+ portraitCount
        }

    }

    }



