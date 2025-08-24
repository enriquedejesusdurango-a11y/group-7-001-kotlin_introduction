package jetbrains.kotlin.course.warmup

fun getGameRules(wordLength: Int, maxAttemptsCount: Int, secretExample: String) =
    "Welcome to the game! $newLineSymbol" +
            newLineSymbol +
            "Two people play this game: one chooses a word (a sequence of letters), " +
            "the other guesses it. In this version, the computer chooses the word: " +
            "a sequence of $wordLength letters (for example, $secretExample). " +
            "The user has several attempts to guess it (the max number is $maxAttemptsCount). " +
            "For each attempt, the number of complete matches (letter and position) " +
            "and partial matches (letter only) is reported. $newLineSymbol" +
            newLineSymbol +
            "For example, with $secretExample as the hidden word, the BCDF guess will " +
            "give 1 full match (C) and 1 partial match (B)."

fun countPartialMatches(secret: String, guess: String): Int {
    return countAllMatches(secret, guess) - countExactMatches(secret, guess)

}

fun countExactMatches(secret: String, guess: String): Int {
    return secret.filterIndexed { index, c -> c == guess[index] }.length

}

fun generateSecret() = "ABCD"

fun isComplete(secret: String, guess: String): Boolean {
    if (secret == guess){
        return  true
    }else {
        return  false
    }

}
fun countAllMatches(secret: String, guess: String): Int {
    return secret.toSet().sumOf { ch ->
        val countInSecret = secret.count { it == ch }
        val countInGuess = guess.count { it == ch }
        minOf(countInSecret, countInGuess)
    }
}
fun printRoundResults(secret: String, guess: String): Unit {
    val fullMatches = countExactMatches(secret, guess)
    val partialMatches = countPartialMatches(secret, guess)
    println("Your guess has $fullMatches full matches and $partialMatches partial matches.")
}
fun isWon(complete: Boolean, attempts: Int, maxAttemptsCount: Int): Boolean {
    return complete && attempts <= maxAttemptsCount
}
fun isLost(complete: Boolean, attempts: Int, maxAttemptsCount: Int): Boolean {
    return !complete && attempts > maxAttemptsCount
}



fun playGame(secret: String, wordLength: Int, maxAttemptsCount: Int): Unit {
    var attempts = 0
    var guess: String? = null
    var complete = false

    while (attempts <= maxAttemptsCount) {
        println("Please input your guess. It should be of length $wordLength.")
        guess = safeReadLine()
        attempts++

        if (guess != null) {
            complete = isComplete(secret, guess)
            printRoundResults(secret, guess)

            if (isWon(complete, attempts, maxAttemptsCount)) {
                println("Congratulations! You guessed it!")
                return
            }

            if (isLost(complete, attempts, maxAttemptsCount)) {
                println("Sorry, you lost! :( My word is $secret")
                return
            }
        }
    }
}

fun main() {
    val wordLength = 4
    val maxAttemptsCount = 3
    val secretExample = "ACEB"

    println(getGameRules(wordLength, maxAttemptsCount, secretExample))

    val secret =generateSecret()
    playGame(secret, wordLength, maxAttemptsCount )

}
