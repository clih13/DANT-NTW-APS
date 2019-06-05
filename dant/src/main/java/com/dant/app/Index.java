package com.dant.app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class Index {

	//List<String[]> lines = new ArrayList<String[]>();
	Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
	private int col;

	public Index(int col) {
		this.col = col;
	}


	public void parseCSV(int col_index) throws IOException {
		int cpt = 0;
    	Reader in;
		try {
			in = new FileReader("tripdata_exemple.csv");
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			boolean header = true;
			
			int lineNumber = 0;
			
			long start = System.currentTimeMillis();
			for (CSVRecord record : records) {
				if (!header) {
					
					String[] values = new String[17];
					
					for (int i = 0; i < 17; i++) {
						values[i] = record.get(i);
					}
					
					insert(values, col_index-1, lineNumber++);
										
					cpt++;
					writeToDisk();
//					if (cpt % 10 == 0) {
//						System.out.println("Stocké " + cpt + " ==>" + (System.currentTimeMillis() - start) / 1000 + " s");
//						writeToDisk();
//					}
				}
				header = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("FINI " + cpt);
		writeToDisk();
		
		System.out.println("Boucle for:");
        for (Map.Entry mapentry : index.entrySet()) {
           System.out.println("clé: "+mapentry.getKey() 
                              + " | valeur: " + mapentry.getValue());
        }


		
	}
	
	
	public void insert(String[] line, int col_index, int lineNumber) {
//		int nb_lignes = lines.size();
//
//		lines.add(line);

		List<Integer> rows = index.get(line[col_index]);

		if (rows == null) {
			rows = new ArrayList<Integer>();
			index.put(line[col_index], rows);
		}

		rows.add(lineNumber);

	}

	public List<String[]> getLignes(String key) {

		List<Integer> rows = index.get(key);
		if (rows == null)
			return null;
		List<String[]> res = readFromDisk(rows);
		return res;
	}

	
//	public List<String[]> getLignesWithoutIndex(String key, int col_index) {
//		
//		List<String[]> res = new ArrayList<String[]>();
//		
//		
//		for(String[] line : lines) {
//			if(line[col_index].equals(key)) {
//				res.add(line);
//			}
//		}
//		
//		return res;
//	}
	
	public int getCol() {
		return this.col;
	}
	
	public void writeToDisk() throws IOException {
		String fileName = "data_index_" + (this.col-1) + ".txt";
		File dataFile = new File(fileName);
		dataFile.createNewFile();

		FileWriter fileWriter = new FileWriter(dataFile, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
//		for(String[] s : this.lines) {
//			for (int i = 0; i < 17; i++) {
//				bufferedWriter.write(s[i]);
//				if(i != 16)
//					bufferedWriter.write(",");
//			}
//			bufferedWriter.newLine();
//		}
		
		for (Map.Entry mapentry : index.entrySet()) {
//	           System.out.println("clé: "+mapentry.getKey() 
//	                              + " | valeur: " + mapentry.getValue());
			bufferedWriter.write(mapentry.getKey() + "[" + mapentry.getValue() + "]");
			bufferedWriter.newLine();
			
	        }
		
		
		//lines.clear();
		//System.gc();			//  <--- Garbage Collector : free up memory space
		bufferedWriter.close();

	}
	
	public List<String[]> readFromDisk(List<Integer> rows) {
		String fileName = "data_index_" + (this.col-1) + ".txt";
		File dataFile = new File(fileName);
		List<String[]> res = new ArrayList<String[]>();
		
		for(Integer row : rows) {
			try(Stream<String> lines = Files.lines(dataFile.toPath())){
				String line = lines.skip(row).findFirst().get();
				res.add(line.split(","));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

}
