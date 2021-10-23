package co.usa.ciclo3.reto3.repository;

import co.usa.ciclo3.reto3.model.Reservation;
import co.usa.ciclo3.reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }

    public void delete(Reservation p){
        reservationCrudRepository.delete(p);
    }

}
