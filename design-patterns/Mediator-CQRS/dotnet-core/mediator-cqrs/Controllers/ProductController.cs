using System.Net;
using mediator_cqrs.Commands.Product;
using mediator_cqrs.Queries.Product;
using MediatR;
using Microsoft.AspNetCore.Mvc;

namespace mediator_cqrs.Controllers;


[ApiController]
[Route("[controller]")]
public class ProductController: ControllerBase
{
    private readonly ILogger<ProductController> _logger;
    private readonly IMediator _mediator;

    public ProductController(ILogger<ProductController> logger, IMediator mediator)
    {
        _logger = logger;

        _mediator = mediator;
    }
    
    [HttpGet(Name = "GetProductsList")]
    public async Task<ActionResult> GetAllProducts()
    {
        try
        {
            return Ok(await _mediator.Send(new GetAllOrdersQuery()));

        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(Convert.ToInt32(HttpStatusCode.InternalServerError), e.Message);
        }
    }
    
    
    [HttpGet("{productId}")]
    public async Task<ActionResult> GetProductById(int productId)
    {
        try
        {
            return Ok(await _mediator.Send(new GetProductById(productId)));

        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(Convert.ToInt32(HttpStatusCode.InternalServerError), e.Message);
        }
    }
    
    
    [HttpPost()]
    public async Task<ActionResult> CreateProduct([FromBody] CreateProductRequest request)
    {
        try
        {
            return Ok(await _mediator.Send(new CreateProductCommand(request.Name, request.SerialNumber)));

        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(Convert.ToInt32(HttpStatusCode.InternalServerError), e.Message);
        }
    }

    
}