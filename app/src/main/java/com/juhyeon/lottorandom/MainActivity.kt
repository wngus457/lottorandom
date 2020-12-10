package com.juhyeon.lottorandom

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener(View.OnClickListener {
            var list = ArrayList<Int>()
            for(i in 0..6 step 1) {
                var randomNumber = Random.nextInt(45)
                if (list.contains(randomNumber) || randomNumber == 0) {
                    while (true) {
                        randomNumber = Random.nextInt(45)
                        if (!list.contains(randomNumber) && randomNumber != 0) {
                            list.add(randomNumber)
                            break
                        }
                    }
                } else {
                    list.add(randomNumber)
                }
            }

            setText(lottoNumber1, backColor(list[0]), list[0].toString())
            setText(lottoNumber2, backColor(list[1]), list[1].toString())
            setText(lottoNumber3, backColor(list[2]), list[2].toString())
            setText(lottoNumber4, backColor(list[3]), list[3].toString())
            setText(lottoNumber5, backColor(list[4]), list[4].toString())
            setText(lottoNumber6, backColor(list[5]), list[5].toString())
            setText(lottoNumber7, backColor(list[6]), list[6].toString())


        })
    }

    fun backColor(number: Int): Drawable? {
        var contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_white)
        when(number){
            in 1..10 -> contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_yello)
            in 11..20 -> contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_blue)
            in 21..30 -> contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_red)
            in 31..40 -> contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_gray)
            in 41..45 -> contxt = ContextCompat.getDrawable(this, R.drawable.text_circle_green)
        }
        return contxt
    }

    fun setText(textView: TextView, color: Drawable?, numberText: String){
        textView.setText(numberText)
        textView.background = color
    }
}