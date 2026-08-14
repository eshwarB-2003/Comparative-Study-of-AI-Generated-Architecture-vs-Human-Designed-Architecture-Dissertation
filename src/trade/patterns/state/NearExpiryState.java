package trade.patterns.state;

public class NearExpiryState implements CreditState {
   public String getStateName(){
       return "NEAR_EXPIRY";
   }

}
