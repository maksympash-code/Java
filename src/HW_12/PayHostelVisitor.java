package HW_12;

public class PayHostelVisitor implements StudentVisitor {

    private final int amount;

    public PayHostelVisitor(int amount) {
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