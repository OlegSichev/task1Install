import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) {

        List<String> newDirectories = List.of("D:/javaHomeworksTemp/Games/src", "D:/javaHomeworksTemp/Games/res",
                "D:/javaHomeworksTemp/Games/savegames", "D:/javaHomeworksTemp/Games/temp",
                "D:/javaHomeworksTemp/Games/src/main", "D:/javaHomeworksTemp/Games/src/test",
                "D:/javaHomeworksTemp/Games/res/drawables", "D:/javaHomeworksTemp/Games/res/vectors",
                "D:/javaHomeworksTemp/Games/res/icons");

        for (String temp : newDirectories) {
            createDirectory(temp);
        }

        createFile("D:/javaHomeworksTemp/Games/src/main", "Main.java");
        createFile("D:/javaHomeworksTemp/Games/src/main", "Utils.java");
        createFile("D:/javaHomeworksTemp/Games/temp", "temp.txt");

        printLog(log);


    }

    public static void createDirectory(String newDirectory) {
        File file = new File(newDirectory);
        if (file.mkdir()) {
            System.out.println("Папка успешно создана");
            log("В пути " + newDirectory + " папка успешно создана. Время создания: "
                    + LocalDateTime.now());
            count++;
        } else {
            System.out.println("Что-то пошло не так");
            log("Ошибка! Не удалось создать в пути " + newDirectory + "папку. Ошибка возникла в " +
                    LocalDateTime.now());
        }
    }

    public static void createFile(String nameDirPath, String nameFile) {
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
            writer.write(logAll + count + " файлов было создано успешно");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}