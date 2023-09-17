package co.za.graphql.project.graphql.business.query.implementation;

import co.za.graphql.project.graphql.business.query.TaskService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class TaskQueryImpl implements GraphQLQueryResolver, TaskService {
}
