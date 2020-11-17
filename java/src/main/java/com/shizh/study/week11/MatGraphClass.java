package com.shizh.study.week11;

import com.sun.corba.se.impl.orbutil.graph.Graph;

/**
 * @ClassName MatGraphClass
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/17
 **/


   public class MatGraphClass {        //图邻接矩阵类
    final int MAXV = 100;            //表示最多顶点个数
    final int INF = 0x3f3f3f3f;        //表示∞
    int[][] edges;            //邻接矩阵数组，元素为int类型
    int n, e;                //顶点数，边数
    String[] vexs;            //存放顶点信息

    public MatGraphClass() {        //构造方法
        edges = new int[MAXV][MAXV];
        vexs = new String[MAXV];
    }

    //图的基本运算算法
    public void CreateMatGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;            //置顶点数和边数
        for (int i = 0; i < n; i++) {
            edges[i] = new int[n];
            for (int j = 0; j < n; j++) {
                edges[i][j] = a[i][j];
            }
        }
    }

    public void DispMatGraph() {        //输出图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == INF) {
                    System.out.printf("%4s", "∞");
                } else {
                    System.out.printf("%5d", edges[i][j]);
                    System.out.println();
                }
            }
        }
    }

        public static int Degree1 (MatGraphClass g,int v) {
//无向图邻接矩阵中求顶点v的度
            int d = 0;
            for (int j = 0; j < g.n; j++) {    //统计第v行的非0非∞元素个数
                if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                    d++;
                }
            }
            return d;
        }

        public static int[] Degree2 (MatGraphClass g,int v)
//有向图邻接矩阵中求顶点v的出度和入度
        {
            int[] ans = new int[2];
            ans[0] = 0;            //累计出度
            for (int j = 0; j < g.n; j++) {    //统计第v行的非0非∞元素个数为出度
                if (g.edges[v][j] != 0 && g.edges[v][j] != g.INF) {
                    ans[0]++;
                    ans[1] = 0;
                }//累计入度
                for (int i = 0; i < g.n; i++) {    //统计第v列的非0非∞元素个数为入度
                    if (g.edges[i][v] != 0 && g.edges[i][v] != g.INF) {
                        ans[1]++;
                    }
                    //返回出度和入度
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        MatGraphClass matGraphClass = new MatGraphClass();
        

    }
    }
