import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars(){
        assertTrue(offByN.equalChars('A','F'));
        assertTrue(offByN.equalChars('t','y'));
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('h','m'));
        assertFalse(offByN.equalChars('a','B'));
        assertFalse(offByN.equalChars('c','t'));
        assertFalse(offByN.equalChars('o','y'));
        assertFalse(offByN.equalChars('h','j'));
    }
}
