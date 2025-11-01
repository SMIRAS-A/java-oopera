public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Артём", "Смирнов", Gender.MALE, 180);
        Actor actor2 = new Actor("Ирина", "Смирнова", Gender.FEMALE, 165);
        Actor actor3 = new Actor("Сергей", "Скудра", Gender.MALE, 182);

        Director director1 = new Director("Иван", "Малюк", Gender.MALE, 158);
        Director director2 = new Director("Ольга", "Свиридова", Gender.FEMALE, 3);

        String musicAuthor = "Энди Дэрисов";
        String choreographer = "Альб Энштейнич";

        Show regularShow = new Show("Спектакль", 134, director1);
        Opera opera = new Opera("Фантом", 175, director2, musicAuthor
                , "Текст либретто оперы Фантом", 666);
        Ballet ballet = new Ballet("Лебединое озеро", 100, director1, musicAuthor
                , "Текст либретто балета Лебединое озеро", choreographer);

        System.out.println("РАСПРЕДЕЛЯЕМ АКТЁРОВ ПО ШОУ");
        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        System.out.println("\nЗАМЕНА АКТЁРА");
        ballet.replaceActor(actor2, "Смирнов");

        System.out.println("\nПОПЫТКА ЗАМЕНИТЬ НЕСУЩЕСТВУЮЩЕГО АКТЁРА");
        opera.replaceActor(actor1, "Доздрапермов");

        System.out.println("\nСПИСКИ АКТЁРОВ ПОСЛЕ ЗАМЕНЫ");
        ballet.printActorsList();

        System.out.println("\nИНФОРМАЦИЯ О РЕЖИССЁРАХ");
        regularShow.printDirectorInfo();
        opera.printDirectorInfo();

        System.out.println("\nЛИБРЕТТО");
        opera.printLibretto();
        System.out.println();
        ballet.printLibretto();

        System.out.println("\nДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ");
        System.out.println("Для оперы Фантом:");
        opera.printMusicInfo();
        System.out.println("Размер хора: " + opera.getChoirSize() + " человек");
        System.out.println("\nДля балета Лебединое озеро:");
        ballet.printMusicInfo();
        ballet.printChoreographerInfo();
    }
}