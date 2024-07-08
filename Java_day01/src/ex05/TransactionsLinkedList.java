package ex05;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private static class nodeList {
        private Transaction transaction;
        private nodeList nodeListNext;
        private nodeList nodeListPrev;

        public nodeList() {
            transaction = null;
            nodeListNext = null;
            nodeListPrev = null;
        }

        public nodeList(Transaction transaction, nodeList next, nodeList prev) {
            this.transaction = transaction;
            nodeListNext = next;
            nodeListPrev = prev;
        }
    }

    nodeList currentNode = new nodeList();
    int cntTransaction = 0;
    public void addTransaction(Transaction transaction) {
        if (currentNode.transaction == null) {
            currentNode.transaction = transaction;
        } else {
            nodeList newNode = new nodeList(transaction, null, currentNode);
            currentNode = newNode;
        }
        cntTransaction++;
    }

    public void removeTransactionById(UUID id) {
        boolean isFound = false;
        for (nodeList i = currentNode; i != null; ) {
            if (i.transaction.getId() == id) {
                isFound = true;
                if (i.nodeListPrev != null && i.nodeListNext != null) {
                    i.nodeListPrev.nodeListNext = i.nodeListNext;
                    i.nodeListNext.nodeListPrev = i.nodeListPrev;
                } else if (i.nodeListPrev == null && i.nodeListNext == null) {
                    i = null;
                } else if (i.nodeListNext == null) {
                    i.nodeListPrev.nodeListNext = null;
                } else if (i.nodeListPrev == null) {
                    i.nodeListNext.nodeListPrev = null;
                }
                cntTransaction--;
                break;
            }
            i = i.nodeListPrev;
        }
        if (!isFound) {
            throw new TransactionNotFoundException("ID is not exists");
        }
    }

    public Transaction[] toArray() {
        Transaction[] arrayTransaction = new Transaction[cntTransaction];
        nodeList tmpCurrentNode = currentNode;
        int i = cntTransaction - 1;
        while(tmpCurrentNode != null) {
            arrayTransaction[i] = tmpCurrentNode.transaction;
            tmpCurrentNode = tmpCurrentNode.nodeListPrev;
            i--;
        }
        return arrayTransaction;
    }
    public int numberTransaction() {
        return cntTransaction;
    }

}
