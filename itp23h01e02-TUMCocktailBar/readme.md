# TUM Cocktail Bar

You are part of the IT department of the new TUM Cocktail Bar. The main goal of the bar is to make students' free time more enjoyable and provide easy and modern access to everything it has to offer. Unfortunately, the previous developer left some bugs in the code and didn't finish his work. Your help is needed in creating the new digital menu and the brand new Robot Waiter!

## Project Structure

In the template repository folder *src/de/in/tum/ase* you can find a file called *Bar.java*, which is the only file you will change in this tutor exercise. In this file, you will have to implement the methods *printCatalog()*, *robotWaiter()*, and *translatedMessage()* by replacing the TODO comments (*//TODO: ...*) with your lines of code.

## Your Tasks

**1.Correct the description values**
    
Nobody wants to read our available cocktails on a piece of paper, which is why we are developing our very own digital menu. The system should print our cocktail catalog along with all descriptions on the console. As of right now, we have 2 cocktails available: the martini and the mimosa. Therefore the *printCatalog()* method should print the following on the console:

`Martini: a cocktail made with gin or vodka and dry vermouth, usually served with a green olive or a twist of lemon peel.`  
`Mimosa: a mixed drink consisting of champagne and orange juice.`   
`However, this is not happening right now. The method contains a few errors that must be corrected.`    

Hint: Make sure that the printed message matches EXACTLY to what is expected!

**2. Develop Robot Waiter**

In order to attract more customers, the TUM Cocktail Bar came up with the idea of a Robot Waiter! It should make the process of ordering more efficient and fun! However, in this early version, we are only interested in getting the customer's order via the console. The robot will ask the customer for the order and, after their response, it will confirm the order with a short message. This is what we are expecting:

`What would you like to order?`     
`→ order`   
`Thank you! You ordered: [order].`  
`Note: [order] represents the user input.`  

Take a look at the *robotWaiter()* method in the *Bar.java* file and implement this early stage version of the Robot Waiter.

**3. Unicode message**

Our previous developer left the weird-looking message when he left the team:

*0x0045 0x0058 0x005A 0x0045 0x004C 0x004C 0x0045 0x004E 0x0054*

We are very curious to see what he was trying to say, so we want you to print the translated message via te method *translatedMessage()*.

Here is an example: if the message were *0x0048 0x0049 0x003F*, we would be expecting the following to be printed: HI?

Hint: We have a suspicion it might be related to Unicode and are sure it is only one word

Note: The last test will be executed after the deadline. Such hidden tests will be part of future exercises as well, without them being explicitly addressed within the problem statement

Thank you for taking care of our system. We are sure many students will benefit from your work.

### Helpful Question

How can executing the Main.java and seeing the output of your programm help you in developing your code?
