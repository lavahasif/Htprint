package com.example.htprint;

public enum PrinterHead {
    _4Head(4),
    _3Head(3),
    _2Head(2),
    _1head(1);
    int name;

    public int getName() {
        return name;
    }

    PrinterHead(int name) {
        this.name = name;
    }
}
