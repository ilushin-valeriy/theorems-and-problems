package su.ilushin.chapter01.part01.task20;

public class SquareCalculator {

  public static void printSquares(long n) {
    for (long i = 0; i <= n; i++) {
      System.out.printf("printSquares: %d^2 = %d\n", i, i * i);
    }
  }

  public static void printSquares2(long n) {
    long square = 0;
    for (long i = 0; i <= n; i++) {

      System.out.printf("printSquares: %d^2 = %d\n", i, square);

      square += (2 * i + 1);
    }
  }

  public static void run() {
    printSquares(5);
    printSquares2(5);

  }
}
