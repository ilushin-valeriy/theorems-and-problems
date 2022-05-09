package su.ilushin.chapter01.part01.task35;

import su.ilushin.common.Pair;

public class Divider {

  public static Pair<Long, Long> div(long a, long b) {

    Pair<Long, Long> result = new Pair<>();

    long b1 = b;

    while (b1 <= a) {
      b1 *= 2;
    }

    long q = 0;
    long r = a;

    //invariant:
    //a = q*b1 + r
    while (b1 != b) {
      b1 /= 2;
      q *= 2;

      if (r >= b1) {
        r = r - b1;
        q = q + 1;
      }
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
