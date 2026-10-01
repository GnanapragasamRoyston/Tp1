import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> produits;

    public Panier(){
        this.produits= new ArrayList<>();
    }
    public void ajouterProduit(Produit produit){
        produits.add(produit);
    }
    public void supprimerProduit(Produit produit){
        produits.remove(produit);
    }
    public void afficherPanier(){
        for (Produit produit : produits) {
            produit.afficherDetails();
        }
    }
    public int calculerTotal(){
        int total=0;
        for (Produit produit: produits){
            total+=produit.getPrix();
        }
        return total;
    }


}
