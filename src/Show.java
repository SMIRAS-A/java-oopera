import java.util.ArrayList;
import java.util.List;

class Show {
    private String title;
    private int duration;
    private Director director;
    private List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director + " (поставлено спектаклей: " + director.getNumberOfShows() + ")");
    }

    public void printActorsList() {
        System.out.println("Актёры в спектакле " + title + ":");
        for (Actor actor : listOfActors) {
            System.out.println(" - " + actor);
        }
    }

    public void addActor(Actor newActor) {

        if (listOfActors.contains(newActor)) {
            System.out.println("Предупреждение: Актёр " + newActor + " уже есть в спектакле!");
            return;
        }
        listOfActors.add(newActor);
        System.out.println("Актёр " + newActor + " добавлен в спектакль " + title);
    }

    public void replaceActor(Actor newActor, String surnameToReplace) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.surname.equals(surnameToReplace)) {

                if (listOfActors.contains(newActor)) {
                    System.out.println("Предупреждение: Актёр " + newActor + " уже есть в спектакле!");
                    return;
                }

                Actor oldActor = listOfActors.set(i, newActor);
                System.out.println("Актёр " + oldActor + " заменён на " + newActor + " в спектакле " + title);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Предупреждение: Актёр с фамилией " + surnameToReplace + " не найден в спектакле "
                    + title);
        }
    }
}