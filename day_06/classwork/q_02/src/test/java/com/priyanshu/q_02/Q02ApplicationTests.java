package com.priyanshu.q_02;

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
@SpringBootTest(classes = Q02Application.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
	@Test
	void testAddstudent() throws Exception {
		String requestBody = "{\"id\": 1, \"name\": \"John Doe\", \"age\": 25, \"city\": \"Cityville\", \"rollno\": 123}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.city").value("Cityville"))
				.andReturn();
	}

	@Order(3)
	@Test
	void testGetPagination() throws Exception {
		int a = 0;
		int b = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/student")
				.param("pageNo", "1")
				.param("pageSize", "10")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(4)
	@Test
	void testGetPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/student/sort")
				.param("pageNo", "1")
				.param("pageSize", "10")
				.param("sortBy", "name")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(5)
	@Test

	public void controllerfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_02/controller"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(6)
	@Test

	public void controllerfile() {

		String filePath = "src/main/java/com/priyanshu/q_02/controller/StudentController.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(7)
	@Test

	public void testModelFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_02/model"; // Replace with the path to your directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(8)
	@Test

	public void testModelFile() {

		String filePath = "src/main/java/com/priyanshu/q_02/model/Student.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(9)
	@Test

	public void testrepositoryfolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_02/repository"; // Replace with the path to your
																				// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(10)
	@Test

	public void testrepositoryFile() {

		String filePath = "src/main/java/com/priyanshu/q_02/repository/StudentRepo.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Order(11)
	@Test

	public void testServiceFolder() {

		String directoryPath = "src/main/java/com/priyanshu/q_02/service";

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Order(12)
	@Test

	public void testServieFile() {

		String filePath = "src/main/java/com/priyanshu/q_02/service/StudentService.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
