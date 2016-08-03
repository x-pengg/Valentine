package me.ridog.valentine.controller.admin;

import me.ridog.valentine.Constants;
import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.service.IContentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Tate on 2016/8/1.
 */
@RestController
@RequestMapping("api/post")
//@NeedLogin
public class PostController {

    @Resource
    private IContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPost(Page<Content> page) {
        Page<Content> pages = contentService.getByPage(page);
        for (Content content : pages.getPageData()) {
            int index = content.getText().indexOf(Constants.MORE);
            if (index >= 0)
                content.setText(content.getText().substring(0, index) + "...");
        }
        return APIResult.newRs().success().data(pages).build();
    }

    @RequestMapping(value = "/{cid}", method = RequestMethod.GET)
    public String getPost(@PathVariable("cid") Integer cid) {
        return APIResult.newRs().success().data(contentService.getById(cid)).build();
    }

}
