package MerkleTrees;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> transactions = new ArrayList<>();

        transactions.add("aa");
        transactions.add("bb");
        transactions.add("dd");
        transactions.add("transaction 4");
        transactions.add("7777");
        transactions.add("udsadsua");

        MerkleTree merkleTree = new MerkleTree(transactions);
        System.out.println(merkleTree.getMerkleRoot());
    }
}
