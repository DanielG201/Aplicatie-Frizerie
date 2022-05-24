package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.models.Reservation;
import org.loose.fis.sre.models.User;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ReservationService {

    private static ObjectRepository<Reservation> reservationRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("reservation.db").toFile())
                .openOrCreate("test", "test");

        reservationRepository = database.getRepository(Reservation.class);
    }
}
