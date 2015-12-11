/**
 * Created by vvkovtun on 27/11/2015.
 */
public class NumberConvertor {

    public static int toInt(String str) {

        final int RADIX = 10;
        int rank;
        int num;
        int limit;
        int result = 0;
        boolean positive = true;
        int i = 0;
        int digit;
        int size = str.length();

        if (str == null) {
            throw new NumberFormatException("null");
        }

        if (size == 0) {
            throw new NumberFormatException("size is 0: for " + str);
        }

        char firstChar = str.charAt(0);

        if (firstChar == '-') {
            positive = false;
            i++;
        }
        if (positive) {
            limit = Integer.MAX_VALUE * (-1);
        } else {
            limit = Integer.MIN_VALUE;
        }
        while (i < size) {

            digit = Character.digit(str.charAt(i++), RADIX);
            rank = size - i;
            if (rank != 0) {
                num = digit * pow(RADIX, rank);
            } else num = digit;

            if (limit > (result + num) * (-1)) {
                throw new NumberFormatException("Integer limit:" + str);
            }
            result += num;
        }
        return positive ? result : -result;
    }


    public static String toString(int num) {

        if (num==Integer.MIN_VALUE){
            return "-2147483648";
        }

        int buf = 0;
        if (num < 0) {
            buf = num * (-1);
        } else {
            buf = num;
        }
        StringBuilder b = new StringBuilder();
        while (buf != 0) {
            b.insert(0, (char) ('0' + buf % 10));
            buf /= 10;
        }
        if (num < 0) {
            b.insert(0, '-');
        }
        if (num == 0) {
            b.insert(0, '0');
        }
        return b.toString();
    }

    public static String toString(double num) {

        return "";
    }

    public static double toDouble(String str) {
        return -1;
    }


    public static int pow(int a, int n) {
        int b = a;
        for (int i = 1; i < n; i++) {
            b *= a;
        }
        return b;
    }


}
