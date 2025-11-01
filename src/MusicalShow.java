class MusicalShow extends Show {
    private String musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Director director, String musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто спектакля " + getTitle() + ":");
        System.out.println("Текст: " + librettoText);
    }

    public void printMusicInfo() {
        System.out.println("Автор музыки: " + musicAuthor);
    }
}