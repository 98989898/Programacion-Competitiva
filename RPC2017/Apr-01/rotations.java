import java.util.*;
import java.io.*;

public class rotations {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter (new BufferedWriter(new OutputStreamWriter(System.out)));
		String input = br.readLine();
		int T= Integer.parseInt(input);
		for (int t=0; t<T; t++){
			input = br.readLine();
			long n = Long.parseLong(input);
			boolean[] has = new boolean[32];
			boolean sol = true;
			for (int i = 0; i <= 27; i++) {
				long k = (31<<i);
				k = n&k;
				k = k>>i;
				if (has[((int)k)]) {
					sol = false;
					break;
				} else {
					has[((int)k)]=true;
				}
			}
			///
			long k = (n>>28);
			long kk = n&1;
			kk = kk<<4;
			k = k|kk;
			if (has[((int)k)]) {
				sol = false;
			} else {
				has[((int)k)]=true;
			}
			//////
			k = (n>>29);
			kk = n&3;
			kk = kk<<3;
			k = k|kk;
			if (has[((int)k)]) {
				sol = false;
			} else {
				has[((int)k)]=true;
			}
			//////
			k = (n>>30);
			kk = n&7;
			kk = kk<<2;
			k = k|kk;
			if (has[((int)k)]) {
				sol = false;
			} else {
				has[((int)k)]=true;
			}
			//////
			k = (n>>31);
			kk = n&15;
			kk = kk<<1;
			k = k|kk;
			if (has[((int)k)]) {
				sol = false;
			} else {
				has[((int)k)]=true;
			}
		////////
			if (sol) {
				pr.println("yes");
			} else {
				pr.println("no");
			}
		}
		pr.close();
	}

}