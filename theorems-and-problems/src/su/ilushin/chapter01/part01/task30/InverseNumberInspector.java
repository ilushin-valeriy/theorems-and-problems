package su.ilushin.chapter01.part01.task30;

import java.util.function.Function;

public class InverseNumberInspector {

  public static void printFirstDigits(long num, long digitCount) {

    System.out.print(1 / ((double) num) + " : ");
    long value = 1;

    for (long i = 1; i <= digitCount; i++) {


      System.out.print(value / num + ",");
      value %= num;
      value *= 10;
    }
    System.out.println();

  }

  public static long getPeriodicLength(long num) {

    long remainder = 1;

    for (long i = 1; i <= num + 1; i++) {
      remainder = (remainder * 10) % num;

    }
    long newRemainder = (remainder * 10) % num;

    long len = 1;
    while (newRemainder != remainder) {
      newRemainder = (newRemainder * 10) % num;
      len++;
    }


    return len;

  }


  public static long getFunctionPeriodLength(Function<Long, Long> func) {

    long left = func.apply(1L);
    long right = func.apply(func.apply(1L));

    while (left != right) {
      left = func.apply(left);
      right = func.apply(func.apply(right));
    }

    long result = 1;
    right = func.apply(left);
    while (left != right) {
      right = func.apply(right);
      result++;
    }

    return result;

  }

  public static void run() {
    printFirstDigits(17, 10);

    for (long i = 1; i <= 25; i++) {
      System.out.format("1/%d = %f : has period len = %d\n", i, 1 / ((double) i), getPeriodicLength(i));
      long base = i;
      System.out.format("1/%d = %f : has period len = %d\n", i, 1 / ((double) i), getFunctionPeriodLength(r -> (r * 10) % base));
      System.out.println();
    }
  }
}
