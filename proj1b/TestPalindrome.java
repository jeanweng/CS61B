import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("%6%"));
        assertFalse(palindrome.isPalindrome("Boob"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome("a"));

//        assertFalse(palindrome.isPalindrome("^", offByOne));
//        assertFalse(palindrome.isPalindrome("Boob", offByOne));
//        assertTrue(palindrome.isPalindrome("flake", offByOne));
//        assertTrue(palindrome.isPalindrome("smlt", offByOne));
    }
}
