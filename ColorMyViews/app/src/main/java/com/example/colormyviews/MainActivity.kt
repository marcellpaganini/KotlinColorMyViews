package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val instructions : Instructions = Instructions("How to play: ", "Tap the views and buttons.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.instructions = instructions

        binding.labelText.text = instructions.label
        binding.infoText.text = instructions.text

        setListeners()
    }

    private fun makeColored(view : View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.sky1)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.sky2)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.sky3)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.sky4)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.sky5)
            R.id.red_button -> view.setBackgroundColor(Color.RED)
            R.id.yellow_button -> view.setBackgroundColor(Color.YELLOW)
            R.id.green_button -> view.setBackgroundColor(Color.GREEN)
            else -> view.setBackgroundResource(R.drawable.skybg)
        }
    }

    private fun setListeners() {

        val boxOneText = binding.boxOneText
        val boxTwoText = binding.boxTwoText
        val boxThreeText = binding.boxThreeText
        val boxFourText = binding.boxFourText
        val boxFiveText = binding.boxFiveText

        val redButton = binding.redButton
        val greenButton = binding.greenButton
        val yellowButton = binding.yellowButton

        val rootConstraintLayout = binding.constraintLayout

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
            redButton, greenButton, yellowButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }


}