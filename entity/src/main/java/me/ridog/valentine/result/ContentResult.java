package me.ridog.valentine.result;

import me.ridog.valentine.pojo.auto.Comment;
import me.ridog.valentine.pojo.auto.Content;

import java.util.List;

/**
 * Created by Tate on 2016/8/5.
 */
public class ContentResult extends Content {

    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}
