package racingcar.racing;

import racingcar.common.Position;

public class Car {
    private final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final Position position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = new Position();
    }

    public void move(int moveNumber) {
        Forward forward = new Forward(moveNumber);

        if (forward.isAvailableForward()) {
            position.forward();
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position.getPosition();
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
