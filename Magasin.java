import java.util.ArrayList;
import java.util.List;

public class Magasin {
	private final List<Produit> produits = new ArrayList<>();

	public void ajouterProduit(Produit produit) {
		produits.add(produit);
	}

	public void afficherProduitsDisponibles() {
		for (Produit produit : produits) {
			if (produit.getQuantite() > 0) {
				produit.afficherDetails();
			}
		}
	}

	public Produit trouverProduitParNom(String nom) {
		for (Produit produit : produits) {
			if (produit.getNom().equals(nom)) {
				return produit;
			}
		}
		return null;
	}
}
