package com.ywyt.springboot3.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author xiejin
 * @date 2019/9/12 14:10
 */
//参数说明
//    indexName :索引库的名称（相当于数据库的database），建议以项目的名称命名
//    type      :类型（相当于数据库中的table），建议以实体类的名称命名
//    shards    :默认分区数（default=5）
//    replicas  :每个分区默认的备份数(default 1)
//    refreshInterval:刷新间隔(default "1s")
//    indexStorType：索引文件存储类型（default "fs")
@Document(indexName = "libary",type = "books")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
public class Book implements Serializable{
    private static final long serialVersionUID = 7038393730004902715L;
    //在使用@Data的时候，这里必须由@Id，否则es中的id为null
    @Id
    private String id ;
    private String title;
    private String author;
    private String releaseDate;
}
