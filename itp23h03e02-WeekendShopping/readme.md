# H03E02 - Weekend Shopping

Since winter is coming soon and the temperature is so low, our cute bear Alice decides to make a grand weekend shopping to buy herself some food so that she can stay at home in the next following weeks. Alice makes a precise shopping list that looks similar to an array structure. Each item on the shopping list has its own name, weight, and value. Alice is a bear who doesn't like eating the same food which ensures that the exact food would not appear twice on the same shopping list. However, before Alice starts shopping, she needs help from us in preparation work. Please remember that Alice doesn't like writing things down one after another in each cell, so she sometimes skips one and puts the item into the next position. Also, Alice sometimes forgets to prepare her shopping list in time which means the shopping doesn't exist yet. This case is represented in code using the null value.

## Project Structure

In the template repository folder src/de/in/tum/ase you can find the files Shopping.java and Item.java. An object of the class Item represents an item that Alice puts on her shopping list. In the class Shopping you will have to implement the following 5 methods shown below. You can use the TODO comments as a reference. Please make sure to use the method signatures stated in the single tasks.

## Part 1: Search

**You have the following tasks:**

**1. Implement Searching function**

Implement the method search(String itemName) in the class Shopping. When Alice is making the newest shopping list for the next weekend, she forgot if she has already added some items to her shopping list. Since Alice doesn't want to eat the same food twice, you need to help her to find out whether an item with the same name already exists. If it's present, return the index of the searched item. If the item is not added yet, use -1 as the result.

**2. Implement minimum function**

Implement the method findMin() in the class Shopping. You need to check the shopping list and find out the index of the item with the smallest value. If there are several items with the same value, please return the smallest index. Be careful that Alice wants the original index of the item regarding the given shoppingList in shoppingList. For the default situation, that is when Alice doesn't prepare the shopping list in time, you need to return -1 to remind Alice.

**3. Implement maximum function**

Implement the method findMax() in the class Shopping. You need to check the shopping list and find out the index of the item with the largest value. If there are several items with the same value, please return the biggest index you find. Be careful that Alice wants the original index of the item regarding the given shoppingList in shoppingList. For the default situation, that is when Alice doesn't prepare the shopping list in time, you need to return -1 to remind Alice.

## Part 2: Shopping, Shopping!

Now we want to help Alice with her shopping. Alice always brings her cute penguin bag when she goes shopping. The penguin bag has a limited capacity and we need to help Alice find the best combination since the bag will sometimes not be big enough to carry all the items Alice wants to buy. The attribute bagCapacity indicates the maximum weight this bag can contain.

**You have the following tasks:**

**1. Implement fillBagMax**

Implement the method fillBagMax() using a [greedy algorithm](https://www.geeksforgeeks.org/greedy-algorithms/). As the result, you need to deliver Alice a new shopping list (a new array of items) only with those items on it, that she can definitely buy later. Make sure that the sum of their weights does not exceed the maximum bagCapacity. Attention: there should be no empty spot in the new shopping list. Since Alice wants to nourish herself with as high as possible valued items, you should give her a shopping list with possible high value. If the next item with highest value is too heavy, then leave it out and try to find the next item with fitting weight and highest value among the remianing items. Return null if there is no prepared shopping list yet.
Hint: You may use the sorting algorithm from the lecture (insertion sort).

Greedy Algorithm in short: Always choose the item with the next biggest value, but be careful about the item's weight since Alice cannot pack the item in her bag, whose weight exceeds the bag's remaining capacity. (Apparently, Alice is not the only one having trouble filling her bagpack in the most optimal way. As an optimal solution for this problem is hard to find, you will stick to the simpler solution stated above. However, if you are interested, you can take a look at the [Knapsack problem](https://en.m.wikipedia.org/wiki/Knapsack_problem).)

## Part 3: Optional Bonus Challenge

**1. calValue**

This in an optional challenge. You can earn up to 3 bonus points for this part.
Implement the method calValue() to tell Alice the total value of items she can buy. Only include items that fit in her pengiun bag into the calculation. Return 0 if no shopping list exists.
Hint: Try to reuse methods implemented in the previous tasks.

### Helpful questions

- How can you compare Strings in Java?


Note: The public tests in this exercise only check simple examples. Run your methods locally and check that they also handle special cases correctly.