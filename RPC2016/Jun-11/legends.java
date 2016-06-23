//ACCEPTED BY BOCA

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class legends {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		String[] split;
		for (int kz = 0 ; kz < testcases ; kz++) {
			for (int i = 0 ; i < 5 ; i++) {
				split = br.readLine().split(" ");
				if (Integer.parseInt(split[1])*3<Integer.parseInt(split[2])) {
					pr.println(split[0]+" plz uninstall");
				}
			}
			String[][] losing = new String[5][];
			int k = 1;
			int d = 0;
			for (int i = 0 ; i < 5 ; i++) {
				losing[i] = br.readLine().split(" ");
				if (Integer.parseInt(losing[i][1])*d<Integer.parseInt(losing[i][2])*k) {
					k = Integer.parseInt(losing[i][1]);
					d = Integer.parseInt(losing[i][2]);
				}
			}
			for (int i = 0 ; i < 5 ; i++) {
				if (Integer.parseInt(losing[i][1])*2<Integer.parseInt(losing[i][2])||(Integer.parseInt(losing[i][1])*d<=Integer.parseInt(losing[i][2])*k&&(Integer.parseInt(losing[i][2])!=0||d==0))) {
					pr.println(losing[i][0]+" plz uninstall");
				}
			}
		}
		
		pr.close();
	}
}
