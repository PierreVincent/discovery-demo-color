package com.newsweaver.demo.colorservice.health;

import com.codahale.metrics.health.HealthCheck;

public class ColorServiceHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        // Always healthy for now
        return Result.healthy();
    }
}
