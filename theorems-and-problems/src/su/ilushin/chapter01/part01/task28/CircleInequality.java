package su.ilushin.chapter01.part01.task28;

public class CircleInequality {

  /**
   * Returns number of solutions for inequality x*x + y*y < n
   * in non-negative integers
   *
   * @param n
   * @return number of solutions
   */
  public static long getSolutionCount(long n) {

    long solutionCount = 0;
    long a = 0;
    while (a * a < n) {
      long b = 0;

      while (b * b + a * a < n) {
        b++;
      }
      solutionCount += b;

      a++;
    }

    return solutionCount;
  }


  public static long getSolutionCount2(long n) {

    long solutionCount = 0;
    long x = 0, y = 0;
    while (y * y < n) {
      y++;
    }

    while (x * x < n) {
      while (x * x + y * y >= n) {
        y--;
      }
      solutionCount += (y + 1);

      x++;
    }


    return solutionCount;
  }


  public static long getSolutionCount0(long n) {

    long solutionCount = 0;
    long a = 1;
    while (a * a < n) a++;

    for (long i = 0; i <= a; i++) {
      for (long j = 0; j <= a; j++) {
        if (i * i + j * j < n) solutionCount++;
      }
    }

    return solutionCount;
  }

  public static void run() {


    for (long i = 1000; i <= 1003; i++) {
      System.out.printf("%d has %d solutions\n", i, getSolutionCount0(i));
      System.out.printf("%d has %d solutions\n", i, getSolutionCount(i));
      System.out.printf("%d has %d solutions\n", i, getSolutionCount2(i));
      System.out.println();
    }


  }
}
