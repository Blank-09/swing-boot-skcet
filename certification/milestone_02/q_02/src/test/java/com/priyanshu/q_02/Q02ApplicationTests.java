package com.priyanshu.q_02;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = Q02Application.class)
@AutoConfigureMockMvc
public class Q02ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void testPostData() throws Exception {
		String st = "{\"medicineId\": 1, \"name\": \"asthalin\", \"brand\": \"cipla\", \"manufacturedIn\": \"chennai\", \"price\": 37.0, \"expiryDate\": \"2020-03-03\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/medicine")
				.contentType(MediaType.APPLICATION_JSON)
				.content(st)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("asthalin"))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn();
	}

	@Test
	@Order(2)
	public void testUpdateData() throws Exception {
		String st = "{\"medicineId\": 1, \"name\": \"asthalin\", \"brand\": \"cipla\", \"manufacturedIn\": \"chennai\", \"price\": 50.0, \"expiryDate\": \"2020-03-03\"}";
		mockMvc.perform(MockMvcRequestBuilders.put("/api/medicine/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(st)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.price").value(50.0))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	@Order(3)
	public void testGetByBrand() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/medicine/bybrand/cipla")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(4)
	public void testGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/medicine")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(5)
	public void testDeleteExpiredMedicines() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/medicine/expired")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void testControllerFolder() {
		String directoryPath = "src/main/java/com/priyanshu/q_02/controller"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testRepositoryFolder() {
		String directoryPath = "src/main/java/com/priyanshu/q_02/repository"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/priyanshu/q_02/model"; // Replace with the path to your directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/priyanshu/q_02/model/Medicine.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testRepositoryFile() {
		String filePath = "src/main/java/com/priyanshu/q_02/repository/MedicineRepo.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

}
