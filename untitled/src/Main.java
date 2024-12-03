/*************************************************************************************************************/

public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist)
{
    SinglyLinkedListNode head = null;
    while(llist!=null)
    {
        SinglyLinkedListNode n = new SinglyLinkedListNode(llist.data);
        n.next=head;
        head=n;
        llist=llist.next;
    }
    return head;
}

/*************************************************************************************************************/

static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
{
    int size=0;
    int size2=0;
    SinglyLinkedListNode temp = head1;
    SinglyLinkedListNode temp1 = head2;
    while(temp!=null)
    {
        size=size+1;
        temp=temp.next;

    }
    while(temp1!=null)
    {
        size2=size2+1;
        temp1=temp1.next;

    }

    if(size!=size2)
    {
        return false;
    }
    while(head1!=null && head2!=null)
    {
        if(head1.data!=head2.data)
        {
            return false;
        }
        head1=head1.next;
        head2=head2.next;
    }
    return true;
}

/*************************************************************************************************************/

static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
{
    SinglyLinkedListNode list = new SinglyLinkedListNode(0);

    SinglyLinkedListNode current = list;

    while(head1!=null && head2!=null)
    {
        if(head1.data<=head2.data)
        {
            current.next=head1;
            head1=head1.next;
        }
        else
        {
            current.next=head2;
            head2=head2.next;
        }
        current=current.next;
    }

    if(head1!=null)
    {
        current.next=head1;
    }
    else{
        current.next=head2;
    }

    return list.next;


}

/*************************************************************************************************************/

public static int getNode(SinglyLinkedListNode llist, int positionFromTail)
{
    SinglyLinkedListNode temp=llist;
    int count=0;
    while(temp!=null)
    {
        temp=temp.next;
        count=count+1;
    }
    int a=count-positionFromTail-1;
    for(int i=0;i<a;i++)
    {
        llist=llist.next;
    }
    return llist.data;
}

/*************************************************************************************************************/

public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist)
{
    SinglyLinkedListNode current = llist;
    while(current!=null)
    {
        SinglyLinkedListNode runner=current;
        while(runner.next!=null)
        {
            if(runner.next.data==current.data)
            {
                runner.next=runner.next.next;
            }
            else
            {
                runner=runner.next;
            }

        }
        current=current.next;
    }
    return llist;

}

/*************************************************************************************************************/

public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist)
{
    HashSet<Integer> set = new HashSet<>();
    SinglyLinkedListNode previous=null;
    SinglyLinkedListNode current=llist;
    while(current!=null)
    {
        if(set.contains(current.data)){
            previous.next=current.next;
        }
        else{
            set.add(current.data);
            previous=current;
        }
        current=current.next;
    }
    return llist;

}

/*************************************************************************************************************/

static boolean hasCycle(SinglyLinkedListNode head)
{
    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;

    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
        {
            break;

        }
    }
    if(fast==null || fast.next==null)
    {
        return false;
    }
    slow=head;
    while(slow!=fast)
    {
        slow=slow.next;
        fast=fast.next;
    }
    return true;

}

/*************************************************************************************************************/

static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
{
    int count=0;
    int count2=0;
    SinglyLinkedListNode current=head1;
    SinglyLinkedListNode current1=head2;
    while(current!=null)
    {
        current=current.next;
        count=count+1;
    }
    while(current1!=null)
    {
        current1=current1.next;
        count2=count2+1;
    }

    int x = Math.abs(count-count2);

    if(count>count2)
    {
        while(x>0)
        {
            head1=head1.next;
            x--;
        }
    }
    else
    {
        while(x>0)
        {
            head2=head2.next;
            x--;
        }
    }

    while(head1!=head2)
    {
        head1=head1.next;
        head2=head2.next;
    }
    return head1.data;


}


