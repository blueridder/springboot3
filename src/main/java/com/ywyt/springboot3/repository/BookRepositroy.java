package com.ywyt.springboot3.repository;

import com.ywyt.springboot3.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author xiejin
 * @date 2019/9/12 20:48
 */
@Component
public interface BookRepositroy extends ElasticsearchRepository<Book,String> {

}
