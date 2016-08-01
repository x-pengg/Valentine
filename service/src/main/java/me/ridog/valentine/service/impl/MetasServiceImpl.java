package me.ridog.valentine.service.impl;

import com.google.common.collect.Lists;
import me.ridog.valentine.mapper.IMetasMapper;
import me.ridog.valentine.mapper.auto.MetasMapper;
import me.ridog.valentine.pojo.auto.Metas;
import me.ridog.valentine.result.MetasResult;
import me.ridog.valentine.service.IMetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
@Service
public class MetasServiceImpl implements IMetasService {

    @Autowired
    private IMetasMapper metasMapperEx;
    @Autowired
    private MetasMapper metasMapper;

    public List<MetasResult> getAll(String type) {
        List<Metas> metases = metasMapperEx.selectAll(type);
        ArrayList<MetasResult> MetasResults = Lists.newArrayList();
        for (Metas metase : metases) {
            MetasResult metasResult = new MetasResult();
            metasResult.setMid(metase.getMid());
            metasResult.setName(metase.getName());
            metasResult.setSlug(metase.getSlug());
            metasResult.setDescription(metase.getDescription());
            metasResult.setCount(metase.getCount());
            metasResult.setType(metase.getType());
            MetasResults.add(metasResult);
        }
        return MetasResults;
    }

    public int addMetas(Metas metas) {
        return metasMapper.insert(metas);
    }

    public int modifyMetas(Metas metas) {
        return metasMapper.updateByPrimaryKey(metas);
    }

    public void deleteMetas(Integer id) {
        metasMapper.deleteByPrimaryKey(id);
    }
}
