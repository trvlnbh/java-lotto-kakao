package lotto.domain;

import lotto.exception.InsufficientMoneyException;

import java.util.Objects;

public class Money {

    private static final int SINGLE_PRICE = 1000;
    private static final String INSUFFICIENT_MONEY_EXCEPTION_MESSAGE = SINGLE_PRICE+"원 이상의 금액이 필요합니다.";

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (!haveSufficientMoney(money)) {
            throw new InsufficientMoneyException(INSUFFICIENT_MONEY_EXCEPTION_MESSAGE);
        }
    }

    private boolean haveSufficientMoney(int money) {
        return money >= SINGLE_PRICE;
    }

    public int possibleNumberBuy() {
        return this.money / SINGLE_PRICE;
    }

    public double getProfitRate(int earnedMoney) {
        return (double)earnedMoney / (double)money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
