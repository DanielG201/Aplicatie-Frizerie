package org.loose.fis.sre.models;

import org.dizitart.no2.objects.Id;

public class Reservation {

    @Id
    private String time;
    private String clientName,clientPhone,status,barberShopName,barberName;

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

    public String getTime() {
        return time;
    }
}
