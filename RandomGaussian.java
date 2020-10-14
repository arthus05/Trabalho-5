import java.util.Random;
import java.io.*;

public final class RandomGaussian {

    public static void main(String... aArgs) {
        try {
            // Arquivo o qual irei escrever os valores
            File written = new File("written.txt");

            // Aqui abrimos os fluxos
            FileOutputStream wr = new FileOutputStream(written);
            FileInputStream re = new FileInputStream(written);

            RandomGaussian gaussian = new RandomGaussian();
            double MEAN = 100.0f;
            double VARIANCE = 5.0f;
            for (int idx = 1; idx <= 10; ++idx) {
                // Aqui escrevemos no arquivo 'written.txt'
                String text = "Generated : " + String.valueOf(gaussian.getGaussian(MEAN, VARIANCE)) + "\n";
                wr.write(text.getBytes());
            }
            wr.close();

            int i = 0;
            while (i != -1) {
                // Aqui lemos o arquivo 'written.txt'
                i = re.read();
                char c = (char) i;
                System.out.print(c);
            }
            re.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Random fRandom = new Random();

    private double getGaussian(double aMean, double aVariance) {
        return aMean + fRandom.nextGaussian() * aVariance;
    }

    private static void log(Object aMsg) {
        System.out.println(String.valueOf(aMsg));
    }
}
