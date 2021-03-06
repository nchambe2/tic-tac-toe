package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PlayerTest {

    private BufferedReader bufferedReader;
    private Player player;
    private Board board;
    private PrintStream printStream;


    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(board, bufferedReader);
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldCaptureUserMove() throws IOException {
        userSelectsEvenNumberOptionThenQuits();

        player.makeMove();

        verify(board).mark("2");

    }

    private void userSelectsEvenNumberOptionThenQuits() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("Quit");
    }

    @Test
    public void shouldCaptureUserMoveWhenInputIsTwo() throws IOException {
        userSelectsOddNumberOptionThenQuits();
        player.makeMove();

        verify(board).mark("1");

    }

    private void userSelectsOddNumberOptionThenQuits() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("Quit");
    }

}