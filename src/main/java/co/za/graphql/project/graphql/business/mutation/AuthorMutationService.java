package co.za.graphql.project.graphql.business.mutation;

import co.za.graphql.project.graphql.model.Author;

public interface AuthorMutationService {

    Author createAuthor(String firstName, String lastName, String login, String password);

    Author loginAuthor(String login, String password) throws Exception;
}
