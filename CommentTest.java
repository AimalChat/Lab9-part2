

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

    @Test
    public void SameAuthorTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(true, salesIte1.addComment("Leo", "Great!", 5));
        assertEquals(false, salesIte1.addComment("Leo", "Mid.", 3));
    }

    @Test
    public void illegalRatingTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(false, salesIte1.addComment("Leo", "AMAZING!", 6));
        assertEquals(false, salesIte1.addComment("Liam", "Trash.", 0));
    }

    @Test
    public void validAuthorTest()
    {
        SalesItem salesIte1 = new SalesItem("Pikachu", 999);
        assertEquals(true, salesIte1.addComment("Liam", "Trash.", 1));
        assertEquals(true, salesIte1.addComment("Micheal Afton", "Great for my plans!", 5));
    }
}



