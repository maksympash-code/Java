package HW_12;

public class PayCanteenVisitor implements StudentVisitor {

    private final int amount;

    public PayCanteenVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(HumanitarianStudent s) {
        s.pay(amount);
    }

    @Override
    public void visit(NaturalStudent s) {
        s.pay(amount);
    }

    @Override
    public void visit(MixedStudent s) {
        s.pay(amount);
    }
}