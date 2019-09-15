package com.test.ApiApp.controlers;


import com.test.ApiApp.domain.PanierElement;
import com.test.ApiApp.domain.Produit;
import com.test.ApiApp.service.ProduitService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping(value = "/produits")

public class Produitcontrolers {

    private final ProduitService produitrepository;

    public Produitcontrolers(ProduitService produitrepository) {
        this.produitrepository = produitrepository;
    }

    @GetMapping(value = "")
    public Flux<Produit> all() {
        return produitrepository.trouverAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Produit> get(@PathVariable(value = "id") Integer id) {
        return this.produitrepository.trouverId(id);
    }

    @PostMapping(value = "")
    public Mono<Produit> ajouterProduit(@RequestBody Produit produit) {
        return produitrepository.ajouterProduit(produit);
    }

    @PostMapping(value = "/ajouterpanier")
    public Mono<Map<Integer, PanierElement>> ajouterProduitPanier(@RequestBody Produit produit) {
        return produitrepository.ajouterProduitPanier(produit);
    }

    @PostMapping(value = "/enleverpanier")
    public Mono<Map<Integer, PanierElement>> enleverProduitPanier(@RequestBody Produit produit) {
        return produitrepository.enleverProduitPanier(produit);
    }

    @GetMapping(value = "/monpanier")
    public Mono<Map<Integer, PanierElement>> monPanier() {
        return produitrepository.afficherMonPanier();
    }

}
