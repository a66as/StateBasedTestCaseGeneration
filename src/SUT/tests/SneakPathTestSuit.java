package SUT.tests;

import SUT.ThreePlayerGame;
import static org.junit.Assert.*;
import org.junit.Test;


public class SneakPathTestSuit{
    ThreePlayerGame sut;
    @Test
    public void testForPath0() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Game Started", sut.stateReporter());
    }
    @Test
    public void testForPath1() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Player 1 Served", sut.stateReporter());
    }
    @Test
    public void testForPath2() {
        sut=new ThreePlayerGame();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Player 2 Served", sut.stateReporter());
    }
    @Test
    public void testForPath4() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Player 3 Served", sut.stateReporter());
    }
    @Test
    public void testForPath6() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p1_Score()==20)) {
            sut.p1_WinsVolley();
        }
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Player 1 Won", sut.stateReporter());
    }
    @Test
    public void testForPath8() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p1_Score()==20)) {
            sut.p1_WinsVolley();
        }
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.dtor();
        assertEquals("T", sut.stateReporter());
        sut.p3_Start();
        assertEquals("T", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("T", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("T", sut.stateReporter());
        sut.p2_Start();
        assertEquals("T", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("T", sut.stateReporter());
        sut.p1_Start();
        assertEquals("T", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("T", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("T", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("T", sut.stateReporter());
    }
    @Test
    public void testForPath13() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p3_Score()==20)) {
            sut.p3_WinsVolley();
        }
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p2_IsWinner();
        assertEquals("Player 3 Won", sut.stateReporter());
    }
    @Test
    public void testForPath19() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p2_Score()==20)) {
            sut.p2_WinsVolley();
        }
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 2 Won", sut.stateReporter());
    }
}
