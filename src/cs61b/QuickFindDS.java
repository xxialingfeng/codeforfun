package cs61b;

public class QuickFindDS implements DisjointSets{
    private int[] id;
    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isCOnnected(int p, int q) {
        return id[p] == id[q];
    }
}
