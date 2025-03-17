import java.math.BigInteger;

class Solution {
    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public int numTrees(int n) {
        BigInteger top = factorial(2 * n);
        // System.out.println(top);
        BigInteger bottom = factorial(n + 1).multiply( factorial(n) );
        // System.out.println(bottom);
        return top.divide(bottom).intValue();
    }
}