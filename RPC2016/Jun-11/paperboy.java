//No - Runtime error (double-check the basename)	


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

// 0 1 2 3 4 (5) 6 7 8 9 

class paperboy {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		while (line!=null&&!line.isEmpty()) {
			String[] split = line.split(" ");
			int n = Integer.parseInt(split[0]);
			int target = Integer.parseInt(split[split.length-1]);
			int[] num = new int[n];
			for (int i = 1 ; i <= n ; i++ ) {
				num[i-1] = Integer.parseInt(split[i]);
			}
			int point = Arrays.binarySearch(num,target);
			int first = point;
			int second = n-1-point;
			boolean normal = true;
			if (second<first) {
				int temp = first;
				first = second;
				second = temp;
				normal = false;
			}
			int counter = 0;
			for (int i = 1 ; i <= first/5 ; i++) {
				if (normal) {
					//left
					counter += 2*Math.abs(num[point]-num[point-5*i]);
				} else {
					counter += 2*Math.abs(num[point]-num[point+5*i]);
				}
			}
			if (first%5!=0) {
				if (normal) {
					//left
					counter += 2*Math.abs(num[point]-num[0]);
				} else {
					counter += 2*Math.abs(num[point]-num[n-1]);
				}
			}
			
			for (int i = 1 ; i <= second/5 ; i++) {
				if (normal) {
					//second is right
					counter += 2*Math.abs(num[point]-num[point+5*i]);
				} else {
					counter += 2*Math.abs(num[point]-num[point-5*i]);
				}
			}
			if (second%5!=0) {
				if (normal) {
					//second is right
					counter += Math.abs(num[point]-num[n-1]);
				} else {
					counter += Math.abs(num[point]-num[0]);
				}
			}
			counter += n;
			pr.println(counter);
			line = br.readLine();
		}

		pr.close();
	}
}
