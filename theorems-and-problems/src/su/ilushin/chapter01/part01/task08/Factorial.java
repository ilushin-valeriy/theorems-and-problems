package su.ilushin.chapter01.part01.task08;


public class Factorial {

  /**
   * Returns a!
   *
   * @param a >0
   * @return factorial for a = a!
   */
  public static long factorial(long a) {
    long result = 1;

    for (int i = 1; i <= a; i++) {
      result *= i;
    }

    return result;
  }

  public static void run() {

    for (long i = 0; i <= 5; i++) {

      System.out.printf("fact : %d! = %d \n", i, factorial(i));
    }
  }
}
