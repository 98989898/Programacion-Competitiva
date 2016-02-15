
//Stack-Overflow-Error

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class ga {
	public static char[][] info;
	public static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		int[] trucox = {1,1,1,0,0,-1,-1,-1};
				int[] trucoy = {0,1,-1,-1,1,1,0,-1};
		for (int kz = 0 ; kz < testcases ; kz++) {
			n = Integer.parseInt(br.readLine());
			info= new char[n][];
			for (int i = 0 ; i < n ; i++) {
				info[i] = br.readLine().toCharArray();
			}
			int sol = 0;
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					
					boolean end = false;
					if (info[i][j]!='-') {
						continue;
					}
					for (int xx = 0; xx < 8 && !end; xx++) {
						if (i+trucox[xx]>=0 && i+trucox[xx]<n) {
							if (j+trucoy[xx]>=0 && j+trucoy[xx]<n) {
								if (info[i+trucox[xx]][j+trucoy[xx]]=='w') {
									sol += floodfill(i,j,'-','w');
									end = true	;
								}
							}
						}
					}
				}
			}
			pr.println(sol);
		}
		
		pr.close();
	}
	public static int dr[] = {1,1,0,-1,-1,-1, 0, 1}; // trick to explore an implicit 2D grid
	public static int dc[] = {0,1,1, 1, 0,-1,-1,-1}; // S,SE,E,NE,N,NW,W,SW neighbors
	public static int floodfill(int r, int c, char c1, char c2) { // returns the size of CC
	if (r < 0 || r >= n || c < 0 || c >= n) return 0; // outside grid
	if (info[r][c] != c1) return 0; // does not have color c1
	int ans = 1; // adds 1 to ans because vertex (r, c) has c1 as its color
	info[r][c] = c2; // now recolors vertex (r, c) to c2 to avoid cycling!
	for (int d = 0; d < 8; d++) {ans += floodfill(r + dr[d], c + dc[d], c1, c2);}
	return ans; // the code is neat due to dr[] and dc[]
	}
}
