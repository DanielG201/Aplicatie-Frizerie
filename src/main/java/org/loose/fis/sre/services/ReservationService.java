package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.ReservationAlreadyExistsException;
import org.loose.fis.sre.exceptions.ReservationNotFound;
import org.loose.fis.sre.exceptions.ReservationNotFree;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.models.Reservation;
import org.loose.fis.sre.models.User;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ReservationService {

    private static ObjectRepository<Reservation> reservationRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("reservation.db").toFile())
                .openOrCreate("test", "test");

        reservationRepository = database.getRepository(Reservation.class);
    }

    public static void addReservation(String name, String phone, String time, String shop, String barber) throws ReservationAlreadyExistsException {
        oldReservation(time);
        reservationRepository.insert(new Reservation(name, phone, time, shop, barber));
    }

    private static void oldReservation(String time) throws ReservationAlreadyExistsException {
        for (Reservation reservation : reservationRepository.find()) {
            if (Objects.equals(time, reservation.getTime()))
                throw new ReservationAlreadyExistsException(time);
        }
    }

    public static Reservation findReservation(String time) throws ReservationNotFound {
        for (Reservation reservation : reservationRepository.find()) {
            if (Objects.equals(time, reservation.getTime()))
                return reservation;
        }
        throw new ReservationNotFound();
    }

    public static ObjectRepository<Reservation> getReservationRepository() {
        return reservationRepository;
    }

    public static void deleteReservation(Reservation toDelete) {
        for (Reservation reservation : reservationRepository.find()) {
            if (Objects.equals(toDelete.getTime(), reservation.getTime()))
                reservationRepository.remove(toDelete);
        }

    }

    public static void editReservation(String clientName, String clientPhone, String time) throws ReservationNotFree, ReservationNotFound{
        Reservation aux = new Reservation();
        for (Reservation reservation : reservationRepository.find()) {
            if (Objects.equals(time, reservation.getTime())) {
                if (reservation.getStatus().equals("Liber")) {
                    Reservation newReservation = new Reservation(clientName, clientPhone, time, reservation.getBarberShopName(), reservation.getBarberName());
                    newReservation.setStatus("Rezervat");
                    reservationRepository.remove(reservation);
                    reservationRepository.insert(newReservation);
                    aux = reservation;
                    break;
                } else {
                    throw new ReservationNotFree();
                }
            }
        }
        if(aux == null){
            throw new ReservationNotFound();
        }
    }
}
