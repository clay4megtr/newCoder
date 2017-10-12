package org.clay.Test;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    boolean flag = true;

    public void dfs(List<List<Integer>> adjList,int v,int[] color){

        color[v] = 0;   //表示正在处理v节点
        List<Integer> adjs = adjList.get(v); 

        for(int i=0;i<adjs.size();i++){
            if(color[adjs.get(i)]==-1){
                dfs(adjList,adjs.get(i),color);
            }else if(color[adjs.get(i)]==0){//回到了状态为0的节点，有环
                flag = false;
            }
        }
        color[v] = 1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        //根据course个数初始化一个空的邻接表
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<Integer>());
        }
        //初始化color数组
        int[] color = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            color[i] = -1;
        }

        //adjList表示邻接表，头结点是后面的课程，后面的list表示先修课
        //由先修课指向 后修课
        for(int i=0;i<prerequisites.length;i++){
            int[] cp = prerequisites[i];
            adjList.get(cp[1]).add(cp[0]);
        }

        //下面对邻接表进行深度遍历，看看是否有环，从每一个节点都遍历一次
        for(int i=0;i<numCourses;i++){
            dfs(adjList, i, color);
            if(!flag){
                return false;
            }
            for(int j=0;j<numCourses;j++){
                color[j] = -1;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //4, [[0,1],[3,1],[1,3],[3,2]]
        int[][] nums = {{0,1},{3,4},{2,1},{3,2}};

        System.out.println(s.canFinish(5, nums));
    }
}