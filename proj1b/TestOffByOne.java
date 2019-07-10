import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('1','2'));
        assertTrue(offByOne.equalChars('%','&'));
        assertTrue(offByOne.equalChars('y','z'));
        assertTrue(offByOne.equalChars('1','0'));
        assertFalse(offByOne.equalChars('o','y'));
        assertFalse(offByOne.equalChars('h','j'));
    }
}
