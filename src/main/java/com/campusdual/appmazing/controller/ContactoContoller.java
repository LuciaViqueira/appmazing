package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactoService;
import com.campusdual.appmazing.model.dto.ContactoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contacto")
public class ContactoContoller {
    @Autowired
    private IContactoService contactoService;

    @GetMapping
    public String testController(){
        return "Contacto controller works";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacto controller works, " + name;
    }

    @GetMapping(value="/testMethod")
    public String testControllerMethod(){
        return "Contacto controller method works";
    }

    @PostMapping(value="/get")
    public ContactoDto queryContacto(@RequestBody ContactoDto contactoDto){
        return contactoService.queryContacto(contactoDto);
    }
    @GetMapping(value="/getAll")
    public List<ContactoDto> queryAllContactos(){
        return contactoService.queryAllContactos();
    }
    @PostMapping(value = "/add")
    public int addContacto(@RequestBody ContactoDto contactoDto){
        return contactoService.insertContacto(contactoDto);
    }

    @PutMapping(value = "/update")
    public int updateContacto(@RequestBody ContactoDto contactoDto){
        return contactoService.updateContacto(contactoDto);
    }
    @DeleteMapping(value = "/delete")
    public int deleteContacto(@RequestBody ContactoDto contactoDto){
        return contactoService.deleteContacto(contactoDto);
    }
}
