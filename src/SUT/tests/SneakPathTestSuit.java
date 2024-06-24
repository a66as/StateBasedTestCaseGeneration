/* Auto generated test case for ThreePlayerGame */
package SUT.tests;
import SUT.ThreePlayerGame;
import static org.junit.Assert.*;
import org.junit.Test;


public class SneakPathTestSuit{
    ThreePlayerGame sut;
    @Test
    public void testForPath0() {
        sut= new ThreePlayerGame();
        assertEquals("Game Started",sut.stateReporter());
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
    public void testForPath1() {
        sut=new ThreePlayerGame();
        sut.p1_Start();
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
    public void testForPath3() {
        sut=new ThreePlayerGame();
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
    public void testForPath5() {
        sut=new ThreePlayerGame();
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        
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
    public void testForPath7() {
        sut=new ThreePlayerGame();
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        
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
    public void testForPath14() {
        sut=new ThreePlayerGame();
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        
        while(!(sut.p1_Score()==20)) {
            sut.p1_WinsVolley();
        }
        assertEquals("Player 1 Won", sut.stateReporter());
        
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
    public void testForPath22() {
        sut=new ThreePlayerGame();
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        
        while(!(sut.p1_Score()==20)) {
            sut.p1_WinsVolley();
        }
        assertEquals("Player 1 Won", sut.stateReporter());
        
        while(!(sut.p3_Score()==20)) {
            sut.p3_WinsVolley();
        }
        assertEquals("Player 3 Won", sut.stateReporter());
        
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
