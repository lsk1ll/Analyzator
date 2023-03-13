package com.javarush.cryptanalyzer.malacion.entity;

import com.javarush.cryptanalyzer.malacion.exception.ApplicationException;
import com.javarush.cryptanalyzer.malacion.repository.ResultCode;

public class Result {
    private ResultCode resultCode;
    private ApplicationException applicationException;
    public Result(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public Result(ResultCode resultCode, ApplicationException applicationException) {
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}
