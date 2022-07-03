using System.Threading;
using System.Threading.Tasks;
using mediator_cqrs.Repository;
using MediatR;

namespace mediator_cqrs.Queries.Product;

public class GetProductById: IRequest<entities.Product>
{
    public int productId { get;  }

    public GetProductById(int productId)
    {
        this.productId = productId;
    }
}

public class GetProductByIdHandler : IRequestHandler<GetProductById, entities.Product>
{

    private readonly IProductRepo _repo;

    public GetProductByIdHandler(IProductRepo repo)
    {
        _repo = repo;
    }

    public async Task<entities.Product> Handle(GetProductById request, CancellationToken cancellationToken)
    {
        return  _repo.GetAllProducts().FirstOrDefault(x => x.ProductId.Equals(request.productId)) ?? null;
    }
}
