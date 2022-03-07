/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program that displays number of characters, lines, words
 *      in a text file
 * PROGRAM 12: File Statistics
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileStats{
    public static void main(String[] args) {
        // Scanner for user input in console
        Scanner s = new Scanner(System.in);
        System.out.print("Enter filename to read: ");
        String filename = s.nextLine();
        s.close();

        int chars = 0, lines = 0, words = 0;
        try{
            // Read file provided by user
            File f = new File(filename);
            if(f.canRead()){
                FileReader fr = new FileReader(f);
                int c = fr.read();
                // Loop until end of file, one char at a time
                while(c != -1){
                    c = fr.read();
                    // Each iteration is a new character
                    chars++;
                    switch(c){
                        // Each \n is a new line + end of word
                        case '\n':
                            words++;
                            lines++;
                            break;
                        // Each \s is an end of word
                        case '\s':
                            words++;
                            break;
                    }
                }
                // If file not empty, atleast one word exist which wasn't counted
                // This is the last word in last line
                if(chars > 0){
                    lines++;
                    words++;
                }
                fr.close();
            }
        } catch(IOException e){
            System.out.println("File IO Error!!");
        }
        // Display results
        System.out.println("Lines: "+lines);
        System.out.println("Words: "+words);
        System.out.println("Characters: "+chars);
    }
}