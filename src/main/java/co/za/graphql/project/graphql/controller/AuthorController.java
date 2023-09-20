package co.za.graphql.project.graphql.controller;

import co.za.graphql.project.graphql.business.mutation.AuthorMutationService;
import co.za.graphql.project.graphql.model.Author;
import co.za.graphql.project.graphql.model.EROLES;
import co.za.graphql.project.graphql.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@AllArgsConstructor
public class AuthorController {

    private final AuthorMutationService authorMutationService;

    @MutationMapping
    public Author createAuthor(@Argument String firstName, @Argument String lastName, @Argument String login, @Argument String password, @Argument Set<EROLES> roles) {
        return authorMutationService.createAuthor(firstName, lastName, login, password, roles);
    }

    @MutationMapping
    public Author loginAuthor(@Argument String login, @Argument String password) throws Exception {
        return authorMutationService.loginAuthor(login, password);
    }
}
