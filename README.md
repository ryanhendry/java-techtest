# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Notes

### How can we run your code
```
./gradlew bootRun --args="example2.txt" 
```
### Big O analysis
Time Complexity:
The intention was in the main part of the algorithm is to do a counting sort, which runs in O(n+k) time. As the range of potential characters in a word is small, it will generally run in 0(n) time. I wasn't sure whether each individual list of anagrams needs to be in sorted order, but since it's required for the existing unit test, I have done so. This adds additional time complexity, I believe, of O(m*log(m)), where m is the number of anagrams in the group,

Space Complexity:
Generally to have a good time complexity, the space complexity increases and this is the case here. This may not be the optimal
trade-off as the problem seems to be memory-bottlenecked vs CPU-bottlenecked. Given more time I may have re-evaluated my approach
and sacrificed time complexity (and execution time) for space complexity.

### Reasons behind data structures chosen
The approach makes heavy use of the stream API which is very readable and parallelizable to decrease execution time. 
I have created the Frequency Java 14 record to store data immutably and with no boilerplate code required.

### What would you do given more time
- I would have chunked the File stream based on line length, as the problem states that each segment of same length words
will fit into memory. This would have potentially slowed the execution time from reduced parallelization.
- As mentioned above I will have looked for a more space efficient algorithm to use.
- There is an interesting approach to checking for anagrams that involves assigning each character a 
 prime number and multiplying them together. Identical numbers will be anagrams. I would have investigated if this approach
 would work well here


## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams



