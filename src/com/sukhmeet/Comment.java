package com.sukhmeet;

/**
 * Created with IntelliJ IDEA.
 * User: sukhmeet
 * Date: 04/09/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
// model  DATA STRUCTURE FOR ROWS
public class Comment {
    private long id;
    private String comment;

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    // Will be used by the ArrayAdapter in the ListView
    public String toString(){
        return comment;
    }
}
