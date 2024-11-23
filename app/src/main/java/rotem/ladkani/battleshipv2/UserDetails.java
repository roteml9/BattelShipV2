package rotem.ladkani.battleshipv2;

public class UserDetails {
    private String usrPsw;
    private String usrEmail;
    private String usrPhone;

    public UserDetails(String usrPsw, String usrEmail, String usrPhone) {
        this.usrPsw = usrPsw;
        this.usrEmail = usrEmail;
        this.usrPhone = usrPhone;
    }

    public UserDetails() {

    }

    public String getUsrPsw() {
        return usrPsw;
    }

    public void setUsrPsw(String usrPsw) {
        this.usrPsw = usrPsw;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPhone() {
        return usrPhone;
    }

    public void setUsrPhone(String usrPhone) {
        this.usrPhone = usrPhone;
    }
}