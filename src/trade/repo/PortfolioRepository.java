package trade.repo;
import trade.model.Credit;


import java.util.List;

public interface  PortfolioRepository {
    List<Credit> getCreditsByBuyer(String email);
    void saveCreditForBuyer(String email, Credit credit);
}
