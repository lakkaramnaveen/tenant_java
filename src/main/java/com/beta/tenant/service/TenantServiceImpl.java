package com.beta.tenant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.tenant.dao.IOwnerDao;
import com.beta.tenant.dao.ITenantDao;
import com.beta.tenant.entity.Owner;
import com.beta.tenant.entity.Tenant;
import com.beta.tenant.exception.TenantException;

@Service
public class TenantServiceImpl implements ITenantService{
	@Autowired
	IOwnerDao ownerDao;
	
	@Autowired
	ITenantDao tenantDao;
	
	String str = "Tenant Not Found";
	
	String str1 = "Owner Not Found";
	
	@Override
	public boolean validateOwner(String ownerName, String ownerPassword) throws TenantException {
		Owner owner=ownerDao.getOwnerByName(ownerName);
		if(!(owner.getOwnerPassword().equals(ownerPassword) && owner.isAdmin())) { 
			throw new TenantException(str1);
		}
		return true;
	}
	
	@Override
	public Tenant createTenant(Tenant tenant) {
		return tenantDao.saveAndFlush(tenant);
	}
	
	@Override
	public Tenant findTenantById(int tenantId) throws TenantException {
		Tenant t = null;
		Optional<Tenant> tr = tenantDao.findById(tenantId);
		if (tr.isPresent()) {
			t = tr.get();
		} else {
			throw new TenantException(str);
		}
		return t;
	}
	
	@Override
	public Tenant updateTenantById(int tenantId,Tenant tenant) throws TenantException {
		if (tenantDao.existsById(tenantId)) {
			tenantDao.saveAndFlush(tenant);
		} else {
			throw new TenantException(str);
		}
		return tenant;
	}


	@Override
	public Tenant deleteTenantById(int tenantId) throws TenantException {
		Tenant tr1 = null;
		Optional<Tenant> trr = tenantDao.findById(tenantId);
		if (trr.isPresent()) {
			tr1 = trr.get();
			tenantDao.deleteById(tenantId);
		} else {
			throw new TenantException(str);
		}
		return tr1;
	}
	
	@Override
	public List<Tenant> findAllTenants() throws TenantException {
		return tenantDao.findAll();
	}
	

	@Override
	public Owner createOwner(Owner owner) {
		return ownerDao.saveAndFlush(owner);
	}

	@Override
	public Owner updateOwnerById(Owner owner) throws TenantException {
		if (ownerDao.existsById(owner.getOwnerId())) {
			ownerDao.saveAndFlush(owner);
		} else {
			throw new TenantException(str1);
		}
		return owner;
	}
	
	
}
