/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-09-25 <br>
 * Time: 07:59 <br>
 * Project: AdventOfCodeCalender <br>
 */

import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args)throws IOException {
        partTwo();

    }

    public static void partOne()throws IOException{
        Scanner scan = new Scanner(new File("Data"));

        int sumFuelReq = 0;
        while(scan.hasNext()){
            int module = scan.nextInt();
            module /= 3;
            module -= 2;
            sumFuelReq += module;
        }
        System.out.println(sumFuelReq);
    }

    public static void partTwo()throws IOException{
        Scanner scan = new Scanner(new File("Data"));

        int sumFuelReq = 0;
        while(scan.hasNext()){
            int module = scan.nextInt();
            module /= 3;
            module -= 2;
            sumFuelReq += module;

            int sum = 0;
            while(module>0){
                module /= 3;
                module -= 2;
                if(module < 0) break;
                else sumFuelReq +=module;
            }
        }
        System.out.println(sumFuelReq);
    }
}
