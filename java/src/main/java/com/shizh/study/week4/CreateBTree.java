package com.shizh.study.week4;
import java.util.*;
/**
 * @ClassName CreateBTree
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/10
 **/

  class BTNode			//二叉链中结点类
  {
    char data;			//存放数据元素
    BTNode lchild;		//指向左孩子结点
    BTNode rchild;		//指向右孩子结点
    public BTNode()		//默认构造方法
    {  lchild=rchild=null;  }
    public BTNode(char d)		//重载构造方法
    {
        data=d;
        lchild=rchild=null;
    }
    public void SetData(char d)
    {
        data=d;
    }
}
public class CreateBTree {
    static class BTreeClass		//二叉树类
    {
        BTNode b;        //根结点
        String bstr;            //二叉树的括号表示串

        public BTreeClass()        //构造方法
        {
            b = null;
        }

        //二叉树基本运算算法
        public void CreateBTree(String str) {
            Stack<BTNode> st = new Stack<BTNode>();     //建立一个栈st
            BTNode p = null;
            boolean flag = true;
            char ch;
            int i = 0;
            while (i < str.length())    //循环扫描str中每个字符
            {
                ch = str.charAt(i);
                switch (ch) {
                    case '(':
                        st.push(p);        //刚刚新建的结点有孩子,将其进栈
                        flag = true;
                        break;
                    case ')':
                        st.pop();        //栈顶结点的子树处理完，出栈
                        break;
                    case ',':
                        flag = false;        //开始处理栈顶结点的右孩子
                        break;
                    default:
                        p = new BTNode(ch);    //用ch值新建一个结点
                        if (b == null) {
                            b = p;        //若尚未建立根结点,p作为根结点
                        } else                //已建立二叉树根结点
                        {
                            if (flag)            //新结点p作为栈顶结点的左孩子
                            {
                                if (!st.empty()) {
                                    st.peek().lchild = p;
                                }
                            } else            //新结点p作为栈顶结点的右孩子
                            {
                                if (!st.empty()) {
                                    st.peek().rchild = p;
                                }
                            }
                        }
                        break;
                }
                i++;                //继续遍历
            }

        }
        @Override
        public String toString()			//返回二叉链的括号表示串
        {  bstr="";
            toString1(b);
            return bstr;
        }
        private void toString1(BTNode  t) //被toString方法调用
        {
            if (t!=null)
            {  bstr+=t.data;			//输出根结点值
                if (t.lchild!=null || t.rchild!=null)
                {  bstr+="(";			//有孩子结点时输出"("
                    toString1(t.lchild);		//递归输出左子树
                    if (t.rchild!=null) {
                        bstr+=",";			//有右孩子结点时输出","
                    }
                    toString1(t.rchild);		//递归输出右子树
                    bstr+=")";			//输出")"
                }
            }
        }
        public BTNode FindNode(char x)	//查找值为x的结点算法
        {
            return FindNode1(b,x);
        }
        private BTNode FindNode1(BTNode  t,char x)
//被FindNode方法调用
        {  BTNode  p;
            if (t==null) {
                return null;		//t为空时返回null
            } else if (t.data==x) {
                return t;				//t所指结点值为x时返回t
            } else
            {  p=FindNode1(t.lchild,x);		//在左子树中查找
                if (p!=null) {
                    return p;			//在左子树中找到p结点，返回p
                } else {
                    return FindNode1(t.rchild,x);	//返回在右子树中查找结果
                }
            }
        }
        public int Height()			//求二叉树高度的算法
        {
            return Height1(b);
        }
        private int Height1(BTNode t)	//被Height方法调用
        {   int lchildh,rchildh;
            if (t==null) {
                return 0;		//空树的高度为0
            } else
            {  lchildh=Height1(t.lchild);	//求左子树高度lchildh
                rchildh=Height1(t.rchild);	//求右子树高度rchildh
                return Math.max(lchildh,rchildh)+1;
            }
        }

        public void PreOrder1(BTreeClass bt)		//先序遍历的递归算法
        {
            PreOrder11(bt.b);
        }
        private void PreOrder11(BTNode t) 	//被PreOrder1方法调用
        {
            if (t!=null)
            {
                System.out.print(t.data+ " ");		//访问根结点
                PreOrder11(t.lchild);			//先序遍历左子树
                PreOrder11(t.rchild);			//先序遍历右子树
            }
        }
        public void InOrder1(BTreeClass bt)		//先序遍历的递归算法
        {
            InOrder11(bt.b);
        }
        private void InOrder11(BTNode t) 	//被PreOrder1方法调用
        {
            if (t!=null)
            {
                InOrder11(t.lchild);			//先序遍历左子树
                System.out.print(t.data+ " ");		//访问根结点
                InOrder11(t.rchild);			//先序遍历右子树
            }
        }
        public void PostOrder1(BTreeClass bt)		//先序遍历的递归算法
        {
            PostOrder11(bt.b);
        }
        private void PostOrder11(BTNode t) 	//被PreOrder1方法调用
        {
            if (t!=null)
            {
                PostOrder11(t.lchild);			//先序遍历左子树
                PostOrder11(t.rchild);			//先序遍历右子树
                System.out.print(t.data+ " ");		//访问根结点
            }
        }

    }
    public static class TestBTree  {

        public static void main(String[] args)
        {
            String data;
            data = "A(B(D(,F(H))),C(,E(G))";
            System.out.println("括号表示法："+data);
            BTreeClass btree = new BTreeClass();
            btree.CreateBTree(data);
            //System.out.println("树的结果："+btree.toString());
            // System.out.println("查找：");
            // btree.FindNode('C').SetData('X');
            //  System.out.println("修改值后的结果："+btree.toString());
            //System.out.println(_node.data);
            System.out.println("高度为："+btree.Height());
            System.out.print("先序序列:");
            btree.PreOrder1(btree);
            System.out.println();
            System.out.print("中序序列:");
            btree.InOrder1(btree);
            System.out.println();
            System.out.print("后序序列:");
            btree.PostOrder1(btree);

        }

    }
}
