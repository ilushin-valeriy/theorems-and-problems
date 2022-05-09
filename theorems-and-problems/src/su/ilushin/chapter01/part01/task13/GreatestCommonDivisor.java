package su.ilushin.chapter01.part01.task13;

public class GreatestCommonDivisor {


  public static long getGDC(long a, long b) {

    if (a == 0) return b;
    if (b == 0) return a;

    long k = a > b ? b : a;

    while (k > 1) {
      if (((a % k) == 0) && ((b % k) == 0)) break;
      k--;
    }

    return k;
  }

  public static long getGDCByEuclidean(long a, long b) {
    long x, y;
    long result;


    long d = 1;
    long a1 = a, b1 = b;

    //a=a1*d; b=b1*d
    while ((((a1 % 2) == 0) && ((b1 % 2) == 0))) {
      d *= 2;
      a1 /= 2;
      b1 /= 2;

    }

    long m = a1;
    long n = b1;
    long d1 = 1;
    long p = 1, q = 0, r = 0, s = 1;

    //m = p*a1+q*b1; n = r*a1+s*b1
    while ((n != 0) && (m != 0)) {
      if (((n % 2) == 0) && ((m % 2) == 0)) {
        d1 *= 2;

        m /= 2;
        if (((p % 2) == 0) && ((q % 2) == 0)) {
          p /= 2;
          q /= 2;
        } else {
          p += b1;
          q -= a1;
          p /= 2;
          q /= 2;
        }

        n /= 2;
        if (((r % 2) == 0) && ((s % 2) == 0)) {
          r /= 2;
          s /= 2;
        } else {
          r += b1;
          s -= a1;
          r /= 2;
          s /= 2;
        }

      } else if (((n % 2) == 1) && ((m % 2) == 0)) {
        m /= 2;

        if (((p % 2) == 0) && ((q % 2) == 0)) {
          p /= 2;
          q /= 2;
        } else {
          p += b1;
          q -= a1;
          p /= 2;
          q /= 2;

        }

      } else if (((n % 2) == 0) && ((m % 2) == 1)) {
        n /= 2;
        if (((r % 2) == 0) && ((s % 2) == 0)) {
          r /= 2;
          s /= 2;
        } else {
          r += b1;
          s -= a1;
          r /= 2;
          s /= 2;
        }
      } else if (n > m) {
        n -= m;

        r -= p;
        s -= q;
      } else {
        m -= n;
        p -= r;
        q -= s;
      }
    }

    if (n == 0) {
      result = m;
      x = p;
      y = q;

    } else {
      result = n;
      x = r;
      y = s;
    }


    result *= (d1 * d);
    x *= d1 ;
    y *= d1;
    System.out.printf("GDCE = %d = %d*%d + %d*%d = %d\n", result, x, a, y, b, (x * a + y * b));
    return result;


  }

  private static long getGDCOrLCMByEuclidean2(long a, long b, boolean needLCM) {
    long x, y;
    long lcm;
    long gdc;

    long u = b;
    long v = a;
    long m = a;
    long n = b;
    long p = 1, q = 0, r = 0, s = 1;

    //invariants:
    //m = p*a+q*b; n = r*a+s*b
    //m*u + n*v = 2*a*b
    while ((n != 0) && (m != 0)) {
      if (n > m) {
        long t = n / m;
        n %= m;

        //n' = n - t*m = (r-t*p)*a + (s-t*q)*b
        r -= t * p;
        s -= t * q;

        // m*u + (n-t*m)*v + t*m*v = m*(u+t*v) + n'*v
        u += t * v;

      } else {
        long t = m / n;
        m %= n;

        //m' = m - t*n = (p-t*r)*a + (q-t*s)*b
        p -= t * r;
        q -= t * s;

        // (m - t*n)*u + n*v + t*n*u = m'*u + n*(v+t*u)
        v += t * u;

      }
    }

    if (n == 0) {
      gdc = m;
      x = p;
      y = q;
      lcm = u / 2;

    } else {
      gdc = n;
      x = r;
      y = s;
      lcm = v / 2;
    }

    System.out.printf("GDCE2 = LCM = %d, %d = %d*%d + %d*%d = %d\n", lcm, gdc, x, a, y, b, (x * a + y * b));
    System.out.printf("%d = %d*%d = %d\n", lcm * gdc, lcm, gdc, a * b);
    return needLCM ? lcm : gdc;
  }

  public static long getLCM2(long a, long b) {
    return getGDCOrLCMByEuclidean2(a, b, true);
  }

  public static long getGDC2(long a, long b) {
    return getGDCOrLCMByEuclidean2(a, b, false);
  }

  public static void run() {

    long a = 24;

    for (long i = 0; i <= 17; i++) {
      System.out.printf("GCD  : GDC  (%d,%d) = %d \n", a, i, getGDC(i, a));
      System.out.printf("GCD  : GDCE (%d,%d) = %d \n", a, i, getGDCByEuclidean(i, a));
//      System.out.printf("GCD  : GDCE2(%d,%d) = %d \n", a, i, getGDC2(i, a));
//      System.out.printf("GCD  : LCME2(%d,%d) = %d \n", a, i, getLCM2(i, a));

      System.out.println();
    }


  }
}
