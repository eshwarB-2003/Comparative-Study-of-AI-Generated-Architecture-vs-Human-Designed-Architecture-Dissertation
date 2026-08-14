package trade.patterns.state;


public class ExpiredState implements CreditState {
    @Override
    public String getStateName() {
        return "EXPIRED";
    }
}
