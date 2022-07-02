package com.rolandsall24.cqrseventsourcingaxon.product.commands;

import com.rolandsall24.cqrseventsourcingaxon.product.commands.enums.ProductStatus;
import com.rolandsall24.cqrseventsourcingaxon.product.commands.events.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;


@Getter
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private UUID productId;
    private String name;
    private long serialNumber;

    public CreateProductCommand(String name, long serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
    }
}

@Aggregate
@NoArgsConstructor
class ProductAggregate{

    @AggregateIdentifier
    private UUID productId;
    private String name;
    private long serialNumber;
    private ProductStatus productStatus;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        if(createProductCommand.getSerialNumber() < 0)
            throw new RuntimeException("Serial Number Not Valid");

        AggregateLifecycle.apply(new ProductCreatedEvent(
                UUID.randomUUID(),
                createProductCommand.getName(),
                createProductCommand.getSerialNumber()

        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.productId = event.getProductId();
        this.serialNumber = event.getSerialNumber();
        this.name = event.getName();
        this.productStatus = ProductStatus.CREATED;

    }
}




