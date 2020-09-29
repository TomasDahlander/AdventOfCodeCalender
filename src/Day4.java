/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-09-29 <br>
 * Time: 10:51 <br>
 * Project: AdventOfCodeCalender <br>
 */
public class Day4 {
    public static void main(String[] args) {
        int range = 542479;
        int testValue = 165432;
        int amountOfPass = 0;
        boolean ok;

        for(int i = 0; i < range; i++){
            String pass = testValue+"";
            ok = true;

            // Kolla om det finns en dubbel
            for(int j = 0; j < 5; j++){
                if(pass.charAt(j) == pass.charAt(j+1)) break;
                else if(pass.charAt(j) == pass.charAt(j+1) && j == 4){
                    ok = false;
                }
            }

            // Kolla om det värdet går neråt.
            int [] intArray = new int[6];
            for(int j = 0; j < 6; j++){
                intArray[j] = Integer.parseInt(pass.charAt(j)+"");
                System.out.println(intArray[j]);
            }
            // kör vidare med att kolla om det går neråt.
            // test kör apa

            // förbereder nästa varv
            if(ok) amountOfPass++;
            testValue++;
        }

    }
}
/*
However, they do remember a few key facts about the password:

* It is a six-digit number.
* The value is within the range given in your puzzle input.
* Two adjacent digits are the same (like 22 in 122345).
* Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
* Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?

Your puzzle input is 165432-707912.
 */