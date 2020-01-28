import java.io.BufferedReader;
import java.io.FileReader;
public class CompetitionFloydWarshall {
	String filename;
	int sA, sB, sC;
	int N, S;
	double city[][];
	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
		this.filename = filename;
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			N = Integer.parseInt(br.readLine());
			S = Integer.parseInt(br.readLine());
				city = new double[N][N];
				for (int i = 0; i < N; i++)
					for (int j = 0; j < N; j++)
						city[i][j] = Integer.MAX_VALUE;
				String line;
				while ((line = br.readLine()) != null) {
					String[] inputNums = line.split(" ");
					city[Integer.parseInt(inputNums[0])][Integer.parseInt(inputNums[1])] = Double.parseDouble(inputNums[2]);
				}
				br.close();
		} catch (Exception e) {
			city = new double[0][0];
		}
	}
}