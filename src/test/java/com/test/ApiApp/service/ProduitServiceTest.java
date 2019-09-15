package com.test.ApiApp.service;

import com.test.ApiApp.domain.Produit;
import com.test.ApiApp.repository.ProduitRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.Optional;

//TODO Ajouter plus de tests unitaires

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProduitServiceTest {

    @TestConfiguration
    static class ProduitServiceTestContextConfiguration {

        @Bean
        public ProduitService produitService() {
            return new ProduitService();
        }
    }

    @MockBean
    private ProduitRepository produitRepository;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void tester_trouverAll() {

        Iterable<Produit> produitList = new ArrayList();
        ((ArrayList<Produit>) produitList).add((Produit.builder().id(1).build()));
        Mockito.when(produitRepository.findAll())
                .thenReturn(produitList);

        Assert.assertEquals(((ArrayList<Produit>) produitList).get(0).getId().intValue(), 1);
    }


    @Test
    public void tester_trouverId() {

        Mockito.when(produitRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(Produit.builder().id(1).build()));
        Mono<Produit> found = produitService.trouverId(1);
        found.subscribe(
                value -> Assert.assertEquals(value.getId().intValue(), 1),
                error -> error.printStackTrace(),
                () -> System.out.println("Terminé sans valeur")
        );
    }

}
