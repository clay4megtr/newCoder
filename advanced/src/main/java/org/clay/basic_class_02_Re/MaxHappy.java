package org.clay.basic_class_02_Re;

import java.util.ArrayList;
import java.util.List;

public class MaxHappy {

    public static class Node{
        public int huo;
        public List<Node> nexts;
        public Node(int huo){
            this.huo = huo;
            this.nexts = new ArrayList<>();
        }
    }

    public static class ReturnData{
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnData(int lai_huo, int bu_lai_huo){
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static ReturnData process(Node head){

        int lai_huo = head.huo;
        int bu_lai_huo = 0;

        for(int i = 0; i < head.nexts.size(); i++){
            Node next = head.nexts.get(i);
            ReturnData nextData = process(next);

        }


        return null;
    }
}
