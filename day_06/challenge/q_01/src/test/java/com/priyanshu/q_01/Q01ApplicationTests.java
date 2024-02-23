package com.priyanshu.q_01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import java.io.File;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = Q01Application.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
	@Test
	void testAddEmployee() throws Exception {

		String requestBody = "{\"employeeId\": 1, \"employeeName\": \"John Doe\", \"employeeEmail\": \"john.doe@example.com\", \"employeeMobile\": \"1234567890\"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.employeeName").value("John Doe"))
				.andReturn();
	}

	@Order(2)
	@Test
	void testGetSortedEmployee() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/sortBy/employeeName")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(3)
	@Test
	void testGetPagination() throws Exception {
		int a = 0;
		int b = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{a}/{b}", a, b)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(4)
	@Test
	void testGetPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{c}/{d}/employeeName", c, d)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(5)
	@Test

	public void controllerfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_01/controller"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(6)
	@Test

	public void controllerfile() {

		String filePath = "src/main/java/com/priyanshu/q_01/controller/EmployeeController.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(7)
	@Test

	public void testModelFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_01/model"; // Replace with the path to your directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(8)
	@Test

	public void testModelFile() {

		String filePath = "src/main/java/com/priyanshu/q_01/model/Employee.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(9)
	@Test

	public void testrepositoryfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_01/repository"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(10)
	@Test

	public void testrepositoryFile() {

		String filePath = "src/main/java/com/priyanshu/q_01/repository/EmployeeRepo.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(11)
	@Test

	public void testServiceFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_01/service";

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(12)
	@Test

	public void testServieFile() {

		String filePath = "src/main/java/com/priyanshu/q_01/service/EmployeeService.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
