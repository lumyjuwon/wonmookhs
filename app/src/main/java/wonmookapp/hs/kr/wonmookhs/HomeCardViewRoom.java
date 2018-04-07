package wonmookapp.hs.kr.wonmookhs;

/**
 * Created by aruffolo on 7/13/16.
 */
public class HomeCardViewRoom {

    private String homename;
    private String homedate;
    private String homedescription;

    public HomeCardViewRoom() {

    }

    public HomeCardViewRoom(String homename, String homedate, String homedescription){
        this.homename = homename;
        this.homedate = homedate;
        this.homedescription = homedescription;
    }

    public String gethomeName() {
        return homename;
    }

    public void sethomeName(String homename) {
        this.homename = homename;
    }

    public String gethomeDate() {
        return homedate;
    }

    public void sethomeDate(String homedate) {
        this.homedate = homedate;
    }

    public String gethomeDescription() {
        return homedescription;
    }

    public void sethomeDescription(String homedescription) {
        this.homedescription = homedescription;
    }
}
