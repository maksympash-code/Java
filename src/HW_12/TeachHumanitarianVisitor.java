package HW_12;

public class TeachHumanitarianVisitor implements StudentVisitor {

    private final int credits;

    public TeachHumanitarianVisitor(int credits) {
        this.credits = credits;
    }

    @Override
    public void visit(HumanitarianStudent s) {
        s.addCredits(credits);
    }

    @Override
    public void visit(NaturalStudent s) {
        // гуманітарний викладач не може навчати природничого студента
    }

    @Override
    public void visit(MixedStudent s) {
        s.addCredits(credits);
    }
}