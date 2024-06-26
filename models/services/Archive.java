package models.services;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archive {
    private static final Path absolutePathToFilePath = Paths.get(System.getProperty("user.dir"), "config", "file_path.txt");

    private String path;

    public Archive() {
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePathToFilePath.toFile()))) {
            String pathFile = br.readLine();

            if (pathFile == null || pathFile.isEmpty()) {
                this.path = System.getProperty("user.dir"); // Will use this directory / project as destiny
            } else {
                this.path = pathFile;
            }

        } catch (IOException e) {
            System.out.print("Um erro aconteceu durante a leitura do arquivo: " + e.getMessage());
        }
    }

    public String getPath() {
        // In case we are dealing with a Windows Platform
        if (path.contains("\\")) {
            path = path.replace("\\", "/"); // Converts to Java Format, if in Windows
        }
        return path;
    }

    public void changePath(String new_path) {
        try { // Checks if the path informed is valid
            Paths.get(new_path);
        } catch (InvalidPathException | NullPointerException e) {
            System.out.println("Opa, algo de errado com seu caminho informado: " + e.getMessage());
            System.exit(-1);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePathToFilePath.toFile()))) {
            bw.write(new_path);
        } catch (IOException e) {
            System.out.print("Um erro aconteceu durante a escrita do arquivo: " + e.getMessage());
        }
    }

    public void addSubject(Subject sub) {
        File fileOfSubjects = new File(getPath(), "subjects.txt");

        try {
            fileOfSubjects.createNewFile(); // Its return doesn't matter in this context
        } catch (IOException createE) {
            System.out.print("Error ao criar o arquivo de matérias: " + createE.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOfSubjects, true))) {
            bw.write(sub.toString());
            bw.newLine();
        } catch (IOException writeE) {
            System.out.print("Error ao adicionar uma matéria no arquivo de matérias: " + writeE.getMessage());
        }
    }
}
