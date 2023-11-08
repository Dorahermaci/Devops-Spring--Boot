package tn.esprit.devops_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImplTestJunit {

    @Autowired
    private ProductServiceImpl productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        // Define any setup or mocking logic here
    }

    @Test
    public void testAddProduct() {
        // Arrange
        Stock mockStock = new Stock();
        when(stockRepository.findById(1L)).thenReturn(Optional.of(mockStock));

        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0f);
        product.setQuantity(5);
        product.setCategory(ProductCategory.ELECTRONICS);

        // Act
        Product addedProduct = productService.addProduct(product, 1L);

        // Assert
        assertNotNull(addedProduct);
        assertEquals("Test Product", addedProduct.getTitle());
        // Add more assertions as needed
    }

    @Test
    public void testRetrieveProduct() {
        // Arrange
        Product mockProduct = new Product();
        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));

        // Act
        Product retrievedProduct = productService.retrieveProduct(1L);

        // Assert
        assertNotNull(retrievedProduct);
        // Add more assertions as needed
    }

    @Test
    public void testRetrieveAllProduct() {
        // Arrange
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Act
        List<Product> retrievedProducts = productService.retreiveAllProduct();

        // Assert
        assertNotNull(retrievedProducts);
        // Add more assertions as needed
    }

    @Test
    public void testRetrieveProductByCategory() {
        // Arrange
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findByCategory(category)).thenReturn(mockProducts);

        // Act
        List<Product> retrievedProducts = productService.retrieveProductByCategory(category);

        // Assert
        assertNotNull(retrievedProducts);
        // Add more assertions as needed
    }

    @Test
    public void testDeleteProduct() {
        // Arrange - No mock needed for this test

        // Act
        productService.deleteProduct(1L);

        // Assert - You can assert the absence of exceptions here
    }

    @Test
    public void testRetrieveProductStock() {
        // Arrange
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findByStockIdStock(1L)).thenReturn(mockProducts);

        // Act
        List<Product> retrievedProducts = productService.retreiveProductStock(1L);

        // Assert
        assertNotNull(retrievedProducts);
        // Add more assertions as needed
    }
}
