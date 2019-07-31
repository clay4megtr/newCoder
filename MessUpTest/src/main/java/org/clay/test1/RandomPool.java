package org.clay.test1;

import java.util.HashMap;
import java.util.Map;

public class RandomPool {

    public static class Pool<P>{
        private Map<P,Integer> map1;
        private Map<Integer,P> map2;

        private int size;

        public Pool(){
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            this.size = 0;
        }

        public void insert(P key){
            if(!this.map1.containsKey(key)){
              this.map1.put(key,size);
              this.map2.put(size++,key);
            }
        }

        public void delete(P key){
            if(this.map1.containsKey(key)){
                int delete_index = this.map1.get(key);
                int last_index = --size;

                P last_key = this.map2.get(last_index);
                this.map1.put(last_key,delete_index);
                this.map1.remove(key);

                this.map2.remove(last_index);
                this.map2.put(delete_index,last_key);
            }
        }

        public P getRandom(){
            if(size == 0){
                return null;
            }

            int random = (int)Math.random() * size;
            return this.map2.get(random);
        }
    }
}
