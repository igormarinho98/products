package webvest.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import webvest.api.controller.InvestmentController;
import webvest.api.model.Investment;
import webvest.api.repository.InvestmentRepository;

@WebMvcTest(InvestmentController.class)
public class InvestmentControllerTests {
	
	@MockBean
	private InvestmentRepository investRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	void shouldCreateInvestment() throws Exception {
		
	//	Investment invest = new Investment ("CDB GVLK+", 100000, false, 13796956, 44, "EMISSAO" );
		
	//    mockMvc.perform(post("/api/invest").contentType(MediaType.APPLICATION_JSON)
	  //  		.content(objectMapper.writeValueAsString(invest)))
	    //		.andExpect(status().isCreated())
	   // 		.andDo(print());
	}
	
	
	
	
}
