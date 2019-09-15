package com.test.ApiApp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Produit {
    @Id
    private Integer id;
    private String nom;
    private String categorie;
    private String description;
    private String poid;
    private String poidunite;
    private String prixunitaire;
    private String stock;
}
