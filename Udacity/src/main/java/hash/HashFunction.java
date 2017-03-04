package hash;

public class HashFunction {
    public int hashFunction(int num) {
        if (num < 1 || num > 1_000_000) {
            throw new IllegalArgumentException("The number is not in range from 1 to 1_000_000");
        }
        return num == 1 ? 1 : (num - 1) / 1000 + 1;
    }
}
