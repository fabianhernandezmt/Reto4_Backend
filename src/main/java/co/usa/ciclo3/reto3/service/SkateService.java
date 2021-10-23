package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Skate;
import co.usa.ciclo3.reto3.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate p){
        if(p.getId()==null){
            return skateRepository.save(p);
        }else{
            Optional<Skate> paux=skateRepository.getSkate(p.getId());
            if(paux.isEmpty()){
                return skateRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Skate update(Skate p){
        if(p.getId()!=null){
            Optional<Skate> paux =skateRepository.getSkate(p.getId());
            if(!paux.isEmpty()){
                if(p.getName() !=null){
                    paux.get().setName(p.getName());
                }
                if(p.getBrand()!=null){
                    paux.get().setBrand(p.getBrand());
                }
                if(p.getYear()!=null){
                    paux.get().setYear(p.getYear());
                }
                if(p.getDescription()!=null){
                    paux.get().setDescription(p.getDescription());
                }
                if(p.getCategory()!=null){
                    paux.get().setCategory(p.getCategory());
                }
                skateRepository.save(paux.get());
                return paux.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    } 
    
        public boolean deleteSkate (int id){
            Boolean aBoolean = getSkate(id).map(p -> {
                skateRepository.delete(p);
                return true;        
            }).orElse(false);
            return aBoolean;
        }
 
    }



