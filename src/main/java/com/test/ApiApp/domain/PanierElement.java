package com.test.ApiApp.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PanierElement {

    private Integer quantite;
    private Produit produit;

}
