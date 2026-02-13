class Solution {
    public static int findGrimoire(int[] ids, int target) {
        for (int id : ids) {
            if (id == target)
                return 1;
        }
        return 0;
    }
}
