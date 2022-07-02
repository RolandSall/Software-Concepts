package com.rolandsall24.cqrseventsourcingaxon.controller.productController;

import com.rolandsall24.cqrseventsourcingaxon.dtos.CreateProductRequestDto;
import com.rolandsall24.cqrseventsourcingaxon.model.Product;
import com.rolandsall24.cqrseventsourcingaxon.product.commands.CreateProductCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {


    private CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<Product> createProduct(@RequestBody CreateProductRequestDto request){
      return commandGateway.send(new CreateProductCommand(
                request.getName(),
                request.getSerialNumber()
        ));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception ){
        ResponseEntity<String> entity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return entity;
    }
}
