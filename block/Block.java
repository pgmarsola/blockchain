package block;

import java.util.LinkedList;
import java.util.List;

public class Block {

    private List<ModelBlock> blockchain;

    public Block() {
        this.blockchain = new LinkedList<>();
    }

    public void addBlock(ModelBlock block) {
        this.blockchain.add(block);
    }

    public List<ModelBlock> getBlockChain() {
        return this.blockchain;
    }

    public int getSize() {
        return this.blockchain.size();
    }

    @Override
    public String toString() {
        String s = "";

        for (ModelBlock block : this.blockchain)
            s += block.toString() + "\n";

        return s;
    }

}
