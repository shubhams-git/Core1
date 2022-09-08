package com.example.core1

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    var opResult: Int = 0




    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "restart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Result", opResult )
        Log.i("Lifecycle", "saveInstanceState $opResult")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        opResult = savedInstanceState.getInt("Result")
        val counter = findViewById<TextView>(R.id.counter)
        counter.text = opResult.toString()
        Log.i("Lifecycle", "restoreInstanceState $opResult")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val scoreBtn=findViewById<Button>(R.id.score)
        val stealBtn=findViewById<Button>(R.id.steal)
        val resetBtn=findViewById<Button>(R.id.reset)
        val counterText=findViewById<TextView>(R.id.counter)
        var player = MediaPlayer.create(this, R.raw.explosion)


        scoreBtn.setOnClickListener{

            if(opResult >= 15)
                player.start()

            if(opResult<15)
                opResult++
                counterText.setTextColor(Color.parseColor(CheckColor(opResult)))
                counterText.text = opResult.toString()
        }

        stealBtn.setOnClickListener{
            if(opResult>0)
                opResult--
                counterText.setTextColor(Color.parseColor(CheckColor(opResult)))
                counterText.text = opResult.toString()
        }

        resetBtn.setOnClickListener{
            opResult = 0
            counterText.setTextColor(Color.parseColor(CheckColor(opResult)))
            counterText.text = opResult.toString()
        }



    }
    fun CheckColor(score: Int): String
    {
        var color = when(score){
            in 5..9 -> "#0000FF"
            in 10..15 -> "#00FF00"
            else -> "#000000"
        }

        return color
    }




}