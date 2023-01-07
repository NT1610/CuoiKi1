public class TrapezoidalRule {
    public static void main(String[] args) {
        System.out.println(integrate());
        System.out.println(integrate(2));
    }

    public static double f(double x) {
        return Math.pow(Math.sin(x), 2) * Math.cos(x);

    }

    public static double integrate(int n) {
        double term1 = 0.0;
        double term2 = 0.0;
        double a = 0.0;
        double b = Math.PI / 2;
        double check = 1;

        for (int k = n; k > 0; k += 2) {

            double h1 = (b - a) / k;
            double h2 = (b - a) / (2 * k);
            term1 = (f(a) + f(a + k * h1)) / 2;
            term2 = (f(a) + f(a + 2 * k * h1)) / 2;

            for (int i = 0; i <= k; i++) {
                double x1 = a + i * h1;
                term1 += f(x1);
            }
            for (int i = 0; i <= 2 * k; i++) {
                double x2 = a + i * h2;
                term2 += f(x2);
            }
            term1 = h1 * term1;
            term2 = h2 * term2;
            if (Math.abs(term2 - term1) < Math.pow(10, -6)) {
                break;
            }

        }
        return term1;

    }

    public static double integrate() {
        return (1.0 / 3) * Math.pow(Math.sin(Math.PI / 2), 3);

    }
}