package me.ridog.valentine.service;

import me.ridog.valentine.pojo.auto.Meta;
import me.ridog.valentine.result.MetaResult;

import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
public interface IMetaService {

    List<MetaResult> getAll();

    int addMeta(Meta meta);

    int modifyMeta(Meta meta);

    void deleteMeta(Integer id);
}
