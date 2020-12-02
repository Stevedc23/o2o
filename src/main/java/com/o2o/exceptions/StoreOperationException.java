package com.o2o.exceptions;

public class StoreOperationException  extends  RuntimeException{

    private static final long serialVersionUID = 9155904309250593500L;
    public StoreOperationException(String msg) {
        super(msg);
    }
}
