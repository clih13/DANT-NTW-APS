package com.dant.app;

import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Table {

	static Map<String, List<Index>> index = new HashMap<String, List<Index>>();


	public void parseCSV(int col_index) throws IOException {
	
		System.out.println("STARTING TO PARSE CSV !!!");

		Reader in;
		int cpt = 0;
		long start = System.currentTimeMillis();
		try {
			in = new FileReader("test.csv");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			boolean header = true;

			for (CSVRecord record : records) {

				if(header){
					header = false;
				}
				else{

					String[] values = new String[19];
					for (int i = 0; i < 19; i++) {
						values[i] = record.get(i);
					}
					Index newLine = getNewIndexWithData(values);
					putOnHashMap(values[col_index], newLine);

					cpt++;
					if (cpt % 500000 == 0) {
						System.out.println("Stocké " + cpt + " ==>" + (System.currentTimeMillis() - start) / 1000 + " s");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("END!!!!");
	}


	public void putOnHashMap(String key, Index newRow){
		List<Index> rows = index.get(key);

		if (rows == null) {
			rows = new ArrayList<Index>();
			index.put(key, rows);
		}

		rows.add(newRow);
		index.put(key, rows);

	}






	public Index getNewIndexWithData(String[] values){
	
		Index aNewIndex = new Index(
			Integer.parseInt(values[0]),
			values[1],
			values[2],
			Integer.parseInt(values[3]),
			values[4],
			values[5],
			values[6],
			Integer.parseInt(values[7]),
			values[8],
			values[9],
			values[10],
			Integer.parseInt(values[11]),
			Float.parseFloat(values[12]),
			Float.parseFloat(values[13]),
			Float.parseFloat(values[14]),
			Float.parseFloat(values[15]),
			Float.parseFloat(values[16]),
			Float.parseFloat(values[17]),
			Float.parseFloat(values[18])
		);
		
		return aNewIndex;
	}

	

}
