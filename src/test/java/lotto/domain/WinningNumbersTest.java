package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.exception.BonusDuplicateException;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    @Test
    public void createEqualInstance() {
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers("1, 2, 3, 4, 5, 6", 7));
    }

    @DisplayName("Validate duplicate between winNumbers and bonusNumber")
    @Test
    public void validateDuplication() {
        assertThatThrownBy(() -> {
            new WinningNumbers("1, 2, 3, 4, 5, 6", 6);
        }).isInstanceOf(BonusDuplicateException.class);
    }
}
