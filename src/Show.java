import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Show> shows = new ArrayList<>();
    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<Director> directors = new ArrayList<>();

    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;

        director.incrementNumberOfShows();
    }

    public Show() {

    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void showDetails() {
        System.out.println("Название: " + title);
        System.out.println("Продолжительность: " + duration + " минут");
        System.out.println("Режиссер: " + director.getName() + " " + director.getSurname()
                + " (поставленных шоу: " + director.getNumberOfShows() + ")");
        System.out.println("Актеры:");
        for (Actor actor : listOfActors) {
            System.out.println("  - " + actor);
        }
    }

    public void addShow() {
        System.out.println("Выберите тип шоу:");
        System.out.println("1 - Спектакль");
        System.out.println("2 - Опера");
        System.out.println("3 - Балет");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите название шоу:");
        String title = scanner.nextLine();

        System.out.println("Введите продолжительность (в минутах):");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Director director = selectOrCreateDirector();

        ArrayList<Actor> showActors = selectActors();

        switch (choice) {
            case 1:
                Performance performance = new Performance(title, duration, director, showActors);
                shows.add(performance);
                System.out.println("Спектакль добавлен!");
                break;
            case 2:
                System.out.println("Введите автора музыки:");
                String operaMusicAuthor = scanner.nextLine();

                System.out.println("Введите текст либретто:");
                String operaLibrettoText = scanner.nextLine();

                System.out.println("Введите название хора:");
                String choir = scanner.nextLine();

                Opera opera = new Opera(title, duration, director, showActors, operaMusicAuthor, operaLibrettoText
                        , choir);
                shows.add(opera);
                System.out.println("Опера добавлена!");
                break;
            case 3:
                System.out.println("Введите автора музыки:");
                String musicAuthor = scanner.nextLine();

                System.out.println("Введите текст либретто:");
                String librettoText = scanner.nextLine();

                System.out.println("Введите имя хореографа:");
                String choreographer = scanner.nextLine();

                Ballet ballet = new Ballet(title, duration, director, showActors, musicAuthor, librettoText
                        , choreographer);
                shows.add(ballet);
                System.out.println("Балет добавлен!");
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private Director selectOrCreateDirector() {
        while (true) {
            System.out.println("Выбор режиссера:");
            System.out.println("1 - Выбрать существующего режиссера");
            System.out.println("2 - Создать нового режиссера");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (directors.isEmpty()) {
                        System.out.println("Нет доступных режиссеров! Создайте нового.");
                        break;
                    }
                    System.out.println("Доступные режиссеры:");
                    for (int i = 0; i < directors.size(); i++) {
                        System.out.println((i + 1) + " - " + directors.get(i).getName() + " "
                                + directors.get(i).getSurname() + " (шоу: " + directors.get(i).getNumberOfShows()
                                + ")");
                    }
                    System.out.println("Выберите номер режиссера:");
                    int directorIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (directorIndex >= 0 && directorIndex < directors.size()) {
                        return directors.get(directorIndex);
                    } else {
                        System.out.println("Неверный номер!");
                    }
                    break;
                case 2:
                    return createNewDirector();
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    private Director createNewDirector() {
        System.out.println("Введите имя режиссера:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию режиссера:");
        String surname = scanner.nextLine();

        System.out.println("Выберите пол (1 - МУЖСКОЙ, 2 - ЖЕНСКИЙ):");
        int genderChoice = scanner.nextInt();
        scanner.nextLine();
        Gender gender = Gender.UNKNOWN;
        switch (genderChoice) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        for (Director existingDirector : directors) {
            if (existingDirector.getName().equals(name) && existingDirector.getSurname().equals(surname)) {
                System.out.println("Такой режиссер уже существует! Используем существующего.");
                return existingDirector;
            }
        }

        Director newDirector = new Director(name, surname, gender);
        directors.add(newDirector);
        System.out.println("Режиссер создан!");
        return newDirector;
    }

    private ArrayList<Actor> selectActors() {
        ArrayList<Actor> selectedActors = new ArrayList<>();

        while (true) {
            System.out.println("Выбор актёра:");
            System.out.println("1 - Добавить существующего актера");
            System.out.println("2 - Создать нового актера");
            System.out.println("3 - Завершить выбор актеров");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (actors.isEmpty()) {
                        System.out.println("Нет доступных актеров!");
                        break;
                    }
                    System.out.println("Доступные актеры:");
                    for (int i = 0; i < actors.size(); i++) {
                        System.out.println((i + 1) + " - " + actors.get(i));
                    }
                    System.out.println("Выберите номер актера:");
                    int actorIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (actorIndex >= 0 && actorIndex < actors.size()) {
                        selectedActors.add(actors.get(actorIndex));
                        System.out.println("Актер добавлен в шоу!");
                    } else {
                        System.out.println("Неверный номер!");
                    }
                    break;
                case 2:
                    addActor();
                    if (!actors.isEmpty()) {
                        selectedActors.add(actors.get(actors.size() - 1));
                    }
                    break;
                case 3:
                    return selectedActors;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    public void addActor() {
        System.out.println("Введите имя актёра:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию актёра:");
        String surname = scanner.nextLine();

        System.out.println("Выберите пол (1 - МУЖСКОЙ, 2 - ЖЕНСКИЙ):");
        int genderChoice = scanner.nextInt();
        scanner.nextLine();
        Gender gender = Gender.UNKNOWN;
        switch (genderChoice) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        System.out.println("Введите рост актёра:");
        int height = scanner.nextInt();
        scanner.nextLine();

        boolean actorExists = actors.stream()
                .anyMatch(actor -> actor.getName().equals(name)
                        && actor.getSurname().equals(surname)
                        && actor.getHeight() == height);

        if (actorExists) {
            System.out.println("Такой актёр уже есть, его добавить нельзя");
        } else {
            Actor newActor = new Actor(name, surname, gender, height);
            actors.add(newActor);
            System.out.println("Актер добавлен!");
        }
    }

    public void showAShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет доступных шоу!");
            return;
        }

        System.out.println("Доступные шоу:");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + " - " + shows.get(i).getTitle());
        }

        System.out.println("Выберите номер шоу:");
        int showIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (showIndex >= 0 && showIndex < shows.size()) {
            shows.get(showIndex).showDetails();
        } else {
            System.out.println("Неверный номер!");
        }
    }

    public void replaceActorInShow() {
        if (shows.isEmpty()) {
            System.out.println("Нет доступных шоу!");
            return;
        }

        System.out.println("Доступные шоу:");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + " - " + shows.get(i).getTitle());
        }

        System.out.println("Выберите номер шоу для замены актёра:");
        int showIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (showIndex < 0 || showIndex >= shows.size()) {
            System.out.println("Неверный номер!");
            return;
        }

        Show selectedShow = shows.get(showIndex);
        ArrayList<Actor> showActors = selectedShow.getListOfActors();

        if (showActors.isEmpty()) {
            System.out.println("В выбранном шоу нет актёров для замены!");
            return;
        }

        if (actors.isEmpty()) {
            System.out.println("Нет доступных актёров для замены!");
            return;
        }

        System.out.println("Актёры в шоу " + selectedShow.getTitle() + ":");
        for (int i = 0; i < showActors.size(); i++) {
            System.out.println((i + 1) + " - " + showActors.get(i));
        }

        System.out.println("Выберите номер актёра, которого хотите заменить:");
        int actorToReplaceIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (actorToReplaceIndex < 0 || actorToReplaceIndex >= showActors.size()) {
            System.out.println("Неверный номер актёра!");
            return;
        }

        Actor actorToReplace = showActors.get(actorToReplaceIndex);

        System.out.println("Доступные актёры для замены:");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println((i + 1) + " - " + actors.get(i));
        }

        System.out.println("Выберите номер актёра, который будет заменять:");
        int newActorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (newActorIndex < 0 || newActorIndex >= actors.size()) {
            System.out.println("Неверный номер актёра!");
            return;
        }

        Actor newActor = actors.get(newActorIndex);

        if (actorToReplace.equals(newActor)) {
            System.out.println("Это тот же самый актёр! Замена не требуется.");
            return;
        }

        showActors.set(actorToReplaceIndex, newActor);
        System.out.println("Актёр " + actorToReplace.getName() + " " + actorToReplace.getSurname()
                + " заменён на " + newActor.getName() + " " + newActor.getSurname()
                + " в шоу " + selectedShow.getTitle());
    }
}