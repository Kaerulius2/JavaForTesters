package ru.stqa.ptf.mantis.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import ru.stqa.ptf.mantis.model.Issue;

import java.io.IOException;
import java.util.Set;

public class RestHelper {

    private final ApplicationManager app;

    public RestHelper(ApplicationManager app) {
        this.app = app;
    }

    public Issue getIssueById(int issueid) throws IOException {

        String json = getExecutor().execute(Request.Get(String.format("http://bugify.stqa.ru/api/issues/%s.json",issueid))).returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json); // парсим json
        JsonElement issues = parsed.getAsJsonObject().get("issues");//выбираем нужный элемент
        String resol = issues.getAsJsonArray().iterator().next().getAsJsonObject().get("state").getAsString();
        int id = issues.getAsJsonArray().iterator().next().getAsJsonObject().get("id").getAsInt();
        String desc = issues.getAsJsonArray().iterator().next().getAsJsonObject().get("description").getAsString();
        return new Issue().withId(id).withResolution(resol).withDescription(desc);
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490","");
    }

}
