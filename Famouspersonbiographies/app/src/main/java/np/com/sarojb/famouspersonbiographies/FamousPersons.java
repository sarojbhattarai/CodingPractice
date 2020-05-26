package np.com.sarojb.famouspersonbiographies;


/*
 * Ahh too much code!
 * we have defined the model what our app contains
 * id is unique to every person
 * name is for the person name
 * field of work is the area of their domain. Eg: Albert Einstein for Science, Sadhguru for spirituality
 * isEnabled is for the favourites.
 * */
public class FamousPersons {
    int id;
    String name;
    String imageUrl;
    String fieldOfWork;
    String shortdesc;
    boolean isEnabled;

    public FamousPersons(int id, String name, String imageUrl, String shortdesc, String fieldOfWork) {
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
        this.fieldOfWork = fieldOfWork;
        this.shortdesc = shortdesc;
        isEnabled = false;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getFieldOfWork() {
        return fieldOfWork;
    }

    public void setFieldOfWork(String fieldOfWork) {
        this.fieldOfWork = fieldOfWork;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "FamousPersons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldOfWork='" + fieldOfWork + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
