import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder sb = new StringBuilder();
        int size = 0;
        Integer resSad = null;
        Integer resAds = null;

        while(true){
            double random = StdRandom.uniform();
            int num = (int)(random * 10);
            if (random < 0.25) {
                sad.addLast(num);
                ads.addLast(num);
                size++;
                sb.append("addLast(" + num + ")\n");
            } else if(random < 0.5){
                sad.addFirst(num);
                ads.addFirst(num);
                size++;
                sb.append("addFirst(" + num + ")\n");
            } else if(random < 0.75 && size > 0){
                resSad = sad.removeFirst();
                resAds = ads.removeFirst();
                size--;
                sb.append("removeFirst()\n");
            } else if(size > 0) {
                resSad = sad.removeLast();
                resAds = ads.removeLast();
                size--;
                sb.append("removeLast()\n");
            }
            assertEquals(sb.toString(), resAds, resSad);
        }
    }
}
