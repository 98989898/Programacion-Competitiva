//Problem D

//ACCEPTED BY BOCA JUDGE

import java.util.*;
import java.io.*;
import java.math.*;

public class dpa01 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter (new BufferedWriter(new OutputStreamWriter(System.out)));
		String input = br.readLine();
		int T = Integer.parseInt(input);
		for (int t=0; t<T; t++){
			int n = Integer.parseInt(br.readLine());
			
		
			int sum = 1;
			boolean printed = false;
			int i = 2;
			for (; i*i < n; i++) {
				//System.out.println("actual:"+i);
				if (n%i==0) {
					sum +=i;
					sum += n/i;
					//System.out.println(i+"i");
					//System.out.println(n/i);
					if (sum>n) {
						pr.println("abundant");
						printed = true;
						break;
					}
				}
				//System.out.println("constant:"+n +" d: "+i);
			}
			if(!printed&&i*i==n) {
				sum +=i;
				//System.out.println(i+"arr");
				if (sum>n) {
					pr.println("abundant");
					printed = true;
				}
			}
	
		
			//System.out.println(sum);
			if (!printed) {
				if (n==sum) {
					pr.println("perfect");
				} else {
					pr.println("deficient");
				}
			}
			//System.out.println("sum"+sum);
			
		}
		pr.close();
	}

}
