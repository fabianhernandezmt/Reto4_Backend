package co.usa.ciclo3.reto3.web;


import co.usa.ciclo3.reto3.model.Category;
import co.usa.ciclo3.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoriaService;

    @GetMapping("/all")
    public List<Category> getCategorias(){
        return categoriaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategoria(@PathVariable("id") int id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoriaService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoriaService.deletecategoria(categoriaId);
    }


}
