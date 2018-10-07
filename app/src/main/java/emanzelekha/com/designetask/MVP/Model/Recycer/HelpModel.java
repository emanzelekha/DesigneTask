package emanzelekha.com.designetask.MVP.Model.Recycer;

public class HelpModel {
    String Title;
    String Time;
    String Attend;
    String type;
    String info;
    int Img;
    boolean Active;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAttend() {
        return Attend;
    }

    public void setAttend(String attend) {
        Attend = attend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
