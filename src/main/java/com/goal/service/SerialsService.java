package com.goal.service;

import java.util.List;

import com.goal.dto.SerialSliderDTO;
import com.goal.form.SerialsForm;
import com.goal.po.Serials;

/**
 * 系列服务
 * @author lizhiwei
 *
 */
public interface SerialsService {
	Serials getSerials(Serials serials);
	
	List<SerialsForm> getSerialsListByParentId(SerialSliderDTO dto);
	
	int insert(Serials serials);
}
