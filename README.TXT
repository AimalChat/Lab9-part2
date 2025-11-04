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

12b.I see it! It has three tests showing! 

13. Create a test class for the Comment class in the online-shop-junit project. 

13b.


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}


14. What methods are created automatically when a new test class is created? 

14b.there are 3, the constructor with nothing within the paramaters or body, setup() adn tearDown().

15. Create a test to check that addComment returns false when a comment from the same author already 
exists. 

15b.
@Test
    public void SameAuthorTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(true, salesIte1.addComment("Leo", "Great!", 5));
        assertEquals(false, salesIte1.addComment("Leo", "Mid.", 3));
    }

16. Create a test that performs negative testing on the boundaries of the rating range. That is, test the 
values 0 and 6 as a rating (the values just outside the legal range). We expect these to return false, so 
assert false in the result dialog. You will notice that one of these actually (incorrectly) returns true. 
This is the bug we uncovered earlier in manual testing. Make sure that you assert false anyway. The 
assertion states the expected result, not the actual result. 

16b.
@Test
    public void illegalRatingTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(false, salesIte1.addComment("Leo", "AMAZING!", 6));
        assertEquals(false, salesIte1.addComment("Liam", "Trash.", 0));
    }

17. Run all tests again. Explore how the Test Result dialog displays the failed test. Select the failed 
test in the list. What options do you have available to explore the details of the failed test? 

17b. We've got many ways of handling this failed test, such as doing a manual wlakthrough of our code
on paper to truly visualize whats happening wihtout relying on the compiler, printing the current value
we wish to rectify, and finally using the debugger to track what happens in each step in the program 
running!

The error:
/**
     * Check whether the given rating is invalid. Return true if it is invalid.
     * Valid ratings are in the range [1..5].
     */
    private boolean ratingInvalid(int rating)
    {
        return rating <= 0 || rating > 5;//it was missing the "=" sign after the "<"
    }

18. Create a test class that has Comment as its reference class. Create a test that checks whether the 
author and rating details are stored correctly after creation. Record separate tests that check whether 
the upvote and downvote methods work as expected. 

18b.


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTestV2.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTestV2
{
    private Comment comment1;

    

    /**
     * Default constructor for test class CommentTestV2
     */
    public CommentTestV2()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        comment1 = new Comment("Micheal Afton", "Great for my plans!", 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void commentDetailsTest()
    {
        assertEquals("Micheal Afton", comment1.getAuthor());
        assertEquals(5, comment1.getRating());
    }

    @Test
    public void upVoteTest()
    {
        comment1.upvote();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void downVoteTest()
    {
        comment1.downvote();
        assertEquals(-1, comment1.getVoteCount());
    }
}

19. Create tests for SalesItem that test whether the findMostHelpfulComment method works as expected. 
Note that this method returns a Comment object. During your testing, you can use the Get button in 
the method result dialog to get the result object onto the object bench, which then allows you to make 
further method calls and add assertions for this object. This allows you to identify the comment object 
returned (e.g., by checking its author). You can also assert that the result is null or not null, 
depending on what you expect.

19b.
//had to add this in the SalesItem class
public ArrayList<Comment> getComments()
    {
        return comments;
    }

@Test
    public void HelpfulCommentTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        salesIte1.addComment("Micheal Afton", "Trash.", 1);
        salesIte1.addComment("Liam", "AMAZING!", 5);
        salesIte1.upvoteComment(1);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(salesIte1.getComments().get(1), comment1);
        assertEquals(1, comment1.getVoteCount());
    }

20. Add further automated tests to your project until you reach a point where you are reasonably confident 
of the correct operation of the classes. Use both positive and negative tests. If you discover any errors, 
be sure to record tests that guard against recurrence of these errors in later versions. 

20b.
@Test
    public void validAuthorTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(true, salesIte1.addComment("Liam", "Trash.", 1));
        assertEquals(true, salesIte1.addComment("Micheal Afton", "Great for my plans!", 5));
    }

@Test
    public void getAllComments()
    {
        SalesItem salesIte2 = new SalesItem("Pikachu", 999);
        salesIte2.addComment("Micheal Afton", "Great for my plans!", 5);
        salesIte2.addComment("Liam", "Trash.", 1);
        assertEquals(2, salesIte2.getComments().size());
    }

@Test
    public void HelpfulCommentTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        salesIte1.addComment("Micheal Afton", "Trash.", 1);
        salesIte1.addComment("Liam", "AMAZING!", 5);
        salesIte1.upvoteComment(1);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals(salesIte1.getComments().get(1), comment1);
        assertEquals(1, comment1.getVoteCount());
    }

21. Rewrite all loops in the SalesItem class using condition-based while loops (replace iterators and for-
each loops). Once you are finished, rerun your tests to convince yourself that your rewriting of the code 
has not broken any of the intended functionality.

21b.
/**
     * Show all comments on screen. (Currently, for testing purposes: print to
     * the terminal. Modify later for web display.)
     */
    public void showInfo()
    {
        System.out.println("*** " + name + " ***");
        System.out.println("Price: " + priceString(price));
        System.out.println();
        System.out.println("Customer comments:");
        int i = 0;
        while(i < comments.size()){
            System.out.println("-------------------------------------------");
            System.out.println(getComments().get(i).getFullDetails());
            i++;
        }
        System.out.println();
        System.out.println("===========================================");
    }
    
    /**
     * Return the most helpful comment. The most useful comment is the one with
     * the highest vote balance. If there are multiple comments with equal 
     * highest balance, return any one of them.
     */
    public Comment findMostHelpfulComment()
    {
        int i = 0;
        Comment best = getComments().get(0);
        while(i < comments.size()) {
            Comment current = getComments().get(i);
            if(current.getVoteCount() > best.getVoteCount()) {
                best = current;
            }
            i++;
        }
        return best;
    }

/**
     * Find the comment by the author with the given name.
     * @return The comment if it exists; null if it doesn't.
     */
    private Comment findCommentByAuthor(String author)
    {
        int i = 0;
        while(i < comments.size()) {
            Comment match = getComments().get(i);
            if(match.getAuthor().equals(author)) {
                return match;
            }
            i++;
        }
        return null;
    }
