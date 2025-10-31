import java.util.ArrayList;

public class MusicalShow extends Show {
    private String musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Director director,
                       ArrayList<Actor> listOfActors, String musicAuthor, String librettoText) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibrettoText() {
        System.out.println("Либретто: " + librettoText);
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Автор музыки: " + musicAuthor);
        printLibrettoText();
    }
}