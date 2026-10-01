public class Produit {
    private int id;
    private String nom;
    private int prix;
    private int quantite;

    public Produit(int id,String nom,int prix, int quantite){
        this.id= id;
        this.nom= nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void afficherDetails(){
        System.out.print(
                "id : "+getId()+"\n"+
                        "nom : "+getNom()+"\n"+
                        "prix : "+getPrix()+"\n"+
                        "quantite : "+getQuantite()+"\n"
        );
    }
}
