package com.dant.app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class Index {

	// List<String[]> lines = new ArrayList<String[]>();
	// Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
	// private int col;

	// public Index(int col) {
	// 	this.col = col;
	// }


	// public void parseCSV(int col_index) throws IOException {
	// 	int cpt = 0;
    // 	Reader in;
	// 	try {
	// 		in = new FileReader("/home/clih/Downloads/yellow_tripdata_2013-12.csv");
	// 		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
	// 		boolean header = true;
			
	// 		long start = System.currentTimeMillis();
	// 		for (CSVRecord record : records) {
	// 			if (!header) {
					
	// 				String[] values = new String[17];
					
	// 				for (int i = 0; i < 17; i++) {
	// 					values[i] = record.get(i);
	// 				}
					
	// 				insert(values, col_index-1);
										
	// 				cpt++;
	// 				if (cpt % 500000 == 0) {
	// 					System.out.println("Stocké " + cpt + " ==>" + (System.currentTimeMillis() - start) / 1000 + " s");
	// 					writeToDisk();
	// 				}
	// 			}
	// 			header = false;
	// 		}
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// 	System.out.println("FINI " + cpt);
	// 	writeToDisk();
		
	// }
	
	
	// public void insert(String[] line, int col_index) {
	// 	int nb_lignes = lines.size();

	// 	lines.add(line);

	// 	List<Integer> rows = index.get(line[col_index]);

	// 	if (rows == null) {
	// 		rows = new ArrayList<Integer>();
	// 		index.put(line[col_index], rows);
	// 	}

	// 	rows.add(nb_lignes);

	// }

	// public List<String[]> getLignes(String key) {

	// 	List<Integer> rows = index.get(key);
	// 	if (rows == null)
	// 		return null;
	// 	List<String[]> res = readFromDisk(rows);
	// 	return res;
	// }

	
	// public List<String[]> getLignesWithoutIndex(String key, int col_index) {
		
	// 	List<String[]> res = new ArrayList<String[]>();
		
		
	// 	for(String[] line : lines) {
	// 		if(line[col_index].equals(key)) {
	// 			res.add(line);
	// 		}
	// 	}
		
	// 	return res;
	// }
	
	// public int getCol() {
	// 	return this.col;
	// }
	
	// public void writeToDisk() throws IOException {
	// 	String fileName = "data_index_" + (this.col-1) + ".txt";
	// 	File dataFile = new File(fileName);
	// 	dataFile.createNewFile();

	// 	FileWriter fileWriter = new FileWriter(dataFile, true);
	// 	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
	// 	for(String[] s : this.lines) {
	// 		for (int i = 0; i < 17; i++) {
	// 			bufferedWriter.write(s[i]);
	// 			if(i != 16)
	// 				bufferedWriter.write(",");
	// 		}
	// 		bufferedWriter.newLine();
	// 	}
		
	// 	lines.clear();
	// 	System.gc();			//  <--- Garbage Collector : free up memory space
	// 	bufferedWriter.close();

	// }
	
	// public List<String[]> readFromDisk(List<Integer> rows) {
	// 	String fileName = "data_index_" + (this.col-1) + ".txt";
	// 	File dataFile = new File(fileName);
	// 	List<String[]> res = new ArrayList<String[]>();
		
	// 	for(Integer row : rows) {
	// 		try(Stream<String> lines = Files.lines(dataFile.toPath())){
	// 			String line = lines.skip(row).findFirst().get();
	// 			res.add(line.split(","));
	// 		} catch (IOException e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	return res;
	// }





	private Map<String, List<Table>> index = new HashMap<String, List<Table>>();


	public void parseCSV(int col_index) throws IOException {
	
		System.out.println("STARTING TO PARSE CSV !!!");

		Reader in;
		int cpt = 0;
		long start = System.currentTimeMillis();
		try {
			in = new FileReader("test1M.csv");
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
					Table newLine = getNewTableWithData(values);
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


	public void putOnHashMap(String key, Table newRow){
		List<Table> rows = index.get(key);

		if (rows == null) {
			rows = new ArrayList<Table>();
			index.put(key, rows);
		}

		rows.add(newRow);
		index.put(key, rows);

	}






	public Table getNewTableWithData(String[] values){

		//Table aNewTable = new Table(Integer.parseInt(values[0]),values[1],values[2],Integer.parseInt(values[3]),Float.parseFloat(values[4]),Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8]),values[9],Float.parseFloat(values[10]),values[11],Float.parseFloat(values[12]),Float.parseFloat(values[13]),Float.parseFloat(values[14]),values[15],Float.parseFloat(values[16]));
		
		Table aNewTable = new Table(
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
		
		return aNewTable;
	}

}
