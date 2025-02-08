class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of the current nodes
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum and carry
            int totalSum = val1 + val2 + carry;
            carry = totalSum / 10;
            int currentDigit = totalSum % 10;

            // Create a new node with the current digit
            current.next = new ListNode(currentDigit);
            current = current.next;

            // Move to the next nodes in the input lists if available
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }
}