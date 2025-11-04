Project: online-shop-junit
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

This project implements a small part of an online sales system (such as Amazon.com).
The current project is concerned only with customer comments for sales items. It contains
code to create, store, show and manipulate customer comments.

The purpose of this project is to introduce regression testing using JUnit. It includes 
a test class that demonstrates some of the testing functionality. Testing is further 
discussed in the book.

NOTE: There are several serious errors to be found in these classes.

12. Open the online-shop-junit project. Run the tests in your project, using the Run Tests button (or Tools
>Testing->Run Tests). You should see a window similar to the image below, summarizing the results of 
the tests.

12b.

13. Create a test class for the Comment class in the online-shop-junit project. 

13b.

14. What methods are created automatically when a new test class is created? 

14b.

15. Create a test to check that addComment returns false when a comment from the same author already 
exists. 

15b.

16. Create a test that performs negative testing on the boundaries of the rating range. That is, test the 
values 0 and 6 as a rating (the values just outside the legal range). We expect these to return false, so 
assert false in the result dialog. You will notice that one of these actually (incorrectly) returns true. 
This is the bug we uncovered earlier in manual testing. Make sure that you assert false anyway. The 
assertion states the expected result, not the actual result. 

16b.

17. Run all tests again. Explore how the Test Result dialog displays the failed test. Select the failed 
test in the list. What options do you have available to explore the details of the failed test? 

17b.

18. Create a test class that has Comment as its reference class. Create a test that checks whether the 
author and rating details are stored correctly after creation. Record separate tests that check whether the 
upvote and downvote methods work as expected. 

18b.

19. Create tests for SalesItem that test whether the findMostHelpfulComment method works as expected. 
Note that this method returns a Comment object. During your testing, you can use the Get button in 
the method result dialog to get the result object onto the object bench, which then allows you to make 
further method calls and add assertions for this object. This allows you to identify the comment object 
returned (e.g., by checking its author). You can also assert that the result is null or not null, depending 
on what you expect.

19b.

20. Add further automated tests to your project until you reach a point where you are reasonably confident 
of the correct operation of the classes. Use both positive and negative tests. If you discover any errors, 
be sure to record tests that guard against recurrence of these errors in later versions. 

20b.

21. Rewrite all loops in the SalesItem class using condition-based while loops (replace iterators and for-
each loops). Once you are finished, rerun your tests to convince yourself that your rewriting of the code 
has not broken any of the intended functionality.

21b.
