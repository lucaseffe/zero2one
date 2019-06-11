package br.com.zero2one.lucas.products.controller;

import br.com.zero2one.lucas.products.model.Product;
import br.com.zero2one.lucas.products.repository.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {
    @InjectMocks
    private ProductsController controller;

    @Mock
    private ProductRepository repository;

    @Test
    public void deleteTest() {
        String expectedValue = "50";

        controller.delete(expectedValue);

        Mockito.verify(repository).deleteById(expectedValue);
    }

    @Test
    public void create() {
        Product product = new Product(); // ARRANGE
        controller.create(product); // ACT
        Mockito.verify(repository).save(product); // ASSERT
    }

    @Test
    public void getById() {
        String id = "55";
        ResponseEntity responseEntity = controller.getById(id);
        Mockito.verify(repository).findById(id);
        Assert.assertThat(responseEntity.getStatusCode(), Matchers.equalTo(HttpStatus.NOT_FOUND));
    }
}
