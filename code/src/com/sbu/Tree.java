package com.sbu;

public class Tree {
    BankNode root = null;

    public BankNode search(Point p){
        return search(root, p);
    }

    private BankNode search(BankNode n, Point p){
        if(n==null)
            return null;

        else if((n.point.x==p.x)&&(n.point.y==p.y))
            return n;

        else if ((n.point.x > p.x)&&(n.left!=null))
            return search(n.left,p);

        else if ((n.point.x < p.x)&&(n.right!=null))
            return search(n.right,p);

        else if(n.point.x == p.x){
            if ((n.point.y > p.y)&&(n.left!=null))
                return search(n.left,p);
            else if ((n.point.y < p.y)&&(n.right!=null))
                return search(n.right,p);
        }

        return null;
    }



    public void delnode(Point p){
        delnode(root,p);
    }

    private void delnode(BankNode n,Point p){
        if((n.point.x==p.x)&&(n.point.y==p.y))
            n.dell();
        else if ((n.point.x > p.x)&&(n.left!=null))
            delnode(n.left,p);
        else if ((n.point.x < p.x)&&(n.right!=null))
            delnode(n.right,p);
        else {
            if ((n.point.y > p.y)&&(n.left!=null))
                delnode(n.left,p);
            else if ((n.point.y < p.y)&&(n.right!=null))
                delnode(n.right,p);
        }
    }
    public void add(BankNode n) {
        if (root == null)
            root = n;
        else
            root.add(n);
    }

    public Myarray<BankNode> listB(Neihood neihood) {
        Myarray<BankNode> banks=new Myarray<>(1);
        listB(root, neihood,banks);
        return banks;
    }
    public void listB(BankNode n,Neihood neihood,Myarray<BankNode> banks) {
        if(n==null)
            return;
        if(neihood.findPoint(n.point))
            banks.addElement(n);
        if(n.left!=null && neihood.findPoint(n.left.point))
            listB(n.left,neihood,banks);
        if(n.right!=null && neihood.findPoint(n.right.point))
            listB(n.right,neihood,banks);
    }



    public Myarray<BankNode> availB(Circle circle) {
        Myarray<BankNode> banks=new Myarray<>(1);
        availB(root, circle,banks);
        return banks;
    }
    public void availB(BankNode n,Circle circle,Myarray<BankNode> banks) {
        if(n==null)
            return;
        if(circle.findPoint(n.point))
            banks.addElement(n);
        if(n.left!=null && circle.findPoint(n.left.point))
            availB(n.left,circle,banks);
        if(n.right!=null && circle.findPoint(n.right.point))
            availB(n.right,circle,banks);
    }




    public BankNode nearestB(Point target) {
        return nearestB(root, target,0);
    }


    private BankNode nearestB(BankNode bankNode, Point target,int k) {

        if (bankNode == null) return null;

        BankNode nextBranch = null;
        BankNode otherBranch = null;

        if(target.x < bankNode.point.x){
            nextBranch = bankNode.left;
            otherBranch = bankNode.right;
        }
        else if(target.x > bankNode.point.x){
            nextBranch = bankNode.right;
            otherBranch = bankNode.left;
        }
        else {
            if(target.y < bankNode.point.y){
                nextBranch = bankNode.left;
                otherBranch = bankNode.right;
            }
            else{
                nextBranch = bankNode.right;
                otherBranch = bankNode.left;
            }


        }

        BankNode temp = nearestB(nextBranch, target,k+1);
        BankNode best = closest(temp,bankNode,target);

        long radiusSquared = distSquared(target, best.point);
        long dist = target.x - bankNode.point.x;

        if (radiusSquared >= dist * dist) {
            temp = nearestB(otherBranch, target,k+1);
            best = closest(temp, best, target);
        }

        return best;
    }

    BankNode closest(BankNode n1, BankNode n2, Point target) {
        if (n1 == null) return n2;

        if (n2 == null) return n1;

        long d1 = distSquared(n1.point, target);
        long d2 = distSquared(n2.point, target);

        if (d1 < d2)
            return n1;
        else
            return n2;
    }


    public static long dist(Point p0, Point p1) {
        return (long) Math.sqrt(distSquared(p0, p1));
    }

    
    static long distSquared(Point p1, Point p2) {
        long total = 0;

        int dist = Math.abs(p1.x - p2.x);
        total += Math.pow(dist, 2);

        int dist2 = Math.abs(p1.y - p2.y);
        total += Math.pow(dist2, 2);

        return total;
    }

}
