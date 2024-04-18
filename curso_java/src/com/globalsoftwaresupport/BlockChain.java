package src.com.globalsoftwaresupport;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    // ledger imutavel
    // não estamos habilitados para remover blocos
    private List<Block> blockChain;

    public BlockChain() {
        this.blockChain = new LinkedList<>();
    }

    public void addBlock(Block block) {
        this.blockChain.add(block);
    }

    public List<Block> getBlockChain() {
        return this.blockChain;
    }

    public int getSize() {
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        String s = "";

        for (Block block : this.blockChain)
            s += block.toString() + "\n";

        return s;
    }

}