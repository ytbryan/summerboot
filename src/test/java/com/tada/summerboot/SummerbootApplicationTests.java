package com.tada.summerboot;

import com.tada.summerboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@WebMvcTest(controllers = ProductController.class)
class SummerbootApplicationTests {

    // Three endpoints I would like to test
    // 1. all products
    // 2. new product
    // 3. Delete product
    // 4. Edit Product
    // 5. update product.
    // Further reading: https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-controller-layer-91bb4099c2a5

    //    @Autowired
    //    private MockMvc mockMvc; // this is your ProductController.class

    //    @Autowired
    //    private ProductServiceImpl productService;
    private List<User> userList;

    @BeforeEach
    public void setUp() {
        //        productService = Mockito.mock(ProductServiceImpl.class);
        this.userList = new ArrayList<>();
        //        this.userList.add(new User(1L, "user1@gmail.com", "pwd1","User1"));
        //        this.userList.add(new User(2L, "user2@gmail.com", "pwd2","User2"));
        //        this.userList.add(new User(3L, "user3@gmail.com", "pwd3","User3"));
    }

    // Further reading: https://www.springboottutorial.com/unit-testing-for-spring-boot-rest-services
    @Test
    public void testCreateProduct() {
        assertEquals("Hello JUnit 5", "Hello JUnit 5");

        //        assert("", "");
        //        this.mockMvc.equals("something","something");
        //        this.mockMvc.perform(null).andReturn();
        //        System.out.println("test");
    }

    @Test
    public void testListAllProducts() {
        assertEquals("Hello JUnit 5", "Hello JUnit 5");
    }

    @Test
    public void testDeleteProduct() {
        assertEquals("Hello JUnit 5", "Hello JUnit 5");
    }

    @Test
    public void testUpdateProduct() {
        assertEquals("Hello JUnit 5", "Hello JUnit 5");
    }

    @Test
    public void testEditProduct() {
        assertEquals("Hello JUnit 5", "Hello JUnit 5");
    }
}
