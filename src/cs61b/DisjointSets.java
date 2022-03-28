package cs61b;

public interface DisjointSets {
    void connect(int p, int q);
    boolean isCOnnected(int p, int q);
}
