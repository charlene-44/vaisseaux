public class Main {
    public static void main(String[] args) {

        Croiseurs croiseur1 = new Croiseurs("Acclamator", "Croiseur", 752);
        Croiseurs croiseur2 = new Croiseurs("Acclamator", "Croiseur", 150);
        Intercepteurs intercepteur = new Intercepteurs("X-wing", "Intercepteur", 2);

        croiseur1.charger(600);
        croiseur1.charger(200);

        intercepteur.tirer();
        intercepteur.tirer();
        intercepteur.tirer();
        intercepteur.recharger();
        intercepteur.tirer();

        // Appel de la fonction afficherCapacites
        afficherCapacites(croiseur1);
        afficherCapacites(croiseur2);
        afficherCapacites(intercepteur);
    }

    // Fonction qui prend un Vaisseau en paramètre et affiche ses caractéristiques
    public static void afficherCapacites(Vaisseaux vaisseau) {
        vaisseau.afficherCaracteristiques();
    }
}

class Vaisseaux {
    String nom;
    String type;
    int taille;

    public Vaisseaux(String nom, String type, int taille) {
        this.nom = nom;
        this.type = type;
        this.taille = taille;
    }

    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nom + ", Type: " + type + ", Taille: " + taille);
    }
}

class Croiseurs extends Vaisseaux {
    int capacite;
    int chargementActuel = 0; // Pour suivre le nombre de personnes actuellement chargées

    void charger(int nombrePersonnes) {
        if (chargementActuel + nombrePersonnes <= capacite) {
            chargementActuel += nombrePersonnes;
            System.out.println("Chargement de " + nombrePersonnes + " personnes réussi !");
        } else {
            System.out.println("Impossible de charger " + nombrePersonnes +
                    " personnes supplémentaires. Capacité maximale dépassée !");
        }
    }

    void decharger() {
        System.out.println("Déchargement des troupes !");
        chargementActuel = 0;
    }

    @Override
    public void afficherCaracteristiques() {
        super.afficherCaracteristiques();
        System.out.println("Capacité: " + capacite + ", Chargement actuel: " + chargementActuel);
    }

    public Croiseurs(String nom, String type, int capacite) {
        super(nom, type, capacite);
        this.capacite = capacite;
    }
}

class Intercepteurs extends Vaisseaux {
    int canon;
    int nombreDeTirs = 0;
    
    void tirer() {
        if (nombreDeTirs < canon) {
            nombreDeTirs++;
            System.out.println("Tir " + nombreDeTirs + " réussi !");
        } else {
            System.out.println("Impossible de tirer, rechargement nécessaire !");
        }
    }
    
    void recharger() {
        System.out.println("Recharge !");
        nombreDeTirs = 0;
    }
    
    @Override
    public void afficherCaracteristiques() {
        super.afficherCaracteristiques();
        System.out.println("Canon: " + canon + ", nombre de tirs: " + nombreDeTirs);
    }
    
    public Intercepteurs(String nom, String type, int canon) {
        super(nom, type, canon);
        this.canon = canon;
    }
}