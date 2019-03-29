package com.dant.app;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import gnu.trove.map.hash.THashMap;

public class Index {

	List<String[]> lines = new ArrayList<String[]>();
	Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
	
	

	public Index() {

	}


	public void parseCSV(int col_index) {
		
    	Reader in;
		try {
			in = new FileReader("tripdata_exemple.csv");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			boolean header = true;
			
			long start = System.currentTimeMillis();
			int cpt = 0;
			for (CSVRecord record : records) {
				if (!header) {
					
					String[] values = new String[17];
					
					for (int i = 0; i < 17; i++) {
						values[i] = record.get(i);
						System.out.println(values[i]);
					}
					
					insert(values, col_index);
										
					cpt++;

					System.out.println("Stocké " + cpt + " ==>" + (System.currentTimeMillis() - start)/1000 + " s");
				}
				header = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(index);
	}
	
	
	public void insert(String[] line, int col_index) {
		int nb_lignes = lines.size();

		lines.add(line);

		List<Integer> rows = index.get(line[col_index]);

		if (rows == null) {
			rows = new ArrayList<Integer>();
			index.put(line[col_index], rows);
		}

		rows.add(nb_lignes);

	}

	public List<String[]> getLignes(String key) {

		List<Integer> rows = index.get(key);
		if (rows == null)
			return null;
		List<String[]> res = new ArrayList<String[]>();

		for (Integer row : rows) {
			res.add(lines.get(row));
		}

		return res;
	}

	
	public List<String[]> getLignesWithoutIndex(String key, int col_index) {
		
		List<String[]> res = new ArrayList<String[]>();
		
		
		for(String[] line : lines) {
			if(line[col_index].equals(key)) {
				res.add(line);
			}
		}
		
		return res;
	}

}
