package com.aaa000.demo.user.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
	
	
	@Autowired
	UserDao userDao;
	
	
	public List<UserDto> parseExcelToUserList(InputStream is) throws IOException {
	    List<UserDto> userList = new ArrayList<>();
	    Workbook workbook = new XSSFWorkbook(is);
	    Sheet sheet = workbook.getSheetAt(0);

	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	        Row row = sheet.getRow(i);
	        if (row == null) continue;

	        UserDto user = new UserDto();
	        user.setUserName(getCellString(row.getCell(0)));
	        user.setUserGender(convertGender(getCellString(row.getCell(1))));
	        user.setUserNewsAgency(convertNewsAgency(getCellString(row.getCell(2))));
	        user.setUserPhoneNumber(getCellString(row.getCell(3)));

	        // 생년월일: 문자열로 읽어서 Date로 파싱
	        String birthdayStr = getCellString(row.getCell(4));
	        user.setUserBirthday(parseDateFromString(birthdayStr));

	        user.setUserId(getCellString(row.getCell(5)));
	        user.setUserEmail(getCellString(row.getCell(6)));

	        String rawPassword = getCellString(row.getCell(7));
	        if (rawPassword == null || rawPassword.isEmpty()) {
	            rawPassword = "defaultPassword123!";
	        }
	        user.setUserPassword(rawPassword);

	        user.setuDelMy((int) 0);
	    

	        userList.add(user);
	    }
	    workbook.close();
	    return userList;
	}

    private String parseDateFromString(String birthdayStr) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getCellString(Cell cell) {
        if (cell == null) return null;
        if(cell.getCellType() == CellType.STRING) return cell.getStringCellValue().trim();
        else if(cell.getCellType() == CellType.NUMERIC) return String.valueOf((int)cell.getNumericCellValue());
        else return null;
    }

    private int convertGender(String gender) {
        if (gender == null) return 7; // 기타
        return switch (gender.trim()) {
            case "남자", "5" -> 5;
            case "여자", "6" -> 6;
            case "기타", "7" -> 7;
            default -> 7;
        };
    }

    private int convertNewsAgency(String agency) {
        if (agency == null) return 4; // 알뜰폰 기본
        return switch (agency.trim()) {
            case "SKT", "1" -> 1;
            case "KT", "2" -> 2;
            case "LG", "3" -> 3;
            case "알뜰폰", "4" -> 4;
            default -> 4;
        };
    }
}
