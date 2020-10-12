package com.shizh.study.week2;

/**
 * @ClassName Example6_1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/12
 **/
  class  Rational{
     int numerator;
     int denominator;
     Rational(){
       }
         Rational( int a , int b){
          if ( a == 0){
              numerator = 0;
              denominator = 1;
          }else  {
              setNumeratorAndDenominator(a,b);
          }
         }
         void  setNumeratorAndDenominator(int a, int b){
           int c = f(Math.abs(a),Math.abs(b));
           numerator = a/c;
           denominator = b/c;
           if (numerator < 0 && denominator < 0){
               numerator = -numerator;
               denominator = -denominator;
           }
         }
     int getNumerator(){
         return numerator;
     }
     int getDenominator(){
         return denominator;
     }
     int f (int a , int b){
         if (a < b){
             int c = a;
             a = b;
             b = c;
         }
         int r = a % b;
         while (r != 0){
             a = b;
             b = r;
             r = a % b;
         }
         return b;
     }
     Rational add(Rational r){
         int a = r.getNumerator();
         int b = r.getDenominator();
         int newNumerator = numerator * b + denominator * a;
         int newDenominator = denominator * b ;
         Rational result = new Rational(newNumerator,newDenominator);
         return result;
     }
     Rational sub(Rational r){
         int a = r.getNumerator();
         int b = r.getDenominator();
         int newNumerator = numerator * b - denominator * a;
         int newDenominator = denominator * b;
         Rational result = new Rational(newNumerator,newDenominator);
         return result;
     }
     Rational muti(Rational r){
         int a = r.getNumerator();
         int b = r.getDenominator();
         int newNumberator = numerator * a ;
         int newDenomiator = denominator * b ;
         Rational result = new Rational(newNumberator,newDenomiator);
         return result;
     }
     Rational div(Rational r){
         int a = r.getNumerator();
         int b = r.getDenominator();
         int newNumberator = numerator * b;
         int newDenomiator = denominator * a;
         Rational result = new Rational(newNumberator,newDenomiator);
         return result;
     }
}
public class Example6_1 {
    public static void main(String[] args) {
        Rational r1 = new Rational(1,5);
        Rational r2 = new Rational(3,2);
        Rational result = r1.add(r2);
        int a = result.getNumerator();
        int b = result.getDenominator();
        System.out.println("1/5 + 3/2 =" + a + "/" + b);
        result = r1.sub(r2);
        a = result.getNumerator();
        b = result.getDenominator();
        System.out.println("1/5 - 3/2 =" + a + "/" + b);
        result = r1.muti(r2);
        a = result.getNumerator();
        b = result.getDenominator();
        System.out.println("1/5 * 3/2 =" + a + "/" +b);
        result = r1.div(r2);
         a = result.getNumerator();
         b = result.getDenominator();
        System.out.println("1/5 / 3/2 =" + a + "/" +b);
        int n = 10, k = 1;
        System.out.println("计算 2/1 + 3/2 + 5/3 + 8/5 + 13/8 + ...的前" + n + "项和.");
        Rational sum = new Rational(0,1);
        Rational item = new Rational(2,1);
        while (k <= n){
            sum = sum.add(item);
            k++;
            int fenzi = item.getNumerator();
            int fenmu = item.getDenominator();
            item.setNumeratorAndDenominator(fenzi + fenmu,fenzi);
        }
        a = sum.getNumerator();
        b = sum.getDenominator();
        System.out.println("用分数表示:");
        System.out.println(a + "/" + b);
        double doubleResult = (a * 1.0)/b;
        System.out.println("用小数表示:");
        System.out.println(doubleResult);
    }
}
