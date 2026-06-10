/*
 * Colby Scroggins
 * CS 417
 * Machine Assignment 3
 */
package machineassignment3;

public class DerivativeApproximation {
    /**
     * This program computes an approximate value for the derivative of f(x) = sin(x) using the 
     * finite difference formula: f'(x) ≈ (f(x + h) - f(x)) / h.
     * The program computes an approximate derivative for a range of values(h) from 1/2 to 1/2^30 
     * and computes the absolute error compared to the known derivative for f'(x) using cos(1).
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Calculate the known derivative
        double x = 1.0;
        double knownDerivative = Math.cos(x);

        // Print the table header
        System.out.println("|  h   |       x       | Approx. f'(x) |  Known f'(x)  |  Abs. Error   |");
        System.out.println("|:----:|--------------:|--------------:|--------------:|--------------:|");

        // Loop through values of h from 1/2 to 1/2^30
        for (int i = 1; i <= 30; i++) {
            // Calculate h as 2^-i
            double h = Math.pow(2, -i);
            
            // Approximate derivative: f'(x) ≈ (f(x + h) - f(x)) / h
            double approximateDerivative = (Math.sin(x + h) - Math.sin(x)) / h;

            // Calculate the absolute error
            double absoluteError = Math.abs(approximateDerivative - knownDerivative);

            // Print the results in a formatted table
            System.out.printf("|2^-%02d | %13.8f | %13.8f | %13.8f | %13.8f |%n", 
                i, 
                x, 
                approximateDerivative, 
                knownDerivative, 
                absoluteError);
        }
    }
}
