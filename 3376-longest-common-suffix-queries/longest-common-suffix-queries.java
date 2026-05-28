class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int bestIndex = 0;

        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[bestIndex].length()) {
                bestIndex = i;
            }
        }

        root.index = bestIndex;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx, String[] wordsContainer) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }

            node = node.children[c];

            if (node.index == -1 ||
                wordsContainer[idx].length() < wordsContainer[node.index].length() ||
                (wordsContainer[idx].length() == wordsContainer[node.index].length()
                 && idx < node.index)) {

                node.index = idx;
            }
        }
    }

    private int search(String word) {

        TrieNode node = root;
        int result = root.index;

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
            result = node.index;
        }

        return result;
    }
}