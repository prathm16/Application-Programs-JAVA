import java.util.*;

class p6
{
    public static void main(String args[])
    {
        Queue obj = new Queue();

        obj.Enqueue(11);
        obj.Enqueue(21);
        obj.Enqueue(51);

        obj.Display();
        System.out.println("Number of elements in queue are : "+obj.Count());

        int iRet = obj.Dequeue();
        System.out.println("Removed element from queue is : "+iRet);

        iRet = obj.Dequeue();
        System.out.println("Removed element from queue is : "+iRet);

        iRet = obj.Dequeue();
        System.out.println("Removed element from queue is : "+iRet);

        iRet = obj.Dequeue();
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

class Queue
{
    public Node first;
    public int iCount;

    public Queue()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {
        System.out.println("Elements in Queue are : \n");

        Node temp = first;

        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public int Count()
    {
        return this.iCount;
    }

    public void Enqueue(int no)
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

    public int Dequeue()
    {
        int Value = 0;

        if(first == null)
        {
            System.out.println("Queue is empty \n");
            return -1;
        }

        else if(first.next == null)
        {
            Value = first.data;
            first = null;
        }

        else
        {
            Value = first.data;
            first = first.next;

            iCount--;
        }
        return Value;
    }
}