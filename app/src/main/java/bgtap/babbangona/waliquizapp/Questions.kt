package bgtap.babbangona.waliquizapp

data class Question(
    val id:Int,
    val question:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    var correctOption: Int
)

data class Quizstatus(
    val id:Int,
    val image:Int,
    val mEssage:String,
    var scoreStatus: Int
)