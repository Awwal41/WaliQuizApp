package bgtap.babbangona.waliquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var muserName: String? = null
    private var mCorrectanswers: Int =0
    private var tvOptionone: TextView? = null
    private var tvOptiontwo: TextView? = null
    private var tvOptionthree: TextView? = null
    private var tvOptionfour: TextView? = null
    private var ivImage: ImageView? = null
    private var btnSubmit: Button? = null
    private var currentPosition: Int = 1 // Default and the first question position
    private var questionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        muserName= intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvOptionone = findViewById(R.id.tvOptionone)
        tvOptiontwo = findViewById(R.id.tvOptiontwo)
        tvOptionthree = findViewById(R.id.tvOptionthree)
        tvOptionfour = findViewById(R.id.tvOptionfour)
        ivImage = findViewById(R.id.ivImage)
        btnSubmit = findViewById(R.id.btnSubmit)
        questionsList = Constants.getQuestion()

        setQuestion()

        // TODO (STEP 4: Set all the click events for Options using the interface onClick listener)
        tvOptionone?.setOnClickListener(this)
        tvOptiontwo?.setOnClickListener(this)
        tvOptionthree?.setOnClickListener(this)
        tvOptionfour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question: Question = questionsList!![currentPosition - 1]
        defaultOptionsView()
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition" + "/" + "${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionone?.text = question.optionOne
        tvOptiontwo?.text = question.optionTwo
        tvOptionthree?.text = question.optionThree
        tvOptionfour?.text = question.optionFour

        if (currentPosition == questionsList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }

    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tvOptionone -> {
                tvOptionone?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.tvOptiontwo -> {
                tvOptiontwo?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.tvOptionthree -> {
                tvOptionthree?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.tvOptionfour -> {
                tvOptionfour?.let {
                    selectedOptionView(it, 4)
                }

            }
            R.id.btnSubmit->
            {
                if (mSelectedOptionPosition == 0) {

                    currentPosition++

                    when {
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, muserName)
                            intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectanswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList?.size)
                            startActivity(intent)
                            finish()
                            Toast.makeText(
                                this@QuizQuestionsActivity,
                                "You have successfully completed the quiz.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    val question = questionsList?.get(currentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctOption != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectanswers++
                    }

                    // This is for correct answer
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if (currentPosition == questionsList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }

    }


// TODO (STEP 3: Create a function for answer view.)
// START
/**
 * A function for answer view which is used to highlight the answer is wrong or right.
 */
private fun answerView(answer: Int, drawableView: Int) {
    when (answer) {
        1 -> {
            tvOptionone?.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                drawableView
            )
        }
        2 -> {
            tvOptiontwo?.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                drawableView
            )
        }

        3 -> {
            tvOptionthree?.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                drawableView
            )
        }

        4 -> {
            tvOptionfour?.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                drawableView
            )
        }
    }
}






    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }


    // TODO (STEP 8: Create a function to set default options view.)
    // START
    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        tvOptionone?.let {
            options.add(0, it)
        }
        tvOptiontwo?.let {
            options.add(1, it)
        }
        tvOptionthree?.let {
            options.add(2, it)
        }
        tvOptionfour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }

    }

}







