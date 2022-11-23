/**
 * UnionFind
 */
class UnionFind {
    private int size;
    private int[] elementsArray;
    private int[] weightsArray;
    public UnionFind(int size) {
        elementsArray = new int[size];
        weightsArray = new int[size];
        for (int i = 0; i < elementsArray.length; i++) {
            elementsArray[i] = i;
            weightsArray[i] = 1;
        }
    }

    private int getRoot(int idx) {
        while (idx != elementsArray[idx]) {
            idx = elementsArray[idx];
        }
        return idx;
    }

    public void union(int idx1, int idx2) {
        if (idx1 >= elementsArray.length || idx2 >= elementsArray.length) return;
        int root1 = getRoot(idx1);
        int root2 = getRoot(idx2);
        if (weightsArray[root1] < weightsArray[root2]) {
            elementsArray[root2] = root1;
            weightsArray[root1] += weightsArray[root1];
        } else {
            elementsArray[root1] = root2;
            weightsArray[root2] += weightsArray[root1];
        }
        System.out.println("Union: " + idx1 + " & " + idx2);
    }

    public boolean isConnected(int idx1, int idx2) {
        if (idx1 >= elementsArray.length || idx2 >= elementsArray.length) return false;
        return getRoot(idx1) == getRoot(idx2);
    }
}

public class UnionFindApp {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(3, 4);
        unionFind.union(7, 8);
        unionFind.union(0, 2);
        unionFind.union(4, 2);
        unionFind.union(6, 5);
        unionFind.union(9, 6);
        unionFind.union(2, 9);
        System.out.println("1, 2 isConnected: " + unionFind.isConnected(1, 2));
        System.out.println("5, 2 isConnected: " + unionFind.isConnected(5, 2));
        System.out.println("6, 7 isConnected: " + unionFind.isConnected(6, 7));
        System.out.println("3, 2 isConnected: " + unionFind.isConnected(3, 2));
    }
}

/**
 * 2 1 9 4 2 9 5 8 8 9
 * 0 1 2 3 4 5 6 7 8 9
 * 
 * 0 1 4 1 2 2 1 1 2 7
 * 0 1 2 3 4 5 6 7 8 9
 * 
 * 
*/


