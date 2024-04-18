package com.gab.blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gab.cryptocurrency.Transaction;
import com.gab.constants.Constants;
import com.gab.cryptocurrency.CryptographyHelper;

public class Block {
    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String previousHash;
    private List<Transaction> transactions;

    public Block(String previousHash) {
        this.transactions = new ArrayList<>();
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = Integer.toString(id) + previousHash + Long.toString(timeStamp) + transactions.toString()
                + Integer.toString(nonce);
        this.hash = CryptographyHelper.generateHash(dataToHash);
    }

    public boolean addTransaction(Transaction transaction) {
        if (transaction == null)
            return false;

        if ((!previousHash.equals(Constants.GENESIS_PREV_HASH))) {
            if ((!transaction.verifyTransaction())) {
                System.out.println("Transação inválida");
                return false;
            }
        }

        transactions.add(transaction);
        System.out.println("Transação válida e foi adicionada no bloco " + this);
        return true;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public String getHash() {
        return this.hash;
    }

}
