# Race Of Threads
This repository involves creating an ArrayList consisting of numbers from 1 to 10,000. Next, divide the 10,000 elements in the ArrayList into four equal parts, each containing 2,500 elements. Design four separate threads to find odd and even numbers within these four ArrayLists of 2,500 elements each.

Each of the four threads will add the even numbers it finds to a common ArrayList.

Each of the four threads will add the odd numbers it finds to a common ArrayList.

The ArrayLists that hold the odd and even numbers will be empty when initially created, and there will be two ArrayLists in total.

When each of the four threads starts processing its own ArrayList of 2,500 elements, it will populate the odd and even number ArrayLists.
