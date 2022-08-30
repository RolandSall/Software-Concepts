using mediator_cqrs.Queries.Product;
using mediator_cqrs.Repository;
using MediatR;

namespace mediator_cqrs.Handlers.Product;

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