package me.ridog.valentine.controller.custom;

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
            if (index >= 0) {
                content.setText(content.getText().substring(0, index) + "...");
            } else if (content.getText().length() > 100) {
                content.setText(content.getText().substring(0, 100) + "...");
            }
        }
        return APIResult.newRs().success().data(pages).build();
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public String getPost(@PathVariable("key") Object key) {
        if (key instanceof Integer) {
            return APIResult.newRs().success().data(contentService.getById((Integer) key)).build();
        } else {
            return APIResult.newRs().success().data(contentService.getBySlug((String) key)).build();
        }
    }

    @RequestMapping(value = "archive", method = RequestMethod.GET)
    public String getArchive() {
        return APIResult.newRs().success().data(contentService.getArchive()).build();
    }

}
