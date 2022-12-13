package com.test.controller;


import com.test.model.TreeNode;
import com.test.service.ITreeNodeService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
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
@RequestMapping("/treenode")
@CrossOrigin
public class TreeNodeController {
    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping("all")
    public JsonResponseBody all(){
        List<TreeNode> treeNodes = treeNodeService.allChecked(null);
        if(null!=treeNodes&&treeNodes.size()>0){
            return new JsonResponseBody(treeNodes);
        }else{
            return new JsonResponseBody(JsonResponseStatus.CREATEMENU.getCode(),JsonResponseStatus.CREATEMENU.getMsg());
        }
    }
}
