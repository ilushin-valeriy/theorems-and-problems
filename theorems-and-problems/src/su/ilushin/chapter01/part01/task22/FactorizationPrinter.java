package su.ilushin.chapter01.part01.task22;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FactorizationPrinter {

  public static long[] getCanonicalPrimes(long n) {

    if (n == 1) return new long[0];

    List<Long> result = new LinkedList<>();

    long b = n;
    long i = 2;

    while (i <= b) {
      if (b % i == 0) {
        b /= i;
        result.add(i);
      } else {
        if (i * i > b) {
          i = b;
        } else {
          i++;
        }

      }
    }

    return result.stream().mapToLong(l -> l).toArray();
  }

  public static boolean isPrime(long n) {
    long i = 2;
    while (i * i <= n) {
      if (n % i == 0) return false;
      i++;
    }
    return true;
  }

  public static void run() {

    for (int i = 1; i <= 25; i++) {
      System.out.println(i + " = " + Arrays.toString(getCanonicalPrimes(i)));
      System.out.println(i + " isPrime " + isPrime(i));
    }

  }
}
