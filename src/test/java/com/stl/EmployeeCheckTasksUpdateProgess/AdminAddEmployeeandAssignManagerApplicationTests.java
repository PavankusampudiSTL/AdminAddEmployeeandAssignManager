package com.stl.EmployeeCheckTasksUpdateProgess;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import com.stl.AdminEmployee.AdminAddEmployeeandAssignManagerApplication;

@SuppressWarnings("unused")
@SpringBootTest(classes = AdminAddEmployeeandAssignManagerApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminAddEmployeeandAssignManagerApplicationTests {

	@Test
	@Order(1)
	public void testSignup() {
		String jsonbody="{\"firstname\":\"Prasad\",\"lastname\":\"Kusampudi\",\"email\":\"prasad@gmail.com\",\"phonenumber\":\"9866754389\",\"password\":\"prasad\",\"manageremail\":\"manikanta@gmail.com\",\"gender\":\"Male\"}";
		String res=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.post("http://localhost:8081/adminemployee/addemployee")
				.then()
				.assertThat().statusCode(201)
				.extract().response().asString();
	}



	@Test
	@Order(3)
	public void testgetallEmployees() {
		String result=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.when()
				.get("http://localhost:8081/adminemployee/get")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}

	@Test
	@Order(4)
	public void testgetEmployees() {
		String result=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.when()
				.get("http://localhost:8081/adminemployee/get/prasad@gmail.com")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}

	@Test
	@Order(5)
	public void testdeleteEmployee() {
		String jsonbody= "{\"email\" : \"prasad@gmail.com\",\"password\" : \"prasad\"}";
		String token=given()
				.header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonbody)
				.when()
				.delete("http://localhost:8081/adminemployee/delete/prasad@gmail.com")
				.then()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
}

