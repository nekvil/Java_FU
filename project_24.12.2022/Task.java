import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Task {
    public String id;
    public String startDate;
    public String endDate;
    public String title;
    public String description;
    public boolean isComplete;
    public String pattern = "dd.MM.YYYY";
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Task() {
        this.isComplete = false;
        this.title = title;
        this.description = description;
        this.startDate = simpleDateFormat.format(new Date());
        this.endDate = endDate;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
