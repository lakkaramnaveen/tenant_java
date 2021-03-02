package com.beta.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beta.tenant.entity.Owner;

@Repository
public interface IOwnerDao extends JpaRepository<Owner, Integer>  {
	@Query(value = "from Owner where ownerName=:ownerName")
	public Owner getOwnerByName(String ownerName);
}
