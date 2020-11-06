package com.shizh.study.month2;

/**
 * @ClassName Test5
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/6
 **/
public class Test5 {
    /**
      * 模拟在一副牌中，抽取第一张，第六张，第50张扑克牌
     */
        public static void main(String[] args) {
            //获取所有扑克牌
            String[] puke = getPuke();

            //抽取指定的三种扑克牌
            int num1 = 1;
            int num2 = 5;
            int num3 = 50;
            String[] pk3 = get3(puke, num1, num2, num3);
            //打印抽取的牌
            for (int i = 0; i < pk3.length; i++) {
                System.out.println(pk3[i] + " ");
            }
        }
        private static String[] getPuke() {
            String[] colors = {"黑色", "红桃", "梅花", "方块"};
            String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

            String[] puke = new String[54];
            int index = 0;
            for (int i = 0; i < colors.length; i++){
                for (int j = 0; j < nums.length; j++){
                    puke[index] = colors[i] + nums[j];
                    index ++;
                }
            }

            puke[52] = "小王";
            puke[53] = "大王";

            return puke;
        }

        public static String[] get3(String[] puke, int i, int i2, int i3){
            String[] pk3 = new String[3];
            pk3[0] = puke[i - 1];
            pk3[1] = puke[i2 - 1];
            pk3[2] = puke[i3 - 1];
            return pk3;
        }
    }

