package su.ilushin.chapter01.part01.task33;

public class FunctionEvaluator {

  /**
   * Returns function value f(0) = 0, f(1) = 1, f(2n) = f(n), f(2n + 1) = f(n) + f(n + 1)
   *
   * @param n
   * @return f(0) = 0, f(1) = 1, f(2n) = f(n), f(2n + 1) = f(n) + f(n + 1)
   */
  public static long calcValueF1_0(long n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    return (n % 2 == 0) ? calcValueF1_0(n / 2) : calcValueF1_0(n / 2) + calcValueF1_0(n / 2 + 1);

  }


  public static long calcValueF1(long n) {


    long k = n;
    long a = 1, b = 0;
    //0 <= k, f (n) = a * f(k) + b * f (k+1)}
    while (k > 0) {
      if (k % 2 == 0) {
        //k=2*k'
        //f(k+1) = f(2*k'+1) = f(k') + f(k'+1);
        //a * f(k) + b * f(k+1) --> (a+b)*f(k')+b*f(k'+1);

        a += b;
        k /= 2;

      } else {
        //k=2*k'+1
        //f(k+1) = f(2*k'+1+1) = f(k'+1);
        //f(k) = f(k')+f(k'+1);
        //a * f(k) + b * f(k+1) --> a*f(k')+(b+a)*f(k'+1);

        k /= 2;
        b += a;

      }
    }

    return b;
  }


  /**
   * Returns f(0) = 13, f(1) = 17, f(2) = 20, f(3) = 30,
   * f(2n) = 43 f(n) + 57 f(n + 1),
   * f(2n + 1) = 91 f(n) + 179 f(n + 1)
   *
   * @param n
   * @return function value
   */
  public static long calcValueF2_0(long n) {
    if (n == 0) return 13;
    if (n == 1) return 17;
    if (n == 2) return 20;
    if (n == 3) return 30;

    return (n % 2 == 0) ?
        43 * calcValueF2_0(n / 2) + 57 * calcValueF2_0(n / 2 + 1) :
        91 * calcValueF2_0(n / 2) + 179 * calcValueF2_0(n / 2 + 1);

  }

  /**
   * Returns f(0) = 13, f(1) = 17, f(2) = 20, f(3) = 30,
   * f(2n) = 43 f(n) + 57 f(n + 1),
   * f(2n + 1) = 91 f(n) + 179 f(n + 1)
   *
   * @param n
   * @return function value
   */
  public static long calcValueF2(long n) {
    if (n == 0) return 13;
    if (n == 1) return 17;
    if (n == 2) return 20;
    if (n == 3) return 30;

    long k = n;
    long a = 1, b = 0, c = 0;
    //1 <= k, f (n) = a * f(k) + b * f (k+1) + c* f(k+2)}

    while (k > 1) {
//      System.out.println(k + " = " + (a * calcValueF2_0(k)
//          + b * calcValueF2_0(k + 1)
//          + c * calcValueF2_0(k + 2))
//      );

      if (k % 2 == 0) {
        long a1;
        long b1;
        long c1;
        //k = 2*k' k>3
        //a*f(2*k') + b*f(2*k'+1) + c*f(2*(k'+1))=
        //a*(43 f(k') + 57 f(k' + 1)) +
        //b*(91 f(k') + 179 f(k' + 1)) +
        //c*(43 f(k'+1) + 57 f(k' + 2)) +

        if (k == 2) {
          //f(2) = f(k'+1)
          //f(3) = f(k'+2);
          a1 = 0;
          b1 = c * 43L + a;
          c1 = c * 57L + b;
        } else {
          a1 = a * 43L + b * 91L;
          b1 = a * 57L + b * 179L + c * 43L;
          c1 = c * 57L;
        }


        a = a1;
        b = b1;
        c = c1;

        k /= 2;
      } else {

        long a1;
        long b1;
        long c1;
        //k = 2*k'+1
        //a*f(2*k'+1) + b*f(2*(k'+1)) + c*f(2*(k'+1)+1) =
        //
        //a*(91 f(k') + 179 f(k' + 1)) +
        //b*(43 f(k'+1) + 57 f(k' + 2)) +
        //c*(91 f(k'+1) + 179 f(k'+1 + 1))

        if (k == 3) {
          //f(3) = f(k'+2)
          a1 = 0;
          b1 = b * 43L + c * 91L;
          c1 = b * 57L + c * 179L + a;
        } else {
          a1 = a * 91L;
          b1 = a * 179L + b * 43L + c * 91L;
          c1 = b * 57L + c * 179L;
        }
        a = a1;
        b = b1;
        c = c1;

        k /= 2;
      }


    }
    return 17L * a + 20L * b + 30L * c;
  }

  public static void run() {


    for (long i = 0; i <= 20; i++) {
//      System.out.format("F(%d) = %d\n", i, calcValueF1_0(i));
//      System.out.format("F(%d) = %d\n", i, calcValueF1(i));

      System.out.format("F(%d) = %d\n", i, calcValueF2_0(i));
      System.out.format("F(%d) = %d\n", i, calcValueF2(i));


      System.out.println();
    }
  }
}
