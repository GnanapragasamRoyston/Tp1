
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Magasin magasin = new Magasin();
		magasin.ajouterProduit(new Produit(1, "eau", 1, 100));
		magasin.ajouterProduit(new Produit(2, "coca", 2, 70));
		magasin.ajouterProduit(new Produit(3, "fanta", 2, 70));

		System.out.print("Nom du client : ");
		String nom = scanner.nextLine();
		System.out.print("Email du client : ");
		String email = scanner.nextLine();
		Client client = new Client(1, nom, email);

		Panier panier = new Panier();
		List<Produit> produitsDansPanier = new ArrayList<>();
		boolean commandeTerminee = false;

		while (commandeTerminee == false) {
			System.out.println("\n1. Afficher les produits disponibles");
			System.out.println("2. Ajouter un produit au panier");
			System.out.println("3. Passer la commande");
			System.out.println("0. Quitter");
			System.out.print("Votre choix : ");
			String choix = scanner.nextLine();

			switch (choix) {
				case "1":
					magasin.afficherProduitsDisponibles();
					break;
				case "2": {
					magasin.afficherProduitsDisponibles();
					System.out.print("Nom du produit à ajouter : ");
					Produit produit = magasin.trouverProduitParNom(scanner.nextLine());

					if (produit == null || produit.getQuantite() == 0) {
						System.out.println("Produit introuvable.");
						break;
					}

					int dejaAjoute = 0;
					for (Produit produitDansPanier : produitsDansPanier) {
						if (produitDansPanier == produit) {
							dejaAjoute++;
						}
					}
					int quantiteDisponible = produit.getQuantite() - dejaAjoute;
					System.out.print("Quantité (disponible : " + quantiteDisponible + ") : ");

					int quantiteDemandee = scanner.nextInt();
					scanner.nextLine();

					if (quantiteDemandee <= 0 || quantiteDemandee > quantiteDisponible) {
						System.out.println("Quantité supérieure au stock disponible.");
						break;
					}

					for (int i = 0; i < quantiteDemandee; i++) {
						panier.ajouterProduit(produit);
						produitsDansPanier.add(produit);
					}
					System.out.println("Produit ajouté au panier.");
					break;
				}
				case "3": {
					if (produitsDansPanier.isEmpty()) {
						System.out.println("Le panier est vide.");
						break;
					}

					Commande commande = new Commande(1, client, panier);
					for (Produit produit : produitsDansPanier) {
						produit.setQuantite(produit.getQuantite() - 1);
					}
					commande.afficherDetailsCommande();
					commandeTerminee = true;
					break;
				}
				case "0":
					commandeTerminee = true;
					break;
				default:
					System.out.println("Choix invalide.");
			}
		}

		scanner.close();
	}
}
