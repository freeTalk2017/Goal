package com.goal.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 单品详情(属性)DTO
 * @author lizhiwei
 *
 */
public class SkuDetailDTO extends AbstractDTO{

	/** id **/
    private String id;

	/** 详情key **/
    private String paramKey;

	/** 详情value **/
    private String paramValue;

	/** 详情描述 **/
    private String paramDesc;

	/** 父属性id **/
    private String pid;

	/** 属性顺序 **/
    private int index;

    /** 子属性列表 **/
	private List<SkuDetailDTO> subDetailList;
	public SkuDetailDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

    
    public List<SkuDetailDTO> getSubDetailList() {
		return subDetailList;
	}

	public void setSubDetailList(List<SkuDetailDTO> subDetailList) {
		this.subDetailList = subDetailList;
	}

	public static void main(String[] args) {
		SkuDetailDTO s1 = new SkuDetailDTO();
		s1.setIndex(4);
		SkuDetailDTO s2 = new SkuDetailDTO();
		s2.setIndex(5);
		SkuDetailDTO s3 = new SkuDetailDTO();
		s3.setIndex(-1);
		
		List<SkuDetailDTO> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
//		list.sort((so1,so2)->so1.getIndex()-so2.getIndex());
		list.sort((so1,so2)->so2.getIndex()-so1.getIndex());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getIndex());
		}
	}
}
