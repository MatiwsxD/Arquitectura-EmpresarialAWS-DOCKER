import java.util.Date;
public class Mensaje {
    private String info;
    private Date date;
    public Mensaje(String info){
        this.info=info;
        this.date = new Date();
    }
    public Mensaje(String info, Date date){
        this.info=info;
        this.date = date;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getDate() {
        return date.toString();
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
