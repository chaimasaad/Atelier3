package com.chayma.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chayma.produits.entities.Categorie;
import com.chayma.produits.entities.Produit;
@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByNomProduit(String nom);
	 List<Produit> findByNomProduitContains(String nom); 
	 
	 @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	 List<Produit> findByNomPrix (String nom, Double prix);
	 @Query("select p from Produit p where p.categorie = ?1")
	 List<Produit> findByCategorie (Categorie categorie);
	 List<Produit> findByCategorieIdCat(Long id);
	 

}
