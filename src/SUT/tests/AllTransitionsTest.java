/* Auto generated test case for ThreePlayerGame */
package SUT.tests;
import SUT.ThreePlayerGame;
import static org.junit.Assert.*;
import org.junit.Test;


public class AllTransitionsTest{
ThreePlayerGame sut= new ThreePlayerGame(); // alpha is already made
@Test
public void testCase1() {
assertEquals("Game Started", sut.stateReporter());
sut.p1_Start();
assertEquals("Player 1 Served", sut.stateReporter());
sut.p2_WinsVolley();
assertEquals("Player 2 Served", sut.stateReporter());

 /********** TC Completed *************/

sut.p3_WinsVolley();
assertEquals("Player 3 Served", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p1_WinsVolley();
assertEquals("Player 1 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p1_Score()==20]*/
sut.p1_IsWinner();
assertEquals("Player 1 Won", sut.stateReporter());

 /********** TC Completed *************/

sut.dtor();
assertEquals("T", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p1_WinsVolley();
assertEquals("Player 1 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p1_Score <20]*/

 /********** TC Completed *************/

sut.p3_Start();
assertEquals("Player 3 Served", sut.stateReporter());
sut.p1_WinsVolley();
assertEquals("Player 1 Served", sut.stateReporter());

 /********** TC Completed *************/

sut.p2_WinsVolley();
assertEquals("Player 2 Served", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p3_WinsVolley();
assertEquals("Player 3 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p3_Score()==20]*/
sut.p3_IsWinner();
assertEquals("Player 3 Won", sut.stateReporter());

 /********** TC Completed *************/

sut.dtor();
assertEquals("T", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p3_WinsVolley();
assertEquals("Player 3 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p3_Score() <20]*/

 /********** TC Completed *************/

sut.p2_Start();
assertEquals("Player 2 Served", sut.stateReporter());
sut.p1_WinsVolley();
assertEquals("Player 1 Served", sut.stateReporter());

 /********** TC Completed *************/

sut.p3_WinsVolley();
assertEquals("Player 3 Served", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p2_WinsVolley();
assertEquals("Player 2 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p2_Score()==20, ]*/
/* for Guard false */
sut.p2_IsWinner();
assertEquals("Player 2 Won", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: []*/

 /********** TC Completed *************/

sut.dtor();
assertEquals("T", sut.stateReporter());

 /********** TC Completed *************/

/* for Guard false */
sut.p2_WinsVolley();
assertEquals("Player 2 Served", sut.stateReporter()); // should be in same state
/* for Guard True please DIY, Satisfy the guard 'null' with body: [this.p2_Score() <20]*/

 /********** TC Completed *************/

}

}