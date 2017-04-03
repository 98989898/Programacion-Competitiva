
//TLE


//Proplem M

import java.util.*;
import java.io.*;
import java.math.*;


public class dpa02 {


	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter (new BufferedWriter(new OutputStreamWriter(System.out)));
		String input = br.readLine();
		int testcases =  Integer.parseInt(input);
		for (int kz = 0; kz < testcases; kz++) {
			input = br.readLine();
			long n = Long.parseLong(input);
			long nn = n;
			long mult = 1;
			long sum = 1;
			while (n%2==0) {
				sum = sum*2;
				n = n/2;
			}
			if (sum!=1) {
				mult *= (sum*2-1);
				sum = 1;
			}
			for (int i = 3; i <= Math.sqrt(n); i+=2) {
				while (n%i==0) {
					sum = sum*i;
					n = n/i;
				}
				if (sum!=1) {
					mult *= (sum*i-1)/(i-1);
					sum = 1;
				}
			}
			if (n!=1) {
				mult *= (n*n-1)/(n-1);
			}
			mult -= nn;
			//System.out.println(mult);
			if (mult>nn) {
				pr.println("abundant");
			} else if (mult==nn) {
				pr.println("perfect");
			} else {
				pr.println("deficient");
			}
		}
		pr.close();
	}

}
