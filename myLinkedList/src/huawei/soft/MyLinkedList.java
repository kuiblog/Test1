/*
 * Copyright Notice:
 *      Copyright  1998-2009, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package huawei.soft;

public class MyLinkedList
{
    private ListNode head;
    
    private ListNode tail;
    
    private Integer len;
    
    public ListNode getHead()
    {
        return head;
    }
    
    private void setHead(ListNode head)
    {
        this.head = head;
    }
    
    public ListNode getTail()
    {
        return tail;
    }
    
    private void setTail(ListNode tail)
    {
        this.tail = tail;
    }
    
    //    public Integer getLen()
    //    {
    //        return len;
    //    }
    
    private void setLen(Integer len)
    {
        this.len = len;
    }
    
    private MyLinkedList()
    {
        super();
    }
    
    public static MyLinkedList createList()
    {
        MyLinkedList list = new MyLinkedList();
        ListNode head = new ListNode();
        head.setId(-1L);
        list.setHead(head);
        list.setTail(head);
        list.setLen(0);
        return list;
    }
    
    public void printList()
    {
        System.out.println("-------------- start -------------- len=" + this.getListLen());
        ListNode node = this.getHead().getNext();
        while (node != null)
        {
            System.out.println("ID=" + node.getId());
            System.out.println("NAME=" + node.getName());
            System.out.println("TELNO=" + node.getTelno());
            System.out.println();
            node = node.getNext();
        }
        System.out.println("-------------- end -------------- len="+this.getListLen());
    }
    
    public Integer getListLen()
    {
        return len;
    }
    
    public ListNode findNodeByStuID(Long id)
    {
        ListNode node = this.getHead().getNext();
        while (node != null)
        {
            if (node.getId().equals(id))
            {
                break;
            }
            node = node.getNext();
        }
        return node;
    }
    
    public Boolean insertNode(Long id, ListNode newNode)
    {
//        ListNode node = this.getHead().getNext();
        ListNode node = this.getHead();
        while (node != null)
        {
            if (node.getId().equals(id))
            {
                newNode.setNext(node.getNext());
                node.setNext(newNode);
                len += 1;
                if (tail == node)
                {
                    tail = newNode;
                }
                break;
            }
            node = node.getNext();
        }
        return node != null ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public void pushBackNode(ListNode newNode)
    {
        tail.setNext(newNode);
        newNode.setNext(null);
        tail = newNode;
        len += 1;
    }
    
    public ListNode removeNodeByStuID(Long id)
    {
        ListNode beforeNode = head;
        ListNode node = head.getNext();
        
        while (node != null)
        {
            if (node.getId().equals(id))
            {
                beforeNode.setNext(node.getNext());
                len -= 1;
                if (tail == node)
                {
                    tail = beforeNode;
                }
                break;
            }
            beforeNode = node;
            node = node.getNext();
        }
        return node;
    }
    
    public void removeList()
    {
        ListNode beforeNode = head;
        ListNode node = head.getNext();
        
        while (node != null)
        {
            beforeNode.setNext(null);
            len -= 1;
            
            beforeNode = node;
            node = node.getNext();
        }
        
        tail = head;
    }
    
    public void orderList()
    {
        MyLinkedList newList = MyLinkedList.createList();
        while (this.getListLen() > 0)
        {
            ListNode one = this.removeNodeByStuID(this.getHead()
                    .getNext()
                    .getId());
            if (newList.getListLen() == 0)
            {
                newList.pushBackNode(one);
            }
            else
            {
                ListNode beforeOrderOne = newList.getHead();
                ListNode orderOne = newList.getHead().getNext();
                while (orderOne != null
                        && (one.getId().compareTo(orderOne.getId()) > 0))
                {
                    beforeOrderOne = orderOne;
                    orderOne = orderOne.getNext();
                }
                newList.insertNode(beforeOrderOne.getId(), one);
            }
        }
        this.head = newList.head;
        this.tail = newList.tail;
        this.len = newList.len;
        newList = null;
    }
    
    public static void main(String[] args)
    {
        MyLinkedList list = MyLinkedList.createList();
        list.printList();
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        list.pushBackNode(printRandomNode());
        System.out.println(list.getTail());
        list.printList();
        list.pushBackNode(printRandomNode());
        System.out.println(list.getTail());
        list.printList();
        ListNode find = printRandomNode();
        System.out.println(list.findNodeByStuID(find.getId()));
        list.pushBackNode(find);
        System.out.println(list.findNodeByStuID(find.getId()));
        list.printList();
        list.insertNode(find.getId(), printRandomNode());
        list.printList();
        list.pushBackNode(printRandomNode());
        list.insertNode(find.getId(), printRandomNode());
        list.printList();
        System.out.println("order---------");
        list.orderList();
        list.printList();
        System.out.println(find);
        list.removeNodeByStuID(find.getId());
        list.printList();
    }
    
    private static ListNode printRandomNode()
    {
        ListNode node = ListNode.createRandomNode();
        System.out.println(node);
        return node;
    }
}
