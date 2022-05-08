package su.ilushin.chapter01.part01.task11;

import su.ilushin.chapter01.part01.task08.Factorial;

public class SumInverseFactorial {

  /**
   * Return Sum of N inverse factorials 1/(0!)+1/(1!)1/(2!)+..1/(n!)
   * complexity O(N)
   *
   * @param n
   * @return Sum inverse Factorials
   */
  public static double getSum(long n) {
    double result = 1;
    double addent = 1;
    for (long i = 1; i <= n; i++) {
      addent /= i;
      result += addent;
    }
    return result;
  }

  private static double getSum2(long n) {
    double result = 0;
    for (long i = 0; i <= n; i++) result = result + 1.0 / Factorial.factorial(i);

    return result;
  }

  public static void run() {

    for (long i = 0; i <= 15; i++) {
      System.out.printf("sum  : F(%d) = %f \n", i, getSum(i));
      System.out.printf("sum  : F(%d) = %f \n", i, getSum2(i));
      System.out.println();
    }
  }
}
