package com.demo.metric;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class MetricManager {

    private static LinkedBlockingQueue<MetricFrame> queue = new LinkedBlockingQueue<>();

    public static void submit(MetricFrame metricFrame) {
        queue.add(metricFrame);
    }

    public static void analyse() {
        Map<MetricFrame, Long> count = queue.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        count.forEach((frame, cnt) -> {
            System.out.printf("执行次数cnt: %d, 类名: %s , 方法名: %s%n", cnt, frame.getClassName(), frame.getMethodName());
        });
    }
}
