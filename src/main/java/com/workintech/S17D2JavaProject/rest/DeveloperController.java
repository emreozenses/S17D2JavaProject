package com.workintech.S17D2JavaProject.rest;

import com.workintech.S17D2JavaProject.dto.DeveloperResponse;
import com.workintech.S17D2JavaProject.model.Developer;
import com.workintech.S17D2JavaProject.model.DeveloperFactory;
import com.workintech.S17D2JavaProject.tax.DeveloperTax;
import com.workintech.S17D2JavaProject.validation.DeveloperValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developer")
@CrossOrigin("*")
public class DeveloperController {

    Map<Integer, Developer> developers;

    private DeveloperTax developerTax;

    @Autowired
    public DeveloperController(DeveloperTax developerTax) {
        this.developerTax = developerTax;
    }

    @PostConstruct
    public void init(){

        developers = new HashMap<>();

    }

    @PostMapping
    public DeveloperResponse save(@RequestBody Developer developer){

        Developer createdDeveloper = DeveloperFactory.createDeveloper(developer,developerTax);
        if(createdDeveloper != null){
            developers.put(createdDeveloper.getId(),createdDeveloper);
        }
        return new DeveloperResponse(createdDeveloper,"succeed", HttpStatus.OK.value());

    }

    @GetMapping
    public List<Developer> getAll(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public DeveloperResponse getById(@PathVariable("id") Integer id){

        if(DeveloperValidation.isDeveloperExist(this.developers,id)){
            return new DeveloperResponse(this.developers.get(id),"succeed",HttpStatus.OK.value());
        }
        return new DeveloperResponse(null,"developer does not exist",HttpStatus.NOT_FOUND.value());
    }
    @PutMapping("/{id}")
    public DeveloperResponse update(@PathVariable("id") Integer id, @RequestBody Developer developer){
        if(!DeveloperValidation.isDeveloperExist(this.developers,id)){
            return new DeveloperResponse(null,"developer already not exist id"+id,HttpStatus.NOT_FOUND.value());
        }
        developer.setId(id);
        Developer updatedDeveloper = DeveloperFactory.createDeveloper(developer,developerTax);
        this.developers.put(updatedDeveloper.getId(),updatedDeveloper);
        return new DeveloperResponse(updatedDeveloper,"succeed",HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    public DeveloperResponse delete(@PathVariable("id") Integer id){
        Developer removedDeveloper = this.developers.get(id);
        this.developers.remove(id);
        return new DeveloperResponse(removedDeveloper,"succeed",HttpStatus.OK.value());
    }



}
