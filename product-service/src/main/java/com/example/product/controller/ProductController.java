package com.example.product.controller;


import com.example.product.model.dto.ProductDTO;
import com.example.product.model.dto.response.GeneralResponseDTO;
import com.example.product.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<GeneralResponseDTO> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));

    }
    @PostMapping
    public ResponseEntity<GeneralResponseDTO> createProduct(@RequestBody @Valid ProductDTO product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO product) {
        return ResponseEntity.ok( productService.updateProduct(id, product));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


}
