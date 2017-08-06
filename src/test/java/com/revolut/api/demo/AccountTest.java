package com.revolut.api.demo;

import com.revolut.api.demo.api.Account;
import com.revolut.api.demo.api.Message;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @ClassRule
    public static final DropwizardAppRule<AccountConfig> RULE = new DropwizardAppRule<>(AccountApplication.class);

    private static String baseUrl;
    private static Client client;

    @BeforeClass
    public static void setUp() {
        baseUrl = String.format("http://localhost:%d", RULE.getLocalPort());
        client = new JerseyClientBuilder(RULE.getEnvironment()).build("Account API Client");
    }

    @Test
    public void shouldReturnAccountTest() {
        String url = String.format("%s/account", baseUrl);
        Response response = client.target(url).request().accept(APPLICATION_JSON_TYPE).get();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("Account API");
    }

    @Test
    public void withdrawFromAccountTest() {
        String url = String.format("%s/account/withdraw/1/20", baseUrl);
        Response response = client.target(url).request().get();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("79.99");
    }

    @Test
    public void depositIntoAccountTest() {
        String url = String.format("%s/account/deposit/1/50", baseUrl);
        Response response = client.target(url).request().get();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("129.99");
    }

   @Test
    public void transferBetweenAccountsTest() {
        String url = String.format("%s/account/transfer/2/3/20", baseUrl);
        Response response = client.target(url).request().get();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo("79.99");
    }
}
