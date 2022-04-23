package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    @Test
    void 레이싱_게임에_참가할_이름을_COMMA_로_구분하여_생성할_수_있다() {
        Racing racing = new Racing("abc,def,ghi");

        assertThat(racing.participantCount()).isEqualTo(3);
    }
}