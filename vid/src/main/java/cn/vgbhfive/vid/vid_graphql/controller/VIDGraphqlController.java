package cn.vgbhfive.vid.vid_graphql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @time: 2019/1/14
 * @author: Vgbh
 */
@RestController
public class VIDGraphqlController {

    private final GraphQL graphql;
    private final ObjectMapper objectMapper;

    @Autowired
    public VIDGraphqlController(GraphQL graphql, ObjectMapper objectMapper) {
        this.graphql = graphql;
        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/graphql/vid", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Object graphqlHello(@RequestBody Map<String, Object> body){
        String query = (String) body.get("query");
        if (query == null) {
            query = "";
        }

        String operationName = (String) body.get("operationName");
        Map<String, Object> variables = (Map<String, Object>) body.get("varibales");
        if (variables == null) {
            variables = new LinkedHashMap<>();
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
