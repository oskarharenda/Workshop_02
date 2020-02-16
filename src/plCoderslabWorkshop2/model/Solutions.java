package plCoderslabWorkshop2.model;

public class Solutions {
    private int id;
    private String created;
    private String updated;
    private String description;
    private int exercises_id;
    private int user_id;

    public Solutions(){

    }

    public Solutions(int id, String created, String updated, String description, int exercises_id, int user_id) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercises_id = exercises_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(int exercises_id) {
        this.exercises_id = exercises_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Solutions{" +
                "id=" + id +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", description='" + description + '\'' +
                ", exercises_id=" + exercises_id +
                ", user_id=" + user_id +
                '}';
    }
}
