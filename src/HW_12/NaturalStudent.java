package HW_12;

public class NaturalStudent extends AbstractStudent {

    public NaturalStudent(int requiredCredits, int initialMoney) {
        super(requiredCredits, initialMoney);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}