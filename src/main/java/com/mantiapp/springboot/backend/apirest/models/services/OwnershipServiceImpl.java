package com.mantiapp.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import com.mantiapp.springboot.backend.apirest.models.dao.IOwnershipDao;

@Service
public class OwnershipServiceImpl implements IOwnershipService{

    @Autowired
    private IOwnershipDao ownershipDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ownership> findAll() {
        return (List<Ownership>) ownershipDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ownership findById(Long id) {
        return ownershipDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Ownership save(Ownership ownership) {
        return ownershipDao.save(ownership);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        ownershipDao.deleteById(id);
    }

}
