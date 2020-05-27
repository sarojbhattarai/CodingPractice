package np.com.sarojb.famouspersonbiographies;

import java.util.ArrayList;

public class AllData {
    public static ArrayList<FamousPersons> famousPerson;
    public static ArrayList<FamousPersons> favouritePerson;

    public AllData() {
        famousPerson = new ArrayList<>();
        favouritePerson = new ArrayList<>();
        initData();
    }

    public static ArrayList<FamousPersons> getFamousPerson() {
        return famousPerson;
    }

    private void initData() {
        if (famousPerson != null) {
            famousPerson.add(new FamousPersons(1, "Albert Einstein", "https://www.nobelprize.org/images/einstein-12923-portrait-medium.jpg", "Genius", "Science","ONe of the brilliant mind of 20th century. His work to theory of relativity is pheonmenol."));
            famousPerson.add(new FamousPersons(2, "Saroj Bhattarai", "https://avatars2.githubusercontent.com/u/24388126?s=460&u=aae9af7c00dd6299cf9f4520678e256437e695ff&v=4", "Programmer", "Software Engineering","One of the pioneer in Software Engineering in Nepal"));
        }
    }

    public FamousPersons getPersonByID(int id) {
        for (FamousPersons fp : famousPerson) {
            if (fp.getId() == id) {
                return fp;
            }
        }
        return null;
    }
}
