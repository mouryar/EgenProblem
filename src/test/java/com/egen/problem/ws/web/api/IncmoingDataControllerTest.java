package com.egen.problem.ws.web.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.egen.problem.ws.factory.DAOFactory;
import com.egen.problem.ws.web.api.mock.IncomingDataDaoMock;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IncmoingDataControllerTest {

	@Mock
	private DAOFactory daoFactory;
	@InjectMocks
	private IncomingDataController incomingDataController;
	private MockMvc mockMvc;


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(incomingDataController).build();
	}

	@Test
	public void testGetAllMetrics() throws Exception {
		when(daoFactory.getIncomingDataDao()).thenReturn(new IncomingDataDaoMock());
		this.mockMvc.perform(get("/api/metrics")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetMetricsInPeriod() throws Exception {
		when(daoFactory.getIncomingDataDao()).thenReturn(new IncomingDataDaoMock());
		this.mockMvc.perform(get("/api/metrics").param("start", "1458062848735").param("end", "1458062848735"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json"));
	}

	/*@Test
	public void testSaveMetrics() throws Exception {
		when(daoFactory.getIncomingDataDao()).thenReturn(new IncomingDataDaoMock());
		IncomingData data = new IncomingData();
		data.setValue("130");
		data.setTimeStamp("1458062848735");
		Gson gson = new Gson();
	    String json = gson.toJson(data);
		this.mockMvc.perform(post("/api/metrics").contentType("application/json").content(json)).andExpect(status().isOk());
	}*/

}
