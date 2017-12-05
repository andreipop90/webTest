package webTest;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class StatusCodeTest {
	@Test
	public void testApiReturns200()
{
		when()
	.get("http://mockbin.org/bin/0a37d42a-992a-4b1e-8cbf-1331a3347489/view")
	.then()
	.statusCode(200);
}
	@Test 
	public void testApiReturns400()
	{
		when()
		.get("http://mockbin.org/bin/4aa412fe-8277-41f2-a4f7-5301767b008c/view")
		.then()
		.statusCode(401);
	}
}
