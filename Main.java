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
        //System.out.println("Please input the number of companies and people (Max of 26) AND");
        //PETER SAID IT WAS OK TO CAP AT 26
        System.out.println("Please input the path of a .txt file separated with a space");
        Scanner scanner = new Scanner(System.in);
        //int clients = scanner.nextInt();
        String fileName = scanner.nextLine();
        //File file = new File("C:/Users/cooki/OneDrive/Desktop/lab5Data.txt");
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        // if (clients > 26){
        //     System.out.println("Input not less than 26. Please try again");
        // }
        System.out.println(fileScanner.nextLine());
        // while (scanner.hasNextLine()){
        //     String line = scanner.nextLine();
        //     System.out.println(line); 
        // } 
        //should figure out a way to take in a line of the text file and convert it to a string
        //use parseInt to input the lines of a text file here
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