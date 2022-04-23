package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차는_이름을_입력받을_수_있으며_5자_이하여야_한다() {
        assertThat(new Car("12345")).isNotNull();
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_빈_값을_허용하지_않는다() {
        assertThatThrownBy(() -> new Car("   ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_이동시_4_이상이면_움직이고_미만이면_움직이지_않는다() {
        Car car = new Car("foo");

        car.move(3);
        assertThat(car.getMoveCount()).isEqualTo(0);

        car.move(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}