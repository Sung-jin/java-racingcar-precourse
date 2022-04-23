package racingcar.racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> participants = new ArrayList<>();

    public Racing(String s) {
        String[] names = s.split(",");

        for (String name: names) {
            participants.add(new Car(name));
        }
    }

    public int participantCount() {
        return this.participants.size();
    }
}
