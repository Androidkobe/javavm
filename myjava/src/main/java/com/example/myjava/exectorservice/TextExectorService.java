package com.example.myjava.exectorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.NonNull;

/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

public class TextExectorService {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    private static final int MINIMUM_CPU_COUNT = CPU_COUNT < 4 ? 4 : CPU_COUNT;

    private static final int CORE_POOL_SIZE = MINIMUM_CPU_COUNT + 1;

    private static final int MAXIMUM_POOL_SIZE = MINIMUM_CPU_COUNT * 2 + 1;

    private static final int DEFAULT_BACKGROUND_THREAD_PRIORITY = 7;

    private static final int DEFAULT_UI_THREAD_PRIORITY = 1;

    public static void main(String[] args) {
        final ThreadFactory sBackgroundThreadFactory = new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(@NonNull Runnable r) {
                Thread t = new Thread(r, "BackgroundThread-" + mCount.getAndIncrement());
                t.setPriority(DEFAULT_BACKGROUND_THREAD_PRIORITY);
                System.out.println("create thread");
                return t;
            }
        };

        System.out.println("core_pool_size = "+CORE_POOL_SIZE);
        System.out.println("maximum_pool_size = "+MAXIMUM_POOL_SIZE);
        final ExecutorService THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>
                (128), sBackgroundThreadFactory);

        List<TestRunable> testRunables = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestRunable testRunable = new TestRunable();
            testRunable.setI(i);
            testRunables.add(testRunable);
        }
        for (TestRunable test:testRunables
        ) {
            THREAD_POOL_EXECUTOR.execute(test);
        }

    }
}
