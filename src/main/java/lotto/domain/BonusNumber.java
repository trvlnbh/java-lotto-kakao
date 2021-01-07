package lotto.domain;

import java.util.Objects;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}