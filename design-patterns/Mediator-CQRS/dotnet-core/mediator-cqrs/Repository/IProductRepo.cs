using mediator_cqrs.entities;

namespace mediator_cqrs.Repository;

public interface IProductRepo
{
    public List<Product> GetAllProducts();


    public String CreateProduct(Product product);
}