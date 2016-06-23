//ACCEPTED BY BOCA

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class squawk {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		while (line!=null&&!line.isEmpty()) {
		String[] split = line.split(" ");
		int nodes = Integer.parseInt(split[0]);
		int vertices = Integer.parseInt(split[1]);
		int patientzero = Integer.parseInt(split[2]);
		int time = Integer.parseInt(split[3]);
		
		int[][] adj = new int[nodes][nodes];
		long[] calls = new long[nodes];
		
		for (int i = 0 ; i < vertices ; i++) {
			split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		/*for (int i = 0 ; i < nodes ; i++) {
			for (int j = 0 ; j < nodes ; j++) {
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}
		System.out.println();*/
		calls[patientzero] = 1;
		//print(calls);
		for (int i = 1 ; i <= time ; i++) {
			long[] nuke = new long[nodes];
			for (int j = 0 ; j < nodes ; j++) {
				if (calls[j]!=0) {
					for (int z = 0 ; z < nodes ; z++) {
						nuke[z] += adj[j][z]*calls[j];
					}
				}
			}
			calls = nuke;
			//print(calls);
		}
		long sol = 0;
		for (int i = 0; i < nodes ; i++) {
			sol += calls[i];
		}
		pr.println(sol);
		
		line = br.readLine();
		}
		pr.close();
	}
	/*static void print(int[] k){
		for (int i = 0 ; i < k.length ; i++) {
			System.out.print(k[i]);
		}
		System.out.println();
	}*/
}
