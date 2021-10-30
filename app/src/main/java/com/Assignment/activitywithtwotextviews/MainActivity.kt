package com.Assignment.activitywithtwotextviews

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
//global variables to keep orientation change count for landscape and portrait
    private var portraitCount=1
    private var landscapeCount = 0

//variable holding the handler for implementing delay
    var handle = Handler()

// overriding the onCREATE lifecycle process and implementing delay
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//variable showing the text displayed during the onCreate process
        var onCreatetext: TextView = findViewById(R.id.MyFirstTextView);
         handle.postDelayed({
             onCreatetext.text = "MyFirstTextView is on create state";
         }, 1500)

//button to switch to the next activity
         var ChangeActivityBtn: Button = findViewById(R.id.button)
         ChangeActivityBtn.setOnClickListener {
             val intent = Intent(this, ActivityWithTwoButtons::class.java)
             startActivity(intent)
         }


    }
// overriding the onStart lifecycle process and implementing delay
    override fun onStart() {
            super.onStart()

//variable showing the text displayed during the onStart process
    var onStartText: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            onStartText.text = "MyFirstTextView is starting"

        },2000)


        }

// overriding the onResume lifecycle process and implementing delay
    override fun onResume() {
        super.onResume()
        var onResumeText: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            onResumeText.text = "MyFirstTextView is resuming"
        },2500)

    }
// overriding the onPause lifecycle process and implementing delay
    override fun onPause() {
        super.onPause()
        var onPauseText: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            onPauseText.text = "MyFirstTextView is  paused"
        },3000)

    }
// overriding the onStop lifecycle process and implementing delay
    override fun onStop() {
        super.onStop()
        var onStopText: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            onStopText.text = "MyFirstTextView has been stopped"
        },3500)

    }
// overriding the onRestart lifecycle process and implementing delay
    override fun onRestart() {
        super.onRestart()
        var onRestartText: TextView = findViewById(R.id.MyFirstTextView)
        handle.postDelayed({
            onRestartText.text = "MyFirstTextView is restarting"
        },4000)

    }
// overriding the onDestroy lifecycle process and implementing delay
    override fun onDestroy() {
        super.onDestroy()
        var onDestroyText: TextView = findViewById(R.id.MyFirstTextView)
        onDestroyText.text = "MyFirstTextView is destroyed"
    }

//Tracking orientation change and keeping count(landscape and portrait)
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val orientationtText: TextView = findViewById(R.id.MySecondTextView)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                landscapeCount++
            orientationtText.text = "my Secondtextview is landscape: "+ landscapeCount
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitCount++
            orientationtText.text = "my Secondtextview is potrait: "+ portraitCount
        }

    }

    }



