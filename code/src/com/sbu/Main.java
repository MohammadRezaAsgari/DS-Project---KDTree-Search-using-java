package com.sbu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Myarray<Neihood> array_N=new Myarray<>(1);
        Myarray<BankNode> array_B=new Myarray<>(1);
        Tree t1=new Tree();

        String input ="";
        do{
            input = sc.nextLine();

            if(input.equals("addN")){
                Neihood n1=new Neihood();

                System.out.println("Enter the name:");
                String name=sc.nextLine();
                n1.Name=name;

                boolean flag=true;
                if(!array_N.isempty()){
                    for(int i=0;i< array_N.count;i++){
                        if(array_N.get(i).Name.equals(name))
                            flag=false;
                    }
                }
                if(!flag)
                    System.out.println("The Neighbourhood name already exists!");
                else {
                System.out.println("Enter x1:");
                n1.xy1.x=sc.nextInt();
                System.out.println("Enter y1:");
                n1.xy1.y=sc.nextInt();
                System.out.println("Enter x2:");
                n1.xy2.x=sc.nextInt();
                System.out.println("Enter y2:");
                n1.xy2.y=sc.nextInt();
                System.out.println("Enter x3:");
                n1.xy3.x=sc.nextInt();
                System.out.println("Enter y3:");
                n1.xy3.y=sc.nextInt();
                System.out.println("Enter x4:");
                n1.xy4.x=sc.nextInt();
                System.out.println("Enter y4:");
                n1.xy4.y=sc.nextInt();
                array_N.addElement(n1);
                }
            }

            else if(input.equals("addB")){
                BankNode b1=new BankNode();

                System.out.println("Enter the bank name:");
                String name=sc.nextLine();
                b1.Bankname=name;

                boolean flag=true;
                if(!array_B.isempty()){
                    for(int i=0;i< array_B.count;i++){
                        if(array_B.get(i).Bankname.equals(name)){
                            flag=false;
                            break;
                        }
                    }
                }

                if(!flag)
                    System.out.println("The Bank name already exists!");
                else {
                    boolean fflag=false;
                    do{
                        System.out.println("Enter x:");
                        int x = sc.nextInt();
                        b1.point.x = x;
                        System.out.println("Enter y:");
                        int y = sc.nextInt();
                        b1.point.y = y;
                        b1.isbase = true;

                        Point p1 = new Point(x, y);
                        if (t1.search(p1)!=null)
                            System.out.println("There's another bank in this location!");
                        else {
                            t1.add(b1);
                            array_B.addElement(b1);
                            fflag=true;
                        }
                    }while (!fflag);
                }

            }

            else if(input.equals("addBr")){
                BankNode b1=new BankNode();

                System.out.println("Enter the bank name:");
                String name=sc.nextLine();
                b1.Bankname=name;
                String bname="";
                int cc=0;

                boolean flag=false;
                if(!array_B.isempty()){
                    for(int i=0;i< array_B.count;i++){
                        if(array_B.get(i).Bankname.equals(name)){
                            System.out.println("Enter the branch name:");
                            bname=sc.nextLine();
                            b1.BrName=bname;
                            cc=i;
                            flag=true;
                            break;
                        }

                    }
                }

                if(!flag)
                    System.out.println("The Bank name doesnt exists!");
                else {
                    boolean fflag=false;
                    do{
                        System.out.println("Enter x:");
                        int x=sc.nextInt();
                        b1.point.x=x;
                        System.out.println("Enter y:");
                        int y=sc.nextInt();
                        b1.point.y=y;
                        b1.isbase=false;

                        Point p1=new Point(x,y);
                        if(t1.search(p1)!=null)
                            System.out.println("There's another bank in this location!");
                        else {
                            t1.add(b1);
                            array_B.get(cc).Branches.addElement(b1);
                            fflag=true;
                        }
                    }while (!fflag);
                }

            }

            else if (input.equals("delBr")){
                System.out.println("Enter x:");
                int x=sc.nextInt();
                System.out.println("Enter y:");
                int y=sc.nextInt();
                Point point=new Point(x,y);

                boolean flag=false;
                if(!array_B.isempty()){
                    for(int i=0;i< array_B.count;i++){
                        for(int j=0;j<array_B.get(i).Branches.count;j++)
                            if(array_B.get(i).Branches.get(j).point.x==x && array_B.get(i).Branches.get(j).point.y==y){
                                array_B.get(i).Branches.removeElementAt(j);
                                System.out.println("Removed bank in ("+x+","+y+")");
                                flag=true;
                                break;
                            }
                    }
                }
                else
                    System.out.println("Theres no bank!");
                if(!flag)
                    System.out.println("Theres not a branch of bank in this location!");
                if(flag)
                    t1.delnode(point);
            }

            else if(input.equals("listB")){
                System.out.println("Enter name of the Neighbourhood:");
                String name=sc.nextLine();
                Neihood neihood=new Neihood();

                boolean flag=false;
                if(!array_N.isempty()){
                    for(int i=0;i< array_N.count;i++){
                        if(array_N.get(i).Name.equals(name)){
                            neihood=array_N.get(i);
                            flag=true;
                            break;
                        }
                    }
                }
                if(!flag)
                    System.out.println("The Neighbourhood name doesnt exists!");
                else {

                    Myarray<BankNode> banks=t1.listB(neihood);
                    if(banks.count!=0) {
                        for (int i = 0; i < banks.count; i++)
                            System.out.println(banks.get(i).toString());
                    }
                    else
                        System.out.println("This Neighbourhood doesnt have any banks!");

                }

            }

            else if(input.equals("listBrs")){
                System.out.println("Enter name of the bank: ");
                String name=sc.nextLine();
                BankNode b1=new BankNode();

                boolean flag=true;
                if(!array_B.isempty()){
                    for(int i=0;i< array_B.count;i++){
                        if(array_B.get(i).Bankname.equals(name)){
                            b1=array_B.get(i);
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag)
                    System.out.println("The Bank name doesnt exists!");
                else {
                    for(int i=0;i< b1.Branches.count;i++)
                        System.out.println(b1.Branches.get(i).toString());
                }


            }

            else if(input.equals("nearB")){
                System.out.println("Enter x:");
                int x=sc.nextInt();
                System.out.println("Enter y:");
                int y=sc.nextInt();
                Point p1=new Point(x,y);

                if(array_B.count!=0)
                    System.out.println(t1.nearestB(p1).toString());
                else
                    System.out.println("Theres no bank!");
            }

            else if(input.equals("nearBr")){
            }

            else if(input.equals("availB")){
                System.out.println("Enter center of the circle");
                System.out.println("Enter x:");
                int x=sc.nextInt();
                System.out.println("Enter y:");
                int y=sc.nextInt();
                Point p1=new Point(x,y);
                System.out.println("Enter radius of the circle:");
                int r=sc.nextInt();
                Circle c1=new Circle(p1,r);

                Myarray<BankNode> banks=t1.availB(c1);
                if(banks.count!=0) {
                    for (int i = 0; i < banks.count; i++)
                        System.out.println(banks.get(i).toString());
                }
                else
                    System.out.println("This circle doesnt have any banks!");

            }

        }while (!input.equals("end"));
    }
}
