package com.newsweaver.demo.colorservice;

import com.newsweaver.demo.colorservice.model.Color;
import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ColorServiceTest {

    @ClassRule
    public static DropwizardAppRule<Configuration> RULE = new DropwizardAppRule<>(ColorService.class, null);

    @Test
    public void shouldReturn200WithColorInJson() throws Exception {
        Client client = ClientBuilder.newClient();
        Response response = client.target(String.format("http://localhost:%d/v1/color", RULE.getLocalPort()))
                .request()
                .get(Response.class);
        assertThat(response.getStatus()).isEqualTo(200);
        Color color = response.readEntity(Color.class);
        assertThat(color.getName()).isNotEmpty();
        assertThat(color.getHex().length()).isEqualTo(6);
    }
}
