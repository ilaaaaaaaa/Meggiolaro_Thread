import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        // Vettori di esempio
        int[] U = {3, 4, 5};
        int[] V = {6, 7, 8};

        // Controllo che i vettori abbiano la stessa dimensione
        if (U.length != V.length) {
            System.out.println("Errore: i vettori devono avere la stessa dimensione.");
            return;
        }

        // Creazione ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // Avvio dei thread
            Future<Double> futuroProdotto = executor.submit(new ProdottoScalare(U, V));
            Future<Double> futuroModuloU = executor.submit(new ModuloVettore(U));
            Future<Double> futuroModuloV = executor.submit(new ModuloVettore(V));

            // Attendo i risultati
            double prodottoScalare = futuroProdotto.get();
            double moduloU = futuroModuloU.get();
            double moduloV = futuroModuloV.get();

            // Calcolo del coseno e dell’angolo
            double cosAlfa = prodottoScalare / (moduloU * moduloV);
            double angoloRadianti = Math.acos(cosAlfa);
            double angoloGradi = Math.toDegrees(angoloRadianti);

            // Output
            System.out.printf("%nCoseno(α) = %.4f%n", cosAlfa);
            System.out.printf("Angolo α = %.2f°%n", angoloGradi);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
