package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTest {

    @BeforeClass
    public void init(){
        RestAssured.authentication= RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490","");
    }

    @Test
    public void testCreateIssue() throws IOException {

        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("Test Desc");
        int issueId = createIssue(newIssue);

        oldIssues.add(newIssue.withId(issueId));
        Set<Issue> newIssues = getIssues();
        assertEquals(newIssues,oldIssues);
    }

    private Set<Issue> getIssues() throws IOException {
        String json = RestAssured.get("http://bugify.stqa.ru/api/issues.json?limit=500").asString();
        JsonElement parsed = new JsonParser().parse(json); // парсим json
        JsonElement issues = parsed.getAsJsonObject().get("issues");//выбираем нужный элемент
        return new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());

    }

    private int createIssue(Issue newIssue) throws IOException {
        String json = RestAssured.given()
                .parameter("subject",newIssue.getSubject())
                .parameter("description",newIssue.getDescription())
                .post("http://bugify.stqa.ru/api/issues.json").asString();

        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();

    }


}
