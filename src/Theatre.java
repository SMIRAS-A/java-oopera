import java.util.Scanner;

public class Theatre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Show showManager = new Show();

        while (true) {
            printMainMenu();
            byte cmd = scanner.nextByte();

            switch (cmd) {
                case 1:
                    showManager.addShow();
                    break;
                case 2:
                    showManager.showAShow();
                    break;
                case 3:
                    showManager.replaceActorInShow();
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    public static void printMainMenu() {
        System.out.println("Введите команду: " +
                "\n1 - Создать шоу" +
                "\n2 - Показать шоу" +
                "\n3 - Заменить актёра" +
                "\n4 - Выход из программы");
    }
}