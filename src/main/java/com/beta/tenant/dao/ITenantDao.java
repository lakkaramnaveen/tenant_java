package com.beta.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beta.tenant.entity.Tenant;

@Repository
public interface ITenantDao extends JpaRepository<Tenant, Integer> {

}
