package com.dant.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.ws.rs.core.*;

public class SearchEquals {

    UriInfo info;
    Map<String, String> parameters;


    public SearchEquals(UriInfo info){
        this.info = info;
        parameters = setParameters(info);
    }


    private Map<String, String> setParameters(UriInfo info){

        Map<String, String> param = new HashMap<String, String>();

        for(Map.Entry<String, List<String>> entry : info.getQueryParameters().entrySet()){
            //System.out.println(entry.getKey());
            for(String s : entry.getValue()){
                //System.out.println(s);
                param.put(entry.getKey(), s);
            }
        }

        return param;

    }


   
    public List<Index> results(){
        List<Index> results = new ArrayList<Index>();

        for (Map.Entry<String, List<Index>> entry : Table.index.entrySet()) {
            for(Index r : entry.getValue()){
                int NbFieldToFiend = parameters.keySet().size();
                Boolean find = false;

                for (String key : parameters.keySet()) {
                    String value = parameters.get(key);

                    switch (key) {
                        case "vendorID":
                        if(r.getVendorID() == Integer.parseInt(value)){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                        case "tpep_pickup_datetime":
                        if (r.tpep_pickup_datetime == value)
                        {
                            find = true;
                           NbFieldToFiend--;
                        } 
                        break;

                        case "tpep_dropoff_datetime":
                        if (r.getTpep_dropoff_datetime() == value)
                        {
                            find = true;
                           NbFieldToFiend--;
                        } 
                        break;

                        case "passenger_count":
                        if(r.getPassenger_count() == Integer.parseInt(value)){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                        case "trip_distance":
                        if(r.getTrip_distance() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "pickup_longitude":
                        if(r.getPickup_longitude() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "pickup_latitude":
                        if(r.getPickup_latitude() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "RateCodeID":
                        if(r.getRateCodeID() == Integer.parseInt(value)){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "store_and_fwd_flag":
                        if(r.getStore_and_fwd_flag() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "dropoff_longitude":
                        if(r.getDropoff_longitude() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                         case "dropoff_latitude":
                        if(r.getDropoff_latitude() == value){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;
                         
                         case "payment_type":
                        if(r.getPayment_type() == Integer.parseInt(value)){
                            find = true;
                           NbFieldToFiend--;
                         }
                         break;

                        case "fare_amount":
                        if (r.getFare_amount() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;

                        case "extra":
                        if (r.getExtra() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;

                        case "mta_tax":
                        if (r.getMta_tax() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;

                        case "tip_amount":
                        if (r.getTip_amount() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;

                        case "tolls_amount":
                        if (r.getTolls_amount() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;

                        case "improvement_surcharge":
                        if (r.getImprovement_surcharge() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } 
                        break;

                        case "total_amount":
                        if (r.getTotal_amount() == Float.parseFloat(value)) {
                            find = true;
                           NbFieldToFiend--;
                        } break;
                    }
                }

                if(find == true && NbFieldToFiend == 0){
                    try{
                        results.add(r);
                    }catch (Exception e ){

                    }
                }

            }

        }
        System.out.println("END SEARCH");
        return results;
    }

}