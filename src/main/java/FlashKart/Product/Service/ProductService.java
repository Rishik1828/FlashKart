package FlashKart.Product.Service;

import FlashKart.Product.Entity.ProductEntity;
import FlashKart.Product.Repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity createProduct(ProductEntity product) {
        productRepository.save(product);
        StringBuilder sb=new StringBuilder();
        sb.append(product.getName()).append(" created successfully");
        return ResponseEntity.ok(sb.toString());
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity getProduct(Long id) {
        Optional<ProductEntity> product=productRepository.findById(id);
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity updateProduct(Long id,ProductEntity product) {
        Optional<ProductEntity> product1=productRepository.findById(id);
        if(product1.isPresent()) {
            productRepository.save(product);
            return ResponseEntity.ok("Product updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteProduct(Long id) {
        Optional<ProductEntity> product=productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
