package introduction_to_java;

import java.text.DecimalFormat;

public class ReadNumberIntoWord {
    public static void main(String[] args) {

        System.out.println("*** " + ReadNumberIntoWord.convert(10101));
        System.out.println("*** " + ReadNumberIntoWord.convert(1));
        System.out.println("*** " + ReadNumberIntoWord.convert(15));
        System.out.println("*** " + ReadNumberIntoWord.convert(57));
        System.out.println("*** " + ReadNumberIntoWord.convert(101));
        System.out.println("*** " + ReadNumberIntoWord.convert(458));
        System.out.println("*** " + ReadNumberIntoWord.convert(991));
        System.out.println("*** " + ReadNumberIntoWord.convert(10101));
        System.out.println("*** " + ReadNumberIntoWord.convert(1001111));
        System.out.println("*** " + ReadNumberIntoWord.convert(202003333));
        System.out.println("*** " + ReadNumberIntoWord.convert(123456789));
        System.out.println("*** " + ReadNumberIntoWord.convert(2147483647));
        System.out.println("*** " + ReadNumberIntoWord.convert(3000000010L));

    }

    private final static String[] TENS_NAME = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private final static String[] NUM_NAME = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"

    };

    private static String convertLessThanOneThousand(int number) {
        String soFar;
        if (number < 20) {
            soFar = NUM_NAME[number];
            number = 0;
        } else {
            soFar = NUM_NAME[number % 10];
            number /= 10;

            soFar = TENS_NAME[number % 10] + " "+soFar;
            number /= 10;
        }

        if (number == 0) {
            return soFar;
        }
        return NUM_NAME[number] + " hundred " + soFar;

    }

    private static String convert(long number) {
        if (number == 0) {
            return "zero";
        }
        String snumber = Long.toString(number);

        String mask = "000000000000";

        DecimalFormat decimalFormat = new DecimalFormat(mask);

        snumber = decimalFormat.format(number);

        int billions = Integer.parseInt(snumber.substring(0, 3));
        int milions = Integer.parseInt(snumber.substring(3, 6));
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        int thousand = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;

        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + " billion ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + " billion ";
        }

        String result = "";
        result = tradBillions;

        String tradMilions;

        switch (milions) {
            case 0:
                tradMilions = "";
                break;
            case 1:
                tradMilions = convertLessThanOneThousand(milions) + " milion ";
                break;
            default:
                tradMilions = convertLessThanOneThousand(milions) + " milion ";
        }

        result += tradMilions;

        String tradHundredThousands;

        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "one thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
        }

        result += tradHundredThousands;

        String tradThousands;

        tradThousands = convertLessThanOneThousand(thousand);

        result += tradThousands;

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

    }

}
