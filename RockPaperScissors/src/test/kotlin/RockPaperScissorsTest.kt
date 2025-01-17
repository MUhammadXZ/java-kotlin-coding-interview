package com.example.rockpaperscissors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RockPaperScissorsTest {

    // Test cases for evaluateRound function
    @Test
    fun testEvaluateRound_PlayerAWins() {
        assertEquals("WIN", evaluateRound(Move.ROCK, Move.SCISSORS))
        assertEquals("WIN", evaluateRound(Move.PAPER, Move.ROCK))
        assertEquals("WIN", evaluateRound(Move.SCISSORS, Move.PAPER))
    }

    @Test
    fun testEvaluateRound_PlayerALoses() {
        assertEquals("LOSE", evaluateRound(Move.ROCK, Move.PAPER))
        assertEquals("LOSE", evaluateRound(Move.PAPER, Move.SCISSORS))
        assertEquals("LOSE", evaluateRound(Move.SCISSORS, Move.ROCK))
    }

    @Test
    fun testEvaluateRound_Draw() {
        assertEquals("DRAW", evaluateRound(Move.ROCK, Move.ROCK))
        assertEquals("DRAW", evaluateRound(Move.PAPER, Move.PAPER))
        assertEquals("DRAW", evaluateRound(Move.SCISSORS, Move.SCISSORS))
    }

    // Test case for playGame function
    @Test
    fun testPlayGame() {
        val results = playGame()

        // Ensure the total number of games is 100
        val totalGames = results["Player A wins"]!! + results["Player B wins"]!! + results["Draws"]!!
        assertEquals(100, totalGames)

        // Ensure all results are non-negative
        assert(results["Player A wins"]!! >= 0)
        assert(results["Player B wins"]!! >= 0)
        assert(results["Draws"]!! >= 0)
    }
}