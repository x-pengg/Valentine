package me.ridog.valentine.controller.admin;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.pojo.auto.Content;
import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.service.IContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Tate on 2016/8/1.
 */
@RestController
@RequestMapping("api/admin/post")
//@NeedLogin
public class PostAdminController {

    @Resource
    private IContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPost(Page<Content> page) {
        Page<Content> pages = contentService.getByPageOfAdmin(page);
        return APIResult.newRs().success().data(pages).build();
    }

}
