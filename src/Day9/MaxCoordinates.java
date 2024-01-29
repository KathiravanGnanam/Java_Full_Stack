package com.blueyonder.day8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class MaxCoordinates {
	
	public static void findMaxCoordinates(Map<Integer,Vector<Integer>> map,int x,int y,int[][] arr) {
		int sum=arr[x][y];
		if(x-1>=0) {
			sum+=arr[x-1][y];
		}
		if(x+1<arr.length) {
			sum+=arr[x+1][y];
		}
		if(y-1>=0) {
			sum+=arr[x][y-1];
		}
		if(y+1<arr[0].length) {
			sum+=arr[x][y+1];
		}
		if(x-1>=0 && y-1>=0) {
			sum+=arr[x-1][y-1];
		}
		if(x+1<arr.length && y-1>=0) {
			sum+=arr[x+1][y-1];
		}
		if(y+1<arr[0].length && x-1>=0) {
			sum+=arr[x-1][y+1];
		}
		if(y+1<arr[0].length && x+1<arr.length) {
			sum+=arr[x+1][y+1];
		}
		Vector<Integer> vec=new Vector<>();
		vec.add(x);
		vec.add(y);
		map.put(sum, vec);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int row,col;
		
		System.out.println("Enter the number of rows and columns:");
		row=sc.nextInt();
		col=sc.nextInt();
		int[][] arr = new int[row][];
		Map<Integer,Vector<Integer>> map1=new HashMap<>();
		System.out.println("Enter the Elements : ");
		for(int i=0;i<row;i++) {
			arr[i]=new int[col];
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				findMaxCoordinates(map1,i,j,arr);
			}
		}
		
		Vector<Integer> vec=null;
		vec=map1.entrySet().stream()
			.max(Comparator.comparing(Map.Entry::getKey))
			.map(Map.Entry::getValue)
			.orElse(null);
			
		System.out.println("x:"+(vec.get(0)+1)+" "+"y:"+(vec.get(1)+1));
	}

}
