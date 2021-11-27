package com.adjarabet.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var button1 : View
    lateinit var button2 : View
    lateinit var button3 : View
    lateinit var button4 : View
    lateinit var button5 : View
    lateinit var button6 : View
    lateinit var button7 : View
    lateinit var button8 : View
    lateinit var button9 : View

    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()

    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    private fun check(){
        var winner = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winner = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winner = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9))
            winner = 1
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9))
            winner = 2
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7))
            winner = 2
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7))
            winner = 1
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8))
            winner = 2
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8))
            winner = 1
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9))
            winner = 1
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9))
            winner = 2
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7))
            winner = 2
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7))
            winner = 1
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9))
            winner = 2
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9))
            winner = 1

        if (winner == 1) {
            Toast.makeText(this, "first player won", Toast.LENGTH_SHORT).show()
        } else if (winner == 2){
            Toast.makeText(this, "second player won", Toast.LENGTH_SHORT).show()
        }
    }

    fun playGame(view: Button, buttonNumber: Int){
        if (activePlayer == 1){
            view.text = "X"
            view.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2){
            view.text = "O"
            view.setBackgroundColor(Color.GRAY)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        view.isEnabled = false
        check()

    }




    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }


}