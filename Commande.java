public class Commande {
    private int idCommande;
    private Client client;
    private Panier produitsCommandes;
    private int total;

    public Commande(int idCommande, Client client, Panier produitsCommandes) {
        this.idCommande = idCommande;
        this.client = client;
        this.produitsCommandes = produitsCommandes;
        this.total = produitsCommandes.calculerTotal();
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void afficherDetailsCommande() {
        System.out.println("id de la commande : " + getIdCommande());

        System.out.println("détail du client :");
        client.afficherDetails();

        System.out.println("produits commandés :");
        produitsCommandes.afficherPanier();

        System.out.println("Total à payer : " + this.total + " €");
    }
}
