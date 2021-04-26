package Queries;

import lombok.Data;

@Data
public class GraphQLQuery {
    /*
    Use this class to dynamically create Graphql queries
    query: this needs to be a string representing the inital query or mutation
    variables: reuse the queires by passing in variables
     */
    private String query;
    private Object variables;
}
