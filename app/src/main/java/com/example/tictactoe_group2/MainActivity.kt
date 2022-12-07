package com.example.tictactoe_group2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    var gamerPos = 0

    val firstGamerList = mutableListOf<Int>()
    val secondGamerList = mutableListOf<Int>()
    lateinit var refreshBtn: Button

    lateinit var text1: TextView
    lateinit var text2: TextView

    companion object{
        val finByList = mutableListOf<Button>()
        var winGamer1 = 0
        var winGamer2 = 0
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshBtn = findViewById(R.id.refresh)

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)

        for (i in 1..9){
            val btnId = "btn$i"
            val resId = resources.getIdentifier(btnId, "id", packageName)
            finByList.add(findViewById<Button>(resId))
        }

        refreshBtn.setOnClickListener {
            firstGamerList.clear()
            secondGamerList.clear()
            finByList.forEach {
                it.text = null
                it.isEnabled = true
            }
            it.visibility = View.INVISIBLE
        }

    }

    fun btnOnclick(view: View) {
        val id = view.id
        val btn = view as Button

        var btnNum = 0

        when(id){
            R.id.btn1-> {
                startGame(1, btn)
            }
            R.id.btn2-> {
                startGame(2, btn)
            }
            R.id.btn3-> {
                startGame(3, btn)
            }
            R.id.btn4-> {
                startGame(4, btn)
            }
            R.id.btn5-> {
                startGame(5, btn)
            }
            R.id.btn6-> {
                startGame(6, btn)
            }
            R.id.btn7-> {
                startGame(7, btn)
            }
            R.id.btn8-> {
                startGame(8, btn)
            }
            R.id.btn9-> {
                startGame(9, btn)
            }
            else->{

            }

        }

        checkWinner()
    }
    private fun startGame(btnNum: Int, btn: Button) {
        if (gamerPos == 1) {
            btn.text = "X"
            this.gamerPos = 2

            firstGamerList.add(btnNum)
        } else {
            btn.text = "0"
            this.gamerPos = 1

            secondGamerList.add(btnNum)
        }
        btn.isEnabled = false
    }

    private fun checkWinner() {
        var winner = 0

        /*row*/
        // 1-qator
        if (firstGamerList.contains(1) && firstGamerList.contains(2) && firstGamerList.contains(3)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(2) && secondGamerList.contains(3)) {
            winner = 2
        }
        // 2-qator
        if (firstGamerList.contains(4) && firstGamerList.contains(5) && firstGamerList.contains(6)) {
            winner = 1
        }
        if (secondGamerList.contains(4) && secondGamerList.contains(5) && secondGamerList.contains(6)) {
            winner = 2
        }
        // 3-qator
        if (firstGamerList.contains(7) && firstGamerList.contains(8) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(7) && secondGamerList.contains(8) && secondGamerList.contains(9)) {
            winner = 2
        }

        /*column*/
        // 1 - ustun
        if (firstGamerList.contains(1) && firstGamerList.contains(4) && firstGamerList.contains(7)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(4) && secondGamerList.contains(7)) {
            winner = 2
        }
        // 2 - ustun
        if (firstGamerList.contains(2) && firstGamerList.contains(5) && firstGamerList.contains(8)) {
            winner = 1
        }
        if (secondGamerList.contains(2) && secondGamerList.contains(5) && secondGamerList.contains(8)) {
            winner = 2
        }
        // 3 - ustun
        if (firstGamerList.contains(3) && firstGamerList.contains(6) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(3) && secondGamerList.contains(6) && secondGamerList.contains(9)) {
            winner = 2
        }

        //cross 1
        if (firstGamerList.contains(1) && firstGamerList.contains(5) && firstGamerList.contains(9)) {
            winner = 1
        }
        if (secondGamerList.contains(1) && secondGamerList.contains(5) && secondGamerList.contains(9)) {
            winner = 2
        }

        //cross 2
        if (firstGamerList.contains(3) && firstGamerList.contains(5) && firstGamerList.contains(7)) {
            winner = 1
        }
        if (secondGamerList.contains(3) && secondGamerList.contains(5) && secondGamerList.contains(7)) {
            winner = 2
        }

        if (winner != 0) {
            if (winner == 1){
                showToast( "X winner")
                winGamer1++

            }else{
                showToast("0 winner")
                winGamer2++
            }
            gameOver()
            refreshBtn.visibility = View.VISIBLE

            text1.text = "X: $winGamer1"
            text2.text = "0: $winGamer2"

        }


    }
    private fun gameOver() {
        finByList.forEach {
            it.isEnabled = false
        }
    }


    private fun showToast(s:String){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

}