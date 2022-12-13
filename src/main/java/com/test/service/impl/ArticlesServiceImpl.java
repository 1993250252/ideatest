package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.model.Articles;
import com.test.mapper.ArticlesMapper;
import com.test.service.IArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zm
 * @since 2022-12-02
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements IArticlesService {

    @Autowired
    private ArticlesMapper articlesMapper;

    @Override
    public List<Articles> queryByPage(Articles articles, PageBean pageBean) {
        List<Articles> articlesList = articlesMapper.queryByPage(articles);
        return articlesList;
    }

    @Override
    public Articles selectOne(Integer id) {
        Articles articles = articlesMapper.selectById(id);
        return articles;
    }
}
