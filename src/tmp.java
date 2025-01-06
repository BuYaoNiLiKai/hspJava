import java.util.Comparator;
import java.util.PriorityQueue;

public class tmp {
    public static void main(String[] args) {
        return;
    }
}

class MedianFinder {
    public static class HeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    PriorityQueue<Integer> bigHeap; //大根堆
    PriorityQueue<Integer> smallHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        bigHeap = new PriorityQueue<>(new HeapComparator()); //大根堆
        smallHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigHeap.isEmpty()) {
            bigHeap.add(num);
            return;
        }
        if (num < bigHeap.peek()) {
            bigHeap.add(num);
            if ((bigHeap.size() - smallHeap.size()) >= 2) {
                smallHeap.add(bigHeap.poll());
            }
        } else {
            smallHeap.add(num);
            if ((smallHeap.size() - bigHeap.size()) >= 2) {
                bigHeap.add(smallHeap.poll());
            }
        }

    }

    public double findMedian() {
        if ((smallHeap.size() + bigHeap.size()) % 2 == 0) {
            return (smallHeap.peek() * 1.0 + bigHeap.peek()) / 2;
        }
        return bigHeap.size() > smallHeap.size() ? bigHeap.peek() : smallHeap.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */