package org.example;

/**
 * 结构化日志实体
 *
 * @author: weibang kong
 * @date: 2025-03-25 15:37:24
 */
public class LogEvent {
    /**
     * 日志时间戳
     */
    private String timestamp;
    /**
     * 线程
     */
    private String thread;
    /**
     * 链路追踪traceId
     */
    private String traceId;
    /**
     * 链路追踪spanId
     */
    private String spanId;
    /**
     * 日志内容
     */
    private String message;

    /**
     * 用户ID
     */
    private String userId;

}
