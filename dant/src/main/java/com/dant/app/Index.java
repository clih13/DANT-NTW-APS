package com.dant.app;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Index {
	
	private int col;
	private HashMap<String, ArrayList<String[]>> lignes;

	public Index(int col) {
		this.lignes = new HashMap<>();
		this.col = col;
	}
	
	public void setData(int colonne) {
    	Reader in;
		try {
			in = new FileReader("/home/clih/Downloads/test.csv");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			boolean header = true;
			
			long start = System.currentTimeMillis();
			int cpt = 0;
			for (CSVRecord record : records) {
				if (!header) {
					if(!lignes.containsKey(record.get(colonne-1)))
						lignes.put(record.get(colonne-1), new ArrayList<String[]>());
					
					ArrayList<String[]> container = lignes.get(record.get(colonne-1));
					String[] values = new String[17];
					
					for (int i = 0; i < 17; i++) {
						values[i] = record.get(i);
					}
					
					if(values.length > 0)
						container.add(values);
					
					this.lignes.put(record.get(colonne-1), container);
					
					cpt++;
					if(cpt % 100000 == 0)
						System.out.println("Stocké " + cpt + " ==>" + (System.currentTimeMillis() - start)/1000 + " s");
				}
				header = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("FINI");
    }
	
	public ArrayList<String[]> getData(String index) {
		return lignes.get(index);
	}

	public int getCol() {
		// TODO Auto-generated method stub
		return this.col;
	}
	
}
