package me.ridog.valentine.service;

import me.ridog.valentine.pojo.auto.Metas;
import me.ridog.valentine.result.MetasResult;

import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
public interface IMetasService {

    List<MetasResult> getAll(String type);

    int addMetas(Metas metas);

    int modifyMetas(Metas metas);

    void deleteMetas(Integer id);
}
