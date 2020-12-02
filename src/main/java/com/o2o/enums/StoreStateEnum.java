package com.o2o.enums;

public enum StoreStateEnum {
    CHECK(0, "In Progress"),
    OFFLINE(-1, "Illegal Store"),
    SUCCESS(1, "Success"),
    PASS(2, "Certified"),
    INNER_ERROR(-1001, "System Inner Error"),
    NULL_STOREID(-1002, "StoreId is NuLL"),
    NULL_STORE(-1003, "Store Information is Null");

    private int state;
    private String stateInfo;

    private StoreStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static StoreStateEnum stateOf(int state) {
        for (StoreStateEnum storeStateEnum : values()) {
            if (storeStateEnum.getState() == state) {
                return storeStateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
