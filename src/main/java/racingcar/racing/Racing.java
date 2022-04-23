package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int MIN_MOVE_NUMBER = 0;
    private final int MAX_MOVE_NUMBER = 9;

    private final List<Car> participants = new ArrayList<>();

    public Racing(String s) {
        String[] names = s.split(",");

        for (String name: names) {
            participants.add(new Car(name));
        }
    }

    public void play(int racingPlayCount) {
        for (int index = 0; index < racingPlayCount; index++) {
            moveAllParticipants();
        }
    }

    public List<Car> getWinners() {
        int furthestDistance = getFurthestDistanceOfTheParticipants();
        List<Car> winners = new ArrayList<>();

        for (Car participant: participants) {
            sameMoveCountThenAdd(furthestDistance, participant, winners);
        }

        return winners;
    }

    public int participantCount() {
        return participants.size();
    }

    private void moveAllParticipants() {
        for (Car participant: participants) {
            participant.move(Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER));
        }
    }

    private int getFurthestDistanceOfTheParticipants() {
        int furthestDistance = 0;

        for (Car participant: participants) {
            furthestDistance = Math.max(furthestDistance, participant.getMoveCount());
        }

        return furthestDistance;
    }

    private void sameMoveCountThenAdd(int distance, Car car, List<Car> target) {
        if (car.getMoveCount() == distance) {
            target.add(car);
        }
    }
}
