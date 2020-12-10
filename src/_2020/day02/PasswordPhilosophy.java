// Challenge problem at https://adventofcode.com/2020/day/2
package _2020.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordPhilosophy {

    public static void main(String[] args) throws FileNotFoundException {
        // Get inputs from input.txt file
        Scanner s = new Scanner(new File("src/_2020/day02/input.txt"));
        int partOneValid = 0;
        int partTwoValid = 0;

        // Find number of valid passwords
        while(s.hasNextLine()) {
            String line = s.nextLine();

            // Extract variables from each line
            Password newPassword = new Password(line);
            int min = newPassword.getMin();
            int max = newPassword.getMax();
            char letter = newPassword.getLetter();
            String password = newPassword.getPassword();

            // PART 1: Test with first password policy
            int numOfOccurrences = password.length() - password.replace(String.valueOf(letter), "").length();
            if(numOfOccurrences >= min && numOfOccurrences <= max) {
                partOneValid++;
            }

            // PART 2: Test with second password policy
            if(password.charAt(min - 1) == letter ^ password.charAt(max - 1) == letter) {
                partTwoValid++;
            }

        }
        s.close();

        System.out.println(partOneValid);
        System.out.println(partTwoValid);

    }

    private static class Password {
        int min;
        int max;
        char letter;
        String password;

        Password(String line) {
            int dashEnd = line.indexOf("-");
            int spaceEnd = line.indexOf(" ");

            min = Integer.parseInt(line.substring(0, dashEnd));
            max = Integer.parseInt(line.substring(dashEnd + 1, spaceEnd));
            letter = line.substring(spaceEnd + 1, spaceEnd + 2).charAt(0);
            password = line.substring(spaceEnd + 4);
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public char getLetter() {
            return letter;
        }

        public String getPassword() {
            return password;
        }
    }

}
