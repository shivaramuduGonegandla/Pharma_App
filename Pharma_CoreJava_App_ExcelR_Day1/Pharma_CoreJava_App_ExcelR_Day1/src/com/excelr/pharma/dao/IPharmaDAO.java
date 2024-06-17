package com.excelr.pharma.dao;

import java.util.Set;

import com.excelr.pharma.exceptions.PharmaException;
import com.excelr.pharma.vo.BatchInfo;

/**
 * @author admin
 *
 */
public interface IPharmaDAO {

	/**
	 * @param medicineTypeCode
	 * @param weightRange
	 * @return double
	 * @throws PharmaException
	 */
	public abstract double getShippingCharge(String medicineTypeCode, String weightRange) throws PharmaException;

	/**
	 * @param batchCode
	 * @return boolean
	 * @throws PharmaException
	 */
	public abstract boolean checkBatchCode(String batchCode) throws PharmaException;

	/**
	 * @param medicineCode
	 * @return boolean
	 * @throws PharmaException
	 */
	public abstract boolean checkMedicineCode(String medicineCode) throws PharmaException;

	/**
	 * @param batchInfo
	 * @return boolean
	 * @throws PharmaException
	 */
	public abstract boolean addBatch(BatchInfo batchInfo) throws PharmaException;

	/**
	 * @param batchCode
	 * @return BatchInfo
	 * @throws PharmaException
	 */
	public abstract BatchInfo findBatchByBatchCode(String batchCode) throws PharmaException;

	/**
	 * @param batchCode
	 * @return boolean
	 * @throws PharmaException
	 */
	public abstract boolean removeBatchByBacthCode(String batchCode) throws PharmaException;

	/**
	 * @return Set<BatchInfo>
	 * @throws PharmaException
	 */
	public abstract Set<BatchInfo> allBatchesInfo() throws PharmaException;
}
