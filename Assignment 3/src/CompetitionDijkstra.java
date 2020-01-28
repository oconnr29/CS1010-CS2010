import java.io.BufferedReader;
import java.io.FileReader;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
	String filename;
	int sA, sB, sC;
	int N, S;
	double[][] city;

	/**
	 * @param filename:
	 *            A filename containing the details of the city road network
	 * @param sA,
	 *            sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra(String filename, int sA, int sB, int sC) {
		this.filename = filename;
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(filename));
			N = Integer.parseInt(bReader.readLine());
			S = Integer.parseInt(bReader.readLine());
				city = new double[N][N];
				if (city.length == 0) {
				for (int i = 0; i < N; i++)
					for (int j = 0; j < N; j++)
						city[i][j] = Integer.MAX_VALUE;
				String line;
				while ((line = bReader.readLine()) != null) {
					String[] lVals = line.split(" ");
					city[Integer.parseInt(lVals[0])][Integer.parseInt(lVals[1])] = Double.parseDouble(lVals[2]);
				}
				bReader.close();
			}
		} catch (Exception e) {
			city = new double[0][0];
		}
	}
	public int timeRequiredforCompetition() {
		int minSpeed = Math.min(sC, Math.min(sA, sB));
		if ((sA > 100 || sA < 50) || (sB > 100 || sB < 50) || (sC > 100 || sC < 50))
			return -1;
		double longestShortest = 0;
		for (int i = 0; i < N; i++) {
			double[] dist = new double[N];
			boolean[] permanent = new boolean[N];
			boolean[] reached = new boolean[N];
			int numActive = 1;
			for (int m = 0; m < N; m++) {
				dist[m] = Integer.MAX_VALUE;
				permanent[m] = false;
				reached[m] = false;
			}
			dist[i] = 0;
			reached[i] = true;

			do {
				int lowest = 0;
				for (int j = 1; j < dist.length; j++)
					lowest = ((dist[j] < dist[lowest] && !permanent[j]) || permanent[lowest]) ? j : lowest;
				int currentLowestAddr = lowest;
				for (int j = 0; j < N; j++) {
					if ((city[currentLowestAddr][j] + dist[currentLowestAddr]) < dist[j] && !permanent[j]) {
						dist[j] = (city[currentLowestAddr][j] + dist[currentLowestAddr]);
						numActive++;
						reached[j] = true;
					}
				}
				permanent[currentLowestAddr] = true;
				numActive--;
			} while (numActive > 0);
			double highest = 0;
			for (int j = 0; j < dist.length; j++)
				highest = (dist[j] > highest) ? dist[j] : highest;
			double tmpLS = highest;
			if (tmpLS == Integer.MAX_VALUE)
				return -1;
			longestShortest = (tmpLS > longestShortest) ? tmpLS : longestShortest;
		}
		longestShortest *= 1000; // convert to meters
		return (int) Math.ceil(longestShortest / minSpeed);
	}
}