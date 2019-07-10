public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<>();
        for(char c: word.toCharArray()){
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        while(!d.isEmpty()){
            char f = d.removeFirst();
            if(d.isEmpty()) {
                return Character.isAlphabetic(f);
            }
            char l = d.removeLast();
            if(!Character.isAlphabetic(f) || f != l) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        while(!d.isEmpty()){
            char f = d.removeFirst();
            if(d.isEmpty()){
                return Character.isAlphabetic(f);
            }
            char l = d.removeLast();
            if(!cc.equalChars(f,l)) {
                return false;
            }
        }
        return true;
    }
}
