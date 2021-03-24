package com.beta.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beta.tenant.entity.Owner;
import com.beta.tenant.entity.Tenant;
import com.beta.tenant.exception.TenantException;
import com.beta.tenant.service.ITenantService;


@RestController
@CrossOrigin(origins = "*") 	//origins=""
public class TenantController {

	@Autowired 
	ITenantService tenantService;

	@PostMapping("owner/login/{user}/{pass}")//login as owner
	public ResponseEntity<Boolean>  findUserLogin(@PathVariable("user") String ownerName, @PathVariable("pass") String ownerPassword) throws TenantException
	{
		return new ResponseEntity<>(tenantService.validateOwner(ownerName,ownerPassword),HttpStatus.ACCEPTED);
	}


	@GetMapping("owner/tenant")//list of all tenants
	public ResponseEntity<List<Tenant>> findAllTenants() throws TenantException {
		return new ResponseEntity<>(tenantService.findAllTenants(), HttpStatus.OK);

	}
	
	@GetMapping("owner")//list of all tenants
	public ResponseEntity<List<Owner>> findAllOwners() throws TenantException {
		return new ResponseEntity<>(tenantService.findAllOwners(), HttpStatus.OK);

	}

	@GetMapping("owner/tenant/{id}")//tenant by id
	public ResponseEntity<Tenant> findTenantById(@PathVariable("id") int tenantId) throws TenantException {
		return new ResponseEntity<>(tenantService.findTenantById(tenantId), HttpStatus.OK);
	}

	//	----------------------------------------------------------------------------------------------------------------------

	@PostMapping("owner/tenant")// add tenant
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
		return new ResponseEntity<>(tenantService.createTenant(tenant), HttpStatus.OK);
	}

	@PostMapping("owner")//add owner
	public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
		return new ResponseEntity<>(tenantService.createOwner(owner), HttpStatus.OK);
	}

	// ------------------------------------------------------------------------------------------------------------------------------

	@DeleteMapping("owner/tenant/{id}")// delete tenant by id
	public ResponseEntity<Tenant> deleteTenantById(@PathVariable("id") int tenantId) throws TenantException {
		return new ResponseEntity<>(tenantService.deleteTenantById(tenantId), HttpStatus.OK);
	}
	
	@DeleteMapping("owner/{id}")// delete owner by id
	public ResponseEntity<Owner> deleteOwnerById(@PathVariable("id") int ownerId) throws TenantException {
		return new ResponseEntity<>(tenantService.deleteOwnerById(ownerId), HttpStatus.OK);
	}

	// -------------------------------------------------------------------------------------------------------------------------

	@PutMapping("owner/tenant/{id}")//update tenant by id
	public ResponseEntity<Tenant> updateTenantById(@PathVariable("id") int tenantId,@RequestBody Tenant tenant) throws TenantException {
		ResponseEntity<Tenant> rt = null;
		if (tenant != null) {
			tenant = tenantService.updateTenantById(tenantId,tenant);
			rt = new ResponseEntity<>(tenant, HttpStatus.OK);
		} else {
			rt = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return rt;

	}

	@PutMapping("owner")//update owner by id
	public ResponseEntity<Owner> updateOwnerById(@RequestBody Owner owner) throws TenantException {
		ResponseEntity<Owner> rt = null;

		if (owner != null) {
			owner = tenantService.updateOwnerById(owner);
			rt = new ResponseEntity<>(owner, HttpStatus.OK);
		} else {
			rt = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return rt;

	}

}
