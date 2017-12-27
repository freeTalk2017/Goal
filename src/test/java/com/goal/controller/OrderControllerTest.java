package com.goal.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;

public class OrderControllerTest extends GenericControllerTest{

	@Test
	public void testSubmitOrder() throws Exception {
		getMockMvc().perform(get("/orders/orderConfirmation"));
	}
}
