package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.ReservationAlreadyExistsException;
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

    public static ObjectRepository<Reservation> getReservationRepository() {
        return reservationRepository;
    }
}
