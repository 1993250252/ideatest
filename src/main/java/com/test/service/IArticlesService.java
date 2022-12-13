package com.test.service;

import com.test.model.Articles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.util.PageBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zm
 * @since 2022-12-02
 */
@Transactional
public interface IArticlesService extends IService<Articles> {

    List<Articles> queryByPage(Articles articles, PageBean pageBean);

    @Cacheable("dd")
    Articles selectOne(Integer id);
}
