using mediator_cqrs.Controllers;
using mediator_cqrs.Repository;
using MediatR;

namespace mediator_cqrs.Commands.Product;

public class CreateProductCommand: IRequest<String>
{
    public string Name { get; }
    public long SerialNumber { get; }

    public CreateProductCommand(string name, long serialNumber)
    {
        Name = name;
        SerialNumber = serialNumber;
    }
   
}

public class CreateProductCommandHandler : IRequestHandler<CreateProductCommand, String>
{

    private readonly IProductRepo _productRepo;

    public CreateProductCommandHandler(IProductRepo productRepo)
    {
        _productRepo = productRepo;
    }

    public async Task<string> Handle(CreateProductCommand request, CancellationToken cancellationToken)
    {

        Random rnd = new Random();
        var product = new entities.Product(rnd.Next(), request.Name, request.SerialNumber);
       return _productRepo.CreateProduct(product);
    }
}