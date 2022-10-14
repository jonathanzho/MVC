package com.example.mvc

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    // creating object of Model class
    var mModel: Model? = null

    // creating object of Button class
    var mButton1: Button? = null
    var mButton2: Button? = null
    var mButton3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating relationship between the
        // observable Model and the
        // observer Activity
        mModel = Model(3)
        mModel!!.addObserver(this)

        // assigning button IDs to the objects
        mButton1 = findViewById(R.id.button1)
        mButton2 = findViewById(R.id.button2)
        mButton3 = findViewById(R.id.button3)


        // transfer the control to Onclick() method
        // when a button is clicked by passing
        // argument "this"
        mButton1?.setOnClickListener(this)
        mButton2?.setOnClickListener(this)
        mButton3?.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()

        mModel?.let { update(it, null) }
    }

    // calling setValueAtIndex() method
    // by passing appropriate arguments
    // for different buttons
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> mModel?.incrementValueAtIndex(0)
            R.id.button2 -> mModel?.incrementValueAtIndex(1)
            R.id.button3 -> mModel?.incrementValueAtIndex(2)
        }
    }

    // function to update the view after
    // the values are modified by the model
    override fun update(arg0: Observable, arg1: Any?) {

        // changing text of the buttons
        // according to updated values
        mButton1!!.text = getString(R.string.count, mModel!!.getValueAtIndex(0))
        mButton2!!.text = getString(R.string.count, mModel!!.getValueAtIndex(1))
        mButton3!!.text = getString(R.string.count, mModel!!.getValueAtIndex(2))
    }
}
