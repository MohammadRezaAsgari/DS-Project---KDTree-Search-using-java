package com.sbu;

public class BankNode {

    Point point=new Point();
    String BrName;
    String Bankname;
    Myarray<BankNode> Branches =new Myarray<>(1);
    boolean isbase=false;
    BankNode left = null;
    BankNode right = null;
    BankNode parent=null;

    public void add(BankNode n) {
        add(n,this);
    }

    @Override
    public String toString() {
        String s1="Bankname=" + Bankname ;
        String s2="  BrName=" + BrName;
        String s3="  Point=> " + point;
        if(isbase)
            return s1+s3;
        else
            return s1+s2+s3;
    }

    public void add(BankNode n, BankNode bankNode) {
        if (n.point.x < bankNode.point.x){
            if (bankNode.left == null) {
                bankNode.left = n;
                n.parent=bankNode;
            }
            else
                add(n,bankNode.left);
        }
        else if (n.point.x > bankNode.point.x) {
            if (bankNode.right == null) {
                bankNode.right = n;
                n.parent=bankNode;
            }
            else
                add(n,bankNode.right);
        }
        else {
            if (n.point.y < bankNode.point.y){
                if (bankNode.left == null) {
                    bankNode.left = n;
                    n.parent=bankNode;
                }
                else
                    add(n,bankNode.left);
            }
            else{
                if (bankNode.right == null){
                    bankNode.right = n;
                    n.parent=bankNode;
                }
                else
                    add(n,bankNode.right);
            }


        }
    }

    public boolean is_right(BankNode n){
        if(n.point.x>n.parent.point.x)
            return true;
        else if(n.point.x<n.parent.point.x)
            return false;
        else {
            if(n.point.y>n.parent.point.y)
                return true;
            else
                return false;
        }
    }

    public BankNode findmin(BankNode node){
        BankNode n=node;
        while(n.left!=null){
            n=node.left;
        }
        return n;
    }

    public void swap(BankNode n1,BankNode n2){
        if(is_right(n2))
            n2.parent.right=null;
        else
            n2.parent.left=null;
        n1.Bankname=n2.Bankname;
        n1.BrName=n2.BrName;
        n1.point.x=n2.point.x;
        n1.point.y=n2.point.y;

    }

    public void dell(){
        if((right==null)&&(left==null)){
            if(is_right(this))
                parent.right=null;
            else
                parent.left=null;
        }
        else if(right==null){
            left.parent=parent;
            if(is_right(this))
                parent.right=left;
            else
                parent.left=left;
        }
        else if(left==null){
            right.parent=parent;
            if(is_right(this))
                parent.right=right;
            else
                parent.left=right;
        }
        else {
            BankNode n=findmin(this.right);
            if(n.right!=null){
                n.right.parent=n.parent;
                n.parent.left=n.right;
            }
            swap(this,n);
        }

        
    }

}
