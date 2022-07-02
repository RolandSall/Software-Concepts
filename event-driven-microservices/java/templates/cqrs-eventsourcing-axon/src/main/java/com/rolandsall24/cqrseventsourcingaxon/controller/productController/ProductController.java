package com.rolandsall24.cqrseventsourcingaxon.controller.productController;

import com.rolandsall24.cqrseventsourcingaxon.dtos.CreateProductRequestDto;
import com.rolandsall24.cqrseventsourcingaxon.model.Product;
import com.rolandsall24.cqrseventsourcingaxon.product.commands.CreateProductCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {


    private CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<CompletableFuture<Product>> createProduct(@RequestBody CreateProductRequestDto request){
      return   ResponseEntity.status(HttpStatus.CREATED).body(commandGateway.send(new CreateProductCommand(
                request.getName(),
                request.getSerialNumber()
        )));
    }
}
