package other.advance.binaryOperation;

import other.advance.binaryOperation.BinaryOperation;

public final class Main {
    public static void main(String[] args) {
        BinaryOperation add = (a, b) -> a + b;
        assert 5 == add.apply(2, 3);
    }
}
