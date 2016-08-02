package me.ridog.valentine.controller.admin;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.Constants;
import me.ridog.valentine.pojo.auto.Meta;
import me.ridog.valentine.result.MetaResult;
import me.ridog.valentine.service.IMetaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
@RestController
@RequestMapping("api/tag")
//@NeedLogin
public class TagController {

    @Resource
    private IMetaService MetaService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTags(){
        List<MetaResult> Meta = MetaService.getAll(Constants.TAG);
        return APIResult.newRs().success().data(Meta).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addTag(Meta meta) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(meta.getSlug()));
        meta.setType(Constants.TAG);
        MetaService.addMeta(meta);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String modifyTag(Meta meta) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(meta.getSlug()));
        meta.setType(Constants.TAG);
        MetaService.modifyMeta(meta);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(value = "/{id:[0-9]+}",method = RequestMethod.DELETE)
    public String deleteTag(@PathVariable("id") Integer id){
        MetaService.deleteMeta(id);
        return APIResult.newRs().success().build();
    }

}
