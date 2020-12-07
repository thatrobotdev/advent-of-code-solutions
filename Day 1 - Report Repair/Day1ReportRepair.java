// Challenge problem at https://adventofcode.com/2020/day/1

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1ReportRepair {
    public static void main(String[] args) throws java.io.IOException {

        // Get inputs from input.txt file
        Scanner s = new Scanner(new File("./Day 1 - Report Repair/input.txt"));
        ArrayList<Integer> inputs = new ArrayList<>();
        while(s.hasNext()) {
            if(s.hasNextInt()) {
                inputs.add(s.nextInt());
            } else {
                s.next();
            }
        }
        s.close();

        // Part 1
        System.out.println(partOne(inputs));

        // Part 2
        System.out.println(partTwo(inputs));

    }

    // Part 1: Find the two entries that sum to 2020 and then multiply those two numbers together
    public static int partOne(ArrayList<Integer> inputs) {
        for(Integer entry1 : inputs) {
            for(Integer entry2 : inputs) {
                if(entry1 + entry2 == 2020) {
                    return entry1 * entry2;
                }
            }
        }
        return 0;
    }

    // Part 2: Find the product of the three entries that sum to 2020
    public static int partTwo(ArrayList<Integer> inputs) {
        for (Integer entry1 : inputs) {
            for (Integer entry2 : inputs) {
                for (Integer entry3 : inputs) {
                    if (entry1 + entry2 + entry3 == 2020) {
                        return entry1 * entry2 * entry3;
                    }
                }
            }
        }
        return 0;
    }
}
