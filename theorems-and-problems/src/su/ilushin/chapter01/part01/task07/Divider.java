package su.ilushin.chapter01.part01.task07;

import su.ilushin.common.Pair;

public class Divider {


  /**
   * Returns division a/b with reminder
   * only +,- are allowed
   *
   * @param a >0
   * @param b >0
   * @return Pair (division by module, reminder)
   */
  public static Pair<Long, Long> div(long a, long b) {

    Pair<Long, Long> result = new Pair<>();

    long q = 0;
    long r = a;
    while (r >= b) {
      q++;
      r -= b;
    }

    result.setValue1(q);
    result.setValue2(r);
    return result;
  }


  public static void run() {

    long a = 7;

    for (long b = 1; b <= 10; b++) {
      Pair<Long, Long> result = div(a, b);
      System.out.printf("div : %d = %d * %d + %d\n", a, b, result.getValue1(), result.getValue2());
    }

  }
}
