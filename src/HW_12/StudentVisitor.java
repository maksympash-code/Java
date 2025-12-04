package HW_12;

public interface StudentVisitor {
    void visit(HumanitarianStudent s);
    void visit(NaturalStudent s);
    void visit(MixedStudent s);
}