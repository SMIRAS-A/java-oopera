import java.util.ArrayList;

public class Performance extends Show {
    private String playAuthor;
    private String genre;

    public Performance(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        super(title, duration, director, listOfActors);
        this.playAuthor = playAuthor;
        this.genre = genre;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Тип: Спектакль");
    }
}