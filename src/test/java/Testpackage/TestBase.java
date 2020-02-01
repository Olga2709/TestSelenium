package Testpackage;
import ApplicationManager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
//создалась ссылка на обьект типа апликейшнменеджер
    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() throws Exception {

        app.init();
    }

    @After
            public void tearDown () {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}

