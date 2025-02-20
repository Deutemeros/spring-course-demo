package com.memoria.fastmath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.memoria.fastmath.model.Equation;
import com.memoria.fastmath.model.Operation;
import com.memoria.fastmath.model.PostResultsBodyParams;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class FastMathControllerTest {

    @Autowired
    public MockMvc mockMvc;
    
	@Test
	public void testGetNewEquation() throws Exception {
        mockMvc.perform(get("/api"))
            .andDo(print())
            .andExpect(status().isOk());
	}
	
	@Test
	public void testResults() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PostResultsBodyParams body = new PostResultsBodyParams();
		body.setEq(new Equation(Operation.ADDITION, 2, 3, 5));
		body.setResults(5);
		mockMvc.perform(post("/api")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(body))
		)
		.andDo(print())
		.andExpect(status().isOk());
	}
}
