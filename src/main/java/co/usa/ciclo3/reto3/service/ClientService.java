package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Client;
import co.usa.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> paux=clientRepository.getClient(p.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int id) {
        Boolean aBoolean = getClient(id).map(client -> {
           clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
