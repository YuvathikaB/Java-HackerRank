package Medium;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVisitor visitor);
}

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVisitor visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVisitor visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVisitor {
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
    public abstract int getResult();
}

class SumInLeavesVisitor extends TreeVisitor {
    private int sum = 0;

    public void visitNode(TreeNode node) {}

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }

    public int getResult() {
        return sum;
    }
}

class ProductOfRedNodesVisitor extends TreeVisitor {
    private long product = 1;
    private final int MOD = 1000000007;

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }

    public int getResult() {
        return (int) product;
    }
}

class FancyVisitor extends TreeVisitor {
    private int evenDepthSum = 0;
    private int greenLeafSum = 0;

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }

    public int getResult() {
        return Math.abs(evenDepthSum - greenLeafSum);
    }
}
public class Visitor {
    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        values = new int[n];
        colors = new Color[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int color = sc.nextInt();
            colors[i] = (color == 0) ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            map.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            map.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        sc.close();

        return buildTree(1, 0);
    }

    private static Tree buildTree(int node, int depth) {
        Set<Integer> children = map.get(node);
        if (children == null || children.isEmpty()) {
            return new TreeLeaf(values[node - 1], colors[node - 1], depth);
        }

        TreeNode treeNode = new TreeNode(values[node - 1], colors[node - 1], depth);
        for (int child : children) {
            map.get(child).remove(node); // prevent going back up
            treeNode.addChild(buildTree(child, depth + 1));
        }

        return treeNode;
    }

    public static void main(String[] args) {
        Tree root = solve();

        TreeVisitor vis1 = new SumInLeavesVisitor();
        TreeVisitor vis2 = new ProductOfRedNodesVisitor();
        TreeVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());

    }
}
