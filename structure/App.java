import java.util.ArrayList;
import java.util.List;

import block.Block;
import block.Constants;
import block.MerkleTree;
import block.ModelBlock;
import miner.Miner;

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

        Block blockchain = new Block();
        Miner miner = new Miner();

        ModelBlock block0 = new ModelBlock(0, "", Constants.GENESIS_PREV_HASH);
        miner.mine(block0, blockchain);

        ModelBlock block1 = new ModelBlock(1, merkleTree.getMerkleRoot(),
                blockchain.getBlockChain().get(blockchain.getSize() - 1).getHash());
        miner.mine(block1, blockchain);

        ModelBlock block2 = new ModelBlock(2, "transaction2",
                blockchain.getBlockChain().get(blockchain.getSize() - 1).getHash());
        miner.mine(block2, blockchain);

        System.out.println("\n" + "BLOCKCHAIN:\n" + blockchain);
        System.out.println("Miner's reward: " + miner.getReward());

    }
}
