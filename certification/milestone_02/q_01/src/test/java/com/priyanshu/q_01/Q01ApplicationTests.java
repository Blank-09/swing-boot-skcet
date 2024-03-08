package com.priyanshu.q_01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.lang.reflect.Field;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = Q01Application.class)
@AutoConfigureMockMvc
class Q01ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void testaddInstitute() throws Exception {
		String institute = "{"
				+ "\"instituteId\": 1,"
				+ "\"instituteName\": \"Sample Institute\","
				+ "\"instituteDescription\": \"This is a test institute\","
				+ "\"instituteAddress\": \"123 Test Street, City\","
				+ "\"email\": \"sample@example.com\","
				+ "\"contactNumber\": \"123-456-7890\""
				+ "}";

		mockMvc.perform(MockMvcRequestBuilders.post("/api/institute")
				.contentType(MediaType.APPLICATION_JSON)
				.content(institute).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(jsonPath("$.instituteName").value("Sample Institute"))
				.andReturn();
	}

	@Test
	@Order(2)
	void testaddCourse() throws Exception {
		String course = "{"
				+ "\"courseId\": 1,"
				+ "\"courseName\": \"Sample Course\","
				+ "\"courseDescription\": \"This is a test course\","
				+ "\"courseDuration\": \"6 Weeks\","
				+ "\"courseFees\": 1000.0,"
				+ "\"noOfSeats\": 20"
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/institute/1/course")
				.contentType(MediaType.APPLICATION_JSON)
				.content(course).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(jsonPath("$.courseName").value("Sample Course"))
				.andReturn();
	}

	@Test
	@Order(3)
	void testgetAllInstitute() throws Exception {
		mockMvc.perform(get("/api/institute")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(4)
	void testgetAllCourseByInstituteId() throws Exception {
		mockMvc.perform(get("/api/institute/1/course")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(5)
	void testgetAllCourse() throws Exception {
		mockMvc.perform(get("/api/institute/course")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andReturn();
	}

	@Test
	@Order(6)
	void testgetCourseById() throws Exception {
		mockMvc.perform(get("/api/institute/course/1")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.courseName").value("Sample Course"))
				.andReturn();
	}

	@Test
	@Order(7)
	void testUpdateInstitute() throws Exception {
		String institute = "{"
				+ "\"instituteId\": 1,"
				+ "\"instituteName\": \"Test Institute\","
				+ "\"instituteDescription\": \"This is a Sample institute\","
				+ "\"instituteAddress\": \"123 Test Street, City\","
				+ "\"email\": \"institute@example.com\","
				+ "\"contactNumber\": \"123-456-4567\""
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.put("/api/institute/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(institute)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.instituteName").value("Test Institute"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	@Order(8)
	void testUpdateCourse() throws Exception {
		String course = "{"
				+ "\"courseId\": 1,"
				+ "\"courseName\": \"Computer Science\","
				+ "\"courseDescription\": \"This is a sample course\","
				+ "\"courseDuration\": \"7 Weeks\","
				+ "\"courseFees\": 1500.0,"
				+ "\"noOfSeats\": 30"
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.put("/api/institute/course/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(course)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.noOfSeats").value(30))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	@Order(9)
	public void testDeleteCourse() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/institute/course/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void testInstituteHasOneToManyAnnotation() {
		try {
			// Use reflection to get the Class object for the Course class
			Class<?> courseClass = Class.forName("com.priyanshu.q_01.model.Institute");

			// Get all declared fields in the Course class
			Field[] declaredFields = courseClass.getDeclaredFields();

			// Check each field for the @OneToMany annotation
			boolean hasOneToMany = false;
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(OneToMany.class)) {
					hasOneToMany = true;
					break; // Stop checking once we find one field with @OneToMany
				}
			}

			// If no field with @OneToMany is found, fail the test
			if (!hasOneToMany) {
				fail("No field with @OneToMany annotation found in Institute class.");
			}

		} catch (ClassNotFoundException e) {
			// If the class is not found, fail the test
			fail("Class not found: " + e.getMessage());
		}
	}

	@Test
	public void testCourseHasManyToOneAnnotation() {
		try {
			// Use reflection to get the Class object for the Course class
			Class<?> courseClass = Class.forName("com.priyanshu.q_01.model.Course");

			// Get all declared fields in the Course class
			Field[] declaredFields = courseClass.getDeclaredFields();

			// Check each field for the @OneToMany annotation
			boolean hasManyToOne = false;
			for (Field field : declaredFields) {
				if (field.isAnnotationPresent(ManyToOne.class)) {
					hasManyToOne = true;
					break; // Stop checking once we find one field with @OneToMany
				}
			}

			// If no field with @OneToMany is found, fail the test
			if (!hasManyToOne) {
				fail("No field with @ManyToOne annotation found in Course class.");
			}

		} catch (ClassNotFoundException e) {
			// If the class is not found, fail the test
			fail("Class not found: " + e.getMessage());
		}
	}

	@Test
	public void testServicefile() {
		String filePath = "src/main/java/com/priyanshu/q_01/service/CourseService.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/priyanshu/q_01/model/Course.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testInstituteRepoFile() {
		String filePath = "src/main/java/com/priyanshu/q_01/repository/InstituteRepo.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testCourseRepoFile() {
		String filePath = "src/main/java/com/priyanshu/q_01/repository/CourseRepo.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

}