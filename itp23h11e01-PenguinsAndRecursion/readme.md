# H11E01 - Penguins and Recursions

Did you know there is a secret laboratory for penguins somewhere on the campus of TUM? There, the penguins research mathematical sequences to discover why they lose the ability to fly! However, they do not know how to write programs. Therefore, they decided to get your help and invite you to their secret laboratory exceptionally. Your task is to help them write complex mathematical sequences.

Important: You are expected to solve this exercise with recursive methods and not allowed to use any loops (e.g. for, while, do-while and other control structures and methods for loops) in any of your methods in this exercise. If you do not follow this, your solution will be graded with 0 points.

## Project Structure

In the template repository folder src/de/in/tum/ase, you can find the class Solution.java, and you are expected to write your solutions there. Also, there is Main.java in the same directory, and that is for your local testing. Static code analysis will not be executed for Main.java.

## Your Tasks

1. **Implement Penguins Twin Sequence**

    First, they asked you to calculate the following twin series.

    *penguTwinSeqF(0)* = 1

    *penguTwinSeqM(0)* = 0

    *penguTwinSeqF(n)* = *n − penguTwinSeqM(penguTwinSeqF(n−1))* if *n* > 0

    *penguTwinSeqM(n)* = *n − penguTwinSeqF(penguTwinSeqM(n−1))* if *n* > 0

    - When n is negative, throw an IllegalArgumentException.
    - It is guranteed that the results fit with in the range of int.

    Examples for *penguTwinSeqF* and *penguTwinSeqM* with *n* = 0...9

|       n        | 0   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
|:--------------:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| penguTwinSeqF  |  1  |  1  |  2  |  2  |  3  |  3  |  4  |  5  |  5  |  6  |
| penguTwinSeqM  |  0  |  0  |  1  |  2  |  2  |  3  |  4  |  4  |  5  |  6  |



2. **Implement Penguins Big Sequence**

    Then, they asked you to write the program that calculates the sequence below.

    *penguBigSeq(0,a)* = 1

    *penguBigSeq(n,a)* = a³ × *(penguBigSeq(n−1,a))²* if if *n* > 0

    - When n is negative, throw an IllegalArgumentException.
    - It is guaranteed that the results fit within the range of long.

    Examples for *penguBigSeq* with *n* = 0…3 and *a* = 2

|      n      |  0  |  1  |  2  |    3    |
|:-----------:|:---:|:---:|:---:|:-------:|
| penguBigSeq |  1  |  8  | 512 | 2097152 |


3. **Implement Penguins Recursive Sequence**

   Last but not least, they asked you to write the program that calculates the sequence below.

    *penguRecursiveSeq(n, p₀, p₁, p₂)* = 2 x *penguRecursiveSeq(-n, p₀, p₁, p₂)* if *n* < 0
    *penguRecursiveSeq(n, p₀, p₁, p₂)* = *pₙ* if 0 ≤ *n* < 3
    *penguRecursiveSeq(n, p₀, p₁, p₂)* = *penguRecursiveSeq(n - 1, p₀, p₁, p₂) - penguRecursiveSeq(n - 2, p₀, p₁, p₂ ) + 2 x penguRecursiveSeq(n - 3,  p₀, p₁, p₂)* otherwise

   - It is guaranteed that -20 < *n* < 20 correctly works for the test cases, therefore, you do not have to worry about the computational complexity.
   - The result fits within the range of long

   Examples for *pinguSequenceRec* with *p* = (1,1,2)

|         n         |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10 |  11 | 12  | 13  | 14  | 15  |  16 |  17 |  18 |  19 |
|:-----------------:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| penguRecursiveSeq |  1  |  1  |  2  |  3  |  3  |  4  |  7  |  9  | 10  | 15  | 23  | 28  | 35  | 53  | 74  | 91  | 123 | 180 | 239 | 305 |

### Hints

- You can use static auxiliary variables and methods in this exercise.
- When you put L after a number literal (e.g. 100L), that value is recognized as long.