package me.ridog.valentine.controller.admin;

import me.ridog.valentine.APIResult;
import me.ridog.valentine.Constants;
import me.ridog.valentine.annotation.NeedLogin;
import me.ridog.valentine.pojo.auto.Metas;
import me.ridog.valentine.result.MetasResult;
import me.ridog.valentine.service.IMetasService;
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
@RequestMapping("api/categorie")
//@NeedLogin
public class CategorieController {

    @Resource
    private IMetasService metasService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCategories(){
        List<MetasResult> metas = metasService.getAll(Constants.CATEGORIE);
        return APIResult.newRs().success().data(metas).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCategories(Metas metas){
        metas.setType(Constants.CATEGORIE);
        metasService.addMetas(metas);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String modifyCategories(Metas metas){
        metasService.modifyMetas(metas);
        metas.setType(Constants.CATEGORIE);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(value = "/{id:[0-9]+}",method = RequestMethod.DELETE)
    public String deleteCategories(@PathVariable("id") Integer id){
        metasService.deleteMetas(id);
        return APIResult.newRs().success().build();
    }
}
