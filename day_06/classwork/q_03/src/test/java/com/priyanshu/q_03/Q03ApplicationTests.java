package com.priyanshu.q_03;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = Q03Application.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
	@Test
	void testAddproduct() throws Exception {
		String requestBody = "{\"productId\": 1, \"productName\": \"SampleProduct\", \"category\": \"Electronics\", \"price\": 100}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(jsonPath("$.productName").value("SampleProduct"))
				.andReturn();
	}

	@Order(2)
	@Test
	void testGetPagination() throws Exception {
		int a = 0;
		int b = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product/{a}/{b}", a, b)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Order(3)
	@Test
	void testGetPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product/{c}/{d}/productName", c, d)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Order(4)
	@Test
	void testgetByid() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/product/1")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productName").value("SampleProduct"))
				.andReturn();
	}

	@Order(5)
	@Test

	public void controllerfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_03/controller"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(6)
	@Test

	public void controllerfile() {

		String filePath = "src/main/java/com/priyanshu/q_03/controller/ProductController.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(7)
	@Test

	public void testModelFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_03/model"; // Replace with the path to your directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(8)
	@Test

	public void testModelFile() {

		String filePath = "src/main/java/com/priyanshu/q_03/model/Product.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(9)
	@Test

	public void testrepositoryfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_03/repository"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(10)
	@Test

	public void testrepositoryFile() {

		String filePath = "src/main/java/com/priyanshu/q_03/repository/ProductRepo.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(11)
	@Test

	public void testServiceFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_03/service";

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(12)
	@Test

	public void testServieFile() {

		String filePath = "src/main/java/com/priyanshu/q_03/service/ProductService.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
