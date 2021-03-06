import java.io.File;
import java.util.Scanner;

public class CompetitionDijkstra2 {
	public String filename;
	public int sA;
	public int sB;
	public int sC;
	public double distanceTo[][];
	public int edgeTo[][];
	public int edgeCount;

	CompetitionDijkstra2(String filename, int sA, int sB, int sC) {
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			int i = 0;
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().trim().split("\\s+");
				if (i == 0) {
					distanceTo = new double[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					edgeTo = new int[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
					for (int j = 0; j < distanceTo.length; j++) {
						for (int k = 0; k < distanceTo[j].length; k++) {
							distanceTo[j][k] = Integer.MAX_VALUE;
							if (j == k)
								distanceTo[j][k] = 0;
						}
					}
				} else if (i == 1)
					edgeCount = Integer.parseInt(line[i - 1]);
				else {
					distanceTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Double.parseDouble(line[2]);
					edgeTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[0]);
				}
				i++;
			}
			for (int j = 0; j < distanceTo.length; j++) {
				boolean[] sptSet = new boolean[distanceTo.length];
				sptSet[j] = true;
				while (true) {
					int x = -1;
					for (int k = 0; k < distanceTo.length; k++) {
						// Break when new vertice is found
						if ((sptSet[k] == false) && (distanceTo[j][k] != Integer.MAX_VALUE)) {
							x = k;
							break;
						}
					}
					if (x == -1)
						break;
					sptSet[x] = true;
					for (int k = 0; k < distanceTo.length; k++) {
						if (distanceTo[j][x] + distanceTo[x][k] < distanceTo[j][k]) {
							distanceTo[j][k] = distanceTo[j][x] + distanceTo[x][k];
							sptSet[k] = false;
							edgeTo[j][k] = x;
						}
					}
				}
			}
			scanner.close();
		} catch (Exception x) {
			distanceTo = new double[0][0];
			edgeTo = new int[0][0];
			return;
		}
	}

	public void shortestPath(int v) {

	}

	public int timeRequiredforCompetition() {
		int minSpeed = Math.min(sC, Math.min(sA, sB));
		double maxDistance = 0.0;
		for (int i = 0; i < distanceTo.length; i++) {
			for (int j = 0; j < distanceTo[i].length; j++) {
				if (distanceTo[i][j] == Integer.MAX_VALUE)
					return -1;
				else if (distanceTo[i][j] > maxDistance)
					maxDistance = distanceTo[i][j];
			}
		}
		int maxTime = (int) Math.ceil((maxDistance * 1000) / minSpeed);
		if (minSpeed <= 0 || maxDistance == 0)
			return -1;
		return maxTime;
	}
}