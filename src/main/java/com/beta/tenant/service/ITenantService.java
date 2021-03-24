package com.beta.tenant.service;

import java.util.List;
import com.beta.tenant.entity.Owner;
import com.beta.tenant.entity.Tenant;
import com.beta.tenant.exception.TenantException;

public interface ITenantService {
	public boolean validateOwner(String ownerName, String ownerPassword) throws TenantException;
	public Tenant createTenant(Tenant tenant);
	public Tenant findTenantById(int tenantId) throws TenantException;
	public Tenant updateTenantById(int tenantId,Tenant tenant) throws TenantException;
	public Tenant deleteTenantById(int tenantId) throws TenantException;
	public Owner createOwner(Owner owner);
	public List<Tenant> findAllTenants() throws TenantException;
	public Owner updateOwnerById(Owner owner) throws TenantException;
	public List<Owner> findAllOwners() throws TenantException;
	public Owner deleteOwnerById(int ownerId) throws TenantException;
}
