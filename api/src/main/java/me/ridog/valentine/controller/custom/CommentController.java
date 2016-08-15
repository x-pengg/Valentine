package me.ridog.valentine.controller.custom;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import me.ridog.valentine.controller.BaseController;
import me.ridog.valentine.param.CommentParam;
import me.ridog.valentine.pojo.auto.Comment;
import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by chan on 16/8/5.
 */
@RestController
@RequestMapping("api/comment")
public class CommentController extends BaseController {

    @Resource
    private ICommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public String comment(@ModelAttribute CommentParam commentParam) {

        Preconditions.checkArgument(null != commentParam.getCid());
        Preconditions.checkArgument(!Strings.isNullOrEmpty(commentParam.getAuthor()));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(commentParam.getEmail()));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(commentParam.getEmail()));

        Comment comment = new Comment();
        comment.setText(commentParam.getContent());
        comment.setMail(commentParam.getEmail());
        comment.setAuthor(commentParam.getAuthor());
        comment.setCid(commentParam.getCid());
        comment.setCreated(new Date());
        comment.setAgent(ctx().ua());
        comment.setIp(ctx().ip());

        if (!Strings.isNullOrEmpty(commentParam.getSite())) {
            if (commentParam.getSite().indexOf("://") >= 0) {
                comment.setUrl("http://" + commentParam.getSite());
            } else {
                comment.setUrl(commentParam.getSite());
            }
        }

        commentService.comment(comment);

        return APIResult.newRs().success().build();
    }
}
