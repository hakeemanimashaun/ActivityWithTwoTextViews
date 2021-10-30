package com.Assignment.activitywithtwotextviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityWithTwoButtons : AppCompatActivity() {
    //variable to keep fragment count
    var fragmentCount = 0
    //override onCreate method and setting content view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_two_buttons)
        //add listener to the add fragment button to track additions and keep count
        findViewById<Button>(R.id.addFragmentButton).setOnClickListener{
            fragmentCount++
            //create new instance of blank fragment, keep count, and add them to the activity backstack
            supportFragmentManager.beginTransaction().add(R.id.fragmentFrame,
                BlankFragment.newInstance("$fragmentCount",""),"Empty Fragment")
                .addToBackStack("backStackFragment").commit()
        }
        //pop backstack to remove fragments
        findViewById<Button>(R.id.removeFragmentButton).setOnClickListener{
            fragmentCount--
            supportFragmentManager.popBackStack()
            findViewById<TextView>(R.id.fragmentText).text = "$fragmentCount"
        }

    }

}