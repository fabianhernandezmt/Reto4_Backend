package co.usa.ciclo3.reto3.repository;

import co.usa.ciclo3.reto3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoriaCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoriaCrudRepository.findAll();
    }
    public Optional<Category>getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }
    public Category save(Category c){
        return categoriaCrudRepository.save(c);
    }

    public void delete(Category p){
        categoriaCrudRepository.delete(p);
    }
}
