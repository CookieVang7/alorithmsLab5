import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;

public class Main {
    /**
    @author Firas Naber and Cookie Vang

    The first input should be a positive integer number to represent the number of companies and people to consider.
    Then it should prompt for a path to a .txt file.

    You might have to change all the \ to / in your path.
    
    To illustrate what your text file should look like, lets say you input the number 3.
    That means you are considering 3 companies looking to hire 3 people.
    Your text file could look like this:

    0 1 2
    2 0 1
    1 2 0

    2 1 0
    1 2 0
    0 2 1

    The first block is the preferences of the companies. So company 0 would prefer worker 0, then worker 1, and lastly worker 2
    The second block is the preferences of the workers. So worker 1 would prefer company 1, then company 2, and lastly company 0
    Each number should be separated by a space.

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
        int companyArray[][] = new int[clients][clients];
        int employeeArray[][] = new int[clients][clients];

        for (int i = 0; i < arrayNum; i++){ //Creates two arrays for the company preferences and people preferences
            if (i < clients){
                for (int j = 0; j < clients; j++){
                companyArray[i][j] = fileScanner.nextInt();
                }
                String line = fileScanner.nextLine();
            }
            else {
                for (int z = 0; z < clients; z++){
                    employeeArray[i-clients][z] = fileScanner.nextInt();
                }
                String anotherLine = fileScanner.nextLine();
            }
        }

        
        // for (int m = 0; m < clients; m++){ //Return the array of a single line
        //     for (int b = 0; b < clients; b++){
        //         System.out.println(companyArray[m][b]);
        //     }
        // }
        

        //A hashset where the companies that still haven't hired anyone exist
        //Similar to a hashmap
        Set<Integer> companiesLeft = new HashSet <Integer> ();
        for (int i=0; i < companyArray.length; i++){
            companiesLeft.add(i);
        }
        
        // //A hashmap where the workers that are still unemployed exist
        // //Hashmap has a key value pair so we can assign a null value to workers that have yet to be employed 
        Map<Integer, Integer> workersLeft = new HashMap <Integer, Integer> ();
        for (int i=0; i < employeeArray.length; i++){
            workersLeft.put(i, null);
        }

        int available = companiesLeft.size();
        while (available > 0){
            //Iterators loop through arrays, sets, and lists
            //iterator().next() will return the first value in this case
            int currentCompany = companiesLeft.iterator().next(); 
            System.out.println("\nCompany " + currentCompany + " looks at the pool of available workers");
            for (int w : companyArray[currentCompany]){ //Looping through company preferences
                Integer fresh = workersLeft.get(w); 
                if (fresh == null){ //Null values mean no job so if the worker is unemployed
                    workersLeft.put(w, currentCompany); //Hire the worker and assign the worker a value in the hash 
                    //map so it no longer has a null value. Put method like an add method
                    companiesLeft.remove(currentCompany); //Taking pointer out of hashset saying a company hired someone
                    System.out.println ("Company " + currentCompany + " hires worker " + w);
                    break;
                }
                else { //If the worker is already employed by a company
                    int prefFresh= -1;
                    int prefCurrent = -1;
                    for (int q = 0; q < employeeArray[w].length; q++){ //Looping through workers' preferences
                        if (employeeArray[w][q] == currentCompany){
                            prefCurrent = q; //Find preference order for old company
                        } 
                        if (employeeArray[w][q] == fresh){
                            prefFresh = q; //Find preference order for new company
                        }
                    }
                    if (prefCurrent < prefFresh) {
                        workersLeft.put(w,currentCompany);
                        companiesLeft.remove(currentCompany);
                        companiesLeft.add(fresh);
                        System.out.println("Worker " + w + " would prefer to work for company " + currentCompany);
                        System.out.println("So worker " + w + " quits company " + fresh + " and is hired by company " + currentCompany);
                        System.out.println("Now company " + fresh + " needs to find a new worker");
                        break;

                    }
                }
            }
            available = companiesLeft.size();
        }
        // System.out.println(companiesLeft);
        // System.out.println(workersLeft);

        Iterator<Entry<Integer, Integer>> itr = workersLeft.entrySet().iterator();
        System.out.println();
        System.out.println("Here is the summary of hirings:");
        System.out.println();
        while (itr.hasNext()) {
            Entry<Integer, Integer> entry = itr.next();
            System.out.println ("Company " + entry.getValue()  + " hired worker " + entry.getKey());
        }
    }
}

