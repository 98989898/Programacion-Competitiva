
//ACCEPTED BY UVA

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.lang.*;

class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcases = scn.nextInt();
		for (int i=0;i<testcases;i++) {
			int s1 = scn.nextInt();
			int s2 = scn.nextInt();
			int s3 = scn.nextInt();
			int mayor;
			int solucion;
			if (s1<s2) {
				mayor=s2;
				solucion=s1;
			} else {
				mayor=s1;
				solucion=s2;
			}
			if (solucion<s3) {
				if (s3<mayor) {
					solucion=s3;
				}else {
					solucion=mayor;
				}
			} 
			System.out.println("Case "+(i+1)+": "+solucion);
		}
		
	}
}

