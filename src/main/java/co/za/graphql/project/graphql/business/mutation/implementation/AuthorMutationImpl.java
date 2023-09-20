package co.za.graphql.project.graphql.business.mutation.implementation;

import co.za.graphql.project.graphql.business.mutation.AuthorMutationService;
import co.za.graphql.project.graphql.model.Author;
import co.za.graphql.project.graphql.model.EROLES;
import co.za.graphql.project.graphql.model.Role;
import co.za.graphql.project.graphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class AuthorMutationImpl implements GraphQLMutationResolver, AuthorMutationService {

    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(String firstName, String lastName, String login, String password, Set<EROLES> roles) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setLogin(login);
        author.setPassword(password);
        author.setRoles(roles);

        authorRepository.save(author);
        return author;
    }

    @Override
    public Author loginAuthor(String login, String password) throws Exception {
        Author author = authorRepository.findByLogin(login);

        if (author != null && author.getPassword().equals(password)) {
            return author;
        }
        else {
            throw new Exception("User not found/Bad password");
        }
    }


}
