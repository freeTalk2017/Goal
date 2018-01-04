package com.goal.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goal.dao.OrderAddressDAO;
import com.goal.dao.OrderCmdDAO;
import com.goal.dao.OrderDAO;
import com.goal.dao.OrderPriceDetailDAO;
import com.goal.dto.OrderAddressDTO;
import com.goal.dto.OrderCmdDTO;
import com.goal.dto.OrderDTO;
import com.goal.dto.OrderPriceDetailDTO;
import com.goal.dto.ResponseOrderDTO;
import com.goal.po.Order;
import com.goal.po.OrderAddress;
import com.goal.po.OrderCmd;
import com.goal.po.OrderPriceDetail;
import com.goal.util.Constant;
import com.goal.util.StringUtil;
import com.goal.util.TypeTransformUtil;
import com.goal.util.UUIDUtil;

/**
 * 订单服务实现类
 * @author lizhiwei
 *
 */
@Component
public class OrderServiceImpl implements OrderService{
	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Resource
	private OrderDAO orderDao;
	
	@Resource
	private OrderPriceDetailDAO orderPriceDetailDao;
	
	@Resource
	private OrderCmdDAO orderCmdDao;
	
	@Resource
	private OrderAddressDAO orderAddressDao;
	@Override
	/**
	 * 提交订单
	 */
	public ResponseOrderDTO submitOrder(OrderDTO dto) throws Exception{
		LOG.info("start submit order service...");
		//插入订单表t_order,并设置返回的orderid和订单总价
		insertOrder(dto);
		
		//插入订单-商品表t_order_cmd
		insertOrderCmd(dto);
		
		//插入订单价格详情表t_order_price_detail
		insertOrderPriceDetail(dto);
		
		//插入订单地址表
		insertOrderAddress(dto);
		
		
		return handleSuccessResultDTO(dto);
	}

	/**
	 * 包装返回的dto
	 * @param existedDto
	 * @return
	 */
	private ResponseOrderDTO handleSuccessResultDTO(OrderDTO existedDto) {
		ResponseOrderDTO newDTO = new ResponseOrderDTO();
		newDTO.setValidateOrder(true);
		newDTO.setOrderId(existedDto.getOrderId());
		newDTO.setTotalPrice(existedDto.getTotalPrice());
		LOG.info("return orderDTO:"+newDTO);
		return newDTO;
	}
	/**
	 * 生成订单编号-临时方法
	 * @return
	 */
	private String mockGenerateOrderId() {
		return new Long(System.currentTimeMillis()).toString();
	}
	
	/**
	 * 生成订单价格-测试方法，只包含商品价格
	 * @param orderDto
	 * @return
	 */
	private String mockGenerateOrderPrice(OrderDTO orderDto) {
		BigDecimal result = new BigDecimal(0);
		for (OrderCmdDTO ocDTO : orderDto.getOrderCmdList()) {
			LOG.info("OrderCmdDTO->>>>>"+ocDTO.getSkuPrice());
			int price = new Integer(ocDTO.getSkuPrice());
			int amount = new Integer(ocDTO.getCmdCount());
			BigDecimal e1 = new BigDecimal(price);
			BigDecimal e2 = new BigDecimal(amount);
			result = result.add(e1.multiply(e2));
		}
		return Integer.toString(result.intValue());
	}
	
	/**
	 * 插入订单表
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	private boolean insertOrder(OrderDTO dto) throws Exception{
		LOG.info("start to insert t_order...");
		Order order = new Order();
		String orderId = UUIDUtil.getUUIDWithoutStrip();
		order.setId(orderId);
		order.setOrderNumber(mockGenerateOrderId());//to be replaced
		order.setUserId(dto.getUserId());
		order.setOrderPrice(mockGenerateOrderPrice(dto));
		order.setDeliveryWay(dto.getDeliveryWay());
		order.setIsCouponUsed(dto.getIsCouponUsed());
		order.setInvoiceType(dto.getInvoiceType());
		order.setOrderStatus(Constant.ORDER_STATUS_INIT);
		order.setCmdCount(getCmdCount(dto));
		order.setComment(dto.getComment());
		orderDao.insert(order);

		LOG.info("end to insert t_order...");
		//设置orderId
		dto.setOrderId(orderId);
		//设置总价
		dto.setTotalPrice(order.getOrderPrice());
		return true;
	}
	
	/**
	 * 获得商品总数量
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	private String getCmdCount(OrderDTO dto) throws Exception {
		int count = 0;
		for(OrderCmdDTO ocDTO:dto.getOrderCmdList()) {
			count+=TypeTransformUtil.stringToInt(ocDTO.getCmdCount());
		}
		return new Integer(count).toString();
	}
	/**
	 * 插入订单商品
	 * @return
	 */
	private boolean insertOrderCmd(OrderDTO dto) throws Exception{
		LOG.info("start to insert t_order_cmd...");

		for(OrderCmdDTO oCmdDto : dto.getOrderCmdList()) {
			OrderCmd oc = new OrderCmd();
			//从cmdDTO中拷贝属性到orderCMD
			BeanUtils.copyProperties(oc, oCmdDto);
			//手动设置id
			oc.setId(UUIDUtil.getUUID());
			//手动设置orderId
			oc.setOrderId(dto.getOrderId());
			orderCmdDao.insert(oc);
		}
		LOG.info("end to insert t_order_cmd...");
		return true;
	}
	/**
	 * 插入订单价格详情
	 * @return
	 */
	private boolean insertOrderPriceDetail(OrderDTO orderDTO) throws Exception{
		LOG.info("start to insert t_order_price_detail...");
		//插入单品详情
		for(OrderCmdDTO ocDTO : orderDTO.getOrderCmdList()) {
			OrderPriceDetail opd = new OrderPriceDetail();
			opd.setId(UUIDUtil.getUUID());
			//手动设置orderId
			opd.setOrderId(orderDTO.getOrderId());
			opd.setDetailKey(ocDTO.getCmdSkuId());
			opd.setDetailName("");
			opd.setDetailValue(ocDTO.getSkuPrice());
			opd.setAmount(ocDTO.getCmdCount());
			orderPriceDetailDao.insert(opd);
		}
		LOG.info("end to insert t_order_price_detail...");
		return true;
	}
	
	/**
	 * 插入订单地址表
	 * @param orderDTO
	 * @return
	 * @throws Exception
	 */
	private boolean insertOrderAddress(OrderDTO orderDTO) throws Exception{
		LOG.info("start to insert t_order_address...");
		OrderAddress oa = new OrderAddress();
		OrderAddressDTO oaDTO = orderDTO.getOrderAddress();
		if(oaDTO==null) {
			throw new Exception("order address can not be none!");
		}
		//copy properties from oaDTO to oa
		BeanUtils.copyProperties(oa, oaDTO);
		//生成并设置id
		oa.setId(UUIDUtil.getUUID());
		//手动设置orderId
		oa.setOrderId(orderDTO.getOrderId());
		orderAddressDao.insert(oa);
		LOG.info("end to insert t_order_address...");
		return true;
	}
	
	
	public static void main(String[] args) {
		int a = new Integer("10000");
		System.out.println(a);
	}

	@Override
	public OrderDTO getOrderById(OrderDTO dto) throws Exception {
		Order order = orderDao.selectOrderById(dto.getOrderId());
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getId());
		orderDTO.setTotalPrice(order.getOrderPrice());
		return orderDTO;
	}
}
