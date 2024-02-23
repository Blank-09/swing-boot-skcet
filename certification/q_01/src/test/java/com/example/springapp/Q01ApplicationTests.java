package com.example.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = Q01Application.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test

	@Order(1)
	void testAddGift() throws Exception {
		String st = "{\"giftId\": 1, \"giftName\": \"Wall Clock\", \"description\": \"Time and date \", \"price\": 200, \"category\": \"clock \"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/gift")
				.contentType(MediaType.APPLICATION_JSON)
				.content(st)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(jsonPath("$.giftName").value("Wall Clock"))
				.andReturn();

	}

	@Test
	@Order(2)
	void testGetGiftById() throws Exception {
		int giftId = 1;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/gift/{giftId}", giftId)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.giftName").value("Wall Clock"))
				.andExpect(jsonPath("$.price").value(200))
				.andReturn();

	}

	@Test
	@Order(3)
	void testgetAll() throws Exception {

		mockMvc.perform(get("/api/gift")

				.accept(MediaType.APPLICATION_JSON))

				.andDo(print())

				.andExpect(status().isOk())

				.andExpect(jsonPath("$").isArray())

				.andReturn();

	}

	@Test
	@Order(4)
	public void testControllerfolder() {

		String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your
																					// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Test
	@Order(5)
	public void testControllerfile() {

		String filePath = "src/main/java/com/example/springapp/controller/GiftController.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Test
	@Order(6)
	public void testModelFolder() {

		String directoryPath = "src/main/java/com/example/springapp/model"; // Replace with the path to your directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Test
	@Order(7)
	public void testModelFile() {

		String filePath = "src/main/java/com/example/springapp/model/Gift.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Test
	@Order(8)
	public void testrepositoryfolder() {

		String directoryPath = "src/main/java/com/example/springapp/repository"; // Replace with the path to your
																					// directory

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Test
	@Order(9)
	public void testrepositoryFile() {

		String filePath = "src/main/java/com/example/springapp/repository/GiftRepo.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

	@Test
	@Order(10)
	public void testServiceFolder() {

		String directoryPath = "src/main/java/com/example/springapp/service";

		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

}
