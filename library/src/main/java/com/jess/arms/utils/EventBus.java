package com.jess.arms.utils;

import com.squareup.otto.Bus;

/**
 * Created by J1aDong on 2017/1/10.
 */

public class EventBus extends Bus {
    private static EventBus bus;

    public static EventBus getDefault() {
        if (bus == null) {
            bus = new EventBus();
        }
        return bus;
    }
}
