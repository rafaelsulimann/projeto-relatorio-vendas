package com.xbrain.projetoxbrain.repositories;

import com.xbrain.projetoxbrain.models.SellerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerModel, Long>{

    boolean existsByFullName(String fullName);
    boolean existsByCpf(String cpf);
    
}
