package eci.ieti;

import eci.ieti.data.*;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 3)).stream()
        	.forEach(System.out::println);
   
        System.out.println();

        userRepository.deleteAll();

        userRepository.save(new User("Alice", "Alice@mail.com"));
        userRepository.save(new User("Bob", "Bob@mail.com"));
        userRepository.save(new User("Jimmy", "Jimmy@mail.com"));
        userRepository.save(new User("Freddy", "Freddy@mail.com"));
        userRepository.save(new User("Michael", "Michael@mail.com"));
        userRepository.save(new User("Johan", "Johan@mail.com"));
        userRepository.save(new User("Nicolas", "Nicolas@mail.com"));
        userRepository.save(new User("Nancy", "Nancy@mail.com"));
        userRepository.save(new User("Martha", "Martha@mail.com"));
        userRepository.save(new User("Alfonso", "Alfonso@mail.com"));

        System.out.println("User found with findAll():");
        System.out.println("-------------------------------");

        userRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        todoRepository.deleteAll();

        todoRepository.save(new Todo("travel to Galapagos", 1, new Date(120,1,20), "Alice@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Belgica", 2, new Date(120,2,20), "Bob@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Colombia", 3, new Date(120,3,20), "Jimmy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Argentina", 4, new Date(120,4,20), "Freddy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Ecuador", 5, new Date(120,5,20), "Michael@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Peru", 6, new Date(120,6,20), "Johan@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Brasil", 7, new Date(120,7,20), "Nicolas@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Mexico", 8, new Date(120,8,20), "Nancy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Canada", 9, new Date(120,9,20), "Martha@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Australia", 10, new Date(120,10,30), "Alfonso@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Inglaterra", 9, new Date(120,11,20), "Alice@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to India", 8, new Date(120,10,20), "Bob@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Rusia", 7, new Date(120,11,20), "Jimmy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to España", 6, new Date(120,10,30), "Freddy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Bolivia", 5, new Date(120,11,20), "Michael@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Honduras", 4, new Date(120,11,20), "Johan@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Uruguay", 3, new Date(120,10,30), "Nicolas@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Paraguay", 2, new Date(120,11,20), "Nancy@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Chile", 1, new Date(120,12,20), "Martha@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Indonesia", 10, new Date(120,12,20), "Alfonso@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Irlanda", 2, new Date(120,11,20), "Nicolas@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Grecia", 6, new Date(120,12,20), "Nicolas@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Micinos, Portugal, Guatemala", 5, new Date(120,1,20), "Johan@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Turquia, Panama ,Alaska", 4, new Date(120,2,20), "Alfonso@mail.com", "pending" ));
        todoRepository.save(new Todo("travel to Japon, Estados Unidos", 5, new Date(120,3,20), "Alfonso@mail.com", "pending" ));


        System.out.println("Paginated search of Todo by criteria:");
        System.out.println("-------------------------------");

        todoRepository.findByDescriptionContaining("Belgica", PageRequest.of(0, 3)).stream()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Paginated search of Todo by responsible:");
        System.out.println("-------------------------------");

        todoRepository.findByResponsible("Alice@mail.com", PageRequest.of(0, 3)).stream()
                .forEach(System.out::println);

        System.out.println();


        hacerConsultas(mongoOperation);
        dueDateExpired(mongoOperation);
        userAndPriority(mongoOperation, new User("Alfonso", "Alfonso@mail.com"));
        usuarioConDosTodos(mongoOperation);
        todos30oMas(mongoOperation);
    }

    public static void hacerConsultas(MongoOperations mongoOperation){
        System.out.println("Consulta Inicial");
        System.out.println("-------------------------------");
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));
        Customer customer = mongoOperation.findOne(query, Customer.class);
        System.out.println(customer.toString());
        System.out.println();
    }

    public static void dueDateExpired(MongoOperations mongoOperation){
        System.out.println("Consulta Fecha expirada");
        System.out.println("-------------------------------");
        Query dueDateExpired = new Query();
        dueDateExpired.addCriteria(Criteria.where("dueDate").lte(new Date()));
        List<Todo> todosDate = mongoOperation.find(dueDateExpired, Todo.class);
        for (Todo todo:todosDate) {
            System.out.println(todo.toString());
        }
        System.out.println();
    }
    public static void userAndPriority(MongoOperations mongoOperation, User user){
        System.out.println("Consulta de un usuario especifico y mas de 5 de prioridad");
        System.out.println("-------------------------------");
        Query userAndPriority = new Query();
        userAndPriority.addCriteria(
                Criteria.where("responsible").is(user.getEmail())
                .andOperator(Criteria.where("priority").gte(5))
        );
        List<Todo> todosUyP = mongoOperation.find(userAndPriority, Todo.class);
        for (Todo todo:todosUyP) {
            System.out.println(todo.toString());
        }
        System.out.println();
    }
    public static void usuarioConDosTodos(MongoOperations mongoOperation){
        System.out.println("Consulta Usuarios con mas de dos Todos");
        System.out.println("-------------------------------");
        Query tdUsuarios = new Query();
        List<User> usuarios = mongoOperation.find(tdUsuarios, User.class);
        ArrayList<User> users = new ArrayList<>();
        for (User user:usuarios) {
            Query dosTodos = new Query();
            dosTodos.addCriteria(Criteria.where("responsible").is(user.getEmail()));
            List<Todo> todos = mongoOperation.find(dosTodos, Todo.class);
            if (todos.size()>2){
                users.add(user);
            }
        }
        for (User user:users) {
            System.out.println(user.toString());
        }
        System.out.println();
    }
    public static void todos30oMas(MongoOperations mongoOperation){
        System.out.println("Consulta Todos con mas de 30 caracteres");
        System.out.println("-------------------------------");
        Query todos30oMas = new Query();
        todos30oMas.addCriteria(Criteria.where("description").regex(".{30,}"));
        List<Todo> todos3 = mongoOperation.find(todos30oMas, Todo.class);
        for (Todo todo:todos3) {
            System.out.println(todo.toString());
        }}

}