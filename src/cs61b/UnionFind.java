package cs61b;

public class UnionFind {
    private int[] intSets;

    public UnionFind(int n){
        for(int i = 0; i < n; i++){
            intSets[i] = -1;
        }
    }

    public void validate(int v1){
        if(v1 < 0 || v1 >= intSets.length){
            throw new IllegalArgumentException("wrong index!");
        }
    }

    public int sizeOf(int v1){
        validate(v1);
        return -parent(found(v1));
    }

    public int parent(int v1){
        validate(v1);
        if(found(v1) == v1){
            return -parent(found(v1));
        }
        return intSets[v1];
    }

    public boolean connected(int v1, int v2){
        validate(v1);
        validate(v2);
        return found(v1) == found(v2);
    }

    public void union(int v1, int v2){
        if(sizeOf(v1) == sizeOf(v2) && !connected(v1,v2)){
            union(found(v1),found(v2));
        }
        if(connected(v1,v2)){
            return;
        }else if(!connected(v1,v2)){
            if(sizeOf(v1) > sizeOf(v2)){
                intSets[found(v1)] -= sizeOf(v2);
                intSets[found(v2)] = found(v1);
            }else{
                intSets[found(v2)] -= sizeOf(v1);
                intSets[found(v1)] = found(v2);
            }
        }
    }

    public int found(int v1){
        validate(v1);
        int root = v1;
        while(parent(root) > -1){
            root = parent(root);
        }

        //path compression
        int currParent;
        while(v1 != root){
            currParent = parent(v1);
            intSets[v1] = root;
            v1 = currParent;
        }
        return root;
    }


}
