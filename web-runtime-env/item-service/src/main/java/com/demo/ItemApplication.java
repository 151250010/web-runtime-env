package com.demo;

import com.demo.metric.MetricFrame;
import com.demo.metric.MetricManager;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.demo")
public class ItemApplication {


    public static void main(String[] args) {
        // 这里是可以通过preMain agent的方式注入 直接注入之后触发机器重启就可以统计启动时长

        // 如何触发机器重启？
        createAnalyseThread();
        SpringApplication.run(ItemApplication.class, args);

    }

    /**
     * 统计每个方法耗时
     *
     * a -> b -> c
     *
     * 第一次看到 a
     * 第二次看到 a => b 实际上还是在调用a方法，a可以再计算一次耗时
     * 第三次看到 a => b => c 实际上还是在调用a方法 , a可以加耗时，b也可也加耗时，c可以加耗时
     *
     *
     * // 要存储一条路径，看到之前路径已经存在的话 出现次数+1
     *
     *
     *
     */
    private static void createAnalyseThread() {
        Thread mainThread = Thread.currentThread();

        Runnable analyseTask = () -> {
            while (true) {
                StackTraceElement[] stackTraceElements = mainThread.getStackTrace();
                // 这里只采集数据就行
                if (stackTraceElements.length > 0) {
                    // 方法被调用多少次？ 估算耗时是多长时间
                    StackTraceElement topEle =  stackTraceElements[0];
                    MetricFrame metricFrame = new MetricFrame(topEle.getMethodName(), topEle.getClassName(), topEle.isNativeMethod(), topEle.getFileName(), topEle.getLineNumber());

                    // 直接方法 + count 就行
                    MetricManager.submit(metricFrame);
                }else {
                    // 启动完成之后直接分析就行
                    MetricManager.analyse();
                    break;
                }

                // java 红黑树实现

                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread analyseThread = new Thread(analyseTask);
        analyseThread.start();
    }

}
