import java.util.ArrayList;

public class Ballet extends MusicalShow {
    private String choreographer;

    public Ballet(String title, int duration, Director director,
                  ArrayList<Actor> listOfActors, String musicAuthor,
                  String librettoText, String choreographer) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }


    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Хореограф: " + choreographer);
        System.out.println("Тип: Балет");
    }
}