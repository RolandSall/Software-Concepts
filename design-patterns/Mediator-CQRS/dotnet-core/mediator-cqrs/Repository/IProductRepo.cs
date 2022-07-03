using mediator_cqrs.entities;

namespace mediator_cqrs.Repository;

public interface IProductRepo
{
    public IEnumerable<Product> GetAllProducts();
}