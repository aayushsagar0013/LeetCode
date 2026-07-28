class Solution {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        char single = ' ';
        StringBuilder firstHalf = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                firstHalf.append(arr[i]);
                i++;
            } else {
                single = arr[i];
            }
        }

        if (single == ' ' && s.length() % 2 != 0) {
            single = arr[arr.length - 1];
        }

        StringBuilder result = new StringBuilder();
        result.append(firstHalf);

        if (single != ' ') {
            result.append(single);
        }

        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
}