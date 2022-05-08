package su.ilushin.chapter01.part01.task09;


import su.ilushin.common.Pair;

public class Fibonacci {

  /**
   * Returns N's Fibonacci number
   * simple implementation
   *
   * @param n >=0
   * @return N's faibonacci number
   */
  public static long fibonacci(long n) {

    if (n == 0) return 0;

    long prevValue = 0;
    long result = 1;


    for (int i = 2; i <= n; i++) {
      long temp = result;
      result = result + prevValue;
      prevValue = temp;
    }

    return result;
  }

  private static class FMatrix {
    private long a11;
    private long a12;
    private long a21;
    private long a22;

    public void initMatrix() {
      this.a11 = 1;
      this.a12 = 1;
      this.a21 = 1;
      this.a22 = 2;
    }

    public void initOne() {
      this.a11 = 1;
      this.a12 = 0;
      this.a21 = 0;
      this.a22 = 1;
    }

    public static FMatrix multiply(FMatrix a, FMatrix b) {
      FMatrix result = new FMatrix();

      result.a11 = a.a11 * b.a11 + a.a12 * b.a21;
      result.a12 = a.a11 * b.a12 + a.a12 * b.a22;
      result.a21 = a.a21 * b.a11 + a.a22 * b.a21;
      result.a22 = a.a21 * b.a12 + a.a22 * b.a22;

      return result;
    }

    public Pair<Long, Long> multiply(long a1, long a2) {
      Pair<Long, Long> result = new Pair<>();

      result.setValue1(this.a11 * a1 + this.a12 * a2);
      result.setValue2(this.a21 * a1 + this.a22 * a2);

      return result;
    }
  }

  /**
   * Returns N's Fibonacci number
   * with complexity O(logN)
   * <p>
   * An,An+1 --> An+2,An+3
   * |1 1| x An    = An+2 = An + An+1
   * |1 2|   An+1    An+3   An + 2*An+1
   *
   * @param n >=0
   * @return N's faibonacci number
   */
  public static long fibonacci2(long n) {

    if (n == 0) return 0;
    if (n == 1) return 1;


    long neededPower = n / 2 ;

    FMatrix matrixPower = new FMatrix();
    matrixPower.initOne();

    FMatrix multiplier = new FMatrix();
    multiplier.initMatrix();

    long b = neededPower;
    while (b > 0) {
      if ((b % 2) == 1) matrixPower = FMatrix.multiply(matrixPower, multiplier);
      multiplier = FMatrix.multiply(multiplier, multiplier);
      b = b / 2;
    }

    Pair<Long, Long> result = matrixPower.multiply(0, 1);


    return n % 2 == 0 ? result.getValue1() : result.getValue2();
  }

  public static void run() {

    for (long i = 0; i <= 15; i++) {

      System.out.printf("fibonacci  : F(%d) = %d \n", i, fibonacci(i));
      System.out.printf("fibonacci2 : F(%d) = %d \n", i, fibonacci2(i));
      System.out.println();
    }
  }
}
