package com.dant.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Index {
	
	private int col;
	private HashMap<String, ArrayList<String>> lignes;

	public Index(int col) {
		this.lignes = new HashMap<String, ArrayList<String>>();
		this.col = col;
	}
	
	public void SetData(int colonne) {
		BufferedReader reader;
		long start = System.currentTimeMillis();
		try {
			File file = new File("tripdata_exemple.csv");
			reader = new BufferedReader(new FileReader(file));
			String line ;
			String[] value;
			
			for(int i=0; i<2; i++) {
				line = reader.readLine();
			}
			
			while((line = reader.readLine()) != null) {
				value = parse(line);
				ArrayList<String> values = new ArrayList<String>();
				for(int i = 0; i<value.length; i++) {
					values.add(value[i]);
				}
				lignes.put(value[colonne-1], values);
			}
		} catch (Exception e) {
			
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public String getData(String index) {
		return lignes.get(index).toString();
	}
	
	public String[] parse(String line) {
		return line.split(",");
	}

	public int getCol() {
		// TODO Auto-generated method stub
		return this.col;
	}
	
}
