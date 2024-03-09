package com.priyanshu.q_01;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = Q01Application.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class Q01ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void testAddCustomer() throws Exception {
		List<String> customerList = Arrays.asList(
				"{\"customerId\": 1, \"firstName\": \"John\", \"lastName\": \"Doe\"}",
				"{\"customerId\": 2, \"firstName\": \"Jane\", \"lastName\": \"Smith\"}",
				"{\"customerId\": 3, \"firstName\": \"Alice\", \"lastName\": \"Johnson\"}",
				"{\"customerId\": 4, \"firstName\": \"Bob\", \"lastName\": \"Williams\"}",
				"{\"customerId\": 5, \"firstName\": \"Emily\", \"lastName\": \"Brown\"}",
				"{\"customerId\": 6, \"firstName\": \"Michael\", \"lastName\": \"Jones\"}",
				"{\"customerId\": 7, \"firstName\": \"Emma\", \"lastName\": \"Garcia\"}");
		for (String customerData : customerList) {
			mockMvc.perform(MockMvcRequestBuilders.post("/customer")
					.contentType(MediaType.APPLICATION_JSON)
					.content(customerData)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isCreated());
		}
	}

	@Order(2)
	@Test
	void testGetCustomerById() throws Exception {
		int customerId = 1;
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/{customerId}", customerId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				// .andExpect(content().string("Car deleted successfully"))
				.andReturn();
	}

	@Test
	@Order(3)
	void testGetAllCustomersPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/{c}/{d}", c, d)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(4)
	void testGetCustomersameStartsWith() throws Exception {
		String expectedcustomerNames[] = { "Emily", "Emma" };

		mockMvc.perform(MockMvcRequestBuilders.get("/customer/startswith/E")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$[?(@.firstName == 'Emily')]").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedcustomerNames.length))
				.andReturn();
	}

	@Test
	@Order(5)
	void testGetCustomersByFirstName() throws Exception {
		// String expectedcustomersName[] = { "John"};
		String name = "John";
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/findByFirstname/{name}", name)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$[?(@.lastName == 'Doe')]").exists())
				// .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedcollegeNames.length))
				.andReturn();
	}

	@Test
	@Order(6)
	void testAddAddress() throws Exception {
		List<String> addressList = Arrays.asList(
				"{\"addressId\": 1, \"street\": \"2nd Street\", \"city\": \"Chennai\", \"zipCode\": \"Chennai60023\"}");

		int customerId = 1; // Example customer ID

		for (String addressData : addressList) {
			mockMvc.perform(MockMvcRequestBuilders.post("/address/{customerId}", customerId)
					.contentType(MediaType.APPLICATION_JSON)
					.content(addressData)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isCreated());
		}
	}

	@Order(7)
	@Test
	void testGetAddressById() throws Exception {
		int addressId = 1;
		mockMvc.perform(MockMvcRequestBuilders.get("/address/{addressId}", addressId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.street").value("2nd Street"))
				.andReturn();

	}

	@Test
	@Order(8)
	void testGetAllAddress() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/address")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[?(@.city == 'Chennai')]").exists())
				.andReturn();
	}

	@Test
	@Order(9)
	void testUpdateAddressDetails() throws Exception {
		String requestBody = "{\"addressId\": 1, \"street\": \"2nd Street\", \"city\": \"Chennai\", \"zipCode\": \"Chennai60024\"}";
		int addressId = 1;
		mockMvc.perform(MockMvcRequestBuilders.put("/address/{addressId}", addressId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("Chennai60024"))
				.andReturn();
	}

	@Test
	@Order(10)
	void testGetCitynameEndsWith() throws Exception {
		String expectedcityNames[] = { "Chennai" };
		String endswith = "i";
		mockMvc.perform(MockMvcRequestBuilders.get("/address/endswith/{endswith}", endswith)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$[?(@.city == 'Chennai')]").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedcityNames.length))
				.andReturn();
	}

	@Order(11)
	@Test
	void testAddressdeleteById() throws Exception {
		int addressId = 1;
		mockMvc.perform(MockMvcRequestBuilders.delete("/address/{addressId}", addressId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Address deleted Successfully"))
				.andReturn();
	}

	@Test
	@Order(12)
	void testAddPurchaseOrders() throws Exception {
		List<String> ordersList = Arrays.asList(
				"{\"orderId\": 1, \"productName\": \"Product A\", \"quantity\": 2, \"price\": 10.50}");

		int customerId = 1; // Example customer ID

		for (String orderData : ordersList) {
			mockMvc.perform(MockMvcRequestBuilders.post("/customer/{customerId}/purchase", customerId)
					.contentType(MediaType.APPLICATION_JSON)
					.content(orderData)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isCreated())
					.andExpect(jsonPath("$.productName").value("Product A"))

					.andReturn();

		}
	}

	@Test
	@Order(13)
	void testGetAllPurchaseOrders() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/purchase")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[?(@.productName == 'Product A')]").exists())
				.andReturn();
	}

	@Order(14)
	@Test
	void testGetPurchaseOrdersById() throws Exception {
		int orderId = 1;
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/purchase/{orderId}", orderId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productName").value("Product A"))
				.andReturn();

	}

	@Test
	@Order(15)
	void testGetPurchaseOrdersByProductName() throws Exception {
		// String expectedcustomersName[] = { "John"};
		String productName = "Product A";

		mockMvc.perform(MockMvcRequestBuilders.get("/customer/purchase/findbyproductname/{productName}", productName)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$[?(@.productName == 'Product A')]").exists())
				// .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedcollegeNames.length))
				.andReturn();
	}

	@Order(16)
	@Test
	void testPurchaseOrderdeleteById() throws Exception {
		int orderId = 1;

		mockMvc.perform(MockMvcRequestBuilders.delete("/customer/purchase/{orderId}", orderId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Order deleted successfully"))
				.andReturn();
	}

	private void checkAnnotationExists(String className, String annotationName) {
		try {
			Class<?> clazz = Class.forName(className);
			ClassLoader classLoader = clazz.getClassLoader();
			Class<?> annotationClass = Class.forName(annotationName, false, classLoader);
			assertNotNull(clazz.getAnnotation((Class) annotationClass)); // Use raw type
		} catch (ClassNotFoundException | NullPointerException e) {
			fail("Class " + className + " or annotation " + annotationName + " does not exist.");
		}
	}

	@Test
	@Order(17)
	public void testConfigHasAnnotation() {
		checkAnnotationExists("com.priyanshu.q_01.configuration.SwaggerConfig",
				"org.springframework.context.annotation.Configuration");
	}

	@Test
	@Order(18)
	public void testConfigHasSwaggerAnnotation() {
		checkAnnotationExists("com.priyanshu.q_01.configuration.SwaggerConfig",
				"springfox.documentation.swagger2.annotations.EnableSwagger2");
	}

}
