package ud.antlr.json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;

import javax.json.JsonObject;

/**
 * A query engine that executes a given JSON query expression against a JSON object and returns
 * a boolean value indicating whether the query conditions are matched or not.
 */
public class JsonQueryEngine {

    /**
     * Execute the given JSON query expression against the specified JSON object.
     *
     * @param expression the JSON query expression to execute.
     * @param item the JSON object to query against.
     * @return a boolean value indicating whether the query conditions were matched or not.
     */
    public boolean execute(String expression, JsonObject item) {
        if (StringUtils.isNotBlank(expression)) {
            CharStream stream = CharStreams.fromString(expression.trim());
            JsonQueryLexer lexer = new JsonQueryLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JsonQueryParser parser = new JsonQueryParser(tokens);

            ParseTree parseTree = parser.query();
            JsonQueryEvaluator evaluator = new JsonQueryEvaluator(item);

            return evaluator.visit(parseTree);
        }

        return false;
    }
}
