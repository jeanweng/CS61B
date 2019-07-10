import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('A','B'));
        assertTrue(offByOne.equalChars('g','f'));
        assertTrue(offByOne.equalChars('y','z'));
        assertFalse(offByOne.equalChars('c','D'));
        assertFalse(offByOne.equalChars('o','y'));
        assertFalse(offByOne.equalChars('h','j'));
    }
}
