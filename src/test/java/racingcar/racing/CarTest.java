package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차는_이름을_입력받을_수_있으며_5자_이하여야_한다() {
        assertThat(new Car("12345")).isNotNull();
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}