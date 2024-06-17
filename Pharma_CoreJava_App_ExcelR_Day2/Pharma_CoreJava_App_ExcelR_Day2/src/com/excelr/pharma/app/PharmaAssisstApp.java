package com.excelr.pharma.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.excelr.pharma.exceptions.PharmaBusinessException;
import com.excelr.pharma.exceptions.PharmaException;
import com.excelr.pharma.service.IPharmaService;
import com.excelr.pharma.service.IPharmaServiceImpl;
import com.excelr.pharma.vo.BatchInfo;

/**
 * @author admin
 *
 */
public class PharmaAssisstApp {
	private static void printLine(int noOfTimes) {
		for (int i = 0; i <= noOfTimes; i++) {
			System.out.print("--");
		}
		System.out.println();
	}

	private static void userMenu() {
		printLine(30);
		System.out.println("1) Register Batch");
		System.out.println("2) Search Batch Info");
		System.out.println("3) Remove Batch Info");
		System.out.println("4) Batches Information");
		printLine(30);
		IPharmaService service = new IPharmaServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Choice");
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1:
				System.out.println("Enter Batch Code");
				String batchCode = scanner.next();
				System.out.println("Enter Medicine Code");
				String medicineCode = scanner.next();
				System.out.println("Weight");
				int weight = scanner.nextInt();
				System.out.println("Enter Price");
				double price = scanner.nextDouble();
				System.out.println("Medicine Type Code");
				String medicineTypeCode = scanner.next();
				System.out.println("isRefrigiration:?");
				String refrigiration = scanner.next();
				BatchInfo batchInfo = new BatchInfo();
				batchInfo.setBatchCode(batchCode);
				batchInfo.setMedicineCode(medicineCode);
				batchInfo.setMedicineTypeCode(medicineTypeCode);
				batchInfo.setPrice(price);
				batchInfo.setWeight(weight);
				batchInfo.setRefrigiration(refrigiration);
				boolean regFlag = service.addBatch(batchInfo);
				if (regFlag) {
					System.out.println("Batch Addedd Successfully");
				}
				break;
			case 2:
				break;
			case 3:
				break;

			default:
				break;
			}
		} catch (InputMismatchException | PharmaException | PharmaBusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		userMenu();
	}
}
