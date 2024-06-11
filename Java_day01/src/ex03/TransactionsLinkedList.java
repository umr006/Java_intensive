package ex03;

public class TransactionsLinkedList {
    private static class nodeList {
        private Transaction transaction;
        private nodeList nodeListNext;
        private nodeList nodeListPrev;

        nodeList() {
            transaction = null;
            nodeListNext = null;
            nodeListPrev = null;
        }

        nodeList(Transaction transaction, nodeList nodeListNext, nodeList nodeListPrev) {
            this.transaction = transaction;
            this.nodeListNext = nodeListNext;
            this.nodeListPrev = nodeListPrev;
        }
    }

    public static class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String errMessage) {
            super(errMessage);
        }
    }

    nodeList currentNode = new nodeList();
    int cntTransaction = 0;

    void addTransaction(Transaction transaction) {
        if (currentNode.transaction == null) {
            currentNode.transaction = transaction;
        } else {
            nodeList newNode = new nodeList(transaction, null, currentNode);
            //currentNode.nodeListNext = newNode; the line below
            newNode.nodeListPrev.nodeListNext = newNode;
            currentNode = newNode;
        }
        cntTransaction++;
    }

        void removeTransactionById(Transaction transaction) {
        //nodeList tmp = currentNode;
        boolean isFound = false;
        for(nodeList i = currentNode; i != null; ) {
            if (i.transaction.getIdentifier() == transaction.getIdentifier()) {
                isFound = true;
                if (i.nodeListNext != null && i.nodeListPrev != null) {
                    i.nodeListPrev.nodeListNext = i.nodeListNext;
                    i.nodeListNext.nodeListPrev = i.nodeListPrev;
                } else if (i.nodeListNext == null && i.nodeListPrev == null) {
                    i = null;
                } else if (i.nodeListPrev == null) {
                    i.nodeListNext.nodeListPrev = null;
                } else if (i.nodeListNext == null) {
                    i.nodeListPrev.nodeListNext = null;
                    currentNode = i.nodeListPrev;
                }
                cntTransaction--;
            }
           i = i.nodeListPrev;
        }
            System.out.println(currentNode.transaction.getIdentifier());
        if (!isFound) throw new TransactionNotFoundException("UUID does not exist");
    }

    public Transaction[] toArray() {
        Transaction[] transactionsArray = new Transaction[cntTransaction];
        nodeList tmpNode = currentNode;
        for(int i = cntTransaction - 1; i >= 0; i--) {
            transactionsArray[i] = tmpNode.transaction;
            tmpNode = tmpNode.nodeListPrev;
        }
        return transactionsArray;
    }
}



