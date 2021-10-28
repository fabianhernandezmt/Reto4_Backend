package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.Reportes.ContadorClientes;
import co.usa.ciclo3.reto3.Reportes.StatusReservas;
import co.usa.ciclo3.reto3.model.Reservation;
import co.usa.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> paux=reservationRepository.getReservation(p.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int id) {
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
 
    public StatusReservas getReporteStatusReservaciones (){
        List<Reservation>completed=reservationRepository.ReservationStatus("completed");
        List<Reservation>cancelled=reservationRepository.ReservationStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }


    public List<Reservation> getReporteTiempoReservaciones (String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(dateA);
            datoDos = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservationTime(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    
     
    }

    public List<ContadorClientes> getTopClientes(){
        return reservationRepository.getTopClientes();
        
    }


}
