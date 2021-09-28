package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText,binding.boxThreeText,
                binding.boxFourTex, binding.boxFiveText, binding.constraintLayout,
            binding.greenButton, binding.yellowButton, binding.redButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        binding.apply {
            when (view) {
                //getResources().getColor
                //Boxes using Color class colors for background
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)
                //Boxes using Android color resources for background
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourTex -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                //boxes using custom colors for backGround
                redButton -> boxThreeText.setBackgroundResource(R.color.myRed)
                yellowButton -> boxFourTex.setBackgroundResource(R.color.myYellow)
                greenButton -> boxFiveText.setBackgroundResource(R.color.myGreen)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}