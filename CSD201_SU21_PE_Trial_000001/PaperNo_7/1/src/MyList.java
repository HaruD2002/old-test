/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        Node q = new Node(new Car(xOwner, xPrice));

        if (q.info.owner.charAt(0) == 'B' || q.info.price > 100) {
            return;
        }
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Car x = new Car("X", 1);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = new Node(x);
        Node q = head;
        if (q == null) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head = p;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        Node q = head;
        q = q.next;
        if (q == null) {
            tail = null;
        }
    }

    void remove(Node q) {
        if (isEmpty() || q == null) {
            return;
        }
        Node p = head;
        if (p == null) {
            return;
        }
        if (q == p) {
            removeFirst();
            return;
        }
        while (p != null && p.next != q) {
            p = p.next;
        }
        Node x = q.next;

        if (p.next == null) {
            tail = p;
        }

    }

    Node findPrice(int xPrice) {
        Node p = head;
        while (p != null) {
            if (p.info.price == xPrice) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void removeNode(int xPrice) {
        Node p = findPrice(xPrice);
        remove(p);
    }

    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        removeNode(5);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        Node p = head, q = null;
        Car temp;
        if (p == null) {
            return;
        }
        while (p != null) {
            q = p.next;
            while (q != null) {
                if (p.info.price > q.info.price) {
                    temp = p.info;
                    p.info = q.info;
                    q.info = temp;
                }
                q = q.next;
            }
            p = p.next;

        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
