package leetcode.sheldon.algorithm.integer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 3/17/18.
 * @version 1.0
 */
public class GuessGameTest {
    @Test
    public void guessNumber() throws Exception {
//        GuessGame guessGame = new GuessGame(6);
//        assertEquals(6, guessGame.guessNumber(10));
//
//        guessGame = new GuessGame(2);
//        assertEquals(2, guessGame.guessNumber(2));


        GuessGame guessGame = new GuessGame(1702766719);
        assertEquals(1702766719, guessGame.guessNumber(2126753390));
    }

}