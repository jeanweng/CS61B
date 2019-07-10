public class OffByN implements CharacterComparator {

    private int n;

    public OffByN(int _n){
        n = _n;
    }

    @Override
    public boolean equalChars(char x, char y){
        if(!Character.isAlphabetic(x) || !Character.isAlphabetic(y)){
            return false;
        }
        return Math.abs(x - y) == n;
    }
}
