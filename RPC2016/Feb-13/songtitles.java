//NOT SENT TO BOCA,
//BECAUSE BOCA WAS NOT ONLINE.
//SEND AS SOON AS POSSIBLE.

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class songtitles {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int testCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCases; i ++) {
			
			String line = br.readLine();
			
			char[] letters = line.toCharArray();
			Arrays.sort(letters);
			
			//StringBuilder sb = new StringBuilder("");
			//sb.append(letters[0]);
			
			boolean notImpossible = true;
			boolean special = false;
			
			for(int j = 1;( j < letters.length )&& notImpossible; j++) {
				char a = letters[j-1];
				char b = letters[j];
				if(b==a) {
					
					int k = 1;
					
					while(letters[j]==a) {
						
						if((j+1)==letters.length) {
							k = j;
							notImpossible = false;
							while (k>0) {
								char remplazo = letters[k-1];
								letters[k-1] = letters[k];
								letters[k] = remplazo;
								k--;
								if (letters[k]!=letters[k+1]&&(k==0||letters[k-1]!=letters[k])) {
									notImpossible = true;
									break;
								} 
							}
							break;
						}
						
						if(special||(j+k)==letters.length) {
							notImpossible = false;
							k = j;
							while (k>0) {
								char remplazo = letters[k-1];
								letters[k-1] = letters[k];
								letters[k] = remplazo;
								k--;
								if (letters[k]!=letters[k+1]&&(k==0||letters[k-1]!=letters[k])) {
									notImpossible = true;
									break;
								} 
							}
							special = true;//or not impossible = false
							break;
						}
							
						char remplazo = letters[j+k];
						letters[j+k] = letters[j];
						letters[j] = remplazo;
						
						k++;
						
					}

				}
				if (!notImpossible) {
					break;
				}
				//sb.append(letters[j]);
			}
			
			if (!notImpossible) {
				pr.println("IMPOSSIBLE");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int l = 0 ; l < letters.length ; l++) {
					sb.append(letters[l]);
				}
				pr.println(sb.toString());
			}
			
		}
		
		
		pr.close();
	}
}

//---------------------------------------//----------------------------------------

//ORIGINAL SOLUTION
//WRONG ANSWER ON BOCA

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class songtitles {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int testCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCases; i ++) {
			
			String line = br.readLine();
			
			char[] letters = line.toCharArray();
			Arrays.sort(letters);
			
			StringBuilder sb = new StringBuilder("");
			sb.append(letters[0]);
			
			boolean notImpossible = true;
			
			for(int j = 1;( j < letters.length )&& notImpossible; j++) {
				char a = letters[j-1];
				char b = letters[j];
				if(b==a) {
					
					int k = 1;
					
					while(letters[j]==a) {
						
						if((j+1)==letters.length) {
							notImpossible = false;
							break;
						}
						
						if((j+k)==letters.length) {
							break;
												}
							
						char remplazo = letters[j+k];
						letters[j+k] = letters[j];
						letters[j] = remplazo;
						
						k++;
						
					}

				}
				if (!notImpossible) {
					break;
				}
				sb.append(letters[j]);
			}
			
			if (!notImpossible) {
				pr.println("IMPOSSIBLE");
			} else {
				pr.println(sb.toString());
			}
			
		}
		
		
		pr.close();
	}
}
