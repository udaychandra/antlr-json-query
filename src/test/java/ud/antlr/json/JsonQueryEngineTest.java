package ud.antlr.json;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonQueryEngineTest {

    private static JsonQueryEngine engine;

    @BeforeAll
    public static void setup() {
        engine = new JsonQueryEngine();
    }

    @Test
    public void testSimpleExpression() {
        String expression = "name eq \"junit\"";

        JsonObject item = Json.createObjectBuilder()
                .add("name", "junit")
                .build();

        assertTrue(engine.execute(expression, item), "Simple query expression should evaluate to true");
    }

    @Test
    public void testComplexExpression() {
        String expression = "bpi.current.code eq \"USD\" and bpi.current.rate gt 650.60";

        JsonObject current = Json.createObjectBuilder()
                .add("code", "USD")
                .add("rate", 700.50)
                .build();

        JsonObject bpi = Json.createObjectBuilder()
                .add("current", current)
                .build();

        JsonObject item = Json.createObjectBuilder()
                .add("bpi", bpi)
                .build();

        assertTrue(engine.execute(expression, item), "Complex query expression should evaluate to true");
    }
}

