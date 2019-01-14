package cn.vgbhfive.vid.vid_graphql.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @time: 2019/1/14
 * @author: Vgbh
 */
@RestController
public class HelloController {

    private final GraphQL graphql;
    private final ObjectMapper objectMapper;

    @Autowired
    public HelloController(GraphQL graphql, ObjectMapper objectMapper) {
        this.graphql = graphql;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "/graphql/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Object graphqlHello(@RequestParam("query") String query,
                               @RequestParam(value = "operationName", required = false) String operationName,
                               @RequestParam("variables") String variablesJson) throws IOException {
        if (query == null) {
            query = "";
        }

        Map<String, Object> variables = new LinkedHashMap<>();

        if (variablesJson != null) {
            variables = objectMapper.readValue(variablesJson, new TypeReference<Map<String, Object>>() {});
        }

        return executeGrapgqlQuery(operationName, query, variables);
    }

    private Map<String, Object> executeGrapgqlQuery(String operationName, String query, Map<String, Object> variables) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                    .query(query)
                    .variables(variables)
                    .operationName(operationName)
                    .build();

        return this.graphql.execute(executionInput).toSpecification();
    }

}
