public class Actor extends Person {
    private int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Актёр {" +
                "Имя = " + getName() +
                ", Фамилия = " + getSurname() +
                ", Пол = " + getGender() +
                ", Рост = " + height + " см." +
                '}';
    }
}