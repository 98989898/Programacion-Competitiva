//Problem F

//ACCEPTED BY BOCA JUDGE


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class sequence {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		for (int kz = 0 ; kz < testcases ; kz++) {
			long n = Long.parseLong(br.readLine());
			pr.println(n*n+2*n);
		}
		
		pr.close();
	}
}
