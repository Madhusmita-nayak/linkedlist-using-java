package com.java.list;
import java.util.Scanner;
//Here I am using single linked list without user input.
//The nodes can have only int type of data.
class Node
{
 int data;
 Node next;
 Node current;
 Node last;
 Node head;
 Node prev;
}
class Features extends Node
{
    public void display()
    {
        if (head==null)
            System.out.println("The list is empty.");
     current=head;
     while (current!=null)
     {
         System.out.println(current.data);
         current=current.next;
     }
    }
  public void create(Node current)
  {
      this.current=current;
      if(head==null)
      {
          head=current;
          head.next=null;
          last=head;
      }
      else if (last==head)
      {
          last.next=current;
          last=current;
          last.next=null;
      }
      else
      {
          last.next=current;
          last=current;
          last.next=null;
      }
  }
  public void deleteByIndex(int index)
  {
      if(head==null)
          System.out.println("No element present.");
      int i=0,c=0;
      current=head;
      if(index==0)
      {
          head=head.next;
          c++;
      }
      else
      {
          while (current != null) {
              if (i+1 == index)
              {
                  if (current.next == last)
                  {
                           current.next=null;
                           c++;
                           break;
                  }
                  else
                  {
                      current.next = current.next.next;
                      c++;
                      break;
                  }
              }

              current = current.next;
              i++;
          }
      }
      if(c==1)
          System.out.println("Data deleted successfully.");
      else
          System.out.println("Index does not exist.");
  }
  public void deleteByUser(int rmv)
  {
      if(head==null)
          System.out.println("No element present.");
      int c=0;
      current=head;
      if (head.data==rmv)
      {
          head=head.next;
          c++;
      }
      else
      {
          while (current!= null)
          {
              if(current.next==last)
              {
                  if (last.data==rmv)
                  {
                      current.next=null;
                      c++;
                      break;
                  }
              }
              else if (current.data == rmv)
              {
                      {
                          current.next = current.next.next;
                          c++;
                          break;
                      }
              }
              current = current.next;
          }
      }
      if(c==1)
          System.out.println("Data deleted successfully.");
      else
          System.out.println("Similar data does not found.");
  }
  public void reverse()
  {
      if (head==null)
          System.out.println("The list is empty.");
      head.prev=null;
      current=head;
      while (current!=null)
      {

          current=current.next;
      }
      head=prev;
      System.out.println("The list reversed successfully.");
  }
  public void detectLoop()
  {
      if(last.next==head)
          System.out.println("Loop present.");
      else
          System.out.println("There is no loop present.");
  }
  public void separateOddEven()
  {
      current=head;
      while (current!=null)
      {
          if(current.data%2==0)
              System.out.println(current.data);
          else
              System.out.println(current.data);
      }
  }
  public void sort()
  {
      Node temp,aux;
      current=head;
      temp=head;
      while(current.next!=null)
      {
          if(temp.data > current.data)
          {
              aux=temp;
              current=temp;
              temp=aux;
          }
          current=current.next;
      }
  }
}
public class LinkedList extends Features {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      Features l=new Features();
      int opt=0;
        while(opt!=9)
        {
            System.out.println("The option available are: \n 1.create \n 2.display \n 3.delete by user \n 4.delete by index \n 5.reverse \n 6.detection of loop \n 7.sort \n 8.separate odd and even \n 9.exit");
            System.out.println("Enter any option:");
            opt=sc.nextInt();
            switch (opt) {
                case 1:
                {
                    int i;
                    System.out.println("Enter how many value you want to insert:");
                    i = sc.nextInt();
                    while (i > 0)
                    {
                        Node ni = new Node();
                        System.out.println("Enter the value:");
                        ni.data = sc.nextInt();
                        l.create(ni);
                        i--;
                    }
                    System.out.println("List created.");
                    break;
                }
                case 2:
                {
                    l.display();
                    break;
                }
                case 3:
                {
                    int rmv;
                    System.out.println("Data to be deleted:");
                    rmv= sc.nextInt();
                    l.deleteByUser(rmv);
                    break;
                }
                case 4:
                {
                    int index;
                    System.out.println("Enter the index value:");
                    index=sc.nextInt();
                    l.deleteByIndex(index);
                    break;
                }
                case 5:
                {
                    l.reverse();
                    break;
                }
                case 6:
                {
                    l.detectLoop();
                    break;
                }
                case 7:
                {
                    l.sort();
                    break;
                }
                case 8:
                {
                    l.separateOddEven();
                    break;
                }
                case 9:
                {
                    System.out.println("Thank you.");
                    break;
                }
                default:
                    System.out.println("wrong option selected.");
            }
        }
    }
}
