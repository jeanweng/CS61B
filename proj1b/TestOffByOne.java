import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('1','2'));
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('%','&'));
        assertTrue(offByOne.equalChars('Y','Z'));
        assertFalse(offByOne.equalChars('%','*'));
        assertFalse(offByOne.equalChars('Z','y'));
        assertFalse(offByOne.equalChars('h','j'));
    }
}
