package miner;

import block.Block;
import block.Constants;
import block.ModelBlock;

public class Miner {

    private double reward;

    public void mine(ModelBlock block, Block blockchain) {

        while (!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        }

        System.out.println(block + " acabou de minerar...");
        System.out.println("Hash: " + block.getHash());

        blockchain.addBlock(block);
        reward += Constants.REWARD;
    }

    private boolean isGoldenHash(ModelBlock block) {
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');

        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }

    public double getReward() {
        return this.reward;
    }

}
