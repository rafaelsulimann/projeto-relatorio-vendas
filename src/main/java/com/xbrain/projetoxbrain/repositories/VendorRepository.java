package com.xbrain.projetoxbrain.repositories;

import com.xbrain.projetoxbrain.models.VendorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<VendorModel, Long>{
    
}
