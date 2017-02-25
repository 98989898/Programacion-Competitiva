
//ACCEPTED BY UVA
//MY FIRST C++ PROGRAM ACCEPTED BY UVA!! EVER!!!!

#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
#include <cstring>
#include <stdio.h>
#include <stdlib.h>

using namespace std;
int times[9999999];
int tapetime;
int tracks;
int totalmax = -1;
vector<int> solution;
void recursion(int max, int currtrack, int sum, vector<int> curr) {
	if (currtrack>=tracks) {
		if (sum>totalmax) {
			totalmax = sum;
			solution = curr;
		}
		return;
	}
	recursion(max,currtrack+1,sum,curr);
	curr.push_back(times[currtrack]);
	if (sum+times[currtrack]==max) {
		recursion(max,tracks,sum+times[currtrack],curr);
	} else if (sum+times[currtrack]<max) {
		recursion(max,currtrack+1,sum+times[currtrack],curr);
	}
}
int main(int argc, char *argv[]) {
	while(scanf("%d %d", &tapetime, &tracks)!=EOF){
	for (int i = 0 ; i < tracks; i++) {
		scanf("%d", &times[i]);
	}
	totalmax = -1;
	solution.clear();
	vector<int> k;
	recursion(tapetime,0,0,k);
	for (int i = 0 ; i < solution.size() ; i++) {
		printf("%d ",solution.at(i));
	}
	printf("sum:%d\n",totalmax);
}
}
