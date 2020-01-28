import static org.junit.Assert.*;
import org.junit.Test;

/*
1.  Justify the choice of the data structures used in CompetitionDijkstra and CompetitionFloydWarshall
	
	I used a 2D array in order to store the data because I think it was the simplest data structure to 
	use and it was the well suited to this problem. The Dijksta algorithm was easiest to implement with 
	the array, it could also be implemented using a priority queue however a 2D array allowed us to find 
	the shortest path and was simpler to implement. The Floyd-Warshall algorithm is best solved by using 
	a matrix and therefore it was ideal to use a 2D array to find the shortest path.
	
2.  Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms in the 
	given problem. Also explain how would their relative performance be affected by the density of the 
	graph. Which would you choose in which set of circumstances and why?
      
	Dijkstra finds the shortest path from one source node, i.e. by going from point to point.
	Floyd-Warshall however finds the shorter path by searching through pairs of vertices.
   
    Floyd Warshall is better for denser graphs as it is more exhaustive and searches through in pairs.
    Dijkstra is better for sparser graphs as it goes through point by point and has a better runtime 
    for repeated actions.
*/
public class CompetitionTests {
	@Test
	public void testDijkstraConstructor() {
		String filename = "tinyEWD.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra city = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(38, city.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		String filename = "tinyEWD.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionFloydWarshall city = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(38, city.timeRequiredforCompetition());
	}

	/*
	 * @Test public void testConstructor() { String filename = "1000EWD.txt"; int sA
	 * = 60; int sB = 80; int sC = 50; CompetitionDijkstra cityD = new
	 * CompetitionDijkstra(filename, sA, sB, sC); assertEquals(28,
	 * cityD.timeRequiredforCompetition()); CompetitionFloydWarshall cityFW = new
	 * CompetitionFloydWarshall(filename, sA, sB, sC); assertEquals(28,
	 * cityFW.timeRequiredforCompetition()); }
	 */

	@Test
	public void testInvalidSpeed() {
		String filename = "tinyEWD.txt";
		int sA = 50;
		int sB = 100;
		int sC = 150;
		CompetitionDijkstra cityD = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(-1, cityD.timeRequiredforCompetition());
		CompetitionFloydWarshall cityFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(-1, cityFW.timeRequiredforCompetition());
	}

	@Test
	public void testInvalidFilename() {
		String filename = "tinyED.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		CompetitionDijkstra cityD = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(-1, cityD.timeRequiredforCompetition());
		CompetitionFloydWarshall cityFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(-1, cityFW.timeRequiredforCompetition());
	}

	@Test
	public void testError() {
		String filename = "input-A.txt";
		int sA = 50;
		int sB = 50;
		int sC = 50;
		CompetitionDijkstra cityD = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(-1, cityD.timeRequiredforCompetition());
		CompetitionFloydWarshall cityFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(-1, cityFW.timeRequiredforCompetition());
	}

	@Test
	public void testError2() {
		String filename = "input-C.txt";
		int sA = 50;
		int sB = 100;
		int sC = 100;
		CompetitionDijkstra cityD = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(-1, cityD.timeRequiredforCompetition());
		CompetitionFloydWarshall cityFW = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(-1, cityFW.timeRequiredforCompetition());

	}
}