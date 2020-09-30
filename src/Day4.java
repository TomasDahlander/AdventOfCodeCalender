/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-09-29 <br>
 * Time: 10:51 <br>
 * Project: AdventOfCodeCalender <br>
 */
public class Day4 {
    public static void main(String[] args) {
        int range = 542480;
        int testValue = 165432;
        int amountOfPass = 0;
        boolean ok;

        for(int i = 0; i < range; i++){
            String pass = testValue+"";
            ok = true;
            
            // Kolla om det finns en dubbel    // 834 = för lågt & 1409 = för högt
            if(pass.charAt(0)==pass.charAt(1) && pass.charAt(0)!=pass.charAt(2)) ok=true;
            else if(pass.charAt(1)==pass.charAt(2) && pass.charAt(1)!=pass.charAt(0) && pass.charAt(1)!=pass.charAt(3)) ok=true;
            else if(pass.charAt(2)==pass.charAt(3) && pass.charAt(2)!=pass.charAt(1) && pass.charAt(2)!=pass.charAt(4)) ok=true;
            else if(pass.charAt(3)==pass.charAt(4) && pass.charAt(3)!=pass.charAt(2) && pass.charAt(3)!=pass.charAt(5)) ok=true;
            else if(pass.charAt(4)==pass.charAt(5) && pass.charAt(4)!=pass.charAt(3)) ok=true;
            else ok = false;

            // Kolla om det värdet går neråt.
            int [] intArray = new int[6];
            for(int j = 0; j < 6; j++){
                intArray[j] = Integer.parseInt(pass.charAt(j)+"");
            }
            for(int j = 0; j < 5; j++){
                if(intArray[j]>intArray[j+1]){
                    ok = false;
                    break;
                }
            }

            // förbereder nästa varv
            if(ok) amountOfPass++;
            testValue++;
        }
        System.out.println(amountOfPass);
    }
}
/*
An Elf just remembered one more important detail:
the two adjacent matching digits are not part of a larger group of matching digits.

Given this additional criterion, but still ignoring the range rule, the following are now true:

* 112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
* 123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
* 111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
How many different passwords within the range given in your puzzle input meet all of the criteria?
 */

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