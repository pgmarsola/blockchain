package com.gab.cryptocurrency;

import com.gab.blockchain.Block;
import com.gab.blockchain.Blockchain;
import com.gab.constants.Constants;

public class Miner {
    private double reward;

    public void mine(Block block, Blockchain blockchain) {
        while (!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        }

        System.out.println(block + " acabou de minerar");
        System.out.println("Hash: " + block.getHash());

        blockchain.addBlock(block);
        reward += Constants.REWARD;
    }

    public boolean isGoldenHash(Block block) {
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);

    }

    public double getReward() {
        return this.reward;
    }
}
