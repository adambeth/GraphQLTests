package Queries;

import lombok.Data;

@Data
public class Mutation {
    private String mutation;
    private Object variables;
}
