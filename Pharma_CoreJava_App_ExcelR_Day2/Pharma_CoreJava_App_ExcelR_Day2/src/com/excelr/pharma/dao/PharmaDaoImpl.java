package com.excelr.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.excelr.pharma.exceptions.PharmaException;
import com.excelr.pharma.vo.BatchInfo;

/**
 * @author admin
 *
 */
public class PharmaDaoImpl implements IPharmaDAO {

	@Override
	public boolean addBatch(BatchInfo batchInfo) throws PharmaException {
		final String METHOD_NAME = "addBatch";
		System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + batchInfo);
		boolean addBatchFlag = false;
		final String BATCH_INSERT_QRY = "INSERT INTO BATCH_INFO VALUES(?,?,?,?,?,?,?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement pstStatement = connection.prepareStatement(BATCH_INSERT_QRY)) {
			pstStatement.setString(1, batchInfo.getBatchCode());
			pstStatement.setString(2, batchInfo.getMedicineCode());
			pstStatement.setInt(3, batchInfo.getWeight());
			pstStatement.setDouble(4, batchInfo.getPrice());
			pstStatement.setString(5, batchInfo.getMedicineTypeCode() + "");
			pstStatement.setDouble(6, batchInfo.getShippingCharge());
			pstStatement.setString(7, batchInfo.getCareLevel());
			int updateCount = pstStatement.executeUpdate();
			if (updateCount > 0) {
				addBatchFlag = true;
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} catch (PharmaException e) {
			throw new PharmaException(e);
		}
		System.out.println("Method Exit:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + addBatchFlag);
		return addBatchFlag;
	}

	@Override
	public boolean checkMedicineCode(String medicineCode) throws PharmaException {
		final String METHOD_NAME = "checkMedicineCode";
		System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + medicineCode);
		boolean medicineCodeFlag = false;
		final String MEDICINE_CODE_QRY = "SELECT *FROM medicine_master WHERE medicine_code=?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement pstStatement = connection.prepareStatement(MEDICINE_CODE_QRY)) {
			pstStatement.setString(1, medicineCode);
			ResultSet resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				medicineCodeFlag = true;
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} catch (PharmaException e) {
			throw new PharmaException(e);
		}
		System.out.println("Method Exit:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + medicineCode);
		return medicineCodeFlag;
	}

	@Override
	public double getShippingCharge(String medicineTypeCode, String weightRange) throws PharmaException {
		final String METHOD_NAME = "getShippingCharge";
		System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + medicineTypeCode
				+ ":" + weightRange);
		double shippingCharge = 0;
		final String SHIPPING_CHARGE_QRY = "SELECT SHIPPING_CHARGE FROM SHIPPING_MASTER WHERE MEDICINE_TYPE_CODE=? AND WEIGHT_RANGE=?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement pstStatement = connection.prepareStatement(SHIPPING_CHARGE_QRY)) {
			pstStatement.setString(1, medicineTypeCode);
			pstStatement.setString(2, weightRange);
			ResultSet resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				shippingCharge = resultSet.getDouble("SHIPPING_CHARGE");
				System.out.println(shippingCharge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PharmaException(e);
		} catch (PharmaException e) {
			throw new PharmaException(e);
		}
		System.out.println("Method Exit:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + shippingCharge);
		return shippingCharge;
	}

	@Override
	public boolean checkBatchCode(String batchCode) throws PharmaException {
		final String METHOD_NAME = "checkBatchCode";
		System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + batchCode);
		boolean batchCodeFlag = false;
		final String BATCH_CODE_QRY = "SELECT batch_code FROM batch_info WHERE batch_code=?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement pstStatement = connection.prepareStatement(BATCH_CODE_QRY)) {
			pstStatement.setString(1, batchCode);
			ResultSet resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				batchCodeFlag = true;
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} catch (PharmaException e) {
			throw new PharmaException(e);
		}
		System.out.println("Method Response:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + batchCodeFlag);
		return batchCodeFlag;
	}

	@Override
	public BatchInfo findBatchByBatchCode(String batchCode) throws PharmaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeBatchByBacthCode(String batchCode) throws PharmaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<BatchInfo> allBatchesInfo() throws PharmaException {
		// TODO Auto-generated method stub
		return null;
	}
}
