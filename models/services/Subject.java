package models.services;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private static final int[] intervalsInDays = new int[] {1,3,7,21, 30, 45, 60};
    private static final LocalDate baseDate = LocalDate.now(); // It will be crucial for calculating next review dates
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private List<LocalDate> next_reviews = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void calculateNextReviews() {
        for (int interval : intervalsInDays) {
            next_reviews.add(baseDate.plusDays(interval));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" | Próximas revisões: ");
        for (LocalDate date : next_reviews) {
            sb.append(date.format(fmt));
            sb.append(", ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
