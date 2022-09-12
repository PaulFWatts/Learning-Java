/**
 * An overly long example to illustrate the danger of using == with floating
 * point numbers (float, double variables). Since they are stored imprecisely
 * they may not be exactly equal to a reference value (like 0, or 1, or 10),
 * even though mathematially they should be.
 * 
 * @author James Montgomery
 */
public class DoubleTrouble {

    public static void main(String[] args) {
        final double EPSILON = 1e-8; //The Greek letter epsilon is often used to represent an allowable 'error' amount
        
        final double TEN = 10.0;
        final double ONE_THIRD = 1.0/3.0;
        double threePlusThird = 3.0 + ONE_THIRD; //|- Mathmatically identical; should equal 3 1/3
        double thirdTimesTen = 10 * ONE_THIRD;   //|
        double d1 = threePlusThird / ONE_THIRD; //|- Mathematically identical; should equal 10
        double d2 = thirdTimesTen / ONE_THIRD;  //|
        double absDifference = Math.abs(d1 - TEN);
        
        System.out.println("ONE_THIRD      == " + ONE_THIRD);
        System.out.println("threePlusThird == " + threePlusThird);
        System.out.println("thirdTimesTen  == " + thirdTimesTen);
        System.out.println("threePlusThird / ONE_THIRD == d1 == " + d1);
        System.out.println("thirdTimesTen / ONE_THIRD  == d2 == " + d2);
        System.out.println("d1 == 10? " + (d1 == TEN));
        System.out.println("d2 == 10? " + (d2 == TEN));
        System.out.println();
        System.out.println("Math.abs(d1 - TEN) == absDifference == " + absDifference);
        System.out.println("absDifference < EPSILON? " + (absDifference < EPSILON));
    }
}
    