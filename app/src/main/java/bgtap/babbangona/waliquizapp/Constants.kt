package bgtap.babbangona.waliquizapp

object Constants {

    const val USER_NAME: String="user_name"
    const val TOTAL_QUESTIONS: String = "totalQuestions"
    const val CORRECT_QUESTIONS: String = "correctQuestions"
    fun getQuestion():ArrayList<Question> {
        val questionsList=java.util.ArrayList<Question>()

        val que1 = Question(1, "What is the name of the person shown?", R.drawable.kolamasha, "Kalo Masha", "Kola Masha",
            "kola Masha","Kola Mahsa",2
        )
questionsList.add(que1)


        val que2 = Question(2, "This equipment is used for what purpose?", R.drawable.sickle , "Agriculture", "Abattoir",
            "De weeding","Karuketing",1
        )
        questionsList.add(que2)


        val que3 = Question(3, "What is the name of the equipment displayed?", R.drawable.wellhead , "Christmas Tree", "Well head",
            "Blow out preventer","Well Spool",2
        )
        questionsList.add(que3)


        val que4 = Question(4, "This flag belongs to what country?", R.drawable.afghanistan , "Tobego", "Libya",
            "Syria","Afghanistan",4
        )
        questionsList.add(que4)


        val que5 = Question(5, "How many animals can you see in this picture?", R.drawable.onepicture , "10", "18",
            "16","14",3
        )
        questionsList.add(que5)

        val que6 = Question(6, "What is the name of the person shown?", R.drawable.ovo , "Ovo Ikirigbe Victor", "Ikirigbe Victor Ovo",
            "Ovo Victor Ikirigbe","Ovokirigbe Victor",2
        )
        questionsList.add(que6)

        return questionsList

    }
}