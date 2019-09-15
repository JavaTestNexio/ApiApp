package com.test.ApiApp.service;

import com.test.ApiApp.domain.PanierElement;
import com.test.ApiApp.domain.Produit;
import com.test.ApiApp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Component

public class ProduitService {

    private static final Map<Integer, PanierElement> Panier = new HashMap<>();
    private static Integer ID_COUNTER = 1;
    @Autowired
    private ProduitRepository produitRepository;

    public Flux<Produit> trouverAll() {

        return Flux.fromIterable(produitRepository.findAll());
    }

    public Mono<Produit> ajouterProduit(Produit produit) {
        return Mono.just(produitRepository.save(produit));
    }

    public Mono<Produit> trouverId(Integer id) {
        return Mono.just(produitRepository.findById(id).get());
    }


    public Mono<Map<Integer, PanierElement>> ajouterProduitPanier(Produit produit) {

        if (produitRepository.findById(produit.getId()).isPresent()) {

            if (Panier.containsKey(produit.getId())) {
                PanierElement produitselection = Panier.get(produit.getId());
                produitselection.setQuantite(produitselection.getQuantite() + 1);
                Panier.put(produit.getId(), produitselection);
            } else {
                PanierElement produitnouveau = PanierElement.builder().quantite(1).produit(produit).build();
                Panier.put(produit.getId(), produitnouveau);
            }
            return Mono.just(Panier);

        }
        return Mono.error(new IllegalArgumentException("Le produit n'existe pas"));
    }

    public Mono<Map<Integer, PanierElement>> enleverProduitPanier(Produit produit) {

        if (Panier.containsKey(produit.getId())) {
            PanierElement produitselection = Panier.get(produit.getId());
            Integer quantite = Math.max(produitselection.getQuantite() - 1, 0);
            produitselection.setQuantite(quantite);

            if (quantite == 0) {
                Panier.remove(produit.getId());
            } else {
                Panier.put(produit.getId(), produitselection);
            }

        }
        return Mono.just(Panier);
    }

    public Mono<Map<Integer, PanierElement>> afficherMonPanier() {

        return Mono.just(Panier);
    }
}
