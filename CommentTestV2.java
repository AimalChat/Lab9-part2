

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