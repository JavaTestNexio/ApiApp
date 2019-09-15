package com.test.ApiApp.repository;

import com.test.ApiApp.domain.Produit;

import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

}
