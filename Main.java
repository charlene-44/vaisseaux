public class Main {
    public static void main(String[] args) {

        Croiseur croiseur1 = new Croiseur("Acclamator", "Croiseur",752, 700);
        Croiseur croiseur2 = new Croiseur("Acclamator", "Croiseur", 150, 165);
        Intercepteur intercepteur = new Intercepteur("X-wing", "Intercepteur",12.5, 2);

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
    public static void afficherCapacites(Vaisseau vaisseau) {
        vaisseau.afficherCaracteristiques();
    }
}

class Vaisseau {
    String nom;
    String type;
    double taille;

    public Vaisseau(String nom, String type, double taille) {
        this.nom = nom;
        this.type = type;
        this.taille = taille;
    }

    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nom + ", Type: " + type + ", Taille: " + taille);
    }
}

class Croiseur extends Vaisseau {
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

    public Croiseur(String nom, String type, double taille, int capacite) {
        super(nom, type, taille);
        this.capacite = capacite;
    }
}

class Intercepteur extends Vaisseau {
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
    
    public Intercepteur(String nom, String type, double taille, int canon) {
        super(nom, type, taille);
        this.canon = canon;
    }
}