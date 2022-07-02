package com.rolandsall24.cqrseventsourcingaxon.commands.product.aggregate;

import com.rolandsall24.cqrseventsourcingaxon.commands.product.commands.CreateProductCommand;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.commands.UpdateProductStatusCommand;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.events.ProductCreatedEvent;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.events.UpdateProductStatusEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

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
                createProductCommand.getSerialNumber(),
                productStatus = ProductStatus.CREATED

        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.productId = event.getProductId();
        this.serialNumber = event.getSerialNumber();
        this.name = event.getName();
        this.productStatus = ProductStatus.CREATED;

    }

    @CommandHandler
    public void on(UpdateProductStatusCommand updateProductStatusCommand){

        AggregateLifecycle.apply(new UpdateProductStatusEvent(
                updateProductStatusCommand.getId(),
                updateProductStatusCommand.getStatus()
        ));
    }

    @EventSourcingHandler
    public void on(UpdateProductStatusEvent event){
        this.productId = event.getProductId();
        this.productStatus = event.getStatus();
    }

}