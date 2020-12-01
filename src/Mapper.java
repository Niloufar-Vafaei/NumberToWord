/**
 * @author Niloufar Vafaei
 */
public class Mapper {

    static String[] numberUnderTwenty = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String[] denominator = {"", "thousand", "million", "billion", "trillion"};

    public String toLetter(int number) throws Exception {
        if (number < 100) {
            return convertUnderHundred(number);
        }
        if (number < 1000) {
            return convertUnderThousand(number);
        }
        for (int i = 0; i < denominator.length; i++) {
            int demonIndex = i - 1;
            long demonValue = new Double(Math.pow(1000, i)).longValue();

            if (demonValue > number) {
                int mod = new Double(Math.pow(1000, demonIndex)).intValue();
                int quotient = number / mod;
                int remain = number - (quotient * mod);

                StringBuilder returnLetter = new StringBuilder();
                returnLetter.append(convertUnderThousand(quotient) + " " + denominator[demonIndex]);
                if (remain > 0) {
                    returnLetter.append(", " + toLetter(remain));
                }
                return returnLetter.toString();
            }
        }
        throw new Exception("out of range");
    }

    private String convertUnderHundred(int val) throws Exception {
        if (val < 20)
            return numberUnderTwenty[val];
        for (int i = 0; i < tens.length; i++) {
            StringBuilder returnValue = new StringBuilder();
            returnValue.append(tens[i]);
            int dval = 20 + 10 * i;
            if (dval + 10 > val) {
                if ((val % 10) != 0)
                    return returnValue.append("-" + numberUnderTwenty[val % 10]).toString();
                return returnValue.toString();
            }
        }
        throw new Exception("out of range");
    }

    private String convertUnderThousand(int val) throws Exception {
        StringBuilder returnValue = new StringBuilder();
        int rem = val / 100;
        int mod = val % 100;
        if (rem > 0) {
            returnValue.append(numberUnderTwenty[rem] + " hundred");
            if (mod > 0) {
                returnValue.append(" ");
            }
        }
        if (mod > 0) {
            returnValue.append(convertUnderHundred(mod));
        }
        return  returnValue.toString();
    }
}
