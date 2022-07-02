package com.rolandsall24.cqrseventsourcingaxon.controller.productController;

import com.rolandsall24.cqrseventsourcingaxon.dtos.CreateProductRequestDto;
import com.rolandsall24.cqrseventsourcingaxon.dtos.UpdateProductDto;
import com.rolandsall24.cqrseventsourcingaxon.model.Product;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.commands.CreateProductCommand;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.commands.UpdateProductStatusCommand;
import com.rolandsall24.cqrseventsourcingaxon.commands.product.enums.ProductStatus;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {


    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping
    public CompletableFuture<Product> createProduct(@RequestBody CreateProductRequestDto request) {
        return commandGateway.send(new CreateProductCommand(
                UUID.randomUUID(),
                request.getName(),
                request.getSerialNumber()
        ));
    }

    @PostMapping("/status/{productId}")
    public CompletableFuture<Product> updateProductStatus(@RequestBody UpdateProductDto updateProductDto, @PathVariable UUID productId) {
          return commandGateway.send(new UpdateProductStatusCommand(
                  productId,
                  ProductStatus.valueOf(updateProductDto.getProductStatus())
        ));
    }


    @GetMapping("/eventStore/{productId}")
    public Stream productEventStoreById(@PathVariable UUID productId) {
        return eventStore.readEvents(String.valueOf(productId)).asStream();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ResponseEntity<String> entity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return entity;
    }
}
