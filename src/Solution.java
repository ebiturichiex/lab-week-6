//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {}

    // Constructor to set the value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor to set value and next pointer
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list
        ListNode current = head;
        int length = 1; // Start at 1 because we'll stop at the tail
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Create a circular linked list
        current.next = head;

        // Step 3: Find the new head
        // k could be greater than the length of the list
        k = k % length;
        int stepsToNewHead = length - k;

        // Move to the new tail (one node before the new head)
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 4: Break the circular linked list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Test the implementation
    public static void main(String[] args) {
        // Create test cases
        Solution solution = new Solution();
        ListNode head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        int k = 2;

        // Rotate and print the result
        ListNode result = solution.rotateRight(head, k);
        printLinkedList(result);
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
