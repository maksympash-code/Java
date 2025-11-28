package Practice_12;

public class GeneralStaff implements MilitaryObject{
    public String title;
    public int generals;
    public int secretPapers;

    public GeneralStaff(String title, int generals, int secretPapers) {
        this.title = title;
        this.generals = generals;
        this.secretPapers = secretPapers;
    }

    @Override
    public String toString() {
        return "General Staff " + title + " has " + generals + " generals and " + secretPapers + " secret papers.";
    }


    @Override
    public void accept(Spy spy) {
        spy.visit(this);
    }
}
