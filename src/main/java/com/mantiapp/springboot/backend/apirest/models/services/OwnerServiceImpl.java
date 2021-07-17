package com.mantiapp.springboot.backend.apirest.models.services;

import com.mantiapp.springboot.backend.apirest.models.dao.IOwnerDao;
import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements IOwnerService{

    @Autowired
    private IOwnerDao ownerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        return (List<Owner>) ownerDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findById(Long id) {
        return ownerDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findByEmail(String email) {
        return ownerDao.findByEmail(email);
    }

    @Override
    @Transactional
    public Owner save(Owner owner) {
        return ownerDao.save(owner);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ownerDao.deleteById(id);
    }

}
