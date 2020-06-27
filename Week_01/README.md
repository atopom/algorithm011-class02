#算法训练营第一周

## 笔记
* 精通一个领域成为专家
1. chunk it up
2. deliberate practicing
3. feedback

* 算法学习
1. 3分学习7分练习
2. 不死磕，敢于放手，敢于死记硬背代码
3. 看高手代码

* Leecode练习攻略
1. 5分钟想不出来，直接看题解和高手代码
2. 每道题至少反复练习5次，1小时后、10小时后、1天后、一周后、面试前一周恢复性训练
3. 要知道计算机只能够通过简单的if-else、for、recursion解决问题，找出 最近 重复子问题

* 数组，Array 时间复杂度
- prepend 	O(1)
	- 正常情况下数组的prepend时间复杂度是O(n)，但是可以优化到O(1)。
	- 采用的方式是申请较大的空间，在数组的最开始预留一部分的空间，然后在epend操作时，把头指针前移一个位置即可。
- append 	O(1)
- loopup 	O(1)
- insert 	O(n)
- delete 	O(n)

* 链表，LinkedList 时间复杂度
- prepend 	O(1)
- append 	O(1)
- loopup 	O(n)
- insert 	O(1)
- delete 	O(1)

* 跳表，Skip 时间复杂度
- prepend 	O(logn)
- append 	O(logn)
- loopup 	O(logn)
- insert 	O(logn)
- delete 	O(logn)
- 跳表特点
	- 只能用于元素是有序的情况，所以跳表对标的是平衡树和二分查找。
	- 优势是原理简单、容易实现、方便扩展，效率更高。
- 总结：进行加速操作的核心思想：1、升维；2、空间换时间

* 栈 Stack First-in-Last-out 操作。
* 队列 Queue First-in-First-out 操作。
* 优先队列 PriorityQueue，具有优先级顺序的队列。
* 双端队列 Double-end-Queue，两端都可进行添加和移除操作的Queue。

## 用 add first 或 add last 这套新的 API 改写 Deque 的代码
```
	Deque<String> deque = new LinkedList<>();
	deque.addFirst("a");
	deque.addFirst("b");
	deque.addFirst("c");

	String first = deque.getFirst();
	System.out.println(first);
	System.out.println(deque);

	while (deque.size() > 0) {
	    System.out.println(deque.removeFirst());
	}

	System.out.println(deque);
```

## 分析 Queue 和 Priority Queue 的源码
* Queue源码分析

> 在Java中Queue是一个接口。对元素进行FIFO(first-in-first-out)管理。
> 插入和移除操作时间复杂度O(1)。
> 检索队头是O(1)，检索其他是O(n)。
> 常见的实现类有：LinkedList、ArrayDeque、PriorityDeque。
> 有两组API，一组是操作会抛异常的、一组是操作会返回默认值的。
```
public interface Queue<E> extends Collection<E> {
    // 1.Throws exception API
    // 插入队尾一个元素
    boolean add(E e);
    // 移除队头一个元素
    E remove();
    // 检索队头元素
    E element();
    
    // 2.Returns special value API
    // 插入队尾一个元素
    boolean offer(E e);
    // 移除队头一个元素
    E poll();
    // 检索队头元素
    E peek();
}
```

* PriorityQueue源码分析

> 插入和移除（按照优先级顺序）的时间复杂度：O(logn)
> 底层具体实现的数据结构较为多样和复杂：heap、bsp(binary search tree)、treap
> Java中的PriorityQueue是一个优先级队列，默认是按照元素的自然顺序排序（可以重写Comparator接口对元素进行自定义排序规则）。
> 插入代码如下：
```
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
   
   // 插入操作
   public boolean add(E e) {
        return offer(e);
   }
   
   public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        // 如果当前size>=队列的长度，就会进行扩容操作
        if (i >= queue.length)
            grow(i + 1);
        // 元素个数+1
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            // 按规则添加元素
            siftUp(i, e);
        return true;
    }
    
    // 按规则添加元素
    private void siftUp(int k, E x) {
        // 自定义排序规则
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            // 默认排序规则
            siftUpComparable(k, x);
    }
    
    // 默认排序规则
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            // 对当前下标进行-1和除2操作获取上一个坐标位置
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            // 按默认的比较规整进行比较，key大直接插入
            if (key.compareTo((E) e) >= 0)
                break;
            // key小，把e前移到k位置
            queue[k] = e;
            // 以上一个坐标位为插入位，进行新一轮比较
            k = parent;
        }
        queue[k] = key;
    }
    
    // 自定义排序规则
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
    
    // 扩容操作
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // 原队列容量<64，扩充到原容量的2倍+2，否则扩容到原容量的1.5倍
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
    
    // 扩容最大值限制 Integer.MAX_VALUE
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
}
```