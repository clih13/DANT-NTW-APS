package com.dant.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import gnu.trove.map.hash.THashMap;

public class Index {

	List<String> lines = new ArrayList<String>();
	Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
	
	public Index() {

	}

	public void parseCSV(int col_index) {
		BufferedReader reader;
		try {
			String line;
			String[] values;
			int cpt = 0;
			long start = System.currentTimeMillis();

			RandomAccessFile ra = new RandomAccessFile("yellow_tripdata_2018-01.csv", "rw");

			ra.seek(0);// Read from start
			long p = ra.getFilePointer();
			
			String d = ra.readLine();
			ra.readLine();
			
			while (d != null && cpt < 1000) {
				long pos = ra.getFilePointer();
				d = ra.readLine();

				insert(d, col_index, pos);
				cpt++;

				if (cpt % 100000 == 0) {
					System.out.println(
							"Stocké " + cpt + " lignes en " + (System.currentTimeMillis() - start) / 1000 + " s");
				}

			}
			//2019-01-01 00:19:39
//			ra.seek(53124);
//			System.out.println(ra.readLine());
//			ra.seek(87593);
//			System.out.println(ra.readLine());
			ra.close();

		} catch (Exception e) {

		}
		
		System.out.println(index);
	}

	public String[] parse(String line) {
		return line.split(",");
	}

	public void insert(String line, int col_index, long pos) throws IOException {

		String[] line_tab = parse(line);
		List<Integer> rows = index.get(line_tab[col_index]);

		if (rows == null) {
			rows = new ArrayList<Integer>();
			index.put(line_tab[col_index], rows);
		}

		rows.add((int) pos);
	}

	// public List<String> getLignes(String key) {
	//
	// List<Integer> rows = index.get(key);
	// if (rows == null)
	// return null;
	// List<String[]> res = new ArrayList<String[]>();
	//
	// for (Integer row : rows) {
	// res.add(lines.get(row));
	// }
	//
	// return res;
	// }
	//
	//
	// public List<String[]> getLignesWithoutIndex(String key, int col_index) {
	//
	// List<String[]> res = new ArrayList<String[]>();
	//
	//
	// for(String[] line : lines) {
	// if(line[col_index].equals(key)) {
	// res.add(line);
	// }
	// }
	//
	// return res;
	// }

}
