package Testpackage;
import ApplicationManager.ApplicationManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
//создалась ссылка на обьект типа апликейшнменеджер
    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown () {
        app.stop();
    }
    public ApplicationManager getApp() {
        return app;
    }
}

