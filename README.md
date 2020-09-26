# alorithmsLab5

What our algorithm does is put all the companies into a hash set and all the workers in to a hash map with null values.<br/>
While there are still companies in the hash set, then we look at a companies' preferences for workers.<br/>

If the company's first choice has a null value, then they are currently not employed and accept the job.<br/>
That worker then gets assigned the value of the company to show that they are employed and the company is 
removed from the hash set showing that they have a employee that they hired.<br/>

If the company's first choice is already employed, then we look at the preferences of the worker.<br/>
If the worker's current employer has a higher rank than the company that is offering, then the worker rejects the 
company that is offering and that company remains in the hash set showing it still needs to hire someone.<br/>

If the worker's current employer has a lower rank thatn the company that is offering, then the worker quits the company
where it's currently employed and is hired by the new company.<br/> 
In the hash map, the worker's value is assigned the new company
and the old company is added back to the hash set showing they still need to hire someone.<br/>

#Input details
The first input should be a positive integer number to represent the number of companies and people to consider.
Then it should prompt for a path to a .txt file.<br/>

You might have to change all the \ to / in your path.<br/>
    
To illustrate what your text file should look like, lets say you input the number 3.<br/>
That means you are considering 3 companies looking to hire 3 people.<br/>
Your text file could look like this:<br/>

0 1 2<br/>
2 0 1<br/>
1 2 0<br/>

2 1 0<br/>
1 2 0<br/>
0 2 1<br/>

The first block is the preferences of the companies. So company 0 would prefer worker 0, then worker 1, and lastly worker 2.<br/>
The second block is the preferences of the workers. So worker 1 would prefer company 1, then company 2, and lastly company 0.<br/>
Each number should be separated by a space.<br/>
COUNTING STARTS AT 0!!! So if the number you input is 3, there should be preferences with only 0 1 and 2