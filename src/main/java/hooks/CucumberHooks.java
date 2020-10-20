package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks extends TestNgHooks{

	@Before
	public void before(Scenario sc) {
		startTestCase(sc.getName(), sc.getId());
	}
	
	@After
	public void after() {
		//closeAllBrowsers();
	}

}





