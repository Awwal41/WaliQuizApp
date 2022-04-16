package bgtap.babbangona.waliquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName: TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button =findViewById(R.id.btn_finish)
        val ivStatus:ImageView? =findViewById(R.id.iv_status)
        val tvStatus: TextView?=findViewById(R.id.tv_congratulations)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tvName.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_QUESTIONS,0)
        tvScore.text="Your Score is $correctAnswers out of $totalQuestions"

        if(correctAnswers>=3){
            tvStatus?.text="Hey, Congratulation you passed the test"
        }else {
            tvStatus?.text="Hey, Sorry you failed the test please try again"
        }

        if(correctAnswers>=3){
            ivStatus?.setImageDrawable(getResources().getDrawable(R.drawable.trophy))
        }else {
            ivStatus?.setImageDrawable(getResources().getDrawable(R.drawable.failed))
        }

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java ))
        }

    }
}