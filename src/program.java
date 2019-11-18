package com.berrak.settlers;
import java.util.*;
import java.io.*;
public class program {

	public static void main(String[] args) {
		System.out.println("Hello Catan!");
		System.out.println("How many players will be in game?");
		Scanner scan = new Scanner(System.in);
		int numOfPlayers = scan.nextInt();
		
		Controller c = new Controller(numOfPlayers);
		
		

	}

}
