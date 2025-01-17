package com.example.rockpaperscissors

import kotlin.random.Random

// Define the possible moves
enum class Move {
    ROCK, PAPER, SCISSORS
}

// Game logic to evaluate the result of a round
fun evaluateRound(playerA: Move, playerB: Move): String {
    return when {
        playerA == playerB -> "DRAW"
        playerA == Move.ROCK && playerB == Move.SCISSORS -> "WIN"
        playerA == Move.PAPER && playerB == Move.ROCK -> "WIN"
        playerA == Move.SCISSORS && playerB == Move.PAPER -> "WIN"
        else -> "LOSE"
    }
}

// Function to get a random move for Player B
fun getRandomMove(): Move {
    return Move.values()[Random.nextInt(Move.values().size)]
}

// Function to play 100 rounds and track results
fun playGame(): Map<String, Int> {
    var playerAWins = 0
    var playerBWins = 0
    var draws = 0

    repeat(100) {
        val playerA = Move.ROCK
        val playerB = getRandomMove()

        when (evaluateRound(playerA, playerB)) {
            "WIN" -> playerAWins++
            "LOSE" -> playerBWins++
            "DRAW" -> draws++
        }
    }

    return mapOf(
        "Player A wins" to playerAWins,
        "Player B wins" to playerBWins,
        "Draws" to draws
    )
}

// Function to print the results in the required format
fun printResults(results: Map<String, Int>) {
    println("Player A wins ${results["Player A wins"]} of 100 games")
    println("Player B wins ${results["Player B wins"]} of 100 games")
    println("Draws: ${results["Draws"]} of 100 games")
}

fun main() {
    val results = playGame()
    printResults(results)
}