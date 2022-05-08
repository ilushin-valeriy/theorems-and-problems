package su.ilushin.chapter01.part01.task01;

public class ValueSwapper {


  /**
   * example for swapping values
   * simple implementation
   *
   * @param a – first value
   * @param b – second value
   */
  public static void swapInt(long a, long b) {


    System.out.printf("swapInt: before swap: a = %d, b = %d\n", a, b);

    long t;

    t = a;
    a = b;
    b = t;

    System.out.printf("swapInt: after swap: a = %d, b = %d\n", a, b);
  }

  /**
   * example for swapping values
   * without additional variable
   *
   * @param a – first value
   * @param b – second value
   */
  public static void swapInt2(long a, long b) {


    System.out.printf("swapInt2: before swap: a = %d, b = %d\n", a, b);

    a = a + b;
    b = a - b;
    a = a - b;

    System.out.printf("swapInt2: before swap: a = %d, b = %d\n", a, b);
  }

  public static void run() {

    swapInt(1 ,2);
    swapInt2(1 ,2);

  }

}
