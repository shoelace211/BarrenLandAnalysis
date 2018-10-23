ReadMe

You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). 
A portion of the farm is barren, and all the barren land is in the form of rectangles. 
Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. 
An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles 
of barren land. 
Read input from STDIN. Print output to STDOUT 
Input 
You are given a set of rectangles that contain the barren land. These rectangles are defined in a string, 
which consists of four integers separated by single spaces, with no additional spaces in the string. The first 
two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers 
are the coordinates of the top right corner. 
Output 
Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 

A sample input would be {"0 292 399 307"}, with the output being 116800 116800.

This project uses the Java programming language and two classes to implement the barren land analysis program. The
methods used for calculating the amount of fertile land in square meters are contained in the Land class. As land is 
passed over, its value is changed from 0 to show that this section has been visited. The count for the amount of fertile 
land is then incremented and this process continues until all available land has been passed over. A main class is used to run 
these methods, with the output being printed to a file. The user can create an object containing the coordinates for 
barren land or this input can be read in from a file. Input using an object would use this notation: {"0 292 399 307"}, 
while file input notation would be: 0 292 399 307. JUnit testing is used to test the main method of calculating the number 
of square meters of fertile land. These tests include cases such as an empty set, multiple sets of barren coordinates, 
and a case that would result in a failure of the program.

This project can be cloned from its public repository and run using the IntelliJ IDE.
