package com.test.ApiApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.test.ApiApp.repository.ProduitRepository;
import com.test.ApiApp.controlers.Produitcontrolers;
import com.test.ApiApp.service.ProduitService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiAppApplicationTests {

	@Autowired
	private ApiAppApplication service;

	@MockBean
	private ProduitRepository repository;

	@Test
	public void getProduitsTest() {




	}

}
