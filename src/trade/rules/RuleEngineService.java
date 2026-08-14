// manages and executes all rules

package trade.rules;


import trade.config.SystemConfig;
import trade.model.Credit;
import trade.model.User;

import java.time.LocalDate;

public class RuleEngineService {

    // =========================
    // PURCHASE RULES
    // =========================

    // Checks whether the purchase quantity is valid
    public boolean validatePurchase(User buyer, Credit credit, int qty) {

        // Rule 1: Quantity must be greater than 0
        if (qty <= 0) {
            System.out.println("Purchase quantity must be greater than 0.");
            return false;
        }

        // Rule 2: Quantity cannot exceed available credits
        if (qty > credit.getQuantity()) {
            System.out.println("Purchase quantity exceeds available credits.");
            return false;
        }

        return true;
    }


    // =========================
    // LISTING RULES
    // =========================

    // Checks whether a credit can be listed
    public boolean validateListing(User seller, Credit credit) {

        // Rule 1: Credit must not be expired
        if (credit.getExpiry().isBefore(LocalDate.now())) {
            System.out.println("Cannot list expired credit.");
            return false;
        }

        // Rule 2: Price must meet minimum price
        if (credit.getPrice() < SystemConfig.getMinCreditPrice()) {
            System.out.println("Price below minimum allowed.");
            return false;
        }

        // Rule 3: Quantity must be positive
        if (credit.getQuantity() <= 0) {
            System.out.println("Invalid credit quantity.");
            return false;
        }

        return true;
    }
}
