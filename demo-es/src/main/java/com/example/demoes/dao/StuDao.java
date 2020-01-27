package com.example.demoes.dao;

import com.example.demoes.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demo-es
 * @Package com.example.demoes.dao
 * @date 2020/1/15 10:15 星期三
 */
@Component
public interface StuDao extends ElasticsearchRepository<Student,Long> {

}
