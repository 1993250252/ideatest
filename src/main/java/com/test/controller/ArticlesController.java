package com.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.model.Articles;
import com.test.service.IArticlesService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zm
 * @since 2022-12-02
 */
@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticlesController {

    @Autowired
    private IArticlesService articlesService;

    @RequestMapping("/list")
    public JsonResponseBody query(Articles articles, PageBean pageBean){
        List<Articles> articlesList = articlesService.queryByPage(articles,pageBean);
        if(null==articlesList&&articlesList.size()==0){
            return new JsonResponseBody(JsonResponseStatus.ERROR.getCode(),JsonResponseStatus.ERROR.getMsg());
        }
        else{

            return new JsonResponseBody(articlesList,(long)pageBean.getTotal());
        }
    }

}
