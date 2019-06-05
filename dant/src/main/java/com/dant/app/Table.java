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


	private int VendorID;
	private String tpep_pickup_datetime;
	private String tpep_dropoff_datetime;
	private int passenger_count;
	private float trip_distance;
	private int RatecodeID;
	private int store_and_fwd_flag;
	private int PULocationID;
	private int DOLocationID;
	private String payment_type;
	private float fare_amount;
	private String extra;
	private float mta_tax;
	private float tip_amount;
	private float tolls_amount;
	private String improvement_surcharge;
	private float total_amount;



	public Table(int VendorID, String tpep_pickup_datetime, String tpep_dropoff_datetime, int passenger_count, float trip_distance, int RatecodeID, int store_and_fwd_flag, int PULocationID, int DOLocationID, String payment_type, float fare_amount, String extra, float mta_tax, float tip_amount, float tolls_amount, String improvement_surcharge, float total_amount) {
		this.VendorID = VendorID;
		this.tpep_pickup_datetime = tpep_pickup_datetime;
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
		this.passenger_count = passenger_count;
		this.trip_distance = trip_distance;
		this.RatecodeID = RatecodeID;
		this.store_and_fwd_flag = store_and_fwd_flag;
		this.PULocationID = PULocationID;
		this.DOLocationID = DOLocationID;
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
