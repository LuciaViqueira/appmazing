package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactoDto;
import com.campusdual.appmazing.model.dto.ProductDto;

import java.util.List;

public interface IContactoService {
    ContactoDto queryContacto(ContactoDto contactoDto);
    List<ContactoDto> queryAllContactos();
    int insertContacto (ContactoDto contactoDto);
    int updateContacto (ContactoDto contactoDto);
    int deleteContacto (ContactoDto contactoDto);
}
