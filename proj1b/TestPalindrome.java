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
        assertTrue(palindrome.isPalindrome("cs61b16sc"));
        assertFalse(palindrome.isPalindrome("Boob"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome("a"));

        assertTrue(palindrome.isPalindrome("^", offByOne));
//        assertFalse(palindrome.isPalindrome("Boob", offByOne));
//        assertTrue(palindrome.isPalindrome("flake", offByOne));
//        assertTrue(palindrome.isPalindrome("smlt", offByOne));
    }
}
