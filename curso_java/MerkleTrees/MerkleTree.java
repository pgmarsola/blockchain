package MerkleTrees;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private List<String> transactions;

    public MerkleTree(List<String> transactions) {
        this.transactions = transactions;
    }

    public String getMerkleRoot() {
        return construct(this.transactions).get(0);
    }

    // é uma função recursiva que continua mesclando os hashes vizinhos (index i and
    // i+1)
    private List<String> construct(List<String> transactions) {
        // caso base para chamadas de métodos recursivos
        if (transactions.size() == 1)
            return transactions;

        // contém cada vez menos itens em cada interação
        List<String> updatedList = new ArrayList<>();

        // mesclando os itens vizinhos
        for (int i = 0; i < transactions.size() - 1; i += 2) {
            updatedList.add(mergeHash(transactions.get(i), transactions.get(i + 1)));
        }

        // se o número de transações for ímpar: o último item é hash consigo mesmo
        if (transactions.size() % 2 == 1)
            updatedList.add(
                    mergeHash(transactions.get(transactions.size() - 1), transactions.get(transactions.size() - 1)));

        // chamada metodo recursivo
        return construct(updatedList);

    }

    private String mergeHash(String hash1, String hash2) {
        String mergedHash = hash1 + hash2;
        return CryptographyHelper.hash(mergedHash);
    }
}
