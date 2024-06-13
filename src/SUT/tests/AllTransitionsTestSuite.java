/* Auto generated test case for ThreePlayerGame */
package SUT.tests;

import SUT.ThreePlayerGame;
import static org.junit.Assert.*;
import org.junit.Test;

public class AllTransitionsTestSuite {
  ThreePlayerGame sut;

  @Test
  public void testForPath0() {
    sut = new ThreePlayerGame();
    assertEquals("Game Started", sut.stateReporter());
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    sut.p2_WinsVolley();
    assertEquals("Player 2 Served", sut.stateReporter());
  }

  @Test
  public void testForPath1() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    sut.p3_WinsVolley();
    assertEquals("Player 3 Served", sut.stateReporter());
  }

  @Test
  public void testForPath2() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    sut.p1_IsWinner();
    assertEquals("Player 1 Won", sut.stateReporter());
  }

  @Test
  public void testForPath3() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    sut.dtor();
    assertEquals("T", sut.stateReporter());
  }

  @Test
  public void testForPath5() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
  }

  @Test
  public void testForPath7() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    sut.p1_WinsVolley();
    assertEquals("Player 1 Served", sut.stateReporter());
  }

  @Test
  public void testForPath8() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    sut.p2_WinsVolley();
    assertEquals("Player 2 Served", sut.stateReporter());
  }

  @Test
  public void testForPath9() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    sut.p3_IsWinner();
    assertEquals("Player 3 Won", sut.stateReporter());
  }

  @Test
  public void testForPath10() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    sut.dtor();
    assertEquals("T", sut.stateReporter());
  }

  @Test
  public void testForPath12() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
  }

  @Test
  public void testForPath14() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    sut.p1_WinsVolley();
    assertEquals("Player 1 Served", sut.stateReporter());
  }

  @Test
  public void testForPath15() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    sut.p3_WinsVolley();
    assertEquals("Player 3 Served", sut.stateReporter());
  }

  @Test
  public void testForPath16() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    while (!(sut.p2_Score() == 20)) {
      sut.p2_WinsVolley();
    }
    assertEquals("Player 2 Won", sut.stateReporter());
    /* Please DIY satisfy the guard null with body:[]*/
    assertEquals("Player 2 Won", sut.stateReporter());
  }

  @Test
  public void testForPath17() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    while (!(sut.p2_Score() == 20)) {
      sut.p2_WinsVolley();
    }
    assertEquals("Player 2 Won", sut.stateReporter());
    sut.dtor();
    assertEquals("T", sut.stateReporter());
  }

  @Test
  public void testForPath19() {
    sut = new ThreePlayerGame();
    sut.p1_Start();
    assertEquals("Player 1 Served", sut.stateReporter());
    while (!(sut.p1_Score() == 20)) {
      sut.p1_WinsVolley();
    }
    assertEquals("Player 1 Won", sut.stateReporter());
    while (!(sut.p3_Score() == 20)) {
      sut.p3_WinsVolley();
    }
    assertEquals("Player 3 Won", sut.stateReporter());
    while (!(sut.p2_Score() == 20)) {
      sut.p2_WinsVolley();
    }
    assertEquals("Player 2 Won", sut.stateReporter());
  }
}
