import java.util.concurrent.Callable;
import java.util.Arrays;

public class ModuloVettore implements Callable<Double> {

    private final int[] vettore;

    public ModuloVettore(int[] vettore) {
        this.vettore = vettore;
    }

    @Override
    public Double call() {
        double sommaQuadrati = 0;
        for (int valore : vettore) {
            sommaQuadrati += valore * valore;
        }
        double modulo = Math.sqrt(sommaQuadrati);
        System.out.println("Modulo del vettore " + Arrays.toString(vettore) + " = " + modulo);
        return modulo;
    }
}
