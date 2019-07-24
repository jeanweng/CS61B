import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        sad1.addFirst(5);
        sad1.addFirst(3);
        if(!sad1.isEmpty()){
            Integer s1 = sad1.removeFirst();

            assertEquals("\naddFirst(5)\naddFirst(3)\nremoveFirst() ", s1, (Integer)5);

        }

    }
}
