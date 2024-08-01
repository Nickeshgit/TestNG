package dependsn_Test;

import org.testng.annotations.Test;

public class DependsOn2_Test {

	@Test(priority = 4)
	public void signin() {
		System.out.println("signin");
	}
}
