package TreeImplService;

import SortedArr.SortedArrayImpl;
import Tree.TreeImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TreeImplService {

    public TreeImpl<Integer> getNewTree(){
        TreeImpl<Integer> treeRes = new TreeImpl<Integer>();
        for (int i = 0; i < 60; i++) {
            treeRes.add((int) ((Math.random()*200) - 100));
        }
        return new GetterBalanceTree(treeRes).globalTree;
    }

    public List<TreeImpl<Integer>> getTreePack(int count) {
        List<TreeImpl<Integer>> treeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            treeList.add(getNewTree());
        }
        return treeList;
    }

    private class GetterBalanceTree{
        private TreeImpl<Integer> globalTree = new TreeImpl<Integer>();

        public GetterBalanceTree(TreeImpl<Integer> globalTree) {
            getBalanceTree(globalTree);
        }

        public void getBalanceTree(TreeImpl<Integer> tree){
            Object[] sortArr= tree.toSortedList().getArray();
            addValues(sortArr, 0, sortArr.length-1);
        }

        public void addValues(Object[] sortArr, int from, int to){
            if(to == from) {
                globalTree.add((Integer) sortArr[to]);
                return;
            }
            if(to-from<0)
                return;

            int middle = (to-from)/2+from;
            globalTree.add((Integer) sortArr[middle]);
            addValues(sortArr,from, middle-1);
            addValues(sortArr,middle+1, to);
        }
    }

    public int prozentBalanceTree(List<TreeImpl<Integer>> arr){
        int countOfBalanceTree = 0;
        for (TreeImpl<Integer> integerTree : arr) {
            if(integerTree.isBalanced())
                countOfBalanceTree++;
        }
        return countOfBalanceTree/arr.size()*100;
    }



    public static void main(String[] args) {

        TreeImplService ts = new TreeImplService();

        List<TreeImpl<Integer>> treePac = ts.getTreePack(20);
        for (TreeImpl<Integer> tree : treePac) {
            tree.display();

            System.out.println("Balanced: "+tree.isBalanced());
        }
        System.out.println(String.format("Percent of balanced Tree is: %s ",ts.prozentBalanceTree(treePac)));



    }

}
