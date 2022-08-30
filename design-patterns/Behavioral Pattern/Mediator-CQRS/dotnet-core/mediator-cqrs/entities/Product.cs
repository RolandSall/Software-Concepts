namespace mediator_cqrs.entities;

public class Product
{
    public int ProductId { get; set; }
    public string Name { get; set; }
    public long SerialNumber { get; set; }

    public Product(int productId, string name, long serialNumber)
    {
        ProductId = productId;
        Name = name;
        SerialNumber = serialNumber;
    }

}