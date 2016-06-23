//ACCEPTED BY BOCA


import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class rummikub {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line = br.readLine();
		int testcases = Integer.parseInt(line);
		for (int kz = 0 ; kz < testcases ; kz++) {
			int numTiles = Integer.parseInt(br.readLine());
			line = br.readLine();
			String[] split = line.split(" ");
			boolean found = false;
			ArrayList<Tile> tiles = new ArrayList<Tile>();
			for (int i = 0 ; i < numTiles ; i++) {
				tiles.add(new Tile(split[i]));
			}
			Collections.sort(tiles);
			int count = 1;
			for (int i = 1 ; i < numTiles && !found; i++) {
				if (tiles.get(i).hasSameColor(tiles.get(i-1))) {
					if (tiles.get(i).isNext(tiles.get(i-1))) {
						count++;
					} else if (tiles.get(i).getNum()!=tiles.get(i-1).getNum()) {
						count = 1;
					}
				} else {
					count = 1;
				}
				if (count>=3) {
					found = true;
				}
			}
			if (!found) {
				Collections.sort(tiles,new MyComparator());
				count = 1;
				for (int i = 1 ; i < numTiles && !found ; i++) {
					if (tiles.get(i).getNum()==tiles.get(i-1).getNum()) {
						if (!tiles.get(i).hasSameColor(tiles.get(i-1))) {
							count++;
						}
					} else {
						count = 1;
					}
					if (count>=3) {
						found = true;
					}
				}
			}
			if (found) {
				pr.println("YES");
			} else {
				pr.println("NO");
			}
		}
		
		pr.close();
	}
}
class Tile implements Comparable<Tile>{
	int num;
	char color;
	public Tile(String i){
		color = i.charAt(i.length()-1);
		num = Integer.parseInt(i.substring(0,i.length()-1));
	}
	public int getNum(){
		return num;
	}
	public char getColor(){
		return color;
	}
	public boolean equals(Tile other){
		if (num==other.getNum()&&color==other.getColor()) {
			return true;
		} else {
			return false;
		}
	}
	public int compareTo(Tile other){
		if (num>other.getNum()) {
			return 1;
		} else if (num==other.getNum()) {
			return 0;
		} else {
			return -1;
		}
	}
	public boolean hasSameColor(Tile other){
		return color==other.getColor();
	}
	public boolean isNext(Tile other){
		return num-1==other.getNum();
	}
}
class MyComparator implements Comparator<Tile>{
	public int compare(Tile a, Tile b){
		if (a.getNum()-b.getNum()==0) {
			return Character.compare(a.getColor(),b.getColor());
		} else {
			return a.getNum()-b.getNum();
		}
	}
}
