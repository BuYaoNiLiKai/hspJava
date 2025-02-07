import java.util.ArrayList;

public class tmp {
    public static class Individual {
        int head;
        int tail;

        public Individual(int head, int tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Individual that = (Individual) o;
            return head == that.head && tail == that.tail;
        }

        @Override
        public String toString() {
            return "Individual{" +
                    "head=" + head +
                    ", tail=" + tail +
                    '}';
        }
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        ArrayList<Individual> individuals = new ArrayList<>();
        return process(nums, 0, 0, k, 0, individuals);
    }

    public static boolean isExist(Individual i, ArrayList<Individual> individuals) {
        for (Individual individual : individuals) {
            if (individual.equals(i)) return true;
        }
        return false;
    }

    // 从 i位置之后 找和为k的子数组
    public static int process(int[] nums, int head, int tail, int k, int already, ArrayList<Individual> individuals) {
        // i位置参与
        if (tail == nums.length) {
            return 0;
        }

        // i位置参与的话
        Individual individual = new Individual(head, tail);
        already += nums[tail];

        int res = 0;
        if (already == k && !isExist(individual, individuals)) {
            individuals.add(individual);
            res = 1;
        }

        return res + process(nums, head, tail + 1, k, already, individuals) + process(nums, head + 1, head + 1, k, 0, individuals);

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 1, 23, 21, 3, 1, 2, 1, 1, 1, 1, 1, 12, 2, 3, 2, 3, 2, 2};
        int k = 6;
        System.out.print(subarraySum(arr, k));
    }
}
