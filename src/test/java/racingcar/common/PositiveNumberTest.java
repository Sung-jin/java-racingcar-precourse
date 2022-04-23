package racingcar.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @Test
    void 양수가_아닌_숫자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}