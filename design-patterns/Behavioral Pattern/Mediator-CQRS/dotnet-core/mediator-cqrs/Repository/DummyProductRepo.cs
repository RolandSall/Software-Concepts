using mediator_cqrs.entities;

namespace mediator_cqrs.Repository;

public class DummyProductRepo: IProductRepo
{

    private List<Product> _list = new List<Product>();

     public DummyProductRepo()
     {
        var product_one = new Product(0, "XBOX", 13123);
        var product_two = new Product(1, "PS4", 13123);
        _list.Add(product_one);
        _list.Add(product_two);
     }


     public List<Product> GetAllProducts()
    {

        return _list;
    }

     public string CreateProduct(Product product)
     {
         _list.Add(product);
         return "Created";
     }
}