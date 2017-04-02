//Problem I

//ACCEPTED BY BOCA


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class rockabye {
	public static int gcd(int a, int b){return b==0 ? a : gcd(b,a%b);}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		for (int kz = 0 ;kz < testcases ; kz++) {
			line = br.readLine();
			String[] split = line.split(" ");
			int drug = Integer.parseInt(split[0]);
			int cure = Integer.parseInt(split[1]);
			String[] name = new String[drug];
			int[] val = new int[drug];
			for (int i = 0 ; i < drug ; i++) {
				line = br.readLine();
				split = line.split(" ");
				name[i] = split[0];
				val[i] = Integer.parseInt(split[1]);
			}
			int gcd = val[0];
			for (int i = 1 ; i < drug ; i++) {
				gcd = gcd(gcd,val[i]);
			}
			int counter = 0;
			int interval = 0;
			while (counter < cure){
				interval += gcd;
				for (int i = 0 ; i < drug; i++) {
					if (interval%val[i]==0) {
						counter++;
						pr.println(interval+" "+name[i]);
						if (counter==cure) {
							break;
						}
					}
				}
			}
		}
		
		pr.close();
	}
	
}
