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

import java.io.File;

@SpringBootTest(classes = Q01Application.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
	@Test
	void testAddlanguage() throws Exception {
		String requestBody = "{\"languageId\": 1, \"languageName\": \"English\", \"languageCode\": 123, \"country\": \"United States\"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/language")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.languageName").value("English"))
				.andReturn();
	}

	@Order(2)
	@Test
	void testGetSortedlanguage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/language/sortBy/languageName")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(3)
	@Test
	void testGetPagination() throws Exception {
		int a = 0;
		int b = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/language/{a}/{b}", a, b)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Order(4)
	@Test
	void testGetPaginationAndSorting() throws Exception {
		int c = 0;
		int d = 3;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/language/{c}/{d}/languageName", c, d)
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

		String filePath = "src/main/java/com/priyanshu/q_01/controller/LanguageController.java";

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

		String filePath = "src/main/java/com/priyanshu/q_01/model/Language.java";

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

		String filePath = "src/main/java/com/priyanshu/q_01/repository/LanguageRepo.java";

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

		String filePath = "src/main/java/com/priyanshu/q_01/service/LanguageService.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
