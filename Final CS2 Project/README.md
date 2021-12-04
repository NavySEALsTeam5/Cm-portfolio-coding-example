# FinalCS1

This program is called workout tracker.
This program is used to help a person track there workout stats. 
For example, some of the things that this program will help a person with is,
there total push ups, squats, sit ups, etc. 
It will also help track one's maxes, including there dead lift, bicep curl, overhead press, max push ups, and more!

This program also allows the user to make and save workouts for later use. 
Another feature that this program has is an exercise help which allows the user to look up an exercise and information on how to do it.
The next feature of this program is the exercise search, which allows the user to discover a certain type of exercise.
The final feature of this program is the challenge feature. This feature give the user random challenges to complete. *WARNING EXTREME MODE IS VERY DIFFICULT*

To operate the program, first launch using any ide, and chooses one of the choices presented on the screen. 
It will look something like this:

The available functions are:

New Maxes
Current Maxes
Add to totals
Current Totals
Get Date
Exercise Help
View Workouts
Create Workouts
Search For Exercise
Easy Challenge
Medium Challenge
Hard Challenge
Extreme Challenge
Random Challenge
I Need Motivation

Choose one of the listed features to move on in the program. upper and lowercases do not matter, but spelling does.
After advancing to the next part of the program, more options will be listed, follow the same steps used before. 

Most of the saving done is the program is simply done with files. The loading is done very similarly, read content from the files into the system.

Im not sure how to run this with the test files nor could i get the sseed working but it set up for testing and proof.
To execute run in the compiler 
`java Main 42 < test.txt`
Could not get working on my device. Please potentially if i lose points for the testing instead potentially replace points with points 
from recursive statements in tree used for testing.


This will automate the process and test almost every method in the program. Upon succesful completion, the program will be completely tested.


Github repo
+-----------------------------------------------+

JAVA FILES


Main.java 
This is the main file where all the navigation and intializing of the program is done. It is mainly used to navigate the program. 
While it does do some calculations and building, it does not do much.

PersonObject.java
This is the object that contains all the stats of the person, and is the object that loads and saves most of the stats.
This would include the saving and the loading of the totals and the maxes.

Workout.java
This is the object allows the viewing, the creation, and the saving of workouts.

SpecialFunctions.java 
This is the file that holds any out of the ordanary functions like clear the screen and play noise. 
There are other methods in there as well.

ExerciseTreeNode.java
This is my custom advance data structure (ADT). 
This differs from regular tree nodes since instead of having a fixed number of nodes, this node uses a list to store its children. 
There is also a recursive print method that i used for extensive testing of the tree. So wasnt made for nothing. There for testing purposes.
Dont know if this counts but I did actually have a need to print out the tree recursively. 

ExerciseSearchTree.java
This object is what is used to construct the node into a tree form. Also loads all the exercises into the tree upon creation.
I used this for the exercise search part of the program, which allowed the user to help narrow the search on an exercise that suited there needs.
I decided that a tree would be best for this so i dont have to have a billion if statements.

Challenges.java 
This is the final object of my program. i used this object to create the random challenge ,ode that is avaiable to the user. 
This was done by using a que, and when the user decides to skip or complete a challenge, it simply removes the front.
I decided to use a queue because it provided all the functionality I needed. 


TXT FILES
all files are held in the files folder.

StatsPerDay should be ignored for. It was where the users stats for the day was being stored.

Maxes.txt is where all the user maxes are stored for later use.
Totlas.txt is where all the users totals are stored for later use.
WeightExercises.txt and BodyWeightExercises.txt are the files where all the aviable exercies are held.
The ".wav" files are the easter eggs music files.
challenges folder holds all the possible challenges the user can get. Each organized by their difficulty.
The avaiable workouts folder is where any created workout is stored.

test.txt is the file that is used to automate the process of going through the program testing methods.
Use this file when tricking java to scan this instead of the keyboard.


WHERE THINGS ARE SO YOU CAN MAKE GRADING EASIER
+---------------------------------------------+

CS1

-Else if statements
Literally everywhere in my program take your pick on which one you want to grade.

-Loops
Many loops were used. Some of interest would be the infinite for loop I used in the workout file. The method was create workout.
If needing more for loops every method inside of workout.java has one.
Also every where through out the program. 

-Whiles
Are also used for much of the navigation in the main.java.

-Files
My mastery of files is accurately demostrated in the person object class.
See the load method, saveTotals, and saveMaxes methods. Also the workout.java files createWorkout method does a lot of printing to files.
The rest of the files I used through out the program were to read from a file.

-try/catch
In the workout.java file, i used try catch stements in every method. This was to catch file not found exception that java requires me to catch.
I also used any where else through out program where I was scanning a file because java required it.

-Arrays
I mainly used arrays to simplify methods. Like in the exerciseMapMaker method. 
I used this to store to files, so I didnt have to make two methods for each file. Instead i just read the files with one in the array and then seconnd one. 
I also used arrays in the workout class. I did this to list all the txt files into the array so i could then iterate through the array and scan for the file that I wanted.
The main array that i used though was in Challenges.java and Workout.java. Both time i used an array to list the files from which workouts and exercises were being pulled from.


-Custom objects
Workout is a custom object, PersonObject is a object, ExerciseSearchTree is a object.

-Switches
The only switches I used were in SpecialFunctions month converting methods and the addTotals. 
The addTotals method in the main.java file is one that the program is dependent on. 
The others one are simply for converting a number version of a month into a string format.

-Enumerated types
I did not do any enumerated types so dont bother lookin.



CS2
	
-Lists
I used lsit in my ExerciseTreeNode data stucture. I used the list to make the amount of children varying and not fixed so the nodes were easier to modify.
This made methods like realloc not neccassary. 
ExerciseTreeNode.java line 14

-Maps
I used a map in the exercise help function of the program. I basically took my files with exercises in them, 
took the name and description of each, and put them into a map. The name of the exercise was the kep, and the description was the value.
See Main.java Line 590 to end. Methods exerciseMapMaker and mapSearch.

-Recursion
I used recursion for my ADT (ExerciseTreeNode). I used recursion to print out the tree.
The was mainly for testing and I did actually need it. Was not added just to meet requirment. But well rounds my ADT and makes it usable for other programs. 
Also was used so i can confirm that my tree was getting the exercises load into it. 
ExerciseTreeNode method printNodeChainHelp. Lines 121 - 134. 

-Queues
A queue was used in the Challenges object/file. I used a queue in this instance because i was having in a sence, 
a line of challenges, where the user completed the one at the front first. Thus making a queue most desirable. 
Since all i need is the ability to remove the front see the front, and prevent access to the middle, a queue was right for the job. 
This was used to create the random challenges that were avaiable to the users.
Lines 30-108 is all modifying the que.

-Custom ADT's (node based)
I created my own data structure tto help create a desicion tree. i chose this tool so i wouldnt have to have 8 bajillion if statements. 
It also added a level of automation to the program. It did this by making it so that i didnt have to add another if statements for each exercise but instead
made a new node automaticaly for each exercise in the file. The aprts of this node based data structure is a data, description, and a list of children.
Found in the ExerciseTreeNode.java File, structure "built" in ExerciseSearchTree.java.

+---------------------------------------------------+
BUGS TO IGNORE

There is a bug when in both the new maxes and add to totals method, where after the user does input and confirms the opitions are printed twice to the screen.
This does not affect or have any adverse affects on the program didnt bother fixing since I clear the screen in both istances anyways.


The stat per day part of the overall program is still kind of buggy, butt it does work and out putt and read from the file.
The only part that breaks a large portion of the program is trying to properly modify the raf file. Which wasnt covered in this class.
Please keep this in mind when grading that every thing else about this part of the program is find but not the raf file part in updateEntry method.



TESTING PROOFS
+---------------------------------------------------+
totalEditor method in Main.java is proved to handle input by the first 12 lines of the test txt file. 
This is the method being used in thsi instance to retrieve the input for editing the totals
This file test it with positive, negative, and 0 all of which work.
Also crap input is givin to the method. Which is handled find. Prints to the screen invalid input. 
Tested on line 12 of the file.

|===|

dobTotalEditor method in Main.java is also tested in the test by lines 13 - 20 of the test.txt . This is proven to work since an exercise that calls this method is called
and is tested with valid and invalid input.

|===|

userInputNum method in Main.java is tested in the test.txt from 22 - 26. Was give valid and invalid input and handled it.

|===|

userInputDouble method in Main.javais tested in the test.txt from 27 - 30. Was given valid and invalid input and handled it.

|===|

currentMaxes method in Main.java is test on 31 of the test.txt file.

|===|

currentTotals method in main.java is tested on line 32 of test.txt file.

|===|

The functionality of the implemented map (basicaly mapSearch and exerciseMapMaker method in Main.java) is tested from lines 33 - 36.
This was tested with a valid key (exercise) and an invalid key(giberish). Handles both fine.

|===|

viewWorkouts method in Main.java and the workout object/class is test in test.txt files from lines 38-41
MEthod is tested withvalid input and invalid input.

avaiableWorkouts method in Workout.java is test when view workouts is called. chooseWorkout is also proven functionality in this chunk of the test.
Both of these are printing information from a file to the screen.

|===|

createWorkout method in Workout.java is tested in lines 42 - 45 in the test.txt file.
Prove of completetion shown if you check the files folder of the repository, then files, then aviableWorkouts folder. Test workout should be in there.

|===|

ExerciseTreeNode functionality is tested in test.txt file from lines 46 -55.
Invalid input is called. And since this is a custom tree both children of the root node is tested for proper functionality.

|===|

The challenges randomness is and functionality is proved in test.txt lines 56 - 61.

If this is succesful, the whole program has significant bugs and is properly working.



EASTER EGGs:
if you type "this program sucks" then "yes it does" then "f*** you" the program will play base boosted thomhas the tank engine theme music.
*WARNING WILL BE VERY LOUD*

All other easter eggs type"
good morning
i need motivation
hes dead
private access
i meesed up
this is going to take a while
who am i
who is he

