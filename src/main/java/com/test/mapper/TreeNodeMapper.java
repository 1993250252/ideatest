package com.test.mapper;

import com.test.model.TreeNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface TreeNodeMapper extends BaseMapper<TreeNode> {

  List<TreeNode> allChecked(@Param("parentId") Integer parentId);
}
