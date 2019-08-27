package TreeImplService;

import Tree.TreeImpl;

import java.util.ArrayList;
import java.util.List;

public class TreeImplService {

    public TreeImpl<Integer> getNewTree(){
        TreeImpl<Integer> treeRes = new TreeImpl<Integer>();
        for (int i = 0; i < 60; i++) {
            treeRes.add((int) ((Math.random()*200) - 100));
        }
        return treeRes;
    }

    public List<TreeImpl<Integer>> getTreePack(int count) {
        List<TreeImpl<Integer>> treeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            treeList.add(getNewTree());
        }
        return treeList;
    }

    public static void main(String[] args) {

        TreeImplService ts =new TreeImplService();
        for (TreeImpl<Integer> tree : ts.getTreePack(20)) {
            tree.display();
            System.out.println("Balansed: "+tree.isBalanced());
        }
    }

}
