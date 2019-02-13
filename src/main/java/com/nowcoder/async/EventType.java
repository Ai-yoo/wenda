package com.nowcoder.async;

/**
 * @author duzhentong
 */
public enum EventType {
    LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3),
    FOLLOW(4),
    UNFOLLOW(5),
    ADD_QUESTION(6),
    FIND_PASSWORD(7);

    private int value;
    EventType(int value) { this.value = value; }
    public int getValue() { return value; }
}
