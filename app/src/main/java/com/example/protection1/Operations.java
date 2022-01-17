package com.example.protection1;


/**
 * @author anechaev
 * @since 17.01.2022
 */
public enum Operations {
    PLUS            ((a1, a2) -> a1 + a2),
    MINUS           ((a1, a2) -> a1 - a2),
    MULTIPLICATION  ((a1, a2) -> a1 * a2),
    DIVIDING        ((a1, a2) -> a1 / a2);

    private Action action;

    Operations(Action op) {
        this.action = op;
    }

    public Action getAction() {
        return action;
    }

    public interface Action {
        public int apply(int a1, int a2);
    }
}
