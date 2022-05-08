package su.ilushin.chapter01.part01.task05;

public class Multiplier {


  /**
   * Returns product a,b
   * only +,-, =, <> are allowed (or language specific equivalents)
   *
   * @param a - first value >0
   * @param b - second value >0
   * @return a*b
   */
  public static long multiply(long a, long b) {
    long result;
    result = 0;
    while (b != 0) {
      result += a;
      b--;
    }

    return result;
  }

  public static void run() {
    long a = 3;

    for (long b = 1; b <= 5; b++) {
      System.out.printf("multiply : %d * %d = %d\n", a, b, multiply(a, b));
    }
  }
}
