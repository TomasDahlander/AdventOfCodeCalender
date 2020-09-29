import java.io.*;
import java.util.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-09-25 <br>
 * Time: 08:03 <br>
 * Project: AdventOfCodeCalender <br>
 */

public class Day2 {
    public static void main(String[] args) throws IOException {

        calculate2();
    }

    public static int[] getArray() throws IOException {
        Scanner scan = new Scanner(new File("DataDay2"));
        scan.useDelimiter(",");
        int[] array = new int[117];
        int i = 0;

        while (scan.hasNext()) {
            array[i] = scan.nextInt();
            i++;
        }
        return array;
    }

    public static int calculate(int[] array) {
        for (int i = 0; i < array.length; ) {

            int firstValue = array[i];
            int sumValue;

            if (firstValue == 1) {
                sumValue = array[array[i + 1]] + array[array[i + 2]];
                array[array[i + 3]] = sumValue;
            } else if (firstValue == 2) {
                sumValue = array[array[i + 1]] * array[array[i + 2]];
                array[array[i + 3]] = sumValue;
            } else if (firstValue == 99) {
                break;
            } else {
                System.out.println("Nåt gick fel.");
                break;
            }
            i += 4;
        }
        return array[0];
    }

    public static void calculate2() throws IOException{
        int antal = 0;
        for(int a = 0; a < 100; a++){
            for(int b = 0; b < 100; b++){
                int[] newArray = getArray();
                newArray[1] = a;
                newArray[2] = b;
                int value = calculate(newArray);
                if(value == 19690720) System.out.println("A:"+a+"\nB:"+b);
            }
        }
    }
}

// 19690720