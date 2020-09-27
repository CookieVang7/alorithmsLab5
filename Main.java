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

    COUNTING STARTS AT 0!!! So if the number you input is 3, there should be preferences with only 0 1 and 2

     */
    public static void main(String[] args) throws FileNotFoundException { 

        System.out.println("Please input the number of companies and people");
        Scanner scanner = new Scanner(System.in); //Input for the number of companies and people
        int clients = scanner.nextInt(); //Names input number clients

        //Example where clients = 4
        //Sample path: C:/Users/cooki/OneDrive/Desktop/lab5Data.txt
        //I usually have to flip the slashes when I copy the path of the file
        
        System.out.println("");
        System.out.println("Please input the path of a .txt file with the ranks/preferences");
        System.out.println("If the input number is 3, each line in the file should be some permuation of: 0 1 2");
        
        Scanner scanner2 = new Scanner(System.in); //Taking in the input path of a text file
        String fileName = scanner2.nextLine(); 
        File file = new File(fileName); //Creating a new File object with the input path
        Scanner fileScanner = new Scanner(file); //Scanning the input file

        int arrayNum = 2*clients;
        int companyArray[][] = new int[clients][clients]; //Array of arrays with company preferences
        int employeeArray[][] = new int[clients][clients]; //Array of arrays with workers' preferences

        for (int i = 0; i < arrayNum; i++){ //Makes two array of arrays with the data from text file
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
            }
        }

        // Returns the array of arrays 
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
        while (available > 0){ //While there are still companies that need to hire people
            //Iterators loop through arrays, sets, and lists
            //iterator().next() will return the first value in this case
            int currentCompany = companiesLeft.iterator().next(); 
            System.out.println("\nCompany " + currentCompany + " looks at the pool of available workers");
            for (int w : companyArray[currentCompany]){ //Looping through company preferences
                Integer fresh = workersLeft.get(w); // Company's choice
                if (fresh == null){ //Null values mean no job so if the worker is unemployed
                    workersLeft.put(w, currentCompany); //Hire the worker and assign the worker a value in the hash 
                    //map so it no longer has a null value. Put method similar to an add method
                    companiesLeft.remove(currentCompany); //Taking pointer out of hashset saying a company hired someone
                    System.out.println ("Company " + currentCompany + " hires Worker " + w);
                    break;
                }
                else { //If the worker is already employed by a company
                    int prefOld= -1;
                    int prefNew = -1;
                    for (int q = 0; q < employeeArray[w].length; q++){ //Looping through workers' preferences
                        if (employeeArray[w][q] == currentCompany){
                            prefNew = q; //Find preference order for new company
                        } 
                        if (employeeArray[w][q] == fresh){
                            prefOld = q; //Find preference order for old company
                        }
                    }
                    if (prefNew < prefOld) { // If new company has a higher preference than the current company
                        workersLeft.put(w,currentCompany);
                        companiesLeft.remove(currentCompany);
                        companiesLeft.add(fresh);
                        System.out.println("Company " + currentCompany + " offered a job to Worker " + w + " and they would "
                        + "prefer to work for them instead of Company " + fresh);
                        System.out.println("So Worker " + w + " quits Company " + fresh + " and is hired by Company " + currentCompany);
                        System.out.println("Now Company " + fresh + " needs to find a new Worker");
                        break;
                    }
                    if (prefOld < prefNew){
                        System.out.println("Company " + currentCompany + " offered a job to Worker " + w);
                        System.out.println("But Worker " + w + " prefers the job they're at. So they reject Company " + currentCompany);
                    }
                }
            }
            available = companiesLeft.size();
        }

        Iterator<Entry<Integer, Integer>> itr = workersLeft.entrySet().iterator();
        System.out.println();
        System.out.println("Here is the summary of hirings:");
        System.out.println();
        while (itr.hasNext()) {
            Entry<Integer, Integer> entry = itr.next();
            System.out.println ("Company " + entry.getValue()  + " hired Worker " + entry.getKey());
        }
        scanner.close();
        scanner2.close();
        fileScanner.close();
    }
}

