package com.example.demo.basis.stream;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class Streamdemo {
    static List<TreeEntity>  listTree = new ArrayList<>();
    static {
        listTree.add(new TreeEntity(1,"爷",0,null));
        listTree.add(new TreeEntity(2,"二爷",0,null));
        listTree.add(new TreeEntity(3,"爷-爸",1,null));
        listTree.add(new TreeEntity(4,"爷-叔",1,null));
        listTree.add(new TreeEntity(5,"二爷-爸",2,null));
        listTree.add(new TreeEntity(6,"爷-爸-大儿子",3,null));
        listTree.add(new TreeEntity(7,"爷-爸-小儿子",3,null));
        listTree.add(new TreeEntity(10,"爷-叔-大儿子",4,null));
        listTree.add(new TreeEntity(11,"爷-叔-小儿子",4,null));
        listTree.add(new TreeEntity(8,"二爷-爸-大儿子",5,null));
        listTree.add(new TreeEntity(9,"二爷-爸-小儿子",5,null));
    }

    public static void main(String[] args) {

        selectTree();

        System.out.println(listTree.toString());




    }

    /**
     * 获取树结构
     * @return
     *
     */



    public static List<TreeEntity> selectTree() {
        List<TreeEntity> leve1Menus = listTree.stream().filter(treeEntity ->
                treeEntity.getParentId() == 0
        ).map((menus) ->{
            menus.setChildNodeList(getChildNode(menus,listTree));
            return menus;
        }).collect(Collectors.toList());
        return leve1Menus;
    }
    /**
     * 递归子节点
     * @param root   当前单个菜单
     * @param allListTree   表中的所有菜单集合
     * @return
     */
    private static List<TreeEntity> getChildNode(TreeEntity root, List<TreeEntity> allListTree){
        List<TreeEntity> ChildNodeList = allListTree.stream().filter((treeEntity) -> {
            return treeEntity.getParentId() == root.getId();
        }).map((treeEntity)->{            treeEntity.setChildNodeList(getChildNode(treeEntity,allListTree));
            return treeEntity;
        }).collect(Collectors.toList());
        return ChildNodeList;
    }


}



@ApiModel(value = "树结构信息")
@Data
@AllArgsConstructor
 class TreeEntity {
    @ApiModelProperty("唯一id")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("父类id")
    private Integer parentId;
    @ApiModelProperty("子节点集合")
    private List<TreeEntity> childNodeList;
}
