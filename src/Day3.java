import java.io.*;
import java.util.*;
/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-09-29 <br>
 * Time: 07:51 <br>
 * Project: AdventOfCodeCalender <br>
 */
class Point{
    int x;
    int y;
    int steps;

    // Konstruktorer
    public Point(int x, int y, int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    // Jämföra points
    public boolean equals(Point point) {
        if (!(point instanceof Point)) return false;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "x = " + x + " , y = " + y;
    }
}

public class Day3 {
    static int loops = 0;

    public static void main(String[] args)throws IOException {
        List<Point> wire1 = getList("DataDay3Del1");
        List<Point> wire2 = getList("DataDay3Del2");
        List<Point> matchWire = getMatchingList(wire1, wire2);
        System.out.println(getFirstPoint(matchWire));
        System.out.println(loops);
    }

    public static int getFirstPoint(List<Point> list){
        int firstPoint = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            loops++;
            if(list.get(i).steps < firstPoint) firstPoint = list.get(i).steps;
        }
        return firstPoint;
    }

    public static int getNearestPoint(List<Point> list){
        int minPoint = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            loops++;
            int x = list.get(i).x;
            int y = list.get(i).y;

            if(x<0) x=x+(-x*2);
            if(y<0) y=y+(-y*2);

            if(x+y<minPoint) minPoint = x+y;
        }
        return minPoint;
    }

    public static List<Point> getMatchingList(List<Point> a, List<Point>b){
        List<Point> list = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                loops++;
                if(a.get(i).equals(b.get(j))){
                    int steps = a.get(i).steps + b.get(j).steps;
                    list.add(new Point(a.get(i).x,a.get(i).y,steps));
                }
            }
        }
        return list;
    }

    public static List<Point> getList(String data) throws IOException {
        Scanner scan = new Scanner(new File(data));
        scan.useDelimiter(",");
        List<Point> wire = new ArrayList<>();
        int x = 0;
        int y = 0;
        int steps = 0;
        char course;
        String input;

        while (scan.hasNext()) {

            input = scan.next(); // tar in hel riktning

            course = input.charAt(0); // sparat första char i course

            String values = input.substring(1); // sparar siffror i values
            int points = Integer.parseInt(values); // parsar values till Int

            for(int i = 0; i < points; i++) {
                loops++;
                if (course == 'R') {
                    x++;
                    steps++;
                    wire.add(new Point(x, y,steps));
                } else if (course == 'U') {
                    y++;
                    steps++;
                    wire.add(new Point(x, y, steps));
                } else if (course == 'L') {
                    x--;
                    steps++;
                    wire.add(new Point(x, y, steps));
                } else if (course == 'D') {
                    y--;
                    steps++;
                    wire.add(new Point(x, y, steps));
                }
            }
        }
        return wire;
    }

}
// 1.580.152.791 loopar