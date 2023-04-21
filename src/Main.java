import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    static StringBuilder log = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) {
        newDir("D:/javaHomeworksTemp/Games", "src");
        newDir("D:/javaHomeworksTemp/Games", "res");
        newDir("D:/javaHomeworksTemp/Games", "savegames");
        newDir("D:/javaHomeworksTemp/Games", "temp");

        newDir("D:/javaHomeworksTemp/Games/src", "main");
        newDir("D:/javaHomeworksTemp/Games/src", "test");

        newFile("D:/javaHomeworksTemp/Games/src/main", "Main.java");
        newFile("D:/javaHomeworksTemp/Games/src/main", "Utils.java");

        newDir("D:/javaHomeworksTemp/Games/res", "drawables");
        newDir("D:/javaHomeworksTemp/Games/res", "vectors");
        newDir("D:/javaHomeworksTemp/Games/res", "icons");

        newFile("D:/javaHomeworksTemp/Games/temp", "temp.txt");

        printLog(log);


    }

    public static void newDir(String nameDirPath, String nameDir) {
        File newDir = new File(nameDirPath, nameDir);
        if (newDir.mkdir()) {
            System.out.println("Папка успешно создана");
            log("В пути " + nameDirPath + " создана папка " + nameDir + " в " + LocalDateTime.now());
            count++;
        } else {
            System.out.println("Что-то пошло не так");
            log("Ошибка! Не удалось создать в пути " + nameDirPath + " папку " + nameDir +
                    " . Ошибка возникла в " + LocalDateTime.now());
        }
    }

    public static void newFile(String nameDirPath, String nameFile) {
        File newFile = new File(nameDirPath, nameFile);
        try {
            if (newFile.createNewFile())
                System.out.println("Файл был создан");
            log("В пути " + nameDirPath + " создан файл " + nameFile + " в " + LocalDateTime.now());
            count++;
        } catch (IOException ex) {
            log("Ошибка! Не удалось создать в пути " + nameDirPath + " файл " + nameFile +
                    " . Ошибка возникла в " + LocalDateTime.now());
            System.out.println(ex.getMessage());
        }
    }

    public static void log(String status) {
        log.append(status);
        log.append("\n");
    }

    public static void printLog(StringBuilder log) {

        String logAll = String.valueOf(log);
        try (FileWriter writer = new FileWriter("D:/javaHomeworksTemp/Games/temp/temp.txt", true)) {
            writer.write(logAll);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}