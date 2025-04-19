package dataStructures;

/*
* 힙이란 이진트리인데 부모노드와 자식노드가 항상 대소관계이다
* 부모가 항상 작으면 최소힙 크면 최대힙이다.
* 배열로 표현 가능한데
* left child = parent * 2 + 1
* right child = parent * 2 + 2
* parent = (child - 1) / 2
* 로 표현 가능 하다
*
* 삽입 후 재구성 해야 한다(heapify Up)
* Heapify Up (bubble up)
* 1. 현재 노드의 index 를 구한다.
* 2. 현재 노드의 부모 노드의 index 를 구한다.
* 3. 현재 노드가 부모 노드 보다 크면 두 노드를 바꾼다.
* 4. 현재 노드의 index 를 부모 노드의 index 로 바꾼다.
* 5. 현재 노드와 부모 노드의 index 를 구한다.(반복)
*
* 삭제 후 재구성 해야 한다(heapify Down)
* 우선 뿌리 노드와 교환 한다
* Heapify Down (bubble down)
* left child > 현재 노드: 다음 index 를 좌측 자식 index 로 설정
* right child > 현재 노드: 다음 index 를 우측 자식 index 로 설정
* 다음 index != 현재 index: 다음 index 를 현재 노드로 바군 후 다음 인덱스 기준 으로 재구성(heapify down)
*
*
* 삽입 작제는 O(logN)
*
* peek: 루트(최대 최솟값 리턴)
* size: 힙 사이즈 리턴
* isEmpty: 힙가 비었을 때 true 리턴
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxHeap {

    ArrayList<Integer> array;

    public MaxHeap(int num){
        this.array = new ArrayList<>();
    }

    private int getParentIndex(int index) { return (index - 1) / 2; }
    private int getLeftChildIndex(int index) { return index * 2 + 1; }
    private int getRightChildIndex(int index) { return index * 2 + 2; }

    private void swap(int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    // heapifyUp: 삽입된 노드를 올려주는 함수
    private void heapifyUp(int myIndex) {
        if (myIndex == 0)
            return;
        int parentIndex = getParentIndex(myIndex);
        while (myIndex > 0 && this.array.get(myIndex) > this.array.get(parentIndex)) {
            swap(myIndex, parentIndex);
            myIndex = parentIndex;
            parentIndex = getParentIndex(myIndex);
        }
    }

    // insert: 새로운 값을 삽입하는 함수
    public void insert(int value) {
        this.array.add(value);
        heapifyUp(this.array.size() - 1);
    }

    // peek: 최대값을 조회하는 함수 (최대 힙의 루트)
    public int peek() {
        if (this.array.isEmpty()) {
            return 0;  // 배열이 비어있다면 0을 반환
        }
        return this.array.get(0);
    }

    // heapifyDown: 루트 노드를 삭제 후, 힙 속성을 유지하는 함수
    private void heapifyDown(int myIndex) {
        int leftIndex = getLeftChildIndex(myIndex);
        int rightIndex = getRightChildIndex(myIndex);
        int largest = myIndex;

        // 왼쪽 자식이 더 크면
        if (leftIndex < array.size() && this.array.get(leftIndex) > this.array.get(largest)) {
            largest = leftIndex;
        }

        // 오쪽 자식이 더 크면
        if (rightIndex < array.size() && this.array.get(rightIndex) > this.array.get(largest)) {
            largest = rightIndex;
        }

        // largest가 바뀌었으면 swap하고 heapifyDown을 다시 호출
        if (largest != myIndex) {
            swap(myIndex, largest);
            heapifyDown(largest);
        }
    }

    // delete: 최대값을 삭제하고 힙을 재구성하는 함수
    public int delete() {
        if (this.array.isEmpty()) {
            return 0;  // 배열이 비어있으면 0을 반환
        }
        int value = this.array.get(0);
        this.array.set(0, this.array.get(array.size() - 1));  // 마지막 값을 루트로 이동
        this.array.remove(array.size() - 1);  // 마지막 값을 삭제
        heapifyDown(0);  // 루트부터 힙 속성을 유지하도록 heapifyDown 호출
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        MaxHeap maxHeap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(maxHeap.delete()).append('\n');  // 최대값 삭제
            } else {
                maxHeap.insert(num);  // 새로운 값 삽입
            }
        }

        System.out.println(sb);
    }
}
