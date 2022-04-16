package bgtap.babbangona.waliquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btNStart:Button = findViewById(R.id.btnStart)
        val enterName:AppCompatEditText = findViewById(R.id.enterName)
        btNStart.setOnClickListener {
            if (enterName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please input your name to start the quiz", Toast.LENGTH_LONG)
                    .show()
            } else {
               val intent =Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, enterName.text.toString())
                startActivity(intent)
                finish()
            }

        }


    }
}