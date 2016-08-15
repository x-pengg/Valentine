package me.ridog.valentine.controller.admin;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import me.ridog.valentine.pojo.auto.Meta;
import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.Constants;
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
@RequestMapping("api/admin/categorie")
//@NeedLogin
public class CategorieController {

    @Resource
    private IMetaService MetaService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCategories(){
        List<MetaResult> Meta = MetaService.getAll();
        return APIResult.newRs().success().data(Meta).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCategories(Meta Meta) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(Meta.getSlug()));
        MetaService.addMeta(Meta);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String modifyCategories(Meta meta) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(meta.getSlug()));
        MetaService.modifyMeta(meta);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(value = "/{id:[0-9]+}",method = RequestMethod.DELETE)
    public String deleteCategories(@PathVariable("id") Integer id){
        MetaService.deleteMeta(id);
        return APIResult.newRs().success().build();
    }
}
