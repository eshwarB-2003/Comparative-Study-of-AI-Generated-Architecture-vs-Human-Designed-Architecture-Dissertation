package trade.patterns.decorator;

/*
 * ReceiptorDecorator is the base class
 * for all receipt decorators.
 * It wraps another ReceiptPrinter.
 */
public abstract class ReceiptorDecorator implements ReceiptPrinter {

    // Wrapped receipt printer
    protected ReceiptPrinter printer;

    // Constructor sets the wrapped printer
    public ReceiptorDecorator(ReceiptPrinter printer) {
        this.printer = printer;
    }
}
