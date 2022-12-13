package com.test.service;

import com.test.model.TreeNode;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface ITreeNodeService extends IService<TreeNode> {

    List<TreeNode> allChecked(Integer parentId);
}
