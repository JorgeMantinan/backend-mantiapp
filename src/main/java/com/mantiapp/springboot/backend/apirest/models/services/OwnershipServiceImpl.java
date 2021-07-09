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

}
