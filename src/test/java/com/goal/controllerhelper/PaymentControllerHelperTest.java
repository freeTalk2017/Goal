package com.goal.controllerhelper;

import java.io.IOException;

import org.junit.Test;

import com.goal.dto.CodeDTO;
import com.goal.helper.PaymentControllerHelper;

public class PaymentControllerHelperTest {

	PaymentControllerHelper helper = new PaymentControllerHelper();
	
	CodeDTO dto = new CodeDTO();
	
	public String code = "02117yOz0Q9oZg1pm4Nz0nCfOz017yOf";
	
	@Test
	public void testGenerateOpenid(){
		dto.setCode(code);
		try {
			System.out.println(helper.generateOpenid(dto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
