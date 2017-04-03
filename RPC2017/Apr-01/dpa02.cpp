
//TLE

//Problem M

#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <cstring>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

using namespace std;
int main(int argc, char *argv[]) {
	int t;
	long int n;
	scanf("%d",&t);
	for (int kz ; kz < t ; kz++) {
		scanf("%ld",&n);
		long int nn = n;
		long int ans = 1;
		int power=0;
		while (n%2==0) {
			power++;
			n = n/2;
		}
		if (power!=0) {
			ans *= ((long int)pow(2.0, power + 1.0) - 1);
			power = 0;
		}
		for (int i = 3; i <= sqrt(n); i+=2) {
			while (n%i==0) {
				power++;
				n = n/i;
			}
			if (power!=0) {
				ans *= ((long int)pow((double)i, power + 1.0) - 1) / (i - 1);
				power = 0;
			}
		}
		if (n!=1) {
			ans *= ((long int)pow((double)n, 2.0) - 1) / (n - 1);
		}
		ans -= nn;
		//System.out.println(mult);
		if (ans>nn) {
			printf("abundant\n");
		} else if (ans==nn) {
			printf("perfect\n");
		} else {
			printf("deficient\n");
		}
	}
}
