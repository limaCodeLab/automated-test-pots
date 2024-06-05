package testCases.posts;

import com.autotest.api.utils.TestResultExtension;
import com.autotest.api.utils.ValidationsBase;
import com.autotest.api.utils.readers.JsonReader;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@Tag("PostsFailure")
@ExtendWith(TestResultExtension.class)
public class PostsFailure extends ValidationsBase {

    JsonReader json = new JsonReader();
    TestResultExtension report = new TestResultExtension();

    @Test
    public void valida_falha_GET_com_url_incorreta(){

        ExtractableResponse<Response> response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("https://jsonplaceholder.typicode.com/post/ERROR")
                        .then()
                        .log().status()
                        .extract();
        report.registroRespostaBodyRelatorio(response);
        response.response().then().statusCode(404);

    }
}