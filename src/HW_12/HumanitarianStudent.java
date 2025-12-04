package HW_12;

public class HumanitarianStudent extends AbstractStudent {

    public HumanitarianStudent(int requiredCredits, int initialMoney) {
        super(requiredCredits, initialMoney);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}