# Mediator & CQRS Patterns In .NET





## Mediator 

#### Problem Statement

Consider having an application that aims to create and update certain profiles (products, customers...).  In this application you have four services (A,B,C,D) that are coupled and communicate to achieve certain goals. Instead of having direct communication among them, in a mediator pattern an entity will exist between these services and somehow `orchestrate` the communication.

For more details on the mediator pattern: [refactoring.guru](https://refactoring.guru/design-patterns/mediator) 

##### MediatR

In .NET core, `MediatorR` is a nugget package that helps implementing the Mediator pattern. Check the source code for an hand-on example.

## CQRS

* CQRS stands for **Command and Query Responsibility Segregation**

  * ​	 Basically this pattern separates read and update operations for a database.

  Extra References: [RolandSall24-Java-Es-CQRS](https://github.com/RolandSall/Microservices-Concepts/blob/main/event-driven-microservices/java/README.md), [Medium article](https://medium.com/design-microservices-architecture-with-patterns/cqrs-design-pattern-in-microservices-architectures-5d41e359768c)



### Main Building Block 

First you need to inject the mediator

```c#
builder.Services.AddMediatR(Assembly.GetExecutingAssembly());
```



Consider a RESTful API that gets all the products you have:

```c#
   [HttpGet(Name = "GetProductsList")]
    public async Task<ActionResult> GetAllProducts()
    {
     return Ok(await _mediator.Send(new GetAllOrdersQuery()));      
    }
```

The second step is to create `GetAllOrdersQuery` class that is passed to the Mediator using the `Send` method

```c#
public class GetAllOrdersQuery: IRequest<List<entities.Product>>
{
    
}
```

`IRequest` will be of type that is expected to be returned.

The Last step is to create the handler. The handler is where you code the logic that happens once a query or a command of a certain type is triggered

```c#
public class GetAllProductOrdersQueryHandler: IRequestHandler<GetAllOrdersQuery, List<entities.Product>>

{    
    private readonly IProductRepo _productRepo;

    public GetAllProductOrdersQueryHandler(IProductRepo productRepo)
    {
        _productRepo = productRepo;
    }

    public async Task<List<entities.Product>> Handle(GetAllOrdersQuery request, CancellationToken cancellationToken)
    {
        return _productRepo.GetAllProducts();
    }
}
```

