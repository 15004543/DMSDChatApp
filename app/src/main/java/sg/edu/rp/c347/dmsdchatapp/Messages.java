package sg.edu.rp.c347.dmsdchatapp;

import java.io.Serializable;

/**
 * Created by 15004543 on 15/8/2017.
 */

public class Messages implements Serializable{
    String text, time, user;

    public Messages(){

    }
    public Messages(String text, String time, String user) {
        this.text = text;
        this.time = time;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
