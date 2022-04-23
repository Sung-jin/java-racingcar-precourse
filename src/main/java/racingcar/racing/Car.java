package racingcar.racing;

public class Car {
    private final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void move(int moveNumber) {
        Forward forward = new Forward(moveNumber);

        if (forward.isAvailableForward()) {
            moveCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("The name of the car must be 5 characters or less.");
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty names are not allowed.");
        }
    }
}
