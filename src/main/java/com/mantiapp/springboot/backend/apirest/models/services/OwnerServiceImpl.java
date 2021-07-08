package com.mantiapp.springboot.backend.apirest.models.services;

import java.util.List;
import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantiapp.springboot.backend.apirest.models.dao.IOwnerDao;

@Service
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	private IOwnerDao ownerDao;

	@Override
	@Transactional(readOnly = true)
	public List<Owner> findAll() {
		return (List<Owner>) ownerDao.findAll();
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Owner> findByEmail()  {
		return (List<Owner>) ownerDao.findByEmail();
	};
	 */
	

}
