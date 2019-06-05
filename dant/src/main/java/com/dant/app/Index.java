package com.dant.app;




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




	public int VendorID;
	public String tpep_pickup_datetime;
	public String tpep_dropoff_datetime;
	public int passenger_count;
	public String trip_distance;
	public String pickup_longitude;
	public String pickup_latitude;
	public int RateCodeID;
	public String store_and_fwd_flag;
	public String dropoff_longitude;
	public String dropoff_latitude;
	public int payment_type;
	public float fare_amount;
	public float extra;
	public float mta_tax;
	public float tip_amount;
	public float tolls_amount;
	public float improvement_surcharge;
	public float total_amount;


	public Index() {
	}

	public Index(int VendorID, String tpep_pickup_datetime, String tpep_dropoff_datetime, int passenger_count, String trip_distance, String pickup_longitude, String pickup_latitude, int RateCodeID, String store_and_fwd_flag, String dropoff_longitude, String dropoff_latitude, int payment_type, float fare_amount, float extra, float mta_tax, float tip_amount, float tolls_amount, float improvement_surcharge, float total_amount) {
		this.VendorID = VendorID;
		this.tpep_pickup_datetime = tpep_pickup_datetime;
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
		this.passenger_count = passenger_count;
		this.trip_distance = trip_distance;
		this.pickup_longitude = pickup_longitude;
		this.pickup_latitude = pickup_latitude;
		this.RateCodeID = RateCodeID;
		this.store_and_fwd_flag = store_and_fwd_flag;
		this.dropoff_longitude = dropoff_longitude;
		this.dropoff_latitude = dropoff_latitude;
		this.payment_type = payment_type;
		this.fare_amount = fare_amount;
		this.extra = extra;
		this.mta_tax = mta_tax;
		this.tip_amount = tip_amount;
		this.tolls_amount = tolls_amount;
		this.improvement_surcharge = improvement_surcharge;
		this.total_amount = total_amount;
	}

	public int getVendorID() {
		return this.VendorID;
	}

	public void setVendorID(int VendorID) {
		this.VendorID = VendorID;
	}

	public String getTpep_pickup_datetime() {
		return this.tpep_pickup_datetime;
	}

	public void setTpep_pickup_datetime(String tpep_pickup_datetime) {
		this.tpep_pickup_datetime = tpep_pickup_datetime;
	}

	public String getTpep_dropoff_datetime() {
		return this.tpep_dropoff_datetime;
	}

	public void setTpep_dropoff_datetime(String tpep_dropoff_datetime) {
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
	}

	public int getPassenger_count() {
		return this.passenger_count;
	}

	public void setPassenger_count(int passenger_count) {
		this.passenger_count = passenger_count;
	}

	public String getTrip_distance() {
		return this.trip_distance;
	}

	public void setTrip_distance(String trip_distance) {
		this.trip_distance = trip_distance;
	}

	public String getPickup_longitude() {
		return this.pickup_longitude;
	}

	public void setPickup_longitude(String pickup_longitude) {
		this.pickup_longitude = pickup_longitude;
	}

	public String getPickup_latitude() {
		return this.pickup_latitude;
	}

	public void setPickup_latitude(String pickup_latitude) {
		this.pickup_latitude = pickup_latitude;
	}

	public int getRateCodeID() {
		return this.RateCodeID;
	}

	public void setRateCodeID(int RateCodeID) {
		this.RateCodeID = RateCodeID;
	}

	public String getStore_and_fwd_flag() {
		return this.store_and_fwd_flag;
	}

	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}

	public String getDropoff_longitude() {
		return this.dropoff_longitude;
	}

	public void setDropoff_longitude(String dropoff_longitude) {
		this.dropoff_longitude = dropoff_longitude;
	}

	public String getDropoff_latitude() {
		return this.dropoff_latitude;
	}

	public void setDropoff_latitude(String dropoff_latitude) {
		this.dropoff_latitude = dropoff_latitude;
	}

	public int getPayment_type() {
		return this.payment_type;
	}

	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}

	public float getFare_amount() {
		return this.fare_amount;
	}

	public void setFare_amount(float fare_amount) {
		this.fare_amount = fare_amount;
	}

	public float getExtra() {
		return this.extra;
	}

	public void setExtra(float extra) {
		this.extra = extra;
	}

	public float getMta_tax() {
		return this.mta_tax;
	}

	public void setMta_tax(float mta_tax) {
		this.mta_tax = mta_tax;
	}

	public float getTip_amount() {
		return this.tip_amount;
	}

	public void setTip_amount(float tip_amount) {
		this.tip_amount = tip_amount;
	}

	public float getTolls_amount() {
		return this.tolls_amount;
	}

	public void setTolls_amount(float tolls_amount) {
		this.tolls_amount = tolls_amount;
	}

	public float getImprovement_surcharge() {
		return this.improvement_surcharge;
	}

	public void setImprovement_surcharge(float improvement_surcharge) {
		this.improvement_surcharge = improvement_surcharge;
	}

	public float getTotal_amount() {
		return this.total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public Index VendorID(int VendorID) {
		this.VendorID = VendorID;
		return this;
	}

	public Index tpep_pickup_datetime(String tpep_pickup_datetime) {
		this.tpep_pickup_datetime = tpep_pickup_datetime;
		return this;
	}

	public Index tpep_dropoff_datetime(String tpep_dropoff_datetime) {
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
		return this;
	}

	public Index passenger_count(int passenger_count) {
		this.passenger_count = passenger_count;
		return this;
	}

	public Index trip_distance(String trip_distance) {
		this.trip_distance = trip_distance;
		return this;
	}

	public Index pickup_longitude(String pickup_longitude) {
		this.pickup_longitude = pickup_longitude;
		return this;
	}

	public Index pickup_latitude(String pickup_latitude) {
		this.pickup_latitude = pickup_latitude;
		return this;
	}

	public Index RateCodeID(int RateCodeID) {
		this.RateCodeID = RateCodeID;
		return this;
	}

	public Index store_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
		return this;
	}

	public Index dropoff_longitude(String dropoff_longitude) {
		this.dropoff_longitude = dropoff_longitude;
		return this;
	}

	public Index dropoff_latitude(String dropoff_latitude) {
		this.dropoff_latitude = dropoff_latitude;
		return this;
	}

	public Index payment_type(int payment_type) {
		this.payment_type = payment_type;
		return this;
	}

	public Index fare_amount(float fare_amount) {
		this.fare_amount = fare_amount;
		return this;
	}

	public Index extra(float extra) {
		this.extra = extra;
		return this;
	}

	public Index mta_tax(float mta_tax) {
		this.mta_tax = mta_tax;
		return this;
	}

	public Index tip_amount(float tip_amount) {
		this.tip_amount = tip_amount;
		return this;
	}

	public Index tolls_amount(float tolls_amount) {
		this.tolls_amount = tolls_amount;
		return this;
	}

	public Index improvement_surcharge(float improvement_surcharge) {
		this.improvement_surcharge = improvement_surcharge;
		return this;
	}

	public Index total_amount(float total_amount) {
		this.total_amount = total_amount;
		return this;
	}


	@Override
	public String toString() {
		return "{" +
			" VendorID='" + getVendorID() + "'" +
			", tpep_pickup_datetime='" + getTpep_pickup_datetime() + "'" +
			", tpep_dropoff_datetime='" + getTpep_dropoff_datetime() + "'" +
			", passenger_count='" + getPassenger_count() + "'" +
			", trip_distance='" + getTrip_distance() + "'" +
			", pickup_longitude='" + getPickup_longitude() + "'" +
			", pickup_latitude='" + getPickup_latitude() + "'" +
			", RateCodeID='" + getRateCodeID() + "'" +
			", store_and_fwd_flag='" + getStore_and_fwd_flag() + "'" +
			", dropoff_longitude='" + getDropoff_longitude() + "'" +
			", dropoff_latitude='" + getDropoff_latitude() + "'" +
			", payment_type='" + getPayment_type() + "'" +
			", fare_amount='" + getFare_amount() + "'" +
			", extra='" + getExtra() + "'" +
			", mta_tax='" + getMta_tax() + "'" +
			", tip_amount='" + getTip_amount() + "'" +
			", tolls_amount='" + getTolls_amount() + "'" +
			", improvement_surcharge='" + getImprovement_surcharge() + "'" +
			", total_amount='" + getTotal_amount() + "'" +
			"}";
	}

	

}
