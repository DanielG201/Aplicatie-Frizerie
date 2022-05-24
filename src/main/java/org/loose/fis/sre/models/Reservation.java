package org.loose.fis.sre.models;

public class Reservation {

    private String clientName,clientPhone,status,time,barberShopName,barberName;

    public Reservation(String clientName,String clientPhone,String time,String barberShopName,String barberName){
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.status = "Liber";
        this.time = time;
        this.barberName = barberName;
        this.barberShopName = barberShopName;
    }

    public Reservation(){

    }

}
