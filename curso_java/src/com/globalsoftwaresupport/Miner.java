package src.com.globalsoftwaresupport;

public class Miner {

    private double reward;

    public void mine(Block block, BlockChain blockChain) {

        while (!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        }

        System.out.println(block + " acabou de minerar...");
        System.out.println("Hash: " + block.getHash());

        blockChain.addBlock(block);
        reward += Constants.REWARD;
    }

    private boolean isGoldenHash(Block block) {
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');

        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }

    public double getReward() {
        return this.reward;
    }

}
