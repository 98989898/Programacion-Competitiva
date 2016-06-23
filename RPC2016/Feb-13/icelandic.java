//ACCEPTED BY BOCA

//Final Version
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class icelandic {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
				int testcases = Integer.parseInt(line);
				String[] split;
				for (int kz = 0 ; kz < testcases ; kz++) {
					int gasStations = Integer.parseInt(br.readLine());
					int gas;
					int distance;
					int[] extra = new int[gasStations];
					int totalsum = 0;
					for (int i = 0 ; i < gasStations ; i++) {
						line = br.readLine();
						split = line.split(" ");
						gas = Integer.parseInt(split[0]);
						distance = Integer.parseInt(split[1]);
						extra[i] = gas - distance;
						totalsum +=extra[i];
					}
					boolean foundsol = false;
					int sol = -1;
					for (int i = 0 ; i < gasStations && !foundsol ; i++) {
						int sum = 0;
						for (int j = 0 ; j < gasStations ; j++) {
							int curr = (i+j)%gasStations;
							sum += extra[curr];
							if (sum<0) {
								break;
							}
							if (j+1==gasStations) {
								foundsol = true;
								sol = i;
								break;
							}
						}
					}
					if (foundsol) {
						System.out.println(sol+1);
					} else {
						System.out.println("IMPOSSIBLE");
					}
			}
}}

//First attempt of a Version
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class icelandic {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		String[] split;
		for (int kz = 0 ; kz < testcases ; kz++) {
			int gasStations = Integer.parseInt(br.readLine());
			int gas;
			int distance;
			int[] extra = new int[gasStations];
			int totalsum = 0;
			for (int i = 0 ; i < gasStations ; i++) {
				line = br.readLine();
				split = line.split(" ");
				gas = Integer.parseInt(split[0]);
				distance = Integer.parseInt(split[1]);
				extra[i] = gas - distance;
				totalsum +=extra[i];
			}
			if (totalsum>=0) {
				
			
			int currExtra = extra[gasStations-1];
			int currFinal = 0;
			boolean solfound = false;
			int sol = -1;
			for (int i = gasStations - 1 ; i >= 0 && !solfound; i--) {
									currExtra += extra[i];
									//System.out.println("curr "+i);
									//System.out.println("currVal "+extra[currFinal]);
									//System.out.println("Saldo "+currExtra);
									//System.out.println("currFin "+currFinal);
									if (currExtra<0) {
										currExtra = 0;
										currFinal = i;
										continue;
									}
									if (extra[i]<0) {
										currExtra = 0;
										currFinal = i;
										continue;
									}
									//System.out.println("curr "+i);
									//System.out.println("currVal "+extra[i]);
									//System.out.println("Saldo "+currExtra);
									//System.out.println("currFin "+currFinal);
									if (currFinal==i) {
										solfound = true;
										sol = i;
										currExtra = 0;
										currFinal = i;
										break;
									}
									while (currExtra>=-extra[currFinal]||extra[currFinal]>=0) {
										currExtra +=extra[currFinal];
										currFinal = (currFinal+1)%gasStations;
										if (currFinal == i) {
											solfound = true;
											sol = i;
											currExtra = 0;									currFinal = i;
											break;
										}
										//System.out.println("curr "+i);
										//System.out.println("currVal "+extra[i]);
										//System.out.println("Saldo "+currExtra);
										//System.out.println("currFin "+currFinal);
									}
								
								}
			if (solfound) {
				pr.println(sol+1);
			} else {
			pr.println("IMPOSSIBLE");
			}
			//System.out.println();
			} else {
				
			
			pr.println("IMPOSSIBLE");}
		}
		
		pr.close();
	}
}
