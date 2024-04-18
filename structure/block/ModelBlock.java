package block;

import java.util.Date;

public class ModelBlock {
    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String previousHash;
    private String transaction;

    public ModelBlock(int id, String transaction, String previousHash) {
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = Integer.toString(id) + previousHash + Long.toString(timeStamp) + Integer.toString(nonce)
                + transaction.toString();

        this.hash = Helper.generateHash(dataToHash);
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Model [id=" + id + ", hash=" + hash + ", previousHash=" + previousHash + ", transaction=" + transaction
                + "]";
    }
}
