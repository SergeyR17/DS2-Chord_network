package chord;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Demo of an network
        int m = 3; // initially num of nodes

        List<ChordNode> nodes = new ArrayList<>();

        ChordNode currentNetwork = new ChordNode(3, 0);
        currentNetwork.joinTo(null);
        nodes.add(currentNetwork);
        // initially fill
        for (int n : new int[]{1, m}) {
            ChordNode node = new ChordNode(m, n);
            node.joinTo(currentNetwork);
            nodes.add(node);
        }
        PerformStabilisationAndShow(nodes);

        // create and add 6th node
        ChordNode anotherNode = new ChordNode(m, 6);
        anotherNode.joinTo(currentNetwork);
        nodes.add(anotherNode);
        PerformStabilisationAndShow(nodes);

        // delete and remove 6th node
        anotherNode.delete();
        nodes.remove(anotherNode);
        PerformStabilisationAndShow(nodes);

        //ChordNode anotherNode = nodes.get(1);
        //anotherNode.delete();
        //nodes.remove(anotherNode);
        //PerformStabilisationAndShow(nodes);
    }

    private static void PerformStabilisationAndShow(List<ChordNode> nodes) {
        int st_iterations = 11;
        System.out.println(String.format("**** Stabilisation start, with: %5d iterations ****",
                st_iterations));

        for (int i = 0; i < st_iterations; i++) {
            for (ChordNode node : nodes) {
                node.stabilizeNetwork();
                node.fixFingers(); // periodically refresh finger table entries
            }
        }

        for (ChordNode node : nodes) {
            System.out.println(node);
        }
        System.out.println("**** Stabilisation performed ****");

    }
}
