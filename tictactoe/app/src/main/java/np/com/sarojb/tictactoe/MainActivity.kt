package np.com.sarojb.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click_button(view: View) {
        val selected_button: Button = view as Button
        var button_id = 0;
        when (selected_button.id) {
            R.id.button_1 -> button_id = 1
            R.id.button_2 -> button_id = 2
            R.id.button_3 -> button_id = 3
            R.id.button_4 -> button_id = 4
            R.id.button_5 -> button_id = 5
            R.id.button_6 -> button_id = 6
            R.id.button_7 -> button_id = 7
            R.id.button_8 -> button_id = 8
            R.id.button_9 -> button_id = 9
        }
//        Toast.makeText(this, "id" + button_id, Toast.LENGTH_LONG).show()
        playGame(button_id, selected_button)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var active_player = 1

    private fun playGame(buttonId: Int, selectedButton: Button) {
        if (active_player == 1) {
            player1.add(buttonId)
            selectedButton.text = "X"
            selectedButton.setBackgroundColor(Color.GREEN)
            active_player = 2
        } else {
            player2.add(buttonId)
            selectedButton.text = "0"
            selectedButton.setBackgroundColor(Color.BLUE)
            active_player = 1
        }
        selectedButton.isEnabled = false
        winner()
    }

    fun winner() {
        var winner: Int = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) || player1.contains(4) && player1.contains(
                5
            ) && player1.contains(6)
            || player1.contains(7) && player1.contains(8) && player1.contains(9) || player1.contains(
                1
            ) && player1.contains(4) && player1.contains(7)
            || player1.contains(2) && player1.contains(5) && player1.contains(8) || player1.contains(
                3
            ) && player1.contains(6) && player1.contains(9)
            || player1.contains(1) && player1.contains(5) && player1.contains(9) || player1.contains(
                3
            ) && player1.contains(5) && player1.contains(7)
        )
            winner = 1


        if (player2.contains(1) && player2.contains(2) && player2.contains(3) || player2.contains(4) && player2.contains(
                5
            ) && player2.contains(6)
            || player2.contains(7) && player2.contains(8) && player2.contains(9) || player2.contains(
                1
            ) && player2.contains(4) && player2.contains(7)
            || player2.contains(2) && player2.contains(5) && player2.contains(8) || player2.contains(
                3
            ) && player2.contains(6) && player2.contains(9)
            || player2.contains(1) && player2.contains(5) && player2.contains(9) || player2.contains(
                3
            ) && player2.contains(5) && player2.contains(7)
        )
            winner = 2
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Winner is " + "Player 1", Toast.LENGTH_SHORT).show()
//                reset()

            } else {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
//                reset()
            }
        }

    }

//    private fun reset() {
//        button_1.isEnabled = true
//        button_1.text = ""
//        button_1.setBackgroundColor(Color.LTGRAY)
//
//        button_2.isEnabled = true
//        button_2.text = ""
//        button_2.setBackgroundColor(Color.LTGRAY)
//
//        button_3.isEnabled = true
//        button_3.text = ""
//        button_3.setBackgroundColor(Color.LTGRAY)
//
//        button_4.isEnabled = true
//        button_4.text = ""
//        button_4.setBackgroundColor(Color.LTGRAY)
//
//        button_5.isEnabled = true
//        button_5.text = ""
//        button_5.setBackgroundColor(Color.LTGRAY)
//
//        button_6.isEnabled = true
//        button_6.text = ""
//        button_6.setBackgroundColor(Color.LTGRAY)
//
//        button_7.isEnabled = true
//        button_7.text = ""
//        button_7.setBackgroundColor(Color.LTGRAY)
//
//        button_8.isEnabled = true
//        button_8.text = ""
//        button_8.setBackgroundColor(Color.LTGRAY)
//
//        button_9.isEnabled = true
//        button_9.text = ""
//        button_9.setBackgroundColor(Color.LTGRAY)
//
//    }

}