//NO - Time limit exceeded


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class jury {
	public static double[] probs;
	public static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		DecimalFormat df = new DecimalFormat("0.00000");
		while (line!=null&&!line.isEmpty()) {
			String[] split = line.split(" ");
			n = Integer.parseInt(split[0]);
			probs = new double[n];
			for (int i = 0 ; i < n ; i++) {
				probs[i] = Double.parseDouble(split[i+1])/100;
			}
			Arrays.sort(probs);
			//for (int i= 0 ; i < n ; i++) {
			//	System.out.println("Index "+i+": "+probs[i]);
			//}
			double max = probs[n-1];
			boolean flag = false;
			for (int i = 3 ; i <= n ; i+=2) {
				if (probs[n-1]==probs[n-i]) {
					flag = true;
					continue;
				}
				if (flag) {
					i -= 2;
					flag = false;
				}
				double temp = 0;
				for (int winmin = i/2+1 ; winmin <= i ; winmin++) {
					temp += probability(winmin,0,i);
					//System.out.println("i: "+i+"  winmin: "+winmin+"  result: "+probability(winmin,0,i));
					//System.out.println(i+": "+temp);
				}
				//System.out.println(i+": "+temp);
				if (temp<max) {
					break;
				} else {
					max = temp;
				}
			}
			pr.println(df.format(max));
			
			line = br.readLine();
		}
		
		pr.close();
	}
	public static double probability(int wins,int curr,int max){
		if (curr==max) {
			return 1;
		}
		if (wins==0) {
			return (1-probs[n-1-curr])*probability(wins,curr+1,max);
		} else if (wins==max-curr) {
			return probs[n-1-curr]*probability(wins-1,curr+1,max);
		} else {
			return probs[n-1-curr]*probability(wins-1,curr+1,max)+(1-probs[n-1-curr])*probability(wins,curr+1,max);
		}
		
	}
}
