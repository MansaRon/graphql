package co.za.graphql.project.graphql.business.mutation;

import co.za.graphql.project.graphql.model.Author;
import co.za.graphql.project.graphql.model.EROLES;
import co.za.graphql.project.graphql.model.Role;

import java.util.Set;

public interface AuthorMutationService {

    Author createAuthor(String firstName, String lastName, String login, String password, Set<EROLES> roles);

    Author loginAuthor(String login, String password) throws Exception;
}
