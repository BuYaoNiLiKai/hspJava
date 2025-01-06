package common_class.arrays;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Bigdata {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("12345678910121314151617");
        BigInteger b2 = new BigInteger("1234567891012131415161");

        System.out.println(b);
        System.out.println(b.add(b2));
        System.out.println(b.subtract(b2));
        System.out.println(b.multiply(b2));
        System.out.println(b.divide(b2));
        BigDecimal bd = new BigDecimal("123456.78910121314151617");
        BigDecimal bd2 = new BigDecimal("12.34567891012131415161");
        System.out.println("_____________________");
        double d = 123456.78910121314151617;
        System.out.println(d);
        System.out.println(bd);
        System.out.println(bd.add(bd2));
        System.out.println(bd.subtract(bd2));
        System.out.println(bd.multiply(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_CEILING)); // 抛出异常

    }
}
