package jetbrains.kotlin.course.first.date

fun main() {
    println("Hello! I will ask you several questions.")
    println("Please answer all of them and be honest with me!")


    println("What is TROTEN?")
    val firstUserAnswer: String = readLine().orEmpty()

    println("How did you spend your graduation?")
    val secondUserAnswer: String = readLine().orEmpty()

    println("Why does a spider need eight legs?")
    val thirdUserAnswer: String = readLine().orEmpty()


    println("Now let's have fun!")

    println(firstQuestion)
    println(firstUserAnswer)

    println(secondQuestion)
    println(secondUserAnswer)

    println(thirdQuestion)
    println(thirdUserAnswer)
}
