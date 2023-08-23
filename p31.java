// Doubly Circular LinkedList

import java.util.*;

class p31
{
    public static void main(String args[])
    {
        DoublyCL obj = new DoublyCL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);

        obj.Display();
        System.out.println("Number of elements in LL are : "+obj.Count());

        obj.InsertAtPos(35, 3);

        obj.Display();
        System.out.println("Number of elements in LL are : "+obj.Count());

        obj.DeleteAtPos(3);

        obj.Display();
        System.out.println("Number of elements in LL are : "+obj.Count());

        obj.DeleteFirst();
        obj.DeleteLast();

        obj.Display();
        System.out.println("Number of elements in LL are : "+obj.Count());
    }
}

class Node
{
    public int data;
    public Node next;
    public Node prev;

    public Node(int no)
    {
        this.data = no;
        this.next = null;
        this.prev = null;
    }
}

class DoublyCL
{
    public Node first;
    public Node last;
    public int iCount;

    public DoublyCL()
    {
        this.first = null;
        this.last = null;
        this.iCount = 0;
    }

    public void Display()
    {
        System.out.println("Elements in LL are : \n");

        Node temp = first;

        for(int iCnt = 1; iCnt <= iCount; iCnt++)
        {
            System.out.print(" | "+temp.data+" | <=> ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public int Count()
    {
        return this.iCount;
    }

    public void InsertFirst(int no)
    {
        Node newn = new Node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }

        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }
        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void InsertLast(int no)
    {
        Node newn = new Node(no);

        if((first == null) && (last == null))
        {
            first = newn;
            last = newn;
        }

        else
        {
            last.next = newn;
            newn.prev = last;
            last = last.next;
        }
        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void InsertAtPos(int no, int pos)
    {
        int iLength = Count();

        if((pos<1) || (pos>iLength+1))
        {
            System.out.println("Invalid position \n");
            return;
        }

        if(pos == 1)
        {
            InsertFirst(no);
        }

        else if(pos == iLength+1)
        {
            InsertLast(no);
        }

        else
        {
            Node newn = new Node(no);
            Node temp = first;

            for(int iCnt = 1; iCnt < pos-1; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next.prev = newn;
            temp.next = newn;
            newn.prev = temp;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if((first == null) && (last == null))
        {
            return;
        }

        else if(first == last)
        {
            first = null;
            last = null;
        }

        else
        {
            first = first.next;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        if((first == null) && (last == null))
        {
            return;
        }

        else if(first == last)
        {
            first = null;
            last = null;
        }

        else
        {
            last = last.prev;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteAtPos(int pos)
    {
        int iLength = Count();

        if((pos<1) || (pos>iLength))
        {
            System.out.println("Invalid position \n");
            return;
        }

        if(pos == 1)
        {
            DeleteFirst();
        }

        else if(pos == iLength)
        {
            DeleteLast();
        }

        else
        {
            Node temp = first;

            for(int iCnt = 1; iCnt < pos-1; iCnt++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;

            iCount--;
        }
    }


}