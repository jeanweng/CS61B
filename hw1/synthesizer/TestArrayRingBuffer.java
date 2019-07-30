package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        for(int i = 1; i < 11; i++){
            arb.enqueue(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        ArrayRingBuffer<Integer> haha = new ArrayRingBuffer<>(6);
        for(int i = 0; i < 6; i++){
            haha.enqueue(i);
        }
        haha.dequeue();
        haha.dequeue();
        haha.enqueue(11);
        haha.enqueue(12);
        System.out.println("First: " + haha.getFirst() + " Last: " + haha.getLast());
        Iterator<Integer> a = haha.iterator();
        while(a.hasNext()){
            System.out.println(a.next());
        }
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
