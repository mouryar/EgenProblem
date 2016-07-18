package com.egen.problem.ws.web.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.egen.problem.ws.factory.DAOFactory;
import com.egen.problem.ws.web.api.mock.AlertDaoMock;

public class AlertControllerTest {

	@Mock
	private DAOFactory daoFactory;
	@InjectMocks
	private AlertController alertController;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(alertController).build();
	}

	@Test
	public void testgetAllAlerts() throws Exception {

		when(daoFactory.getAlertsDao()).thenReturn(new AlertDaoMock());
		this.mockMvc.perform(get("/api/alerts")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void getAlertsInPeriod() throws Exception {

		when(daoFactory.getAlertsDao()).thenReturn(new AlertDaoMock());
		this.mockMvc.perform(get("/api/alerts").param("start", "07142016").param("end", "07202016"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json"));
	}

}
