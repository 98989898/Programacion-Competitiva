//ACCEPTED BY BOCA

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class cheating {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		for (int t=0; t<T; t++){
			String dxy = br.readLine();
			String [] split = dxy.split(" ");
			double D = Double.parseDouble(split[0]);
			double x = Double.parseDouble(split[1]);
			double y = Double.parseDouble(split[2]);
			double ans = 0;
			
			double sqrtD = Math.sqrt(D);
			double k = Math.sqrt(Math.pow(x,2)+(Math.pow(y,2)));
			double div = k/sqrtD;
			int divaprox = (int)div;
			if (x==0 && y==0){
				ans = 0;
			}else{
				if (k<sqrtD){
					ans = 2;
				}else{
					if (div-divaprox>=-0.000000001&&div-divaprox<=0.000000001){
						ans = divaprox;
					}else if(div-divaprox-1>=-0.000000001&&div-divaprox-1<=0.000000001){
						ans = divaprox + 1;
					}else if(div-divaprox+1>=-0.000000001&&div-divaprox+1<=0.000000001){
						ans = divaprox -1;
					}else{
						ans = (k/sqrtD)+1;
					}
				}
			}


			pr.println((int)ans);
		}
		
		pr.close();
	}
}
