using mediator_cqrs.entities;
using mediator_cqrs.Repository;
using Microsoft.AspNetCore.Mvc;
using Microsoft.VisualBasic;

namespace mediator_cqrs.Controllers;


[ApiController]
[Route("[controller]")]
public class ProductController: ControllerBase
{
    private readonly ILogger<ProductController> _logger;
    private readonly IProductRepo _productRepo;

    public ProductController(ILogger<ProductController> logger, IProductRepo productRepo)
    {
        _logger = logger;
        _productRepo = productRepo;
    }
    
    [HttpGet(Name = "GetProductsList")]
    public async Task<ActionResult> Get()
    {
        return Ok(_productRepo.GetAllProducts());
    }

    
}