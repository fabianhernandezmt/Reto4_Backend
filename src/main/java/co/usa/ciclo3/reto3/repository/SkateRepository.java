package co.usa.ciclo3.reto3.repository;

import co.usa.ciclo3.reto3.model.Skate;
import co.usa.ciclo3.reto3.repository.crud.SkateCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkateRepository {

    @Autowired
    private SkateCrudRepository skateCrudRepository;

    public List<Skate> getAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }
    public Optional<Skate> getSkate(int id){
        return skateCrudRepository.findById(id);
    }

    public Skate save(Skate p){
        return skateCrudRepository.save(p);
    }

    public void delete(Skate p){
        skateCrudRepository.delete(p);
    }

}
