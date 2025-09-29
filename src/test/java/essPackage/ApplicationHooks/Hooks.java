package essPackage.ApplicationHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends BaseClass {

    @Before
    public void launchBrowser() throws IOException {
        setup();
        System.out.println(">>> Browser launched and Properties loaded <<<");
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();   // closes the browser
            driver = null;   // release memory
        }
    }
}
