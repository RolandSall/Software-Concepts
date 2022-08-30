using FluentValidation;
using mediator_cqrs.Commands.Product;

namespace mediator_cqrs.Validation
{

    public class CreateProductCommandValidator : AbstractValidator<CreateProductCommand>
    {
        public CreateProductCommandValidator()
        {
            RuleFor(x => x.SerialNumber).NotNull().NotEqual(0);
            RuleFor(x => x.Name).NotNull().NotEqual("foo");
        }
        
        
    }
}