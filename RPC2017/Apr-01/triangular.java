//Problem H

//ACCEPTED BY BOCA JUDGE


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class triangular {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for (int t=0; t<T; t++){
			line = br.readLine();
			long n = Long.parseLong(line);
			if (n==1) {
				pr.println("0 0");
				continue;
			} else if (n==2) {
				pr.println("-1 0");
				continue;
			} else if (n==3){
				pr.println("0 1");
				continue;
			}
			n -=3;
			
			double triangleprocess = (-6+Math.sqrt(36+16*n))/8;
	
			long trianglespent = (long) triangleprocess;
			//System.out.println("triangleprocess"+triangleprocess);
			long currtrig = trianglespent+1;
			long remainder = n-trianglespent*(trianglespent+1)*4-2*trianglespent;
			///System.out.println(n);
			//System.out.println(trianglespent);
			//System.out.println(trianglespent*(trianglespent+1)*4+2*trianglespent);
			long x = 0;
			long y = currtrig;
			//System.out.println(currtrig);
			//System.out.println(remainder);
			if (remainder!=0) {
				if (remainder<=2*currtrig) {
					x = remainder;
					y -= remainder;
				} else {
					remainder -= 2*currtrig;
					x += 2*currtrig;
					y -= 2*currtrig;
					if (remainder<=4*currtrig+1) {
						x -= remainder;
					} else {
						remainder -= 4*currtrig+1;
						x -= 4*currtrig+1;
						x  += remainder;
						y += remainder;
					}
				}
			}
			pr.println(x+" "+y);
		}
		
		pr.close();
	}
}
