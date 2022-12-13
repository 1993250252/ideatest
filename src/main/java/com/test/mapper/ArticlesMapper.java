package com.test.mapper;

import com.test.model.Articles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zm
 * @since 2022-12-02
 */
 @Repository
public interface ArticlesMapper extends BaseMapper<Articles> {

      List<Articles> queryByPage(Articles articles);
}
