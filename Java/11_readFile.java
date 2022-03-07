/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program that reads a file and displays it on the screen
 * PROGRAM 11: File Handling
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class ReadFile{
    public static void main(String[] args) {
        // Scanner for user input in console
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename to read: ");
        String filename = sc.nextLine();
        sc.close();
        // Catch IOException if any occours
        try{
            File f = new File(filename);
            // Check if file is readable
            if(f.canRead()){
                System.out.printf("\nReading %s...\n\n", filename);
                // Scanner for opened file
                Scanner sf = new Scanner(f);
                System.out.println("-- FILE BEGIN --");
                // Loop until end and print all lines
                while(sf.hasNext())
                    System.out.println(sf.nextLine());
                System.out.println("--- FILE END ---");
                sf.close();
            }
            else
                System.out.println("Unable to read file!!");
        } catch(IOException e){
            System.out.println("File IO Error!!");
        }
    }
}