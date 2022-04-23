package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.PositiveNumber;
import racingcar.functional.LoopHelper;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int MIN_MOVE_NUMBER = 0;
    private final int MAX_MOVE_NUMBER = 9;

    private final List<Car> participants = new ArrayList<>();

    public Racing(String participantNames) {
        String[] names = participantNames.split(",");

        for (String name: names) {
            participants.add(new Car(name));
        }
    }

    public void play(PositiveNumber racingPlayCount) {
        System.out.println("실행 결과");

        for (int index = 0; index < racingPlayCount.value; index++) {
            LoopHelper.listForEach(participants, (value) -> {
                value.move(Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER));
            });

            OutputView.RacingMoveResultPrint(this);
        }

        OutputView.RacingEndResultPrint(this);
    }

    public List<Car> getWinners() {
        int furthestDistance = LoopHelper.maxValueInIntegerList(
            LoopHelper.listMap(participants, Car::getPosition)
        );

        return LoopHelper.listFilter(participants, (value) -> value.getPosition() == furthestDistance);
    }

    public int participantCount() {
        return participants.size();
    }

    public List<Car> getParticipants() {
        return this.participants;
    }
}
