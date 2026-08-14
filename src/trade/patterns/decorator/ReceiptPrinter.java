package trade.patterns.decorator;

import trade.model.Receipt;

/*
 * ReceiptPrinter defines a common method
 * for printing receipt details.
 */
public interface ReceiptPrinter {

    // Prints receipt information
    void print(Receipt receipt);
}
