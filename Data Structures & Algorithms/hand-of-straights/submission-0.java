class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        if (n % groupSize != 0)
    return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
     Arrays.sort(hand);



for (int x : hand) {
    hm.put(x, hm.getOrDefault(x, 0) + 1);
}

for (int i = 0; i < n; i++) {

    int smallest = hand[i];

    if (hm.get(smallest) == 0)
        continue;

    for (int k = 0; k < groupSize; k++) {

        int x = smallest + k;

        if (!hm.containsKey(x) || hm.get(x) == 0)
            return false;

        hm.put(x, hm.get(x) - 1);
    }
}

return true;
    }
}
