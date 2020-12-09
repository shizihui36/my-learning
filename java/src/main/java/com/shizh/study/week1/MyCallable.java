package com.shizh.study.week1;

import java.util.concurrent.*;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {

            String value = "test";
            System.out.println("ready to work");
            Thread.sleep(5000);
            System.out.println("task done");
            return value;
        }
    }
class TreadPoolDemo {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        // 向线程池中提交任务
        Future<String> future = executorService.submit(new MyCallable());
        // 判断任务是否完成
        if (!future.isDone()) {
            System.out.println("task not finished, please wait~~");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 将线程池关闭
            executorService.shutdown();
        }
    }
}
