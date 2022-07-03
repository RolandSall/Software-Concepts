using System.Runtime.InteropServices;

namespace mediator_cqrs.Controllers;

public class CreateProductRequest
{

  
    public string Name { get; set; }
    public long SerialNumber { get; set; }
}