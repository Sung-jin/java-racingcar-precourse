package racingcar.common;

public class PositiveNumber {
    public final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
    }
}
