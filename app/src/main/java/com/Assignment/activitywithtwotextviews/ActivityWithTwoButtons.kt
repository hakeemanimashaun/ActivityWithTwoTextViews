package com.Assignment.activitywithtwotextviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityWithTwoButtons : AppCompatActivity() {
    var fragmentCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_two_buttons)
        findViewById<Button>(R.id.addFragmentButton).setOnClickListener{
            fragmentCount++
            supportFragmentManager.beginTransaction().add(R.id.fragmentFrame,
                BlankFragment.newInstance("$fragmentCount",""),"Empty Fragment").addToBackStack("backStackFragment").commit()
        }
        findViewById<Button>(R.id.removeFragmentButton).setOnClickListener{
            fragmentCount--
            supportFragmentManager.popBackStack()
            findViewById<TextView>(R.id.fragmentText).text = "$fragmentCount"
        }

    }

}