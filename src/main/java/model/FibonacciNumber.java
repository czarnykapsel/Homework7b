package model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FibonacciNumber {

//    public FibonacciNumber() {
//    }

    public static List<BigDecimal> fnumbers(long number) {
        BigDecimal num1 = BigDecimal.valueOf(0);
        BigDecimal num2 = BigDecimal.valueOf(1);
        List<BigDecimal> result = new ArrayList();
        if (number == 0) {
            result.add(BigDecimal.valueOf(0));
            return result;
        } else if (number == 1) {
            result.add(BigDecimal.valueOf(0));
            result.add(BigDecimal.valueOf(1));
            return result;
        } else {
            if (number >= 2) {
                result.add(BigDecimal.valueOf(0));
                result.add(BigDecimal.valueOf(1));

                for(int i = 2; i <= number; ++i) {
                    BigDecimal num3 = num1.add(num2);
                    result.add(num3);
                    num1 = num2;
                    num2 = num3;
                }
            }
            return result;
        }
    }
}
