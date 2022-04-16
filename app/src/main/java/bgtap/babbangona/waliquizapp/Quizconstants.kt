package bgtap.babbangona.waliquizapp

object Quizconstants {
    fun getQuizstatus():ArrayList<Quizstatus> {
        val quizStatus=java.util.ArrayList<Quizstatus>()

        val sta1 = Quizstatus(1,R.drawable.trophy, "Hey, Congratulation you passed the test",1)
        quizStatus.add(sta1)

        val sta2 = Quizstatus(2,R.drawable.failed, "Hey, Sorry you failed the test please try again",2)
        quizStatus.add(sta1)
        return quizStatus
    }
}