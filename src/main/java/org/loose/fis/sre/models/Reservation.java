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

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public void setBarberShopName(String barberShopName) {
        this.barberShopName = barberShopName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getBarberName() {
        return barberName;
    }

    public String getBarberShopName() {
        return barberShopName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getStatus() {
        return status;
    }
}
