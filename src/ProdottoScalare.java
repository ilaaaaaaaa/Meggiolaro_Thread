import java.util.concurrent.Callable;

public class ProdottoScalare implements Callable<Double> {

    private final int[] U;
    private final int[] V;

    public ProdottoScalare(int[] U, int[] V) {
        this.U = U;
        this.V = V;
    }

    @Override
    public Double call() {
        double prodotto = 0;
        for (int i = 0; i < U.length; i++) {
            prodotto += U[i] * V[i];
        }
        System.out.println("Prodotto scalare: " + prodotto);
        return prodotto;
    }
}
