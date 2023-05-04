package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactoService;
import com.campusdual.appmazing.model.Contacto;
import com.campusdual.appmazing.model.dao.ContactoDao;
import com.campusdual.appmazing.model.dto.ContactoDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactoService")
@Lazy
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    public ContactoDto queryContacto(ContactoDto contactoDto) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        Contacto result = contactoDao.getReferenceById(contacto.getId());
        return ContactoMapper.INSTANCE.toDTO(result);
    }

    @Override
    public List<ContactoDto> queryAllContactos() {
        return ContactoMapper.INSTANCE.toDTOList(contactoDao.findAll());
    }

    @Override
    public int insertContacto(ContactoDto contactoDto) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        contactoDao.saveAndFlush(contacto);
        return contacto.getId();
    }

    @Override
    public int updateContacto(ContactoDto contactoDto) {
        return insertContacto(contactoDto);
    }

    @Override
    public int deleteContacto(ContactoDto contactoDto) {
        Contacto contacto = ContactoMapper.INSTANCE.toEntity(contactoDto);
        contactoDao.delete(contacto);
        return contacto.getId();
    }
}
