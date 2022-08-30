using MediatR;

namespace mediator_cqrs.Queries.Product;

public class GetAllOrdersQuery: IRequest<List<entities.Product>>
{
    
}