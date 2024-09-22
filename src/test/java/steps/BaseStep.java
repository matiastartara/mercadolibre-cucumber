package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

import java.net.MalformedURLException;

public class BaseStep {
    @Before
    public void setUp() throws MalformedURLException {
        Driver.get().navigate().to("https://www.mercadolibre.com.ar");
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown() throws MalformedURLException {
        Driver.get().quit();
    }
}
