package co.za.graphql.project.graphql.business.query.implementation;

import co.za.graphql.project.graphql.business.query.AuthorService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class AuthorQueryImpl implements GraphQLQueryResolver, AuthorService {
}
