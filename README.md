# algorithmsLab5

Our algorithm is a resemblance of a Gale-Shapley algorithm which is also known as the Stable Marriage problem (reference: https://prismoskills.appspot.com/lessons/Algorithms/Chapter_14_-_Marriage_problem.jsp).<br/>

There is essentially an n amount of companies that want to hire an n amount of workers. Both the companies and workers have preferenes/ranks of each other. Companies will go through their preferences and hire the people highest on their list. If that worker has not yet had a job offer, they will accept the job. But if they are currently employed and get a job offer that is higher based on their preference of the companies, the person will quit their current job and accept the new job. This leaves the old company to look for a new worker.<br/>

What our algorithm does is put all the companies into a hash set and all the workers in to a hash map with null values.
While there are still companies in the hash set, then we look at a companies' preferences for workers.<br/>

If the company's first choice has a null value, then they are currently not employed and accept the job.
That worker then gets assigned the value of the company to show that they are employed and the company is 
removed from the hash set showing that they have a employee that they hired.<br/>

If the company's first choice is already employed, then we look at the preferences of the worker.
If the worker's current employer has a higher rank than the company that is offering, then the worker rejects the 
company that is offering and that company remains in the hash set showing it still needs to hire someone.<br/>

If the worker's current employer has a lower rank thatn the company that is offering, then the worker quits the company
where it's currently employed and is hired by the new company.
In the hash map, the worker's value is assigned the new company
and the old company is added back to the hash set showing they still need to hire someone.<br/>

# Input details <br/>
The first input should be a positive integer number to represent the number of companies and people to consider.
Then it should prompt for a path to a .txt file.<br/>

You might have to change all the \ to / in your path.<br/>
    
To illustrate what your text file should look like, lets say you input the number 3.
That means you are considering 3 companies looking to hire 3 people.
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

# Why our Algorithm is Correct
<br/>
Our algorithm finds a satisfactory solution, because let's say Company 0 prefers Worker 2 over the worker they ended up hiring. Then, Company 0 must have already offered Worker 2 a job since Worker 2 was higher on the preference list. Two cases could lead to this conclusion:<br/>
1) Company 0 was the first company to offer Worker 2 a job and Worker 2 would have to accept the job from Company 0. But then a company that Worker 2 preferred more offered them a job, so they quit Company 0, forcing them to hire a less preferrable worker.<br/>
2) Worker 2 already had a job when they were offered one by Company 0. But Worker 2 liked the company they were at more and rejected Company 0.<br/>
<br/>
In either case, if a company would have preferred a different worker to the one they ended up with, they would've already made a job offer to them.<br/>
It's important to note that this is an optimal satisfactory solution from the perspective of the companies and not necessarily from the perspective of the workers. The workers don't have the opportunity to choose who they would prefer to work for, but can only make a best choice based on the offers they are given. What this implies is that if the workers got to choose the companies, there would be different pairing results that reflect the preferences of the workers and not necessarily the companies (reference: https://www.youtube.com/watch?v=0m_YW1zVs-Q).

# Efficiency of Our Algorithm

# Test Data and Results
<br/>

**Test 1:** 4 companies and 4 workers<br/>
<br/>
Company Preferences:<br/>
(Note: The first row below is Company 0's preferences of Workers 0, 1, 2 and 3)<br/>
0 1 2 3<br/>
2 0 3 1<br/>
3 1 0 2<br/>
2 0 1 3<br/>
Worker Preferences:<br/>
(Note: The first row below is Worker 0's preferences of Companies 0, 1, 2 and 3)<br/>
1 2 3 0<br/>
2 0 3 1<br/>
1 0 2 3<br/>
3 2 0 1<br/>

(For this test, we'll include what goes on when the program runs)<br/>
Company 0 looks at the pool of available workers<br/>
Company 0 hires Worker 0<br/>

Company 1 looks at the pool of available workers<br/>
Company 1 hires Worker 2<br/>

Company 2 looks at the pool of available workers<br/>
Company 2 hires Worker 3<br/>

Company 3 looks at the pool of available workers<br/>
Company 3 offered a job to Worker 2<br/>
But Worker 2 prefers the job they're at. So they reject Company 3<br/>
Company 3 offered a job to Worker 0 and they would prefer to work for them instead of Company 0<br/>
So Worker 0 quits Company 0 and is hired by Company 3<br/>
Now Company 0 needs to find a new Worker<br/>

Company 0 looks at the pool of available workers<br/>
Company 0 offered a job to Worker 0<br/>
But Worker 0 prefers the job they're at. So they reject Company 0<br/>
Company 0 hires Worker 1<br/>

Pairings:<br/>
Company 3 hired Worker 0<br/>
Company 0 hired Worker 1<br/>
Company 1 hired Worker 2<br/>
Company 2 hired Worker 3<br/>

**Test 2:** 10 companies and 10 workers<br/>
<br/>
Company Preferences:<br/>
0 1 2 3 4 5 6 7 8 9<br/>
0 2 3 5 1 4 6 8 7 9<br/>
2 1 3 5 6 8 9 4 7 0<br/>
6 3 5 9 2 8 7 4 1 0<br/>
5 2 4 8 1 3 6 9 7 0<br/>
0 2 5 6 3 9 8 7 4 1<br/>
3 6 5 2 0 1 4 8 7 9<br/>
8 5 2 4 1 0 3 6 9 7<br/>
4 1 0 2 5 3 6 9 8 7<br/>
5 2 0 1 4 7 8 9 6 3<br/>

0 1 2 3 4 5 6 7 8 9<br/>
0 2 3 5 1 4 6 8 7 9<br/>
2 1 3 5 6 8 9 4 7 0<br/>
6 3 5 9 2 8 7 4 1 0<br/>
5 2 4 8 1 3 6 9 7 0<br/>
0 2 5 6 3 9 8 7 4 1<br/>
3 6 5 2 0 1 4 8 7 9<br/>
8 5 2 4 1 0 3 6 9 7<br/>
4 1 0 2 5 3 6 9 8 7<br/>
5 2 0 1 4 7 8 9 6 3<br/>

Pairings:<br/>
Company 0 hired Worker 0<br/>
Company 1 hired Worker 1<br/>
Company 2 hired Worker 2<br/>
Company 6 hired Worker 3<br/>
Company 4 hired Worker 4<br/>
Company 5 hired Worker 5<br/>
Company 3 hired Worker 6<br/>
Company 9 hired Worker 7<br/>
Company 7 hired Worker 8<br/>
Company 8 hired Worker 9<br/>

**Test 3:** 15 companies and 15 workers<br/>
<br/>
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14<br/>
0 1 2 3 4 5 7 6 8 9 11 10 12 13 14<br/>
1 3 2 4 5 10 11 13 14 7 8 9 6 12 0<br/>
1 3 10 11 12 14 7 6 8 9 2 4 5 13 0<br/>
5 2 3 6 1 4 8 9 7 10 11 12 13 14 0<br/>
9 8 7 5 4 1 2 3 0 10 11 12 13 14 6<br/>
14 13 12 11 10 9 8 7 6 5 4 3 2 1 0<br/>
14 12 13 11 10 9 8 7 6 5 4 3 2 1 0<br/>
12 13 14 11 9 10 8 7 6 5 4 3 2 1 0<br/>
2 11 10 9 8 7 6 5 4 3 1 0 12 13 14<br/>
3 9 6 8 5 7 4 1 2 0 10 11 12 14 13<br/>
8 5 6 3 9 2 7 4 1 10 14 13 12 11 9<br/>
7 8 9 4 5 6 10 3 2 1 11 12 13 14 0<br/>
4 5 8 0 9 6 3 2 7 1 14 12 11 13 10<br/>
5 2 3 6 9 10 11 12 13 14 7 4 8 0 1<br/>

0 1 3 2 4 5 6 7 8 9 10 11 12 13 14<br/>
0 1 2 3 4 5 7 6 8 9 11 10 12 13 14<br/>
1 3 2 4 5 10 11 13 14 7 8 9 6 12 0<br/>
1 3 10 11 12 14 7 6 8 9 2 4 5 13 0<br/>
5 2 3 6 1 4 8 9 7 10 11 12 13 14 0<br/>
9 8 7 5 4 1 2 3 0 10 11 12 13 14 6<br/>
14 13 12 11 10 9 8 7 6 5 4 3 2 1 0<br/>
13 12 14 11 10 9 8 7 6 5 4 3 2 1 0<br/>
12 13 14 11 9 10 8 7 6 5 4 3 2 1 0<br/>
2 11 10 9 8 7 6 5 4 3 1 0 12 13 14<br/>
3 9 6 8 5 7 4 1 2 0 10 11 12 14 13<br/>
8 5 6 3 9 2 7 4 1 10 14 13 12 11 9<br/>
7 8 9 4 5 6 10 3 2 1 11 12 13 14 0<br/>
4 5 8 0 9 6 3 2 7 1 14 12 11 13 10<br/>
5 2 3 6 9 10 11 12 13 14 7 4 8 0 1<br/>

Pairings:<br/>
Company 0 hired Worker 0<br/>
Company 1 hired Worker 1<br/>
Company 2 hired Worker 2<br/>
Company 3 hired Worker 3<br/>
Company 4 hired Worker 4<br/>
Company 5 hired Worker 5<br/>
Company 14 hired Worker 6<br/>
Company 12 hired Worker 7<br/>
Company 13 hired Worker 8<br/>
Company 11 hired Worker 9<br/>
Company 10 hired Worker 10<br/>
Company 9 hired Worker 11<br/>
Company 7 hired Worker 12<br/>
Company 8 hired Worker 13<br/>
Company 6 hired Worker 14<br/>

# References
Algorithm structure references:<br/>
https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm<br/>
https://www.youtube.com/watch?v=0m_YW1zVs-Q<br/>
https://www.geeksforgeeks.org/stable-marriage-problem/<br/>
https://prismoskills.appspot.com/lessons/Algorithms/Chapter_14_-_Marriage_problem.jsp<br/>

Implementation specific references<br/>
https://www.youtube.com/watch?v=lHFlAYaNfdo<br/>
https://kodejava.org/how-do-i-read-file-using-scanner-class/<br/>
https://www.dummies.com/programming/java/java-use-arrays-with-two-dimensions-or-more/<br/>
https://www.youtube.com/watch?v=4V_3HnsSS7c<br/>
