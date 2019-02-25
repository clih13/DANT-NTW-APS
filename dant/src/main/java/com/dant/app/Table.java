package com.dant.app;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

	static ArrayList<Table> listTable = new ArrayList<Table>();
	private ArrayList<Index> index;
	private String name;

	public Table(String name) {
		this.index = new ArrayList<Index>();
		this.name = name;
		listTable.add(this);
	}	
	
	public void addIndex(Index index) {
		this.index.add(index);		
	}
	
	public static Table getTablebyName(String name) {
		for(Table t : listTable) {
			if(name.equals(t.name)) {
				return t;
			}
		}
		return null;
	}
}
