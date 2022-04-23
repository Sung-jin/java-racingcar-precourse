package racingcar.racing;

public class Car {
    private final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The name of the car must be 5 characters or less.");
        }
    }
}
