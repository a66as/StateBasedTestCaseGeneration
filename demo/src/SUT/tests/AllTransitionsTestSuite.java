/* Auto generated test case for ThreePlayerGame */
package SUT.tests;
import SUT.ThreePlayerGame;
import static org.junit.Assert.*;
import org.junit.Test;


public class AllTransitionsTestSuite{
    ThreePlayerGame sut;
    @Test
    (timeout = 1000)
    public void testForPath0() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 2 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath1() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 3 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath2() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p1_Score()==20)) {
            sut.p1_WinsVolley();
        }
        assertEquals("Player 1 Won", sut.stateReporter());
        sut.p1_IsWinner();
        assertEquals("Player 1 Won", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath3() {
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
    }
    @Test
    (timeout = 1000)
    public void testForPath4() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p1_Start();
        assertEquals("Player 1 Served", sut.stateReporter());
        /* Please DIY satisfy the guard */
        assertEquals("Player 1 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath5() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Player 1 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath6() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        sut.p2_WinsVolley();
        assertEquals("Player 2 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath7() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p3_Score()==20)) {
            sut.p3_WinsVolley();
        }
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.p3_IsWinner();
        assertEquals("Player 3 Won", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath8() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p3_Score()==20)) {
            sut.p3_WinsVolley();
        }
        assertEquals("Player 3 Won", sut.stateReporter());
        sut.dtor();
        assertEquals("T", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath9() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p3_Start();
        assertEquals("Player 3 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while((sut.p3_Score()<19)) {
            sut.p3_WinsVolley();
        }
        assertEquals("Player 3 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath10() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p1_WinsVolley();
        assertEquals("Player 1 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath11() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        sut.p3_WinsVolley();
        assertEquals("Player 3 Served", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath12() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p2_Score()==20)) {
            sut.p2_WinsVolley();
        }
        assertEquals("Player 2 Won", sut.stateReporter());
        /* Please DIY satisfy the guard */
        assertEquals("Player 2 Won", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath13() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while(!(sut.p2_Score()==20)) {
            sut.p2_WinsVolley();
        }
        assertEquals("Player 2 Won", sut.stateReporter());
        sut.dtor();
        assertEquals("T", sut.stateReporter());
    }
    @Test
    (timeout = 1000)
    public void testForPath14() {
        sut=new ThreePlayerGame();
        assertEquals("Game Started", sut.stateReporter());
        sut.p2_Start();
        assertEquals("Player 2 Served", sut.stateReporter());
        /*TODO: check if the guard could be satisfied by the following generated code.*/
        while((sut.p2_Score()<19)) {
            sut.p2_WinsVolley();
        }
        assertEquals("Player 2 Served", sut.stateReporter());
    }
    
}
