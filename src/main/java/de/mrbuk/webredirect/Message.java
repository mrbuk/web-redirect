package de.mrbuk.webredirect;

import java.util.Date;

public class Message {
    private Date created;
    private String text;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
