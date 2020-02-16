package plCoderslabWorkshop2.model;

public class User_group {
    int id;
    String name;

    public User_group(){

    }

    public User_group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User_group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
