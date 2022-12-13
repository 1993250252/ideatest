package com.test.service.impl;

import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.util.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author:ZhaoMeng
 * @Description:
 * @Date:Created 2022/12/10 18:26
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ArticlesServiceImplTest {

    @Autowired
    private IArticlesService articlesService;
    private Articles articles=new Articles();
    @Test
    public void queryByPage() {
        PageBean pageBean=new PageBean();
        List<Articles> articles = articlesService.queryByPage(null, pageBean);
        for (Articles article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void selectOne(){
        Articles articles = articlesService.selectOne(1);
        System.out.println(articles);
    }
}