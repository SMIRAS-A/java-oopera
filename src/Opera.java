import java.util.ArrayList;

public class Opera extends MusicalShow {
    private String choir;

    public Opera(String title, int duration, Director director,
                 ArrayList<Actor> listOfActors, String musicAuthor,
                 String librettoText, String choir) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choir = choir;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Хор: " + choir);
        System.out.println("Тип: Опера");
    }
}