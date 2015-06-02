package com.newsweaver.demo.colorservice.resources;

import com.newsweaver.demo.colorservice.model.Color;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColorResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ColorResource(new Color("steelblue", "4682B4")))
            .build();

    @Test
    public void shouldReturnAColor() throws Exception {
        Color actual = resources.client().target("/v1/color").request().get(Color.class);
        assertThat(actual.getName()).isEqualTo("steelblue");
        assertThat(actual.getHex()).isEqualTo("4682B4");
    }

}
