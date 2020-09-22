import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    /**
    @author Firas Naber and Cookie Vang
    
    We capped the input at 26 so there can at most be 26 companies and 26 clients. PETER SAID THIS WAS OK.
    In the .txt file, each company corresponds to a letter in the alphabet and the people are numbers. 
    So if you input 3 as the number of companies and people, your .txt file should look similar to the following:
    A 2 1 3
    B 1 2 3 
    C 3 1 2
    1 A C B
    2 C A B
    3 B A C
     */
    public static void main(String[] args) throws FileNotFoundException { 

        System.out.println("Please input the number of companies and people (Max of 26)");
        //PETER SAID IT WAS OK TO CAP AT 26
        Scanner scanner = new Scanner(System.in); //Input for the number of companies and people
        int clients = scanner.nextInt(); //Takes in a number less than or equal to
        
        if (clients > 26){ //If input is something other than a number less than or equal to 26
            System.out.println("Input not less than 26. Please try again");
        }

        //Sample path: C:/Users/cooki/OneDrive/Desktop/lab5Data.txt
        //I have to flip the slashes when I copy it and add the file name at the end
        if (clients <= 26) { 
            System.out.println("");
            System.out.println("Please input the path of a .txt file with the ranks/preferences");
            System.out.println("An example of what each line in the file should be is: A 2 3 5 1 4");
            System.out.println("The first character 'A' resembles company A followed by how they rank 5 people");
            System.out.println("Eventually, you should have lines that look like: 1 C A E B D");
            System.out.println("The first character '1' resembles person 1 followed by how they rank 5 companies");
            System.out.println("The number of companies and people should MATCH the number you input above"); 
        }

        //Now input a path for the text file that has each company and their ranks/preferences
        Scanner scanner2 = new Scanner(System.in); //Taking in the input path
        String fileName = scanner2.nextLine(); //The input path is called fileName
        File file = new File(fileName); //Creating a new file with the input path
        Scanner fileScanner = new Scanner(file); //Scanning the input file

        ArrayList<Character> ranks = new ArrayList<>();

        while (fileScanner.hasNextLine()){
            char client = fileScanner.next().charAt(0); //Gets the first character of each line, either the company or person 
            String line = fileScanner.nextLine();
            int length = line.length()/2;
            if (clients != length){ //If text file has incorrect line (preference) length
                System.out.println("Your text file has one or more lines where the preferences don't match"
                + " the number of companies and people that you input. Please fix that");
                break;
            }
            ranks.add(client);
            //System.out.println(client);
            //System.out.println(line);
            //System.out.println(length);
        }
        System.out.println(ranks);
        
        
        
    }

    

    // Client can either mean the company or the people
    // public static ArrayList<T>[] hire(int client){
    //     return null;
    // }

    //helper method that compares two rankings
    // public static boolean compareRank(T clientOne, T clientTwo, ArrayList<T> clientOneRank, ArrayList<T> clientTwoRank){
    //     return null;
    // }

    //NEED TO DO
    //Initialize each company and their rankings of the people
    //Initialize each person and their rankings of the companies
    //A while loop where the companies pick people and the people either accept or reject
    
}