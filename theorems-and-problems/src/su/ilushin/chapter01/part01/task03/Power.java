package su.ilushin.chapter01.part01.task03;


public class Power {

  /**
   * Returns the value of the first argument raised to the power of the second argument
   * simple implementation =
   *
   * @param a – the base
   * @param b – the exponent >0
   * @return the value a^b
   */
  public static long power(long a, long b) {
    long result = 1;

    for (int i = 0; i < b; i++) {
      result = result * a;
    }
    return result;
  }

  /**
   * Returns the value of the first argument raised to the power of the second argument
   * Computational complexity - O(Log(n))
   *
   * @param a – the base
   * @param b – the exponent >0
   * @return the value a^b
   */
  public static long power2(long a, long b) {
    long result = 1;
    long multiplier = a;

    while (b > 0) {
      if ((b % 2) == 1) result = result * multiplier;
      multiplier = multiplier * multiplier;
      b = b / 2;
    }

    return result;
  }

  public static void run() {

    long a = 3;
    for (long b = 0; b <= 5; b++) {
      System.out.printf("power : %d^%d = %d\n", a, b, power(a, b));
      System.out.printf("power2: %d^%d = %d\n", a, b, power2(a, b));
      System.out.println();
    }


  }
}
