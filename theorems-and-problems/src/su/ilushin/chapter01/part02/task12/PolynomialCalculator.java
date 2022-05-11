package su.ilushin.chapter01.part02.task12;

import su.ilushin.common.Pair;

public class PolynomialCalculator {

  public static Pair<Double, Double> getPolynomialValue(double x, double[] coefficients) {
    double value = 0;
    double diffValue = 0;
    for (int i = coefficients.length - 1; i >= 0; i--) {
      value *= x;
      value += coefficients[i];
      if (i > 0) {
        diffValue *= x;
        diffValue += coefficients[i] * i;
      }
    }
    //d(x*P)=P+x*P'
    //

    Pair<Double, Double> result = new Pair<>();
    result.setValue1(value);
    result.setValue2(diffValue);
    return result;
  }

  public static void run() {

    double[] coefficients={100,10,2}; //2*x^2 + 10*x + 100 | d = 4*x+10
    double x = 2;
    Pair<Double,Double> result=getPolynomialValue(x,coefficients);
    System.out.printf("f(%f) = %f, df(%f) = %f \n", x,result.getValue1(),x,result.getValue2());
  }

}
