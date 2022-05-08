package su.ilushin.chapter01.part01.task06;

public class Adder {

  /**
   * Returns product a,b
   * <p>
   * only following assignment are allowed:
   * ⟨variable1⟩ = ⟨variable2⟩,
   * ⟨variable⟩ = ⟨constant⟩,
   * ⟨variable1⟩ = ⟨variable2⟩ + 1.
   *
   * @param a - first value >0
   * @param b - second value >0
   * @return a+b
   */
  public static long sum(long a, long b) {

    long result = a;
    long temp = 0;
    while (temp < b) {
      temp++;
      result++;
    }

    return result;
  }

  public static void run() {
    long a = 3;

    for (long b = 0; b <= 5; b++) {
      System.out.printf("sum : %d + %d = %d\n", a, b, sum(a, b));
    }
  }
}
