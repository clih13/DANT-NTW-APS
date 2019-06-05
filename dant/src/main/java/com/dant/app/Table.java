package com.dant.app;

public class Table {

	// static ArrayList<Table> listTable = new ArrayList<Table>();
	// private ArrayList<Index> index;
	// private String name;

	// public Table(String name) {
	// 	this.index = new ArrayList<Index>();
	// 	this.name = name;
	// 	listTable.add(this);
	// }	
	
	// public void addIndex(Index index) {
	// 	this.index.add(index);		
	// }
	
	// public static Table getTablebyName(String name) {
	// 	for(Table t : listTable) {
	// 		if(name.equals(t.name)) {
	// 			return t;
	// 		}
	// 	}
	// 	return null;
	// }
	
	// public Index getIndex(int index) {
	// 	for(Index i : this.index) {
	// 		if(i.getCol() == index) {
	// 			return i;
	// 		}
	// 	}
	// 	return null;
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




	public Table() {
	}



	public Table(int VendorID, String tpep_pickup_datetime, String tpep_dropoff_datetime, int passenger_count, String trip_distance, String pickup_longitude, String pickup_latitude, int RateCodeID, String store_and_fwd_flag, String dropoff_longitude, String dropoff_latitude, int payment_type, float fare_amount, float extra, float mta_tax, float tip_amount, float tolls_amount, float improvement_surcharge, float total_amount) {
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


}
