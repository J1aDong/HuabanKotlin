package com.jess.arms.rx.rxerrorhandler.handler;

import com.jess.arms.rx.rxerrorhandler.handler.listener.ResponseErroListener;

import android.content.Context;

/**
 * Created by jess on 9/2/16 13:47
 * Contact with jess.yan.effort@gmail.com
 */
public class ErrorHandlerFactory {
    public final String TAG = this.getClass().getSimpleName();
    private Context mContext;
    private ResponseErroListener mResponseErroListener;

    public ErrorHandlerFactory(Context mContext, ResponseErroListener mResponseErroListener) {
        this.mResponseErroListener = mResponseErroListener;
        this.mContext = mContext;
    }

    /**
     *  处理错误
     * @param throwable
     */
    public void handleError(Throwable throwable) {
        mResponseErroListener.handleResponseError(mContext, (Exception) throwable);
    }
}
