import java.io.File;
import java.util.Scanner;
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
 *    ï Each contestant walks at a given estimated speed.
 *    ï The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */
public class CompetitionFloydWarshall {
	String filename;
	int sA, sB, sC;
	int N, S;
	double city[][];
	/**
	 * @param filename:
	 *            A filename containing the details of the city road network
	 * @param sA,
	 *            sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
		this.filename = filename;
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			N = Integer.parseInt(scanner.nextLine());
			S = Integer.parseInt(scanner.nextLine());
			city = new double[N][N];
			for (int i = 0; i < city.length; i++)
				for (int j = 0; j < city.length; j++) {
					city[i][j] = Integer.MAX_VALUE;
					if (i == j)
						city[i][j] = 0;
				}
			while (scanner.hasNextLine()) {
				String[] inputNums = scanner.nextLine().trim().split("\\s+");
				city[Integer.parseInt(inputNums[0])][Integer.parseInt(inputNums[1])] = Double.parseDouble(inputNums[2]);
			}
			scanner.close();
		} catch (Exception e) {
			city = new double[0][0];
		}
	}
	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {
		if (sA < 50 || sB < 50 || sC < 50 || sA > 100 || sB > 100 || sC > 100)
			return -1;
		for (int i = 0; i < city.length; i++)
			for (int j = 0; j < city.length; j++)
				for (int k = 0; k < city.length; k++)
					if (city[j][i] + city[i][k] < city[j][k])
						city[j][k] = city[j][i] + city[i][k];
		int minSpeed = Math.min(sC, Math.min(sA, sB));
		double maxDistance = 0.0;
		for (int i = 0; i < city.length; i++)
			for (int j = 0; j < city.length; j++)
				if (city[i][j] == Integer.MAX_VALUE)
					return -1;
				else if (city[i][j] > maxDistance)
					maxDistance = city[i][j];
		if (maxDistance == 0)
			return -1;
		int maxTime = (int) Math.ceil(maxDistance * 1000 / minSpeed);
		return maxTime;
	}
}