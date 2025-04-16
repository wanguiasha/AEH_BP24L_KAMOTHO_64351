
      public class myFifthapp {

        public static void main(String[] args) {
            int n = 20; // Number to calculate factorial for

            // Measure iterative factorial
            long startTimeIterative = System.nanoTime();
            long iterativeResult = factorialIterative(n);
            long endTimeIterative = System.nanoTime();
            double iterativeTime = (endTimeIterative - startTimeIterative) / 1_000_000.0; // Convert to milliseconds

            // Measure recursive factorial
            long startTimeRecursive = System.nanoTime();
            long recursiveResult = factorialRecursive(n);
            long endTimeRecursive = System.nanoTime();
            double recursiveTime = (endTimeRecursive - startTimeRecursive) / 1_000_000.0; // Convert to milliseconds

            // Display results
            System.out.println("Factorial of " + n + " (Iterative): " + iterativeResult);
            System.out.println("Time taken (Iterative): " + iterativeTime + " ms");
            System.out.println("Factorial of " + n + " (Recursive): " + recursiveResult);
            System.out.println("Time taken (Recursive): " + recursiveTime + " ms");
        }

        // Iterative factorial method
        private static long factorialIterative(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers");
            }
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        // Recursive factorial method
        private static long factorialRecursive(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers");
            }
            if (n == 0 || n == 1) {
                return 1;
            }
            return n * factorialRecursive(n - 1);
        }
    }

