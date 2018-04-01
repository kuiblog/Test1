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

import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;   



public class ListNode
{
    private Long id;
    
    private String name;
    
    private String telno;
    
    private ListNode next;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param name
     * @see [�ࡢ��#��������#��Ա]
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public String getTelno()
    {
        return telno;
    }
    
    public void setTelno(String telno)
    {
        this.telno = telno;
    }
    
    public ListNode getNext()
    {
        return next;
    }
    
    public void setNext(ListNode next)
    {
        this.next = next;
    }
    
    @Override
    public String toString()
    {
        return "ListNode:" + this.hashCode() + " [id=" + id + ", name=" + name
                + ", telno=" + telno + "]";
    }
    
    public static ListNode createRandomNode()
    {
        ListNode node = new ListNode();
        Random random = new Random();
        node.setId(Math.abs(random.nextLong()));
//        node.setName(Math.abs(random.nextInt()) + "");
        node.setName(RandomStringUtils.randomAlphabetic(3).toLowerCase());
        node.setTelno(Math.abs(random.nextInt()) + "");
        return node;
    }
    
}
