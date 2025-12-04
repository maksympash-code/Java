package HW_12;

public class StudentFactory {

    public static Student createStudent(String dirStr, int requiredCredits, int initialMoney) {
        switch (dirStr) {
            case "humanitarian":
            case "гуманітарний":
                return new HumanitarianStudent(requiredCredits, initialMoney);
            case "natural":
            case "природничий":
                return new NaturalStudent(requiredCredits, initialMoney);
            case "mixed":
            case "природничо-гуманітарний":
                return new MixedStudent(requiredCredits, initialMoney);
            default:
                // якщо щось дивне — вважаємо змішаним
                return new MixedStudent(requiredCredits, initialMoney);
        }
    }
}