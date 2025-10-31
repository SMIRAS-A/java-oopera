public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, Gender gender) {
        super(name, surname, gender);
        this.numberOfShows = 0;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    public void incrementNumberOfShows() {
        this.numberOfShows++;
    }

    @Override
    public String toString() {
        return "Режиссёр {"
                + "Имя = " + getName()
                + ", Фамилия = " + getSurname()
                + ", Пол = " + getGender()
                + ", Количество поставленных спектаклей = " + numberOfShows + "}";
    }
}