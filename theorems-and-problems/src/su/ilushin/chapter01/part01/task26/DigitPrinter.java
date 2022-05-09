package su.ilushin.chapter01.part01.task26;

import java.util.Arrays;

public class DigitPrinter {

  public static void printDigits(long n) {

    long base = 1;
    long b = n;

    while (base * 10 <= n) {
      base *= 10;
    }

    while (base > 0) {
      System.out.print((b / base) + ",");
      b %= base;
      base /= 10;
    }
    System.out.println();
  }

  public static void printReverseDigits(long n) {
    long b = n;
    while (b > 0) {
      System.out.print((b % 10) + ",");
      b /= 10;
    }
    System.out.println();
  }

  public static void run() {

    printDigits(0);
    printDigits(5);
    printDigits(12300987);
    printDigits(123009870);

    System.out.println();
    printReverseDigits(0);
    printReverseDigits(5);
    printReverseDigits(12300987);
    printReverseDigits(123009870);

  }
}
