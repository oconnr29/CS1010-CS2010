import static org.junit.Assert.*;

import org.junit.Test;

public class Competition2Tests {

	@Test
	public void testDijkstraConstructor() {

		CompetitionDijkstra2 map;
		String filename = "tinyEWD.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		map = new CompetitionDijkstra2(filename, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		CompetitionFloydWarshall2 map;
		String filename = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionFloydWarshall2(filename, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testDijkstraFilenameError() {
		CompetitionDijkstra2 map;
		String filename = "tsha.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionDijkstra2(filename, sA, sB, sC);
	}

	@Test
	public void testFloydWarshallFilenameError() {
		CompetitionFloydWarshall2 map;
		String filename = "tsha.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testDijkstraNegativeSpeed() {
		String filename = "tinyEWD.txt";
		int sA = 0;
		int sB = 80;
		int sC = 60;
		CompetitionDijkstra2 map = new CompetitionDijkstra2(filename, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
		sA = -1;
		sB = 0;
		sC = -2;
		map = new CompetitionDijkstra2(filename, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	@Test
	public void testFloyWarshallNegativeSpeed() {
		String filename = "tinyEWD.txt";
		int sA = 0;
		int sB = 80;
		int sC = 60;
		CompetitionFloydWarshall2 map = new CompetitionFloydWarshall2(filename, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
		sA = -1;
		sB = 0;
		sC = -2;
		map = new CompetitionFloydWarshall2(filename, sA, sB, sC);
		assertEquals(-1, map.timeRequiredforCompetition());
	}

	@Test
	public void testInputA() {
		String filename = "input-A.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	/*@Test
	public void testInputB() {
		String filename = "input-B.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
		assertEquals(10000, mapD.timeRequiredforCompetition());
		assertEquals(10000, mapFW.timeRequiredforCompetition());
	}/*

	@Test
	public void testInputC() {
		String filename = "input-C.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputD() {
		String filename = "input-D.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputE() {
		String filename = "input-E.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputF() {
		String filename = "input-F.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputG() {
		String filename = "input-G.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	/*
	 * @Test public void testInputH() { String filename = "input-H.txt"; int sA =
	 * 60; int sB = 80; int sC = 50; CompetitionDijkstra2 mapD = new
	 * CompetitionDijkstra2(filename, sA, sB, sC); CompetitionFloydWarshall2 mapFW =
	 * new CompetitionFloydWarshall2(filename, sA, sB, sC); }
	 */
	@Test
	public void testInputI() {
		String filename = "input-I.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputJ() {
		String filename = "input-J.txt";
		int sA = 10;
		int sB = 20;
		int sC = 15;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
		assertEquals(-1, mapD.timeRequiredforCompetition());
		assertEquals(-1, mapFW.timeRequiredforCompetition());
	}

	@Test
	public void testInputK() {
		String filename = "input-K.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputL() {
		String filename = "input-L.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputM() {
		String filename = "input-M.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}

	@Test
	public void testInputN() {
		String filename = "input-N.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra2 mapD = new CompetitionDijkstra2(filename, sA, sB, sC);
		CompetitionFloydWarshall2 mapFW = new CompetitionFloydWarshall2(filename, sA, sB, sC);
	}
}