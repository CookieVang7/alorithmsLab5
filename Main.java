import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;

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
            System.out.println("An example of what each line in the file should be is: 2 3 5 1 4");
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

        // int clientNum = fileScanner.nextInt(); //Number of companies and people
        // String line2 = fileScanner.nextLine(); //Skips the rest of the first line
        int arrayNum = 2*clients;
        int arrays[][] = new int[arrayNum][clients];
        int counter = 0;
        
        for (int i = 0; i < arrayNum; i++){ //Create an array for each line of the file
            for (int j = 0; j < clients; j++){
                arrays[i][j] = fileScanner.nextInt();
            }
            String line = fileScanner.nextLine();
            counter++;
        }
        for (int m = 0; m < clients; m++){ //Return the array of a single line
            System.out.println(arrays[clients][m]);
        }
        //At this point, we can return a company's/person's ranking


        

        //A hashset where the companies that still haven't hired anyone exist
        //Similar to a hashmap
        int companyLength = counter/2;
        Set<Integer> comapniesLeft = new HashSet <Integer> ();
        for (int i=0; i < companyLength; i++){
            comapniesLeft.add(i);
        }
        
        // //A hashmap where the workers that are still unemployed exist
        // //Hashmap has a key value pair so we can assign a null value to workers that have yet to be employed 
        Map<Integer, Integer> workersLeft = new HashMap <Integer, Integer> ();
        for (int i=0; i < companyLength; i++){
            workersLeft.put(i, null);
        }

        // int available = comapniesLeft.size();
        // while (available > 0){
        //     //Iterators loop through arrays, sets, and lists
        //     //iterator().next() will return the first value in this case
        //     int currentCompany = comapniesLeft.iterator().next(); 
        //     for (int w : arrays[available])
        // }
        
        
    }


   

    //NEED TO DO
    //Initialize each company and their rankings of the people
    //Initialize each person and their rankings of the companies
    //A while loop where the companies pick people and the people either accept or reject
    
}

