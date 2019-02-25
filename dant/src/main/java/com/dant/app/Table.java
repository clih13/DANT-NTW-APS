package com.dant.app;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

	private ArrayList<Index> index;
	private String name;

	public Table(String name) {
		this.index = new ArrayList<Index>();
		this.name = name;
	}	
	
	public void addIndex(Index index) {
		this.index.add(index);		
	}
	
}
