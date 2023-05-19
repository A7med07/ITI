/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintproject;

/**
 *
 * @author mahmo
 */
public class ListNode<T> {

    private T data;
    private ListNode next;

    public ListNode(T nodeData) {
        this(nodeData, null);
    }

    public ListNode(T nodeData, ListNode nodeNext) {
        data = nodeData;
        next = nodeNext;
    }

    public T getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setData(T newData) {
        data = newData;
    }

    public void setNext(ListNode newNext) {
        next = newNext;
    }
}
