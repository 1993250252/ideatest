package com.test.service.impl;

import com.test.model.TreeNode;
import com.test.mapper.TreeNodeMapper;
import com.test.service.ITreeNodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TreeNodeServiceImpl extends ServiceImpl<TreeNodeMapper, TreeNode> implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public List<TreeNode> allChecked(Integer parentId) {
        List<TreeNode> treeNodes = treeNodeMapper.allChecked(parentId);
        if(null!=treeNodes&&treeNodes.size()>0){
            for (TreeNode treeNode : treeNodes) {
                if(treeNode.getTreeNodeType()!=2){
                    List<TreeNode> children = allChecked(treeNode.getTreeNodeId());
                    treeNode.setChildren(children);
                }
            }
        }
        return treeNodes;
    }
}
