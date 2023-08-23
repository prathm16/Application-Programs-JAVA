import java.util.*;

class stack
{
    public static void main(String args[])
    {
        Stack obj = new Stack();

        obj.Push(11);
        obj.Push(21);
        obj.Push(51);

        obj.Display();
        System.out.println("Number of elements in stack are : \n"+obj.Count());

        int iRet = obj.Pop();
        System.out.println("Poped elements from stack is : "+iRet);

        iRet = obj.Pop();
        System.out.println("Poped elements from stack is : "+iRet);

        iRet = obj.Pop();
        System.out.println("Poped elements from stack is : "+iRet);

        iRet = obj.Pop();
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

class Stack
{
    public Node first;
    public int iCount;

    public Stack()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {
        System.out.println("Elements in Stack are : \n");

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

    public void Push(int no)
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

    public int Pop()
    {
        int Value = 0;
        Node temp = first;

        if(first == null)
        {
            System.out.println("Stack is empty \n");
            return -1;
        }

        else if(first.next == null)
        {
            Value = first.data;
            first = null;
        }

        else
        {
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            Value = temp.next.data;
            temp.next = null;

            iCount--;
        }
        return Value;
    }
}