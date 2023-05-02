package com.etiya.ecommerceDemo.core.utils.result;

public class SuccessResult extends Result {
    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }

}
