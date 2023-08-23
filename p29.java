// Singly Linear LinkedList

import java.util.*;

class p29
{
    public static void main(String args[])
    {
        SinglyLL obj = new SinglyLL();

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

    public Node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyLL
{
    public Node first;
    public int iCount;

    public SinglyLL()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {
        System.out.println("Elements in the LL are : \n");

        Node temp = first;

        while(temp != null)
        {
            System.out.print(" | "+temp.data+" | -> ");
            temp = temp.next;
        }
        System.out.println("null \n");
    }

    public int Count()
    {
        return this.iCount;
    }

    public void InsertFirst(int no)
    {
        Node newn = new Node(no);

        if(first == null)
        {
            first = newn;
        }

        else
        {
            newn.next = first;
            first = newn;
        }
        iCount++;
    }

    public void InsertLast(int no)
    {
        Node newn = new Node(no);
        Node temp = first;

        if(first == null)
        {
            first = newn;
        }

        else
        {
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
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

            for(int iCnt = 1; iCnt <pos-1; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            return;
        }

        else if(first.next == null)
        {
            first = null;
        }

        else
        {
            first = first.next;
            iCount--;
        }
    }

    public void DeleteLast()
    {
        if(first == null)
        {
            return;
        }

        else if(first.next == null)
        {
            first = null;
        }

        else
        {
            Node temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
            iCount--;
        }
        
    }

    public void DeleteAtPos(int pos)
    {
        int iLength = Count();

        if((pos < 1) || (pos > iLength))
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
            Node tempX = null;

            for(int iCnt = 1; iCnt < pos-1; iCnt++)
            {
                temp = temp.next;
            }
            tempX = temp.next;
            temp.next = temp.next.next;


            iCount--;
        }
    }
}