package me.ridog.valentine.service.impl;

import me.ridog.valentine.mapper.auto.CommentMapper;
import me.ridog.valentine.pojo.auto.Comment;
import me.ridog.valentine.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chan on 16/8/5.
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void comment(Comment comment) {
        commentMapper.insert(comment);
    }
}
