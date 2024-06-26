import models.services.Archive;
import models.services.Subject;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Archive archive = new Archive();
        String subject_name;

        System.out.print("Olá! Qual matéria deseja registrar no caminho " + archive.getPath() + "?\nOu digite `alterar caminho` para alterar o caminho de destino do seu arquivo de texto! ");
        subject_name = sc.nextLine();

        if (subject_name.equalsIgnoreCase("alterar caminho")) {
            String new_path;

            System.out.print("Sim! Você pode alterar o caminho onde suas revisões são salvas. Pode me informar o caminho absoluto? ");
            new_path = sc.nextLine();

            archive.changePath(new_path);

            System.exit(0);
        }

        System.out.print("Certo, irei realizar o registro de " + subject_name + "!\n");

        Subject subject = new Subject(subject_name);

        subject.calculateNextReviews();

        archive.addSubject(subject);

        sc.close();
    }
}
