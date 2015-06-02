package com.newsweaver.demo.colorservice;

import com.newsweaver.demo.colorservice.health.ColorServiceHealthCheck;
import com.newsweaver.demo.colorservice.model.ColorSet;
import com.newsweaver.demo.colorservice.resources.ColorResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ColorService extends Application<Configuration>  {

    public static final String SERVICE_ID = "color-service";

    public static void main(String[] args) throws Exception {
        new ColorService().run(args);
    }

    @Override
    public String getName() {
        return "Color Service";
    }

    @Override
    public void initialize(Bootstrap<Configuration> config) {
        config.addBundle(new Java8Bundle());
    }

    @Override
    public void run(Configuration config, Environment environment) throws Exception {
        environment.healthChecks().register(SERVICE_ID, new ColorServiceHealthCheck() );
        environment.jersey().register(new ColorResource(ColorSet.randomColor()));
    }

}
