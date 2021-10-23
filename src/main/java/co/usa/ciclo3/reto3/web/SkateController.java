package co.usa.ciclo3.reto3.web;

import co.usa.ciclo3.reto3.model.Skate;
import co.usa.ciclo3.reto3.service.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SkateController {

    @Autowired
    private SkateService skateService;

    @GetMapping("/all")
    public List<Skate> getSkates(){
        return skateService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable("id") int id){
        return skateService.getSkate(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate p){
        return skateService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate p) {
        return skateService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return skateService.deleteSkate(id);
    } 
}
